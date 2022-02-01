package com.schinaman.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_TELEPHONE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Telephone implements Serializable {
	private static final long serialVersionUID = -628219035461422639L;
	
	@Id
	private String number;

	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "client_id")
	private Client client;
	
	
}
