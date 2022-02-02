package com.schinaman.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.schinaman.project.entities.enums.TypeClient;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_CLIENT")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = -6471186254001615959L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer id;
	private String name;
	private String email;
	private String cpfOuCnpj;
	@Getter(AccessLevel.NONE)
	private Integer type; //vai expor dado "TypeClient"
	
	
	//exemplo para entidade fraca, não precisaria criar repository, solução questionavel, @ElementCollection ;break; @CollectionTable (name = "tb_telefone")
	@Setter(AccessLevel.NONE)
	@JsonManagedReference
	@OneToMany (mappedBy = "client")
	private List<Telephone> telephones = new ArrayList<>();
	
	@Setter(AccessLevel.NONE)
	@JsonManagedReference
	@OneToMany (mappedBy = "client")
	private List<Address> addresses = new ArrayList<>();
	
	@Setter(AccessLevel.NONE)
	@OneToMany (mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public Client(Integer id, String name, String email, String cpfOuCnpj, TypeClient type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.type = type.getCode();
	}

	public TypeClient getType() { // o get é um tipo "TypeClient" Jpa vai retornar o retorno do GET do atributo type
		return TypeClient.toEnum(this.type);
	}
	
	
}
