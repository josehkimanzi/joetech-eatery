package com.joetech.eatery.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joetech.eatery.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	 List<Rating> findByFoodId(Long foodId);

}
