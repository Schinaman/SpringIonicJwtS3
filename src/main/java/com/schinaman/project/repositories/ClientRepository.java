package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
