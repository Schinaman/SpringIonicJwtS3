package com.schinaman.project.resources.Exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable{
	private static final long serialVersionUID = -5024800428084467532L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	

}
