package com.joetech.eatery.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity(name = "Order")
@Table(name = "orders",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Order {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long foodId;

	    private Long userId;

	    private int quantity;

	    private String status;
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

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Optional<Food> getFood() {
			return food;
		}

		public void setFood(Optional<Food> food) {
			this.food = food;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", foodId=" + foodId + ", userId=" + userId + ", quantity=" + quantity
					+ ", status=" + status + ", food=" + food + "]";
		}
		


	    // getters and setters

}
