package com.schinaman.project.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Category;
import com.schinaman.project.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	//Poderia implementar a interface numa classe porém a anotation @Query permite adionar o JPQL diretamente como argumento
	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% AND cat IN :categories")
	Page<Product> search(@Param("name") String name,@Param("categories") List<Category> categories, Pageable pageRequest);
	
	//Criando com base Method Names keywords
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	//Page<Product> findDistinctByNameContainingAndCategoriesIn(String name, List<Category> categories, Pageable pageRequest);
	
}
