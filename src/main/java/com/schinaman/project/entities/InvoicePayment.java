package com.schinaman.project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.schinaman.project.entities.enums.PaymentState;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "TB_INVOICE_PAYMENT")
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonTypeName("pagamentoComBoleto")
public class InvoicePayment extends Payment{
	private static final long serialVersionUID = -7993336783228537348L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dueDate;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date paymentDate;
	
	public InvoicePayment(Integer id, PaymentState paymentState, Order order, Date dueDate, Date paymentDate) {
		super(id, paymentState, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	
}
