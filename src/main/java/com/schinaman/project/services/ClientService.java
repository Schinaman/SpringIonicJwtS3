package com.schinaman.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.Category;
import com.schinaman.project.entities.Client;
import com.schinaman.project.repositories.ClientRepository;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;



@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo; 
	
	
	public Client findById (Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
	
}
