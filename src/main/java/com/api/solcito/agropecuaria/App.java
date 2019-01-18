package com.api.solcito.agropecuaria;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


/**
 * Principal main 
 * ASC API 
 *
 */

@SpringBootApplication  
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class}) // removing auto configuratios of JPA and Hibernate
public class App extends SpringBootServletInitializer{

	@Autowired
	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	  @PostConstruct
	  public void setUp() {
	    objectMapper.registerModule(new JavaTimeModule());
	  }
	  
}
