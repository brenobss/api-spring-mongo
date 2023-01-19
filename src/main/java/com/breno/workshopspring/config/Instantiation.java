package com.breno.workshopspring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.breno.workshopspring.domain.Post;
import com.breno.workshopspring.domain.User;
import com.breno.workshopspring.dto.AuthorDTO;
import com.breno.workshopspring.dto.CommentDTO;
import com.breno.workshopspring.repository.PostRepository;
import com.breno.workshopspring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User pablo = new User(null, "Pablo Sarabia", "pablo@gmail.com");
		User joao = new User(null, "João Brabo", "joaobrabo@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, pablo, joao));
		
		Post post1 = new Post(null, sdf.parse("25/01/2023"), "Partiu Viagem!", "Vou viajar para Rio de Contas", new AuthorDTO(pablo));
		Post post2 = new Post(null, sdf.parse("17/03/2023"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(pablo));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("25/01/2023"), new AuthorDTO(joao));
		CommentDTO comment2 = new CommentDTO("Aproveite", sdf.parse("25/01/2023"), new AuthorDTO(maria));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("17/03/2023"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		pablo.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(pablo);
	}

}
