package com.breno.workshopspring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.breno.workshopspring.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
