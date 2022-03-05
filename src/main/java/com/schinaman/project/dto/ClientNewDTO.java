package com.schinaman.project.dto;

import java.io.Serializable;

import com.schinaman.project.entities.Telephone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientNewDTO implements Serializable{ //utilizado para o metodo Insert Post
	private static final long serialVersionUID = -7098318953931222838L;
	
	
	private String name;
	private String email;
	private String cpfOuCnpj;
	private Integer type; 
	
	private String logradouro;
	private String number;
	private String complement;
	private String bairro;
	private String cep;
	
	private Integer cityId;	

	private String telephone1;
	private String telephone2;
	private String telephone3;
	

}
