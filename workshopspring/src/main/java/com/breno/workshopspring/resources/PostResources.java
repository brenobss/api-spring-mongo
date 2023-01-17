package com.breno.workshopspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.breno.workshopspring.domain.Post;
import com.breno.workshopspring.resources.util.URL;
import com.breno.workshopspring.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitleContaining(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitleContaining(text);
		return ResponseEntity.ok().body(posts);
	}
}
