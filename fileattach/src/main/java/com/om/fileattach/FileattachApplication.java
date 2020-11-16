package com.om.fileattach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.om"})
public class FileattachApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileattachApplication.class, args);
	}

}
