package com.schinaman.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name="TB_CITY")
@EqualsAndHashCode (of = "id")
@NoArgsConstructor
@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 1945875053099663250L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Getter
	private Integer id;
	
	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;
	
	
	public City(Integer id, String name, State state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}
	
	
}







