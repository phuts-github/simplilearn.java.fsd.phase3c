package com.simplilearn.sportyshoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String category;
	private String brand;
	private String code;
	private String descr;
	private String color;
	private int size;
	private String status;
	private Double price;

	public Products() {
		super();
	}

	public Products(int id, String category, String brand, String code, String descr, String color, int size, String status,
			Double price) {
		super();
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.code = code;
		this.descr = descr;
		this.color = color;
		this.size = size;
		this.status = status;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", category=" + category + ", brand=" + brand + ", code=" + code + ", descr=" + descr
				+ ", color=" + color + ", size=" + size + ", status=" + status + ", price=" + price + "]";
	}

}
