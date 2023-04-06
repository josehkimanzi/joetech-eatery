package com.joetech.eatery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joetech.eatery.entity.Food;
import com.joetech.eatery.entity.Rating;
import com.joetech.eatery.exception.ResourceNotFoundException;
import com.joetech.eatery.jpa.FoodRepository;
import com.joetech.eatery.jpa.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
	 @Autowired
	 private FoodRepository foodRepository;

    public Rating createRating(Rating rating) {
    	int ratingValue = rating.getRating();
    	  if (ratingValue < 1 || ratingValue > 5) {
              throw new IllegalArgumentException("Rating must be between 1 and 5");
          }
    	  else {
    		  Optional<Food> optionalFood = foodRepository.findById(rating.getFoodId());
		        if (optionalFood.isPresent()) {
		        	 return ratingRepository.save(rating);
		        	
		        } else {
		            throw new ResourceNotFoundException("Food not found with id " + rating.getFoodId());
		        }
		        
    		 
    		  
    	  }
        
    }

    public List<Rating> getRatingsByFoodId(Long foodId) {
    	List<Rating> ratings=ratingRepository.findByFoodId(foodId);
    	Optional<Food> optionalFood = foodRepository.findById(foodId);
    	for (Rating rating : ratings) {
            rating.setFood(optionalFood);
        }
        return ratings;
       
    }

	public List<Rating> getAllRatings() {
		List<Rating> ratings =ratingRepository.findAll();
    	for (Rating rating : ratings) {
    		Optional<Food> optionalFood = foodRepository.findById(rating.getFoodId());
            rating.setFood(optionalFood);
        }
		return ratings;
	}

    // Other service methods for updating and deleting ratings

}
