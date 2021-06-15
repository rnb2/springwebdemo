package com.rnb.springwebdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Component  – Indicates a auto scan component.
//@Repository – Indicates DAO component in the persistence layer.
//@Service 	  – Indicates a Service component in the business layer.
//@Controller – Indicates a controller component in the presentation layer.


@SpringBootApplication
public class SpringwebdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebdemoApplication.class, args);
	}


}
