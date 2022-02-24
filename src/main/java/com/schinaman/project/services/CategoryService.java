package com.schinaman.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.schinaman.project.dto.CategoryDTO;
import com.schinaman.project.entities.Category;
import com.schinaman.project.repositories.CategoryRepository;
import com.schinaman.project.services.Exceptions.DataIntegrityException;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo; 
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}

	public Category insert(Category obj) {
		return repo.save(obj);
	}
	
	public Category update(Category obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public Category fromDTO (CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}
	
	//se tiver produtos atrelados não vou conseguir fazer a deleção; exception, posso decidir em forçar a deleção dos produtos ou lançar uma exceção
	public void delete(Integer id) {
		findById(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	
}
