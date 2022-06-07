package com.schinaman.project.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.Client;
import com.schinaman.project.entities.InvoicePayment;
import com.schinaman.project.entities.ItemOrder;
import com.schinaman.project.entities.Order;
import com.schinaman.project.entities.enums.PaymentState;
import com.schinaman.project.repositories.ItemOrderRepository;
import com.schinaman.project.repositories.OrderRepository;
import com.schinaman.project.repositories.PaymentRepository;
import com.schinaman.project.repositories.ProductRepository;
import com.schinaman.project.security.UserSS;
import com.schinaman.project.services.Exceptions.AuthorizationException;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;



@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo; 
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired ItemOrderRepository itemOrderRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private EmailService emailService;
	
	public Order findById (Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Order.class.getName()));
	}
	
	public Order insert (Order obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setClient(clientService.findById(obj.getClient().getId()));
		obj.getPayment().setPaymentState(PaymentState.PENDENTE);
		obj.getPayment().setOrder(obj);
		
		if (obj.getPayment() instanceof InvoicePayment) {
			InvoicePayment payment = (InvoicePayment) obj.getPayment();
			invoiceService.preencherPagamentoComBoleto(payment, obj.getInstante());
		}
		obj = repo.save(obj);
		paymentRepo.save(obj.getPayment());
		
		for (ItemOrder io : obj.getItems()) {
			io.setDiscount(0.0);
			io.setProduct(productService.findById(io.getProduct().getId()));
			io.setPrice(io.getProduct().getPrice());
			io.setOder(obj);
		}
		itemOrderRepository.saveAll(obj.getItems());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
	
	
	public Page<Order> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Direction.valueOf(direction), orderBy);
		Client client = clientService.findById(user.getId());
		return repo.findByClient(client, pageRequest);
	
	}
}