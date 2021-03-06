package online.shixun.demo.eshop.dto;

import java.io.Serializable;

public class EshopProductWithBLOBs extends EshopProduct implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_product.product_description
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String productDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_product.product_information
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String productInformation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_product.product_after_sale
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String productAfterSale;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_product
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_product.product_description
     *
     * @return the value of eshop_product.product_description
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_product.product_description
     *
     * @param productDescription the value for eshop_product.product_description
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_product.product_information
     *
     * @return the value of eshop_product.product_information
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getProductInformation() {
        return productInformation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_product.product_information
     *
     * @param productInformation the value for eshop_product.product_information
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation == null ? null : productInformation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_product.product_after_sale
     *
     * @return the value of eshop_product.product_after_sale
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getProductAfterSale() {
        return productAfterSale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_product.product_after_sale
     *
     * @param productAfterSale the value for eshop_product.product_after_sale
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setProductAfterSale(String productAfterSale) {
        this.productAfterSale = productAfterSale == null ? null : productAfterSale.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_product
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productDescription=").append(productDescription);
        sb.append(", productInformation=").append(productInformation);
        sb.append(", productAfterSale=").append(productAfterSale);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}