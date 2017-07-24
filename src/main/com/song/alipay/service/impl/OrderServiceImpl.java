package com.song.alipay.service.impl;

import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.github.pagehelper.PageInfo;
import com.song.alipay.common.AccessURL;
import com.song.alipay.dao.OrderMapper;
import com.song.alipay.domain.Order;
import com.song.alipay.dto.query.OrderQuery;
import com.song.alipay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Song on 2017/7/20.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DefaultAlipayClient alipayClient;

    @Override
    public PageInfo<Order> pageOrders(OrderQuery query) {
        //PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Order> list = orderMapper.listOrder();
        return new PageInfo<>(list);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Override
    public Boolean save(Order order) {
        if (order != null && order.getId() == null) {
            order.setStatus("0");
        }
        return orderMapper.insert(order) > 0 ? true : false;
    }

    public Order getById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Override
    public Boolean update(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order) > 0 ? true : false;
    }

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Override
    public Boolean remove(Integer id) {
        return orderMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @Override
    public String getAlipayForm(Integer orderId) throws Exception{
        Order order = getById(orderId);
        AlipayTradeWapPayRequest payRequest = new AlipayTradeWapPayRequest();
        payRequest.setReturnUrl(AccessURL.ALI_PAY_RETURN_URL);
        payRequest.setNotifyUrl(AccessURL.ALI_PAY_NOTIFY_URL);
        payRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+order.getId()+"\"," +
                "    \"total_amount\":\""+order.getAmount()+"\"," +
                "    \"subject\":\""+order.getGoodsName()+"\"," +
                "    \"product_code\":\"QUICK_WAP_PAY\"" +
                "  }");//填充业务参数

        AlipayTradeWapPayResponse response = alipayClient.execute(payRequest);
        String body = response.getBody();
        return body;
    }

    @Override
    public Boolean refound(Integer orderId) throws Exception{
        Order order = getById(orderId);
        AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
        refundRequest.setBizContent("{" +
                "\"out_trade_no\":\""+order.getId()+"\"," +
                "\"trade_no\":\""+order.getAliTradeNo()+"\"," +
                "\"refund_amount\":"+order.getAmount()/100.00+"," +
                "\"refund_reason\":\"正常退款\"," +
                "  }");
        AlipayTradeRefundResponse response = alipayClient.execute(refundRequest);
        if (response.isSuccess()) {
            //修改订单
            order.setStatus("6");
            order.setAmount(0);
            update(order);

            return true;
        }
        return false;
    }
}
