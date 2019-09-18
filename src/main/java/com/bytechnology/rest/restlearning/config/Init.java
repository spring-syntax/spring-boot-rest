package com.bytechnology.rest.restlearning.config;

import com.bytechnology.rest.restlearning.user.UserRepository;
import com.bytechnology.rest.restlearning.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Init implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(Init.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) {
        log.info("Start creating users!");
        userRepository.save(new User("Ion", LocalDate.of(1987,10,20)));
        userRepository.save(new User("Mihai", LocalDate.of(1986,2,1)));
        userRepository.save(new User("Alex", LocalDate.of(1983,3,5)));
        userRepository.save(new User("Cristi", LocalDate.of(1967,4,4)));
        userRepository.save(new User("Dorin", LocalDate.of(1944,7,2)));
        log.info("Finish creating users!");
    }
}
