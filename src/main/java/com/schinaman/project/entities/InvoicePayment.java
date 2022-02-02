package com.schinaman.project.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.schinaman.project.entities.enums.PaymentState;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class InvoicePayment extends Payment{
	private static final long serialVersionUID = -7993336783228537348L;
	
	private Date dueDate;
	private Date paymentDate;
	
	public InvoicePayment(Integer id, PaymentState paymentState, Order order, Date dueDate, Date paymentDate) {
		super(id, paymentState, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	
}
