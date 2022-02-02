package com.schinaman.project;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.schinaman.project.entities.Address;
import com.schinaman.project.entities.CardPayment;
import com.schinaman.project.entities.Category;
import com.schinaman.project.entities.City;
import com.schinaman.project.entities.Client;
import com.schinaman.project.entities.InvoicePayment;
import com.schinaman.project.entities.Order;
import com.schinaman.project.entities.Payment;
import com.schinaman.project.entities.Product;
import com.schinaman.project.entities.State;
import com.schinaman.project.entities.Telephone;
import com.schinaman.project.entities.enums.PaymentState;
import com.schinaman.project.entities.enums.TypeClient;
import com.schinaman.project.repositories.AddressRepository;
import com.schinaman.project.repositories.CategoryRepository;
import com.schinaman.project.repositories.CityRepository;
import com.schinaman.project.repositories.ClientRepository;
import com.schinaman.project.repositories.OrderRepository;
import com.schinaman.project.repositories.PaymentRepository;
import com.schinaman.project.repositories.ProductRepository;
import com.schinaman.project.repositories.StateRepository;
import com.schinaman.project.repositories.TelephoneRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository adressRepository;
	@Autowired
	private TelephoneRepository telephoneRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Product p1 = new Product (null, "Computador" , 2000.00);
		Product p2 = new Product (null, "Impressora" , 800.00);
		Product p3 = new Product (null, "Mouse" , 80.00);
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
	
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");
		City city1 = new City(null, "Uberlândia", state1); 
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		state1.getCities().addAll(Arrays.asList(city1));
		state1.getCities().addAll(Arrays.asList(city2, city3));
		
		Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", TypeClient.PESSOAFISICA);
		Telephone tel1 = new Telephone("27363323", client1); 
		Telephone tel2 = new Telephone("93838393", client1);
		Address end1 = new Address(null, "Rua Flores", "300", "apto300", "Jardim","38220834", client1, city1 );
		Address end2 = new Address(null, "Avenida Matos", "105", "Sala8000", "Centro","38777012", client1, city2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Order order1 = new Order(null, sdf.parse("30/09/2017 10:32"), client1, end1);
		Order order2 = new Order(null, sdf.parse("10/10/2017 19:35"), client1, end2);
		
		Payment payment1 = new CardPayment(null, PaymentState.QUITADO, order1, 6);
		order1.setPayment(payment1); // preciso setar depois já que eu tirei do construtor para poder instaciar pedido;
		
		Payment payment2 = new InvoicePayment(null, PaymentState.PENDENTE, order2, sdf.parse("20/10/2017 00:00"), null);
		order2.setPayment(payment2);
		
		client1.getPedidos().addAll(Arrays.asList(order1, order2));

		
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		clientRepository.saveAll(Arrays.asList(client1));
		adressRepository.saveAll(Arrays.asList(end1, end2));
		telephoneRepository.saveAll(Arrays.asList(tel1, tel2));
		
		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
	
	}

}
