package com.simplilearn.sportyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private Double finalPrice;
	private Double postage;
	private Double totalPrice;
	@Column(columnDefinition = "longtext")
	private String arrayOfBasketItems;
	private String address;
	private String email;
	private String name;
	private String orderDate;
	private String shipDate;
	private String status;

	public Orders() {
		super();
	}

	public Orders(int id, Double finalPrice, Double postage, Double totalPrice, String arrayOfBasketItems,
			String address, String email, String name, String orderDate, String shipDate, String status) {
	 	super();
		this.id = id;
		this.finalPrice = finalPrice;
		this.postage = postage;
		this.totalPrice = totalPrice;
		this.arrayOfBasketItems = arrayOfBasketItems;
		this.address = address;
		this.email = email;
		this.name = name;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Double getPostage() {
		return postage;
	}

	public void setPostage(Double postage) {
		this.postage = postage;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getArrayOfBasketItems() {
		return arrayOfBasketItems;
	}

	public void setArrayOfBasketItems(String arrayOfBasketItems) {
		this.arrayOfBasketItems = arrayOfBasketItems;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", finalPrice=" + finalPrice + ", postage=" + postage + ", totalPrice=" + totalPrice
				+ ", arrayOfBasketItems=" + arrayOfBasketItems + ", address=" + address + ", email=" + email + ", name="
				+ name + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", status=" + status + "]";
	}

}
