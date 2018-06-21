package online.shixun.demo.eshop.module.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class ComparisonTable {

    private List<String> skuIds = new ArrayList<>();

    public List<String> getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(List<String> skuIds) {
        this.skuIds = skuIds;
    }

    /**
     * 添加对比的商品
     *
     * @param skuId
     */
    public void addItem(String skuId) {
        //判断是否包含同款
        if (!skuIds.contains(skuId)) {
            skuIds.add(skuId);
        }
    }

}
