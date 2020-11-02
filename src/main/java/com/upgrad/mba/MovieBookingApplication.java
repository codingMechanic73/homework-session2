package com.upgrad.mba;

import com.upgrad.mba.dao.*;
import com.upgrad.mba.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class MovieBookingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieBookingApplication.class, args);


        // Stub code from github
        TheatreDao theatreDao = context.getBean(TheatreDao.class);
        CityDao cityDao = context.getBean(CityDao.class);
        BookingDao bookingDao = context.getBean(BookingDao.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        MovieDao movieDao = context.getBean(MovieDao.class);
        MovieTheatreDao movieTheatreDao = context.getBean(MovieTheatreDao.class);
        UserTypeDao userTypeDao = context.getBean(UserTypeDao.class);
        LanguageDao languageDao = context.getBean(LanguageDao.class);
        StatusDao statusDao = context.getBean(StatusDao.class);


        UserType admin = new UserType();
        admin.setUserTypeName("Admin");
        admin = userTypeDao.save(admin);

        UserType user = new UserType();
        user.setUserTypeName("User");
        user = userTypeDao.save(user);

        Language english = new Language();
        english.setLanguageName("English");
        english = languageDao.save(english);

        Language british = new Language();
        british.setLanguageName("British");
        british = languageDao.save(british);

        Status upcoming = new Status();
        upcoming.setStatusName("UPCOMING");
        upcoming = statusDao.save(upcoming);

        Status ongoing = new Status();
        ongoing.setStatusName("ONGOING");
        ongoing = statusDao.save(ongoing);

        Status deleted = new Status();
        deleted.setStatusName("DELETED");
        deleted = statusDao.save(deleted);

        City mumbai = new City();
        mumbai.setCityName("MUMBAI");
        mumbai = cityDao.save(mumbai);

        City delhi = new City();
        delhi.setCityName("DELHI");
        delhi = cityDao.save(delhi);

        Theatre theatre1 = new Theatre();
        theatre1.setTheatreName("Urvashi Cinema");
        theatre1.setTicketPrice(500);
        theatre1.setCity(mumbai);
        theatre1 = theatreDao.save(theatre1);

        Theatre theatre2 = new Theatre();
        theatre2.setTheatreName("Cinepolis Multiplex");
        theatre2.setTicketPrice(600);
        theatre2.setCity(mumbai);
        theatre2 = theatreDao.save(theatre2);

        Theatre theatre3 = new Theatre();
        theatre3.setTheatreName("PVR IMAX");
        theatre3.setTicketPrice(700);
        theatre3.setCity(delhi);
        theatre3 = theatreDao.save(theatre3);

        System.out.println("**************Cities***********");
        cityDao.findAll().forEach(System.out::println);

        System.out.println("**************Theatres***********");
        theatreDao.findAll().forEach(System.out::println);

        System.out.println("**************Theatres in Mumbai***********");
        cityDao.findById(mumbai.getCityId())
                .ifPresent(city -> city.getTheatres().forEach(System.out::println));

        Customer customer1 = new Customer();
        customer1.setFirstName("Emma");
        customer1.setLastName("Stone");
        customer1.setUsername("emmastone123");
        customer1.setPassword("imemma");
        customer1.setDateOfBirth(LocalDateTime.of(1988, 11, 6, 0, 0));
        customer1.setPhoneNumbers(new HashSet<>(Arrays.asList(1234567890, 1234554321)));
        customer1.setUserType(user);
        customer1.setLanguage(english);
        customer1 = customerDao.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Chris");
        customer2.setLastName("Hemsworth");
        customer2.setUsername("hammer_man");
        customer2.setPassword("thor");
        customer2.setDateOfBirth(LocalDateTime.of(1983, 8, 11, 0, 0));
        customer2.setPhoneNumbers(new HashSet<>(Arrays.asList(1234567890, 1234554321)));
        customer2.setUserType(user);
        customer2.setLanguage(english);
        customer2 = customerDao.save(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Robert");
        customer3.setLastName("Downey");
        customer3.setUsername("iron_man");
        customer3.setPassword("imironman");
        customer3.setDateOfBirth(LocalDateTime.of(1965, 4, 4, 0, 0));
        customer3.setUserType(admin);
        customer3.setLanguage(english);
        customer3.setPhoneNumbers(new HashSet<>() {{
            add(1234567890);
        }});
        customerDao.save(customer3);

        customerDao.findAll().forEach(System.out::println);

        Movie movie1 = new Movie();
        movie1.setMovieName("Avengers: Infinity War");
        movie1.setMovieDesc("The Avengers must stop Thanos, an intergalactic warlord, " +
                "from getting his hands on all the infinity stones.");
        movie1.setReleaseDate(LocalDateTime.of(2018, 4, 27, 5, 30));
        movie1.setDuration(150);
        movie1.setCoverPhotoUrl("cover-photo-url");
        movie1.setTrailerUrl("trailer-url");
        movie1.setStatus(upcoming);
        movie1 = movieDao.save(movie1);

        Movie movie2 = new Movie();
        movie2.setMovieName("Avengers: Endgame");
        movie2.setMovieDesc("After Thanos, an intergalactic warlord, disintegrates half of " +
                "the universe, the Avengers must reunite and assemble again to reinvigorate their " +
                "trounced allies and restore balance.");
        movie2.setReleaseDate(LocalDateTime.of(2019, 4, 26, 5, 30));
        movie2.setDuration(180);
        movie2.setCoverPhotoUrl("cover-photo-url");
        movie2.setTrailerUrl("trailer-url");
        movie2.setStatus(ongoing);
        movie2 = movieDao.save(movie2);

        MovieTheatre movieTheatre11 = new MovieTheatre();
        movieTheatre11.setMovie(movie1);
        movieTheatre11.setTheatre(theatre1);
        movieTheatre11 = movieTheatreDao.save(movieTheatre11);

        MovieTheatre movieTheatre12 = new MovieTheatre();
        movieTheatre12.setMovie(movie1);
        movieTheatre12.setTheatre(theatre2);
        movieTheatre12 = movieTheatreDao.save(movieTheatre12);

        MovieTheatre movieTheatre21 = new MovieTheatre();
        movieTheatre21.setMovie(movie2);
        movieTheatre21.setTheatre(theatre1);
        movieTheatre21 = movieTheatreDao.save(movieTheatre21);

        Booking booking1 = new Booking();
        booking1.setBookingDate(LocalDateTime.now());
        booking1.setNoOfSeats(5);
        booking1.setCustomer(customer1);
        booking1.setMovieTheatre(movieTheatre11);
        booking1 = bookingDao.save(booking1);

        Booking booking2 = new Booking();
        booking2.setBookingDate(LocalDateTime.now());
        booking2.setNoOfSeats(2);
        booking2.setCustomer(customer1);
        booking2.setMovieTheatre(movieTheatre11);
        booking2 = bookingDao.save(booking2);

        Booking booking3 = new Booking();
        booking3.setBookingDate(LocalDateTime.now());
        booking3.setNoOfSeats(3);
        booking3.setCustomer(customer2);
        booking3.setMovieTheatre(movieTheatre12);
        booking3 = bookingDao.save(booking3);

        System.out.println("**************Customers***********");
        customerDao.findAll().forEach(System.out::println);

        System.out.println("**************Bookings***********");
        bookingDao.findAll().forEach(System.out::println);

        System.out.println("**************Bookings by customer1***********");
        customerDao.findById(customer1.getCustomerId())
                .ifPresent(customer -> customer.getBookings().forEach(System.out::println));

        System.out.println("**************Bookings before deleting a customer*********");
        bookingDao.findAll().forEach(booking -> System.out.println(booking.getCustomer().getFirstName()));

        customerDao.deleteById(customer1.getCustomerId());

        System.out.println("**************Bookings after deleting a customer*********");
        bookingDao.findAll().forEach(booking -> System.out.println(booking.getCustomer().getFirstName()));
    }
}

