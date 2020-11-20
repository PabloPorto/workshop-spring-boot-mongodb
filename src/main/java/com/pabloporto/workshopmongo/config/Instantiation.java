package com.pabloporto.workshopmongo.config;

import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User pablo = new User( null,"Pablo","pablo@gmail.com");
        User lucas = new User(null,"Lucas","Lucas@gmail.com");
        User amanda = new User(null,"Amanda","amanda@gmail.com");

        userRepository.saveAll(Arrays.asList(pablo,lucas,amanda));
    }
}
