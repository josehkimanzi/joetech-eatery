package com.joetech.eatery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joetech.eatery.entity.Food;
import com.joetech.eatery.entity.Rating;
import com.joetech.eatery.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping("/{foodId}")
    public List<Rating> getRatingsByFoodId(@PathVariable("foodId") Long foodId) {
        return ratingService.getRatingsByFoodId(foodId);
    }
    @GetMapping("/")
    public List<Rating> getAllRatings(){
    	 List<Rating> ratings = ratingService.getAllRatings();
    	 return ratings;
    	
    }

    // Other endpoints for updating and deleting ratings

}
