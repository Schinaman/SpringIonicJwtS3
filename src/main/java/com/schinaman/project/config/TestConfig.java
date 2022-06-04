package com.schinaman.project.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.schinaman.project.services.DBService;
import com.schinaman.project.services.EmailService;
import com.schinaman.project.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDataBase();
			return true;
	}
	
	// quando eu anoto um metodo como @Bean eu disponibilizo esse metodo como um componente do sistema
	// se em outra classe eu faço uma uma injeção com autowired, o spring procura por um componente q pode ser o @Bean e retorna uma instancia do obj
	// pra dizer que a @Autowired na *Interfece* do OrderService é uma instancia de MockEmailService. Não dá p instanciar interce 
	@Bean
	public EmailService emailSerice() {
		return new MockEmailService();
	}
}
