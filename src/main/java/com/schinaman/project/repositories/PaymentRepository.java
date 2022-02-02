package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
