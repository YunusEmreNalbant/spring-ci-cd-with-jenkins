package com.yunusemrenalbant.cicdjenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCiCdWithJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCiCdWithJenkinsApplication.class, args);
	}

}
