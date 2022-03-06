package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, String>{

}
