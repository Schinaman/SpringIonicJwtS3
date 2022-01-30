package com.schinaman.project;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.schinaman.project.entities.Category;
import com.schinaman.project.repositories.CategoryRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(2, "Higiene");
		 
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
