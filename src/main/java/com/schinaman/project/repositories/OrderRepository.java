package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
