package com.song.alipay.service;

import com.github.pagehelper.PageInfo;
import com.song.alipay.domain.Order;
import com.song.alipay.dto.query.OrderQuery;

/**
 * Created by Song on 2017/7/20.
 */
public interface OrderService {

    PageInfo<Order> pageOrders(OrderQuery query);


    Boolean save(Order order);

    Order getById(Integer id);

    Boolean update(Order order);

    Boolean remove(Integer id);

    String getAlipayForm(Integer orderId) throws Exception;

    /**
     * 退款
     * @param orderId 订单id
     * @return
     */
    Boolean refound(Integer orderId) throws Exception;
}
