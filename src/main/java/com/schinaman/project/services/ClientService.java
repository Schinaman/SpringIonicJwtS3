package com.schinaman.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.schinaman.project.dto.ClientDTO;
import com.schinaman.project.entities.Category;
import com.schinaman.project.entities.Client;
import com.schinaman.project.repositories.ClientRepository;
import com.schinaman.project.services.Exceptions.DataIntegrityException;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;



@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo; 
	
	public List<Client> findAll(){
		return repo.findAll();
	}
	
	public Client findById (Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
	
	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Client fromDTO (ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}
	
	//Clientes com Pedido não pode ser deletado, Cliente sem pedido pode
	public void delete(Integer id) {
		findById(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
