package com.schinaman.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.Category;
import com.schinaman.project.entities.Order;
import com.schinaman.project.entities.Product;
import com.schinaman.project.repositories.CategoryRepository;
import com.schinaman.project.repositories.ProductRepository;
import com.schinaman.project.services.Exceptions.ObjectNotFoundException;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo; 

	@Autowired
	private CategoryRepository categoryRepo;
	
	public Product findById (Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));
	}
	
	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = categoryRepo.findAllById(ids);
		return repo.search(name, categories, pageRequest);
		
	}
	
}
