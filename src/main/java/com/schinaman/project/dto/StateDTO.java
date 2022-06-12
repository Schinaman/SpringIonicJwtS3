package com.schinaman.project.dto;

import java.io.Serializable;

import com.schinaman.project.entities.State;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StateDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public StateDTO(State obj) {
		id = obj.getId();
		name = obj.getName();
	}
}
