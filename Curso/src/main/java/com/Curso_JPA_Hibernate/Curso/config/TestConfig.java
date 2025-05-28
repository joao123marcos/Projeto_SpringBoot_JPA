package com.Curso_JPA_Hibernate.Curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.UserRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.User;

@Configuration
@Profile("test") // Vai executar apenas no perfil de teste no banco de dados
public class TestConfig implements CommandLineRunner {

    @Autowired // É a injeção de dependencia do framework
    private UserRepository userRepository;

    /*
     * A CommandLineRunner vai executar tudo que tiver no método rum quando a
     * aplicação for instanciada. É uma maneira se popular o banco quando a aplicação for
     * instanciada.
     */
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", 
            "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", 
            "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2)); //salva no banco  

        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}