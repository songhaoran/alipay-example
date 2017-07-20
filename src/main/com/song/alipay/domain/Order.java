package com.song.alipay.domain;

public class Order {
    /**
     * 对应数据库 order.id
     * 
     */
    private Integer id;

    /**
     * 对应数据库 order.goods_name
     * 商品名称
     */
    private String goodsName;

    /**
     * 对应数据库 order.amount
     * 订单总价,单位:分
     */
    private Integer amount;

    /**
     * 对应数据库 order.status
     * 订单状态,0:新建,1:已付款;2:已发货;3:已收货;4:退货中;5:已退货;6:已退款
     */
    private String status;

    /**
     * 对应数据库 order.seller_id
     * 销售者id
     */
    private Integer sellerId;

    /**
     * 对应数据库 order.ali_trade_no
     * 
     */
    private String aliTradeNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getAliTradeNo() {
        return aliTradeNo;
    }

    public void setAliTradeNo(String aliTradeNo) {
        this.aliTradeNo = aliTradeNo;
    }
}