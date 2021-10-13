package io.github.morbidreich.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	private int quantity;
	
	public Cart() {
		super();
	}

	public Cart(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}
}
