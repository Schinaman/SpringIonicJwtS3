package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Address;
import com.schinaman.project.entities.Product;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
