/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.core.service.BeanEnum;
import online.shixun.demo.eshopadmin.model.EshopColorModel;
import online.shixun.demo.eshopadmin.model.EshopProductModel;
import online.shixun.demo.eshopadmin.model.EshopSizeModel;
import online.shixun.demo.eshopadmin.model.EshopSkuModel;
import online.shixun.demo.eshopadmin.module.product.dao.EshopSkuDao;
import online.shixun.demo.eshopadmin.util.BeanUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("eshopSkuService")
public class EshopSkuService extends BaseServiceAbstractPage<EshopSkuModel, String> {


    @Autowired
    public EshopSkuService(@Qualifier("eshopSkuDao") JpaRepository<EshopSkuModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopSkuModel model, StringBuilder whereSql, Map<String, Object> params) {

    }

    /**
     * 根据产品颜色,尺码集保存销售单元
     *
     * @param sizes
     * @param colors
     * @param productModel
     * @throws Exception
     */
    @Transactional
    public void saveModel(String[] sizes, String[] colors, EshopProductModel productModel) throws Exception {

        List<EshopSkuModel> dbSku = ((EshopSkuDao) super.getJpaRepository()).findEshopSkuModelByProduct(productModel.getId());//数据库中当前产品的所有销售单元
        //key -->sku id
        //value --> true-删除/false-不删除
        Map<String, Boolean> removeSkus = new HashMap<String, Boolean>() {
            {
                //需要进行批量移除的销售单元
                for (EshopSkuModel skuModel : dbSku) {
                    put(skuModel.getId(), true);
                }
            }
        };

        //需要进行批量保存的销售单元
        List<EshopSkuModel> saveSkus = new ArrayList<>();
        //汇总销售单元演颜色,尺寸[列转行]
        List<String> skuList = new ArrayList<String>() {{
            for (String color : colors) {
                for (String size : sizes) {
                    add(String.format("%s-%s", color, size));
                }
            }
        }};
        for (String color_size : skuList) {
            //拆分
            String color = color_size.replaceAll("-[\\s\\S]*", "");//颜色
            String size = color_size.replaceAll("[\\s\\S]*-", "");//尺码

            //查询销售单元存在与否
            boolean isExist = false;
            if (Objects.nonNull(dbSku) && dbSku.size() > 0) {
                for (EshopSkuModel skuModel : dbSku) {
                    if (Objects.equals(skuModel.getColorModel().getId(), color) && Objects.equals(skuModel.getSizeModel().getId(), size)) {
                        removeSkus.put(skuModel.getId(), false);//发现相同的标识未不删除
                        isExist = true;
                    }
                }
            }
            if (isExist) {
                continue;
            }
            EshopSkuModel sku = new EshopSkuModel();//最小销售单元
            sku.setProductModel(productModel);//产品
            sku.setColorModel(new EshopColorModel(color));//颜色
            sku.setSizeModel(new EshopSizeModel(size));//尺码
            sku.setCreateTime(new Date());//创建时间
            sku.setUpdateTime(new Date());//更新时间
            sku.setIsDel(BeanEnum.UNDEL.getIndex());//数据移除状态
            sku.setId(BeanUtils.getId());//ID
            sku.setSkuIndex(1);//前台显示顺序
            sku.setSkuRank(1d);//打星
            if (Objects.nonNull(productModel.getImgModel()) &&
                    productModel.getImgModel().size() > 0 &&
                    Strings.isNotBlank(productModel.getImgModel().get(0).getImgUrl()) &&
                    Strings.isNotBlank(productModel.getImgModel().get(0).getImgUrl().split(",")[0])
                    ) {
                sku.setSkuImg(productModel.getImgModel().get(0).getImgUrl().split(",")[0]);//图片
            }
            sku.setSkuName(productModel.getProductName());

            //此处数据添加后期删除
            sku.setSkuStock(10);//库存
            sku.setSkuDeliveFee(10d); //运费
            sku.setSkuMarketPrice(10d); //市场价
            sku.setSkuPrice(10d);//售价
            sku.setSkuUpperLimit(10); //购买限制

            //添加到集合中进行批量保存
            saveSkus.add(sku);
        }
        //批量删除
        List<String> ids = removeSkus.keySet().stream().filter(key -> removeSkus.get(key)).collect(Collectors.toList());
        if (Objects.nonNull(ids) && ids.size() > 0) {
            ((EshopSkuDao) super.getJpaRepository()).batchReomve(ids);
        }
        //批量保存
        batchInsert(saveSkus, 10);
    }
}

