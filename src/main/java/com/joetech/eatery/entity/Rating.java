package com.joetech.eatery.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity(name = "Rating")
@Table(name = "rating",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Rating {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long foodId;

	    private Long userId;

	    private int rating;

	    private String comment;
	    @Transient
	    private Optional<Food> food; 

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getFoodId() {
			return foodId;
		}

		public void setFoodId(Long foodId) {
			this.foodId = foodId;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Optional<Food> getFood() {
			return food;
		}

		public void setFood(Optional<Food> optionalFood) {
			this.food = optionalFood;
		}

		@Override
		public String toString() {
			return "Rating [id=" + id + ", foodId=" + foodId + ", userId=" + userId + ", rating=" + rating
					+ ", comment=" + comment + ", food=" + food + "]";
		}



		}


	



