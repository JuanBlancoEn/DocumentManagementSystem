package com.blanco.documents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blanco.documents.User.User;
import com.blanco.documents.User.UserRepository;

@Configuration
class DatabaseLoad {

  private static final Logger log = LoggerFactory.getLogger(DatabaseLoad.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      // Verificar si ya existen usuarios antes de insertar
      if (!repository.existsByUsername("Bilbo Baggins")) {
        log.info("Preloading " + repository.save(new User("Bilbo Baggins", "burglar", "Bilbo@gmail.com")));
      }

      if (!repository.existsByUsername("Frodo Baggins")) {
        log.info("Preloading " + repository.save(new User("Frodo Baggins", "thief", "Frodo@gmail.com")));
      }
    };
  }
}
