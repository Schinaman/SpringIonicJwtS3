package com.schinaman.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = -4462717412250644233L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Integer id;
	private String logradouro;
	private String number;
	private String complement;
	private String bairro;
	private String cep;
	
	@JsonBackReference //?
	@ManyToOne
	@JoinColumn (name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn (name = "city_id")
	private City city;
	
	
	public Address(Integer id, String logradouro, String number, String complement, String bairro, String cep, Client client, City city) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.number = number;
		this.complement = complement;
		this.bairro = bairro;
		this.cep = cep;
		this.client = client;
		this.city = city;
	}
	

	
	
	
}
