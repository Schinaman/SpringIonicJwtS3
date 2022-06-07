package com.schinaman.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.schinaman.project.dto.ClientDTO;
import com.schinaman.project.dto.ClientNewDTO;
import com.schinaman.project.entities.Address;
import com.schinaman.project.entities.City;
import com.schinaman.project.entities.Client;
import com.schinaman.project.entities.Telephone;
import com.schinaman.project.entities.enums.Profile;
import com.schinaman.project.entities.enums.TypeClient;
import com.schinaman.project.repositories.AddressRepository;
import com.schinaman.project.repositories.ClientRepository;
import com.schinaman.project.repositories.TelephoneRepository;
import com.schinaman.project.security.UserSS;
import com.schinaman.project.services.Exceptions.AuthorizationException;
import com.schinaman.project.services.Exceptions.DataIntegrityException;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;



@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo; 
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private TelephoneRepository phoneRepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	public List<Client> findAll(){
		return repo.findAll();
	}
	
	public Client findById (Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Profile.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
	
	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Client insert(Client obj) {
		obj = repo.save(obj);
		addressRepo.saveAll(obj.getAddresses());
		phoneRepo.saveAll(obj.getTelephones());
		return obj;
	}
	
	
	public Client fromDTO (ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null, null);
	}
	
	public Client fromDTO (ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOuCnpj(), TypeClient.toEnum(objDto.getType()), pe.encode(objDto.getSenha()));
		City city = new City(objDto.getCityId(), null, null);
		Address address = new Address(null, objDto.getLogradouro(), objDto.getNumber(), objDto.getComplement(), objDto.getBairro(), objDto.getCep(), cli, city);
		cli.getAddresses().add(address);
		

		Telephone tel1 = new Telephone(objDto.getTelephone1(), cli);
		cli.getTelephones().add(tel1);  
		if (objDto.getTelephone2()!=null) {
			Telephone tel2 = new Telephone(objDto.getTelephone2(), cli);
			cli.getTelephones().add(tel2);
		}
		if (objDto.getTelephone3()!=null) {
			Telephone tel3 = new Telephone(objDto.getTelephone3(), cli);
			cli.getTelephones().add(tel3);
		}
		return cli;
		
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

