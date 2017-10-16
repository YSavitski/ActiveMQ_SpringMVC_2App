package com.example.activemq.controller;

import com.example.activemq.model.Order;
import com.example.activemq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AppController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String prepareProduct(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = { "/newOrder" }, method = RequestMethod.GET)
    public String prepareOrder(ModelMap model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "order";
    }

    @RequestMapping(value = { "/newOrder" }, method = RequestMethod.POST)
    public String sendOrder(@Valid Order order, BindingResult result,
                            ModelMap model) {
        if (result.hasErrors()) {
            return "order";
        }
        orderService.sendOrder(order);
        model.addAttribute("success", "Order for " + order.getProductName() + " registered.");
        return "ordersuccess";
    }

    @RequestMapping(value = { "/checkStatus" }, method = RequestMethod.GET)
    public String checkOrderStatus(ModelMap model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orderStatus";
    }
}
