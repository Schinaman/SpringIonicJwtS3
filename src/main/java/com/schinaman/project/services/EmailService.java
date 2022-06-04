package com.schinaman.project.services;

import org.springframework.mail.SimpleMailMessage;

import com.schinaman.project.entities.Order;

public interface EmailService {
	void sendOrderConfirmationEmail(Order obj);
	void sendEmail(SimpleMailMessage msg);
}
