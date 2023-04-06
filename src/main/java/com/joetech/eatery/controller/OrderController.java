package com.joetech.eatery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joetech.eatery.entity.Order;
import com.joetech.eatery.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	 @Autowired
	    private OrderService orderService;

	    @PostMapping("/")
	    public Order createOrder(@RequestBody Order order) {
	        return orderService.createOrder(order);
	    }

	    @GetMapping("/{foodId}")
	    public List<Order> getOrdersByFoodId(@PathVariable("foodId") Long foodId) {
	        return orderService.getOrdersByFoodId(foodId);
	    }
	    @GetMapping("/")
	    public List<Order> getAllOrders(){
	    	 List<Order> orders = orderService.getAllOrders();
	    	 return orders;
	    	
	    }

}
