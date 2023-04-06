package com.joetech.eatery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joetech.eatery.entity.Food;
import com.joetech.eatery.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable("id") Long id) {
        return foodService.getFoodById(id);
    }

    @GetMapping("/")
    public List<Food> getAllFoods(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) Double maxPrice,
                                   @RequestParam(required = false) Double minPrice,
                                   @RequestParam(required = false) String sortBy,
                                   @RequestParam(required = false) String sortOrder) {
        List<Food> foods = foodService.getAllFoods();

        if (name != null) {
            foods = foodService.searchByName(foods, name);
        }

        if (maxPrice != null) {
            foods = foodService.filterByMaxPrice(foods, maxPrice);
        }

        if (minPrice != null) {
            foods = foodService.filterByMinPrice(foods, minPrice);
        }

        if (sortBy != null && sortOrder != null) {
            foods = foodService.sortByField(foods, sortBy, sortOrder);
        }

        return foods;
    }
    @PostMapping("/")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable("id") Long id, @RequestBody Food food) {
        Food updatedFood = foodService.updateFood(id, food);
        if (updatedFood == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable("id") Long id) {
        boolean deleted = foodService.deleteFood(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    
    // Other endpoints for searching, filtering, and sorting foods


}
