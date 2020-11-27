package com.example.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(JpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {

			// save a few CustomerEntitys
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all CustomerEntitys
			log.info("CustomerEntitys found with findAll():");
			log.info("-------------------------------");
			for (Customer Customer : repository.findAll()) {
				log.info(Customer.toString());
			}
			log.info("");

			// fetch an individual CustomerEntity by ID
			Customer Customer = repository.findById(1L);
			log.info("CustomerEntity found with findById(1L):");
			log.info("--------------------------------");
			log.info(Customer.toString());
			log.info("");

			// fetch CustomerEntitys by last name
			log.info("CustomerEntity found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
		};
	}
}
