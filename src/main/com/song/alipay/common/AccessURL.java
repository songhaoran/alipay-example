package com.song.alipay.common;

/**
 * Created by Song on 2017/7/20.
 */
public interface AccessURL {
    //服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    String ALI_PAY_NOTIFY_URL = "/ali/pay/notify";

    //页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    String ALI_PAY_RETURN_URL = "/ali/pay/return";

    //订单列表
    String ORDER_LIST = "/order/list";

    //保存订单
    String SAVE_ORDER = "/order/save";

    //订单支付
    String PAY_FOR_ORDER = "/order/pay";
}
