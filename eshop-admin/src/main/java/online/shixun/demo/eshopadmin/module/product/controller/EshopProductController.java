/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.controller;

import online.shixun.demo.eshopadmin.core.controller.BaseController;
import online.shixun.demo.eshopadmin.core.response.ResponseData;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.core.service.BeanEnum;
import online.shixun.demo.eshopadmin.core.service.ProductEnum;
import online.shixun.demo.eshopadmin.core.service.UploadFileNginxService;
import online.shixun.demo.eshopadmin.model.*;
import online.shixun.demo.eshopadmin.module.brand.service.EshopBrandService;
import online.shixun.demo.eshopadmin.module.product.service.*;
import online.shixun.demo.eshopadmin.module.type.service.EshopTypeService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;


@RestController
@RequestMapping("/shopping/mall/product")
public class EshopProductController extends BaseController<EshopProductModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private EshopSkuService eshopSkuService; //最小销售单元服务
    private EshopBrandService eshopBrandService; //商品品牌服务
    private EshopTypeService eshopTypeService; //商品类型服务
    private EshopFeatureService eshopFeatureService;//商品材质服务
    private EshopColorService eshopColorService;//商品颜色服务
    private EshopSizeService eshopSizeService;//商品尺码服务
    private EshopImgService eshopImgService;//商品图片服务
    private UploadFileNginxService uploadFileNginxService; //文件服务

    @Value("${system.file.images.suffix.include}")
    private String include;//包含的图片类型  案例：.jpg|.png|.gif

    @Override
    public String getMainPageUrl() {
        return "product/productMain";
    }

    @Override
    public String getFromPageUrl() {
        return "product/productFrom";
    }

    @Autowired
    public EshopProductController(
            @Qualifier("eshopProductService") BaseServiceAbstractPage baseServiceAbstractPage,
            @Qualifier("eshopSkuService") EshopSkuService eshopSkuService,
            @Qualifier("eshopBrandService") EshopBrandService eshopBrandService,
            @Qualifier("eshopTypeService") EshopTypeService eshopTypeService,
            @Qualifier("eshopColorService") EshopColorService eshopColorService,
            @Qualifier("eshopFeatureService") EshopFeatureService eshopFeatureService,
            @Qualifier("eshopSizeService") EshopSizeService eshopSizeService,
            @Qualifier("eshopImgService") EshopImgService eshopImgService,
            @Qualifier("uploadFileNginx") UploadFileNginxService uploadFileNginxService
    ) {
        super(baseServiceAbstractPage);
        this.eshopSkuService = eshopSkuService;
        this.eshopBrandService = eshopBrandService;
        this.eshopTypeService = eshopTypeService;
        this.eshopColorService = eshopColorService;
        this.eshopFeatureService = eshopFeatureService;
        this.eshopSizeService = eshopSizeService;
        this.eshopImgService = eshopImgService;
        this.uploadFileNginxService = uploadFileNginxService;
    }

    /***
     * 进入模块编辑界面(添加，详情，编辑)
     * @param mav
     * @param action add/edit/info
     * @param id
     * @return
     */
    @Override
    public ModelAndView from(ModelAndView mav, String action, String id, HttpServletRequest request) {

        //定义添加商品页面加载的数据集合
        List<EshopBrandModel> brands = new ArrayList<>();//商品品牌
        List<EshopTypeModel> types = new ArrayList<>();//商品类型
        List<EshopFeatureModel> features = new ArrayList<>();//商品材质
        List<EshopColorModel> colors = new ArrayList<>();//商品颜色
        List<EshopSizeModel> sizes = new ArrayList<>();//商品尺码

        //调用商品相关服务加载数据到集合
        try {
            EshopBrandModel brandModel = new EshopBrandModel();
            brandModel.setIsDel(BeanEnum.UNDEL.getIndex());
            eshopBrandService.getModelsPage(brandModel, null, null).stream().forEach(brands::add);

            EshopTypeModel typeModel = new EshopTypeModel();
            typeModel.setIsDel(BeanEnum.UNDEL.getIndex());
            eshopTypeService.getModelsPage(typeModel, null, null).stream().forEach(types::add);

            EshopFeatureModel featureModel = new EshopFeatureModel();
            featureModel.setIsDel(BeanEnum.UNDEL.getIndex());
            eshopFeatureService.getModelsPage(featureModel, null, null).stream().forEach(features::add);

            EshopColorModel colorModel = new EshopColorModel();
            colorModel.setIsDel(BeanEnum.UNDEL.getIndex());
            eshopColorService.getModelsPage(colorModel, null, null).stream().forEach(colors::add);

            EshopSizeModel sizeModel = new EshopSizeModel();
            sizeModel.setIsDel(BeanEnum.UNDEL.getIndex());
            eshopSizeService.getModelsPage(sizeModel, null, null).stream().forEach(sizes::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置响应
        mav.addObject("brands", brands);//商品品牌
        mav.addObject("types", types);//商品类型
        mav.addObject("features", features);//商品特点
        mav.addObject("colors", colors);//商品颜色
        mav.addObject("sizes", sizes);//商品尺码

        //调用父类from方法完成基础功能
        super.from(mav, action, id, request);

        //设置图片大小
        EshopProductModel eshopProductModel = (EshopProductModel) mav.getModel().get("model");
        if (Objects.nonNull(eshopProductModel)) {
            eshopProductModel.getImgModel().forEach(imgModel -> {
                imgModel.setImgSize(new File(String.format("%s%s", getImageHome(request), imgModel.getImgUrl())).length());
            });
        }

        return mav;
    }

    /**
     * 保存数据
     *
     * @param model
     * @return
     */
    @Override
    public ResponseData save(EshopProductModel model) {
        //控制,尺码、颜色、材质的数据合法性，允许用户不填写，关注实体的get方法
        ResponseData responseData = new ResponseData();
        try {
            if (!Objects.equals(model.getProductIsShow(), ProductEnum.SHOW.getIndex())) {
                //保存产品
                //第一次保存数据设置创建时间
                if (Objects.isNull(model.getCreateTime())) {
                    model.setCreateTime(new Date());
                }
                //每次执行保存，记录更新时间
                model.setUpdateTime(new Date());
                //保存产品
                model = super.baseServiceAbstractPage.editModel(model, model.getId());

                //保存产品的销售单元
                String[] sizes = Strings.isBlank(model.getProductSizes()) ? new String[0] : model.getProductSizes().split(",");//尺码
                String[] colors = Strings.isBlank(model.getProductColors()) ? new String[0] : model.getProductColors().split(",");//颜色
                eshopSkuService.saveModel(sizes, colors, model);
            }
            responseData.setData("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    @Override
    public ResponseData deleteReal(String id, HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        try {
            //知道到需要删除的图片，进行删除
            EshopImgModel imgModel = new EshopImgModel();
            eshopImgService.getModelsPage(imgModel, null, null).forEach(image -> {
                Arrays.stream(image.getImgUrl().split(",")).forEach(fileName -> {
                    logger.info("删除nginx文件服务器的文件");
                    uploadFileNginxService.sendGET("deleteFile", String.format("fileName=%s", fileName));
                });
            });
            responseData = super.deleteReal(id, request);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    @Override
    public Sort getPagesSort() {
        return Sort.by(Sort.Order.desc("productIsShow"), Sort.Order.desc("productIsNew"), Sort.Order.desc("productIsHot"), Sort.Order.desc("productIsCommend"), Sort.Order.asc("updateTime"));
    }

    @GetMapping("/productUpUrl")
    public ResponseData productUpUrl(String id) {
        ResponseData responseData = new ResponseData();
        try {
            EshopProductModel productModel = (EshopProductModel) baseServiceAbstractPage.getModel(id);
            if (Objects.equals(productModel.getIsDel(), BeanEnum.DEL.getIndex())) {
                responseData.setError("商品已经加入购物车无法上架");
                return responseData;
            } else if (Objects.equals(productModel.getProductIsShow(), ProductEnum.SHOW.getIndex())) {
                responseData.setError("请勿重复上架");
                return responseData;
            }
            productModel.setProductIsShow(ProductEnum.SHOW.getIndex());
            baseServiceAbstractPage.editModel(productModel, id);
            responseData.setData("上架成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    @GetMapping("/productDownUrl")
    public ResponseData productDownUrl(String id) {
        ResponseData responseData = new ResponseData();
        try {
            EshopProductModel productModel = (EshopProductModel) baseServiceAbstractPage.getModel(id);
            if (Objects.equals(productModel.getIsDel(), BeanEnum.DEL.getIndex())) {
                responseData.setError("商品已经加入购物车无法下架");
                return responseData;
            } else if (Objects.equals(productModel.getProductIsShow(), ProductEnum.UNSHOW.getIndex())) {
                responseData.setError("请勿重复下架");
                return responseData;
            }
            productModel.setProductIsShow(ProductEnum.UNSHOW.getIndex());
            baseServiceAbstractPage.editModel(productModel, id);
            responseData.setData("下架成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

}