package com.schinaman.project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	
	//acesso direto aos objetos para melhorar a semantica n precisar acessar primeiro o id PK
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
}
