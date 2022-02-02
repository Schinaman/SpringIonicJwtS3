package com.schinaman.project.entities.enums;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentState {

	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");

	private Integer code;
	private String description;

	public static PaymentState toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (PaymentState x : PaymentState.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + code);

	}
}
