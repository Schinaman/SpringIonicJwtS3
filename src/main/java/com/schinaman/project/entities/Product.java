package com.schinaman.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_PRODUCT")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = -6572197248220127872L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Integer id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private Double price;
	
	
	@Getter
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUCT_CATEGORY", 
				joinColumns = @JoinColumn(name = "produto_id"),
				inverseJoinColumns = @JoinColumn(name = "category_id")) 
	private List<Category> categories = new ArrayList<>();
	//nome tabela intermediaria + nome do campo da tabela correspondente ao codigo do produto (fk), + nome da outra chave estrangeira que vai referenciar a categoria (fk2)
	
	@JsonIgnore
	@Setter(AccessLevel.NONE)
	@OneToMany (mappedBy = "id.product")
	private Set<ItemOrder> items = new HashSet<>();
	
	public Set<ItemOrder> getItems() {
		return items;
	}
	

	public Product(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	@JsonIgnore
	public List<Order> getOrders(){
		List<Order> list = new ArrayList<>();
		for (ItemOrder x : items) {
			list.add(x.getOrder());
		}
		return list;
	}
	
	
}
