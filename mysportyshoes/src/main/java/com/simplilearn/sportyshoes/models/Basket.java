package com.simplilearn.sportyshoes.models;

//@Entity
//@Table(name = "basket")
public class Basket {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String category;
	private String brand;
	private String email;
	private String descr;
	private String color;
	private int size;
	private String status;
	private Double price;
	private int quantity;

	public Basket() {
	 	super();
	}

	public Basket(int id, String category, String brand, String email, String descr, String color, int size,
			String status, Double price, int quantity) {
		super();
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.email = email;
		this.descr = descr;
		this.color = color;
		this.size = size;
		this.status = status;
		this.price = price;
		this.quantity = quantity;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", category=" + category + ", brand=" + brand + ", email=" + email + ", descr=" + descr
				+ ", color=" + color + ", size=" + size + ", status=" + status + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

}
