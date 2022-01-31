package com.schinaman.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name="TB_STATE")
@EqualsAndHashCode (of = "id")
@NoArgsConstructor
@Entity
public class State implements Serializable {
	private static final long serialVersionUID = 868839266653967780L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter
	private Integer id;
	
	@Getter
	@Setter
	private String name;

	@Getter
	@OneToMany (mappedBy = "state")
	private List<City> cities = new ArrayList<City>();
	
	
	public State(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
