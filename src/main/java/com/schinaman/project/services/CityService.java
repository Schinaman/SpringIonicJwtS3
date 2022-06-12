package com.schinaman.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schinaman.project.entities.City;
import com.schinaman.project.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repo;

	public List<City> findByState(Integer stateId) {
		return repo.findCities(stateId);
	}
}
