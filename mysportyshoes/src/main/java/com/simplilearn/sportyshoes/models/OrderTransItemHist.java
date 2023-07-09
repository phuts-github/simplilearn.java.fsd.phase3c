package com.simplilearn.sportyshoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordertransitemhist")
public class OrderTransItemHist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private int ordersId;
	private int size;
	private Double price;
	private String category;
	private String brand;
	private String descr;
	private String color;
	private String status;
	private String orderDateCYMD;

	public OrderTransItemHist() {
		super();
	}

	public OrderTransItemHist(int id, int ordersId, int size, Double price, String category, String brand, String descr,
			String color, String status, String orderDateCYMD) {
		super();
		this.id = id;
		this.ordersId = ordersId;
		this.size = size;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.descr = descr;
		this.color = color;
		this.status = status;
		this.orderDateCYMD = orderDateCYMD;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderDateCYMD() {
		return orderDateCYMD;
	}

	public void setOrderDateCYMD(String orderDateCYMD) {
		this.orderDateCYMD = orderDateCYMD;
	}

	@Override
	public String toString() {
		return "OrderHistoryTrans [id=" + id + ", ordersId=" + ordersId + ", size=" + size + ", price=" + price
				+ ", category=" + category + ", brand=" + brand + ", descr=" + descr + ", color=" + color + ", status="
				+ status + ", orderDateCYMD=" + orderDateCYMD + "]";
	}

}
