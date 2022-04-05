package com.schinaman.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schinaman.project.entities.CardPayment;
import com.schinaman.project.entities.InvoicePayment;

// permite que o jackson instancie as classes a partir o pagamento especifico para inserção de Order
@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(CardPayment.class);
				objectMapper.registerSubtypes(InvoicePayment.class);
				super.configure(objectMapper);
			};
		};
		return builder;
	}
}
