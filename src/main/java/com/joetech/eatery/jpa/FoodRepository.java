package com.joetech.eatery.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joetech.eatery.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
