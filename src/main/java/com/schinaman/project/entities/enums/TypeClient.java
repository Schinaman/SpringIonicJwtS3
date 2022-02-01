package com.schinaman.project.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeClient {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int code;
	private String description;
	
	public static TypeClient toEnum (Integer code) {
		if (code == null) {
			return null;
		}
		for (TypeClient x : TypeClient.values()) {
			return x;
		}
		
		throw new IllegalArgumentException("Id inválido: " + code);
	}
	
}
