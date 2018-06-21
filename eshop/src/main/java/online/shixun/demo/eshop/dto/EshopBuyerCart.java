package online.shixun.demo.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EshopBuyerCart implements Serializable {

    //购物车中的商品结果集
    private List<EshopBuyerCartItem> items = new ArrayList<>();

    /**
     * 添加购物项到购物车
     *
     * @param item
     */
    public void addItem(EshopBuyerCartItem item) {
        //判断是否包含同款
        if (items.contains(item)) {
            //追加数量
            for (EshopBuyerCartItem EshopBuyerCartItem : items) {
                if (EshopBuyerCartItem.equals(item)) {
                    EshopBuyerCartItem.setAmount(item.getAmount() + EshopBuyerCartItem.getAmount());
                }
            }
        } else {
            items.add(item);
        }
    }

    public List<EshopBuyerCartItem> getItems() {
        return items;
    }

    public void setItems(List<EshopBuyerCartItem> items) {
        this.items = items;
    }

    /**
     * 小计:商品数量
     *
     * @return
     */
    @JsonIgnore
    public Integer getProductAmount() {
        Integer result = 0;
        //计算
        for (EshopBuyerCartItem buyerItem : items) {
            result += buyerItem.getAmount();
        }
        return result;
    }

    /**
     * 商品金额
     *
     * @return
     */
    @JsonIgnore
    public Float getProductPrice() {
        Float result = 0f;
        //计算
        for (EshopBuyerCartItem buyerItem : items) {
            result += buyerItem.getSubtotal();
        }
        return result;
    }

    /**
     * 运费
     *
     * @return
     */
    @JsonIgnore
    public Float getFee() {
        Float result = 0f;
        //满了79包邮
        if (getProductPrice() > 0 && getProductPrice() < 79) {
            result = 5f;
        }
        return result;
    }

    /**
     * 总价
     *
     * @return
     */
    @JsonIgnore
    public Float getTotalPrice() {
        return getProductPrice() + getFee();
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_buyer_cart.id
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_buyer_cart.is_del
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    private Integer isDel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_buyer_cart.create_time
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_buyer_cart.update_time
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_buyer_cart.user_id
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_buyer_cart.id
     *
     * @return the value of eshop_buyer_cart.id
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_buyer_cart.id
     *
     * @param id the value for eshop_buyer_cart.id
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_buyer_cart.is_del
     *
     * @return the value of eshop_buyer_cart.is_del
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_buyer_cart.is_del
     *
     * @param isDel the value for eshop_buyer_cart.is_del
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_buyer_cart.create_time
     *
     * @return the value of eshop_buyer_cart.create_time
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_buyer_cart.create_time
     *
     * @param createTime the value for eshop_buyer_cart.create_time
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_buyer_cart.update_time
     *
     * @return the value of eshop_buyer_cart.update_time
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_buyer_cart.update_time
     *
     * @param updateTime the value for eshop_buyer_cart.update_time
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_buyer_cart.user_id
     *
     * @return the value of eshop_buyer_cart.user_id
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_buyer_cart.user_id
     *
     * @param userId the value for eshop_buyer_cart.user_id
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public EshopBuyerCart(String id, Integer isDel, Date createTime, Date updateTime, String userId) {
        this.id = id;
        this.isDel = isDel;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
    }

    public EshopBuyerCart() {
    }
}