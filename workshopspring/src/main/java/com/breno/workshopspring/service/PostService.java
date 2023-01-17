package com.breno.workshopspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.workshopspring.domain.Post;
import com.breno.workshopspring.repository.PostRepository;
import com.breno.workshopspring.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitleContaining(String text) {
		Optional<List<Post>> obj = Optional.ofNullable(repo.findByTitleContainingIgnoreCase(text));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum post encontrado"));
	}
}
