package com.schinaman.project.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.schinaman.project.entities.Client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO implements Serializable{
	private static final long serialVersionUID = -3583627032720001915L;

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		
	}
	
	private Integer id;
		@NotEmpty(message="Preenchimento obrigatório")
		@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
		@Email(message="Email obrigatório")
		@NotEmpty(message="Preenchimento obrigatório")
	private String email;

}
