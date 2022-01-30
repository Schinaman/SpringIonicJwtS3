package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
