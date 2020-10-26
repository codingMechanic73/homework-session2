package com.upgrad.mba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class MovieBookingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingApplication.class, args);
		DataSource ds = ctx.getBean(DataSource.class);
	}

}
