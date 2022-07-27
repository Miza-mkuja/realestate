package com.example.Real.Estate;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class RealEstateApplication {
@Bean
public ModelMapper modelMapper(){
	return new ModelMapper();
}
	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}


}
