package com.example.toh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TohApplication {

	public static void main(String[] args) {
		SpringApplication.run(TohApplication.class, args);
	}

	@Bean
	CommandLineRunner init(HeroRepository repo){
		return args -> {
			repo.save(new Hero("Zaca"));
			repo.save(new Hero("Mães"));
			repo.save(new Hero("Edirvaldo Ferreira"));
			repo.save(new Hero("SuperGirl"));
			repo.save(new Hero("Wonder Woman"));
			repo.save(new Hero("Flabio Assumssaum"));
			repo.save(new Hero("Vaterman"));
			repo.save(new Hero("Doiscarasnumamotoman"));
		};
	}

}
