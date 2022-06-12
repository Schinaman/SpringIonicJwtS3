package com.schinaman.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.State;
import com.schinaman.project.repositories.StateRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository repo;

	public List<State> findAll() {
		return repo.findAllByOrderByName();
	}
}
