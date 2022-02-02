package com.schinaman.project.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.schinaman.project.entities.enums.PaymentState;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_Card_Payment")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CardPayment extends Payment{
	private static final long serialVersionUID = -2055299287367869144L;
	
	private Integer numberOfParcels;

	public CardPayment(Integer id, PaymentState paymentState, Order order, Integer numberOfParcels) {
		super(id, paymentState, order);
		this.numberOfParcels = numberOfParcels;
	}
	
	
}
