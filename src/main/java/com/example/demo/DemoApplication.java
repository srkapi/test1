package com.example.demo;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.adapter.out.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling //habilita el soporte de scheduling y permite usar la notación @scheduled en el conexto de la app
@EnableAsync
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

        Authority personajeUpdate = new Authority();
        idAuthority = 3;
        idAuthorityToLong = Long.valueOf(idAuthority);
        personajeUpdate.setId(idAuthorityToLong);
        personajeUpdate.setName("PERSONAJE_UPDATE");
        authorityRepository.save(personajeUpdate);

        Authority personajeDelete = new Authority();
        idAuthority = 4;
        idAuthorityToLong = Long.valueOf(idAuthority);
        personajeDelete.setId(idAuthorityToLong);
        personajeDelete.setName("PERSONAJE_DELETE");
        authorityRepository.save(personajeDelete);

        Authority keyCreate = new Authority();
        idAuthority = 5;
        idAuthorityToLong = Long.valueOf(idAuthority);
        keyCreate.setId(idAuthorityToLong);
        keyCreate.setName("KEY_CREATE");
        authorityRepository.save(keyCreate);

        Authority keyRead = new Authority();
        idAuthority = 6;
        idAuthorityToLong = Long.valueOf(idAuthority);
        keyRead.setId(idAuthorityToLong);
        keyRead.setName("KEY_READ");
        authorityRepository.save(keyRead);

    }
}
