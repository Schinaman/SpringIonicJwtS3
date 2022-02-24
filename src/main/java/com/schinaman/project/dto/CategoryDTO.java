package com.schinaman.project.dto;

import java.io.Serializable;

import com.schinaman.project.entities.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = 6859412778959598054L;
	
	public CategoryDTO(Category obj) {
		id = obj.getId();
		name = obj.getName();
	}
	
	private Integer id;
	private String name;
}
