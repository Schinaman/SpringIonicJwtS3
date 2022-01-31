package com.schinaman.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_CATEGORY")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Integer id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@JsonManagedReference //do lado que eu quero que venha os objetos associados
	@ManyToMany (mappedBy = "categories")
	private List<Product> products = new ArrayList<>();

	
	
	
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	} 
	
	
	
}
