package com.schinaman.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.schinaman.project.entities.Client;
import com.schinaman.project.repositories.ClientRepository;
import com.schinaman.project.security.UserSS;



public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClientRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client client = repo.findByEmail(email);
		if (client == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(client.getId(), client.getEmail(), client.getSenha(), client.getProfiles());
	}

}
