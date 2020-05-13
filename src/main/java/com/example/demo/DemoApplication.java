package com.example.demo;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.adapter.out.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling //habilita el soporte de scheduling y permite usar la notación @scheduled en el conexto de la app
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Authority personajeCreate = new Authority();
        int idAuthority = 1;
        Long idAuthorityToLong = Long.valueOf(idAuthority);
        personajeCreate.setId(idAuthorityToLong);
        personajeCreate.setName("PERSONAJE_CREATE");
        authorityRepository.save(personajeCreate);

        Authority personajeRead = new Authority();
        idAuthority = 2;
        idAuthorityToLong = Long.valueOf(idAuthority);
        personajeRead.setId(idAuthorityToLong);
        personajeRead.setName("PERSONAJE_READ");
        authorityRepository.save(personajeRead);

        User admin = new User();
        int idAdmin = 1;
        Long idAdminToLong = Long.valueOf(idAdmin);
        admin.setId(idAdminToLong);
        admin.setUsername("admin");
        admin.setPassword("$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha"); //password BCrypt from admin1234
        admin.setAccountExpired(false);
        admin.setAccountLocked(false);
        admin.setCredentialsExpired(false);
        admin.setEnabled(true);
        admin.addAuthority(personajeCreate);
        admin.addAuthority(personajeRead);
        userRepository.save(admin);

    }
}
