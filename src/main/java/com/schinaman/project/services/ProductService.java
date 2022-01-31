package com.schinaman.project.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.Category;
import com.schinaman.project.entities.Product;
import com.schinaman.project.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo; 
	
	public Product findById(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName(),null));
	
	}

}
