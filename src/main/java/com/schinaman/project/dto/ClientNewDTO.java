package com.schinaman.project.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.schinaman.project.services.validation.ClientInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ClientInsert
public class ClientNewDTO implements Serializable{ //utilizado para o metodo Insert Post
	private static final long serialVersionUID = -7098318953931222838L;
	
		@NotEmpty(message="Preenchimento obrigatório")
		@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
		@Email(message="Email obrigatório")
		@NotEmpty(message="Preenchimento obrigatório")
	private String email;
	private String cpfOuCnpj; //validação depende do tipo; criar validação customizada da classe
	private Integer type; 
	
		@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
		@NotEmpty(message="Preenchimento obrigatório")
	private String number;
	private String complement;
	private String bairro;
		@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	private Integer cityId;	
		@NotEmpty(message="Preenchimento obrigatório")
	private String telephone1;
	private String telephone2;
	private String telephone3;
	

}
