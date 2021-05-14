package com.ngs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.ngs"})
public class BIDVToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(BIDVToolApplication.class, args);
	}

}
