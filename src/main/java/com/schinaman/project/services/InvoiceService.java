package com.schinaman.project.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.schinaman.project.entities.InvoicePayment;

@Service
public class InvoiceService {

	public void preencherPagamentoComBoleto(InvoicePayment payment, Date instanteDoPedido){
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		payment.setDueDate(cal.getTime());
	}
}
