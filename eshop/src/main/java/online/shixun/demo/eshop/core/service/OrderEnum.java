/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.core.service;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName OrderEnum
 * @Description TODO
 * @Date 2018/05/17 13:42
 * @Author shixun.online
 * @Version 1.0
 **/
public enum OrderEnum {

    ;

    /**
     * 配送方式
     */
    public enum PaymentWayEnum {
        outside_delivery(".自取", 1),
        home_delivery("送货上门", 2);

        protected String name;
        protected int index;

        PaymentWayEnum(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        /**
         * 根据编码获得名称
         *
         * @param index
         * @return
         */
        public String getName(int index) {
            return Arrays.stream(PaymentWayEnum.values()).filter(paymentWayEnum -> Objects.equals(paymentWayEnum.getIndex(), index)).findFirst().get().getName();
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 订单付款方式
     */
    public enum PaymentCashEnum {
        cash("现金", 1),
        credit_cart("信用卡", 2);
        protected String name;
        protected int index;

        PaymentCashEnum(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        /**
         * 根据编码获得名称
         *
         * @param index
         * @return
         */
        public String getName(int index) {
            return Arrays.stream(PaymentCashEnum.values()).filter(paymentCashEnum -> Objects.equals(paymentCashEnum.getIndex(), index)).findFirst().get().getName();
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 订单支付状态
     */
    public enum IsPaiyEnum {
        //付款方式
        payment_freight("到付", 1),
        payment_wait("待付款", 2),
        payment_succeed("已付款", 3),
        refund_wait("待退款", 4),
        refund_succeed("退款成功", 5),
        refund_error("退款失败", 6);

        // 成员变量
        protected String name;
        protected int index;

        IsPaiyEnum(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        /**
         * 根据编码获得名称
         *
         * @param index
         * @return
         */
        public String getName(int index) {
            return Arrays.stream(IsPaiyEnum.values()).filter(isPaiyEnum -> Objects.equals(isPaiyEnum.getIndex(), index)).findFirst().get().getName();
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * 订单状态
     */
    public enum StatusEnum {

        //订单状态
        submit("提交订单", 1),
        allocation("仓库配货", 2),
        come("商品出库", 3),
        wait("等待收货", 4),
        accomplish("完成", 5),
        refund_wait("待退货", 6),
        refund_succeed("已退货", 7);

        // 成员变量
        protected String name;
        protected int index;

        StatusEnum(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        /**
         * 根据编码获得名称
         *
         * @param index
         * @return
         */
        public String getName(int index) {
            return Arrays.stream(StatusEnum.values()).filter(statusEnum -> Objects.equals(statusEnum.getIndex(), index)).findFirst().get().getName();
        }

        public int getIndex() {
            return index;
        }
    }

}
