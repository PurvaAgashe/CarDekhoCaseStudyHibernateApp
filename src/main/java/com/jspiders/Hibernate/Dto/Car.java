package com.jspiders.Hibernate.Dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table (name = "carInfo")
public class Car {
 
	@Id
	@Column(name = "car_id")
	private int car_id;
	@Column(name="name")
	private String name;
	@Column(name = "model")
	private String model;
	@Column(name="brand")
	private String brand;
	@Column(name = "fuel_type")
	private String fuel_type;
	@Column(name= "price")
	private double price;
}
