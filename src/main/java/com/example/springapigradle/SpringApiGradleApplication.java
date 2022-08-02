package com.example.springapigradle;

import com.example.springapigradle.model.User;
import com.example.springapigradle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiGradleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGradleApplication.class, args);
	}

	// @Autowired
	// private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user=new User();
//		user.setName("Jawhar");
//		userRepository.save(user);
	}
}
