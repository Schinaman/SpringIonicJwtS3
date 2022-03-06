package com.schinaman.project.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.schinaman.project.dto.ClientNewDTO;
import com.schinaman.project.entities.Client;
import com.schinaman.project.entities.enums.TypeClient;
import com.schinaman.project.repositories.ClientRepository;
import com.schinaman.project.repositories.TelephoneRepository;
import com.schinaman.project.resources.Exceptions.FieldMessage;
import com.schinaman.project.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {

	@Autowired
	private ClientRepository repo;
	@Autowired
	private TelephoneRepository phoneRepo;
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
// inclua os testes aqui, inserindo erros na lista
		if (objDto.getType().equals(TypeClient.PESSOAFISICA.getCode()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getType().equals(TypeClient.PESSOAJURIDICA.getCode()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		
		Client aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		//Inicialmente tinha jogado dentro da logica em Service //dá pra jogar essa parte no validator (ClientInsert)
		if (objDto.getTelephone1()!=null && phoneRepo.findById(objDto.getTelephone1()).isPresent()) list.add(new FieldMessage("telephone1", "Telephone já existente"));
		if (objDto.getTelephone2()!=null && phoneRepo.findById(objDto.getTelephone2()).isPresent()) list.add(new FieldMessage("telephone2", "Telephone já existente"));;
		if (objDto.getTelephone3()!=null && phoneRepo.findById(objDto.getTelephone3()).isPresent()) list.add(new FieldMessage("telephone3", "Telephone já existente"));;
			
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}