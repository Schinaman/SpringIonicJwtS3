package com.schinaman.project.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profile {

	ADMIN(1, "ROLE_ADMIN"), // termo "ROLE" é exigencia do spring security  
	CLIENT(2, "ROLE_CLIENT");
	

	private Integer code;
	private String description;

	public static Profile toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (Profile x : Profile.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + code);

	}
}
