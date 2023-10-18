package com.amurfu.tienda;

import lombok.Generated;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Generated
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
