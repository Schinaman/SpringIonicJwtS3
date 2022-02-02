package com.schinaman.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.Order;
import com.schinaman.project.entities.Order;
import com.schinaman.project.repositories.OrderRepository;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;



@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo; 
	
	
	public Order findById (Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Order.class.getName()));
	}
	
}
