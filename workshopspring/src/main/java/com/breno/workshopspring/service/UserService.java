package com.breno.workshopspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.workshopspring.domain.User;
import com.breno.workshopspring.dto.UserDTO;
import com.breno.workshopspring.repository.UserRepository;
import com.breno.workshopspring.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public void insert(User obj) {
		repo.insert(obj);
	}
	
	public void deleteById(String id) {
		this.findById(id);
		repo.deleteById(id);
	}
	
	public void update(User obj) {
		User newObjUser = findById(obj.getId());
		this.updateData(newObjUser, obj);
		repo.save(newObjUser);
	}
	
	public void updateData(User newObjUser, User obj) {
		newObjUser.setName(obj.getName());
		newObjUser.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
