package com.joetech.eatery.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "Food")
@Table(name = "food",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 200)
    private String name;

    @Column(name = "description", nullable = true, length = 200)
    private String description;

    @Column(name = "price", nullable = true)
    private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
    

}
