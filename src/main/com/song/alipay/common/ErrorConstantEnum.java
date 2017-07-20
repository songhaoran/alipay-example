package com.song.alipay.common;

/**
 * 错误提示大全
 * 系统错误：40000以后
 * 业务错误：50000以后
 */
public enum ErrorConstantEnum {
    ERROR_USERNAME_PWD("50000", "用户名或密码错误"),


    CART_ADD_FAIL("50001", "添加购物车失败"),
    CART_MODIFY_FAIL("50002", "修改购物车失败"),
    CART_DELETE_FAIL("50003", "删除购物车失败"),

    ORDER_CONFIRM_FAIL("50004", "确认收货失败"),
    ORDER_CANCEL_FAIL("50005", "取消订单失败"),
    ORDER_CREATE_FAIL("50006", "下单失败,请重新下单"),
    ORDER_DELETE_FAIL("50014", "删除订单失败"),
    ORDER_ADD_REFUND_APPLY_FAIL("50011", "申请退款失败"),
    ORDER_HAS_PAYED_INFO_FAIL("50012", "订单未支付"),
    ORDER_FOOD_CODE_EXPIRED("51013", "券码不在有效期"),
    ORDER_FOOD_CODE_HAS_USED("51013", "券码已经消费过"),
    ORDER_FOOD_CODE_NULL("51013", "券码不存在"),
    ORDER_FOOD_CODE_GOOD_NULL("51013", "餐饮商品不存在"),
    ORDER_FOOD_CODE_GOOD_REMOVED("51013", "餐饮商品已下架"),


    COUPON_RECEIVE_FAIL("50007", "优惠券领取失败"),
    COUPON_EXCHANGE_FAIL("50008", "优惠券兑换失败"),
    COUPON_CODE_EXPIRED("50009", "兑换码已失效"),
    COUPON_CODE_ERROR("50010", "请输入正确的兑换码"),
    COUPON_CODE_USED("50011", "兑换码已使用"),
    COUPON_UPPER_LIMIT("50012", "该类型优惠券已达到上限"),

    ILLEGAL_SMS_CODE("50017", "验证码错误"),
    EXIST_USER_ERROR("50018", "该手机号已注册，请登录"),
    NOT_EXIST_USER_ERROR("50019", "该手机号未注册，请注册"),
    PASSWORD_ERROR("50011", "密码错误"),
    OLD_PASSWORD_ERROR("50012", "愿密码错误"),
    NOT_EXIST_BROKER("50013", "您未注册经纪人账号"),

    GIFT_CARD_NOT_FOUND("50030", "礼品卡不存在"),
    GIFT_CARD_NOT_STOCK("50030", "礼品卡商品库存不足"),
    GIFT_CARD_EXPIRED("50031", "礼品卡不在有效期"),
    GIFT_CARD_CODE_ERROR("50032", "兑换码错误"),
    GIFT_CARD_CODE_HAS_USED("50033", "兑换码已经兑换过"),
    INTEGRAL_GOODS_NOT_FOUND("50035", "积分商品不存在"),
    INTEGRAL_GOODS_REMOVED("50034", "积分商品已下架"),
    INTEGRAL_GOODS_NOT_STOCK("50036", "积分商品库存不足"),

    INTEGRAL_NOT_ENOUGH("50037", "用户积分不足"),
    ACTIVITY_NOT_EXIST("50038", "活动不存在"),
    PARTICIPATION_CHANCE_ZERO("50039", "您没有抽奖机会了"),
    NOT_IN_DURATION("50040", "不在活动时间范围内"),

    SURVEY_NO_PAPER("50050", "问卷不存在或已过期"),
    USER_PASSWD_ERROR("50051", "原密码错误"),

    //邀请活动
    THIS_INVITATION_END("50061","该活动已结束"),
    REGISTER_FROM_INVITATION_ERROR("50062","通过邀请活动注册失败"),
    REGISTER_FROM_INVITATION_EXIST_ERROR("50063","该手机号已经注册过了"),

    STOCK_SHORTAGE("50035", "您购买的商品暂时缺货，请重新挑选商品"),

    ADD_FEEDBACK_FAIL("50036", "新增消息失败"),

    NO_PARAMETER_ERROR("40001", "沒有提交必要参数，请联系客服"),

    DATABASE_ERROR("40002", "插入数据库出现异常，请联系客服"),

    SYSTEM_ERROR("40003", "系统错误，请联系客服"),

    ORG_CUSTOMER_FALUT("40003", "系统错误，请联系客服"),

    NO_DATA("40004", "暂时没有数据，请等待"),

    limit_access_frequency("40005", "访问太过频繁"),

    ILLEGAL_USER_AUTH("40006", "用户未通过验证"),

    ILLEGAL_PARAM_AUTH("40007", "认证参数无效"),

    SEND_SMS_ERROR("40008", "验证码发送失败"),

    ILLEGAL_ACCESS("40009", "非法访问"),

    ILLEGAL_PARAM("40010", "非法参数"),

    ERROR_UPLOAD_IMAGE("40011", "图片上传失败"),

    ERROR_OPERATEION("40012", "操作失败"),

    IS_LATEST_VERSION("40013", "当前版本是最新版本"),

    SEARCH_KEYWORD_ERROR("60001", "搜索关键词为空"),
    NEWS_PRAISE_FAIL("60002", "点赞失败"),
    NEWS_PRAISE_ALREADY_PRAISED_ERROR("60003", "已经赞过了"),
    NEWS_CANCEL_PRAISE_FAIL("60004", "取消点赞失败"),

    GET_WX_OPEN_ID_FAIL("60005", "获取微信openId失败"),

    ORDER_IMPORT_EXPRESS_FILE_FORMAT_ERROR("60010", "请使用Excel2003(.xls)格式导入"),
    ORDER_IMPORT_EXPRESS_FILE_ERROR("60011", "导入失败，请重新导入"),


    OK("200", "恭喜，操作成功");


    private final String code;
    private final String msg;


    ErrorConstantEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
