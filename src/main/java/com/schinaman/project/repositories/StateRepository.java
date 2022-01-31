package com.schinaman.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schinaman.project.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
