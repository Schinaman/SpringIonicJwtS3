package com.schinaman.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_ORDER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Order implements Serializable {
	private static final long serialVersionUID = 7860581297555175651L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Setter (AccessLevel.NONE)
	private Integer id;
	private Date instante;
	
	@OneToOne (cascade=CascadeType.ALL, mappedBy = "order") //como é o mesmo id cascade all trata trata a transiencia da informação por nao estar salva no bd
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "addressDelivery_id")
	private Address addressDelivery;

	public Order(Integer id, Date instante,  Client client, Address addressDelivery) { //Payment payment para poder instanciar pedido primeiro
		super();
		this.id = id;
		this.instante = instante;
		this.client = client;
		this.addressDelivery = addressDelivery;
	}
	
	
	
}
