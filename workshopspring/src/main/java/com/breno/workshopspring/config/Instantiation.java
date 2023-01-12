package com.breno.workshopspring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.breno.workshopspring.domain.User;
import com.breno.workshopspring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User pablo = new User(null, "Pablo Sarabia", "pablo@gmail.com");
		User joao = new User(null, "João Brabo", "joaobrabo@hotmail.com");
		
		repo.saveAll(Arrays.asList(maria, pablo, joao));
		
	}

}
