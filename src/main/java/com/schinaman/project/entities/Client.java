package com.schinaman.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	private Integer id;
	private String name;
	//@Column(unique=true) // essa anotation do jpa já garante que será uma chave candidata c valor unico, mas ao tentar inserir é o bd que lança a exceção (spring data) e pouco controle sobre a exceção e tratamento
	private String email;
	private String cpfOuCnpj;
	@Getter(AccessLevel.NONE)
	private Integer type; //vai expor dado "TypeClient"
	
	
	//exemplo para entidade fraca, não precisaria criar repository, solução questionavel, @ElementCollection ;break; @CollectionTable (name = "tb_telefone")
	@Setter(AccessLevel.NONE)
	@JsonManagedReference
	@OneToMany (mappedBy = "client", cascade=CascadeType.ALL)
	private List<Telephone> telephones = new ArrayList<>();
	
	@Setter(AccessLevel.NONE)
	@JsonManagedReference
	@OneToMany (mappedBy = "client", cascade=CascadeType.ALL) //permite apagar os endereços relacionados;
	private List<Address> addresses = new ArrayList<>();
	
	@JsonBackReference
	@Setter(AccessLevel.NONE)
	@OneToMany (mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public Client(Integer id, String name, String email, String cpfOuCnpj, TypeClient type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.type = (type==null) ? null : type.getCode() ;
	}

	public TypeClient getType() { // o get é um tipo "TypeClient" Jpa vai retornar o retorno do GET do atributo type
		return TypeClient.toEnum(this.type);
	}
	
	
}
