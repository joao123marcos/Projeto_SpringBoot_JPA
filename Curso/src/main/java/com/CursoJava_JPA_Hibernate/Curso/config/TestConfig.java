package com.CursoJava_JPA_Hibernate.Curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.OrderRepository;
import com.CursoJava_JPA_Hibernate.Curso.Repositories.UserRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.Order;
import com.CursoJava_JPA_Hibernate.Curso.entities.User;
import com.CursoJava_JPA_Hibernate.Curso.enums.OrderStatus;

@Configuration
@Profile("test") // Vai executar apenas no perfil de teste no banco de dados
public class TestConfig implements CommandLineRunner {

    @Autowired // É a injeção de dependencia do framework
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    /*
     * A CommandLineRunner vai executar tudo que tiver no método rum quando a
     * aplicação for instanciada. É uma maneira se popular o banco quando a
     * aplicação for
     * instanciada.
     */
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com",
                "988888888", "123456");
                
        User u2 = new User(null, "Alex Green", "alex@gmail.com",
                "977777777", "123456");

        Order o1 = new Order(null, 
          Instant.parse("2025-05-30T14:42:07Z"), 
          OrderStatus.valueOf("SHIPPED"), u1);
        
        Order o2 = new Order(null, 
          Instant.parse("2025-05-30T15:42:10Z"), 
          OrderStatus.valueOf("WAITING_PAYMENT"), u2);
        
        Order o3 = new Order(null, 
          Instant.parse("2025-05-30T16:21:22Z"), 
          OrderStatus.valueOf("DELIVERED"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2)); // salva no banco
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}