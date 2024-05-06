package com.todotic.contactlistapi;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Joel","jbbg@gmail.com", LocalDateTime.now()),
					new Contact("Ricardo","Ricar@gmail.com", LocalDateTime.now()),
					new Contact("Josue","josue@gmail.com", LocalDateTime.now()),
					new Contact("Oswaldo","Oswaldo@gmail.com", LocalDateTime.now()),
					new Contact("Mayra","Mayra@gmail.com", LocalDateTime.now())
			);
			contactRepository.saveAll(contacts );
		};

	}
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
