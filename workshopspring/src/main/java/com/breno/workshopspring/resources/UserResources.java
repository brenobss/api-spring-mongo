package com.breno.workshopspring.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.breno.workshopspring.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		User maria = new User(1, "Maria Silva", "maria@email.com");
		User carlos = new User(2, "Carlos Souza", "carlos@email.com");
		list.addAll(Arrays.asList(maria, carlos));
		return ResponseEntity.ok().body(list);
	}
}
