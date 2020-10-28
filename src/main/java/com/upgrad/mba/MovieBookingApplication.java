package com.upgrad.mba;

import com.upgrad.mba.dao.TheatreDao;
import com.upgrad.mba.entities.Theatre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieBookingApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MovieBookingApplication.class, args);
        TheatreDao theatreDao = ctx.getBean(TheatreDao.class);

        System.out.println("\n*******Add Theatres*******");
        Theatre theatre1 = new Theatre();
        theatre1.setTheatreName("Inox");
        theatre1.setTicketPrice(600);

        Theatre theatre2 = new Theatre();
        theatre2.setTheatreName("Big cinemas");
        theatre2.setTicketPrice(300);

        Theatre theatre3 = new Theatre();
        theatre3.setTheatreName("Adlabs");
        theatre3.setTicketPrice(200);

        theatreDao.saveAll(Arrays.asList(theatre1, theatre2, theatre3));

        System.out.println("\n********Find theatre by name*******");
        theatreDao.findByTheatreName("Inox").forEach(theatre -> System.out.println(theatre.getTheatreName()));

        System.out.println("\n*******Find theatre for price less than 500");
        theatreDao.findByTicketPriceLessThan(700).forEach(theatre -> System.out.println(theatre.getTheatreName()));

        System.out.println("\n******Find theatre containing s");
        theatreDao.findByTheatreNameContaining("s").forEach(theatre -> System.out.println(theatre.getTheatreName()));

    }

}
