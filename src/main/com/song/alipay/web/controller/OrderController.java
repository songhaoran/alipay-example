package com.song.alipay.web.controller;

import com.github.pagehelper.PageInfo;
import com.song.alipay.common.AccessURL;
import com.song.alipay.domain.Order;
import com.song.alipay.dto.query.OrderQuery;
import com.song.alipay.service.OrderService;
import com.song.alipay.util.ReturnMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Song on 2017/7/20.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = AccessURL.ORDER_LIST)
    public String toOrderList(OrderQuery query,Model model) {
        PageInfo<Order> page = orderService.pageOrders(query);
        model.addAttribute("page", page);
        return "/order/order-list";
    }

    @RequestMapping("/order/edit")
    public String edit(Integer id,Model model) {
        Order order;
        if (id == null) {
            order = new Order();
        } else {
            order = orderService.getById(id);
        }
        model.addAttribute("obj", order);
        return "/order/order-edit";
    }

    @PostMapping(value = AccessURL.SAVE_ORDER)
    @ResponseBody
    public Map<String,Object> save(Order order) {
        if (orderService.save(order)) {
            return ReturnMapUtil.getOKResult();
        }
        return ReturnMapUtil.getErrorResult("保存失败!");
    }

    @GetMapping(value = AccessURL.PAY_FOR_ORDER, produces = "text/html;charset=UTF-8")
    public String pay(Integer id) throws Exception {
        String alipayForm = orderService.getAlipayForm(id);
        return alipayForm;
    }
}
