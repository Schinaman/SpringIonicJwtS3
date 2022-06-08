package com.schinaman.project.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmailDTO implements Serializable{
	private static final long serialVersionUID = 6859412778959598054L;
	
	@Email(message="Email obrigatório")
	private String email;
	
}
