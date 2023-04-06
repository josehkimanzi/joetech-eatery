package com.joetech.eatery.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joetech.eatery.entity.Food;
import com.joetech.eatery.exception.ResourceNotFoundException;
import com.joetech.eatery.jpa.FoodRepository;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public List<Food> searchByName(List<Food> foods, String name) {
        return foods.stream()
                .filter(food -> food.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Food> filterByMaxPrice(List<Food> foods, Double maxPrice) {
        return foods.stream()
                .filter(food -> food.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Food> filterByMinPrice(List<Food> foods, Double minPrice) {
        return foods.stream()
                .filter(food -> food.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }

    public List<Food> sortByField(List<Food> foods, String field, String order) {
        Comparator<Food> comparator = null;
        switch (field) {
            case "name":
                comparator = Comparator.comparing(Food::getName);
                break;
            case "price":
                comparator = Comparator.comparing(Food::getPrice);
                break;
            // add more cases for other fields as needed
            default:
                // default to sorting by name if an invalid field is provided
                comparator = Comparator.comparing(Food::getName);
        }

        if (order.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }

        return foods.stream().sorted(comparator).collect(Collectors.toList());
    }

	public Food createFood(Food food) {
		 return foodRepository.save(food);
	}

	public Food updateFood(Long id, Food food) {
		 Optional<Food> optionalFood = foodRepository.findById(id);
	        if (optionalFood.isPresent()) {
	            Food existingFood = optionalFood.get();
	            existingFood.setName(food.getName());
	            existingFood.setDescription(food.getDescription());
	            existingFood.setPrice(food.getPrice());
	            return foodRepository.save(existingFood);
	        } else {
	            throw new ResourceNotFoundException("Food not found with id " + id);
	        }
	}

	public boolean deleteFood(Long id) {
		// TODO Auto-generated method stub
		Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            foodRepository.deleteById(id);
            return true;
        } else {
        	 return false;
          //  throw new ResourceNotFoundException("Food not found with id " + id);
           
        }
	}

    // Other service methods for searching, filtering, and sorting foods



}

