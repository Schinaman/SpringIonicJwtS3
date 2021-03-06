package com.schinaman.project.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_ITEM_ORDER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class ItemOrder implements Serializable{
	private static final long serialVersionUID = 7935727227544456854L;

	@JsonIgnore
	@EmbeddedId
	private ItemOrderPK id = new ItemOrderPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public ItemOrder(Order order, Product product, Double discount, Integer quantity, Double price) { //ItemOrderPK id,
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}
	
	public double getSubTotal() {
		return (price - discount) * quantity;
	}
	
	//acesso direto aos objetos para melhorar a semantica n precisar acessar primeiro o id PK
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getProduct().getName());
		builder.append(", Qtde: ");
		builder.append(getQuantity());
		builder.append(", Preço unitário: ");
		builder.append(nf.format(getPrice()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
	
	
	
	
}
