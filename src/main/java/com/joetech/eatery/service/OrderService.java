package com.joetech.eatery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joetech.eatery.entity.Food;
import com.joetech.eatery.entity.Order;
import com.joetech.eatery.entity.Rating;
import com.joetech.eatery.exception.ResourceNotFoundException;
import com.joetech.eatery.jpa.FoodRepository;
import com.joetech.eatery.jpa.OrderRepository;

@Service
public class OrderService {
	 @Autowired
	    private OrderRepository orderRepository;
	 @Autowired
	 private FoodRepository foodRepository;

	    public Order createOrder(Order order) {
	    	 Optional<Food> optionalFood = foodRepository.findById(order.getFoodId());
		        if (optionalFood.isPresent()) {
		        	return orderRepository.save(order);
		        	
		        } else {
		            throw new ResourceNotFoundException("Food not found with id " + order.getFoodId());
		        }	
		       }
	        
	    

	    public List<Order> getOrdersByFoodId(Long foodId) {
	    	List<Order> orders= orderRepository.findByFoodId(foodId);
	    	Optional<Food> optionalFood = foodRepository.findById(foodId);
	    	for (Order order : orders) {
	            order.setFood(optionalFood);
	        }
	    	return orders;
	    }
	    public List<Order> getAllOrders() {
	    	List<Order> orders=orderRepository.findAll();
	    	for (Order order : orders) {
	    		Optional<Food> optionalFood = foodRepository.findById(order.getFoodId());
	            order.setFood(optionalFood);
	        }
			return orders;
		}


	    // Other service methods for updating and deleting orders

}
