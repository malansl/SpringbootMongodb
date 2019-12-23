package com.malands.SpringbootMongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.malands.SpringbootMongodb.DTO.AuthorDTO;
import com.malands.SpringbootMongodb.domain.Post;
import com.malands.SpringbootMongodb.domain.User;
import com.malands.SpringbootMongodb.repository.PostRepository;
import com.malands.SpringbootMongodb.repository.UserRepository;

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
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex green", "alexg@gmail.com");
		User bob = new User(null, "bob brown", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar pra sao paulo, abraço! ", new AuthorDTO (maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje! ", new AuthorDTO (maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}