package com.schinaman.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.schinaman.project.entities.enums.PaymentState;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_PAYMENT")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	private static final long serialVersionUID = 8032306653868479057L;
	
	@Id
	@Setter (AccessLevel.NONE)
	private Integer id; //id do pagamento é o mesmo do pedido
	@Getter (AccessLevel.NONE)
	private Integer paymentState;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn (name = "order_id")
	@MapsId //id do pagamento é o mesmo do pedido
	private Order order;

	public Payment(Integer id, PaymentState paymentState, Order order) {
		super();
		this.id = id;
		this.paymentState = (paymentState==null) ?null : paymentState.getCode();
		this.order = order;
	}


	public PaymentState getPaymentState (Integer code) {
		return PaymentState.toEnum(code);
	}

	
	
	
	
}
