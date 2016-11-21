package edu.mum.ea.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsApplication.class, args);		
	}
	
}
