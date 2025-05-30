package com.CursoJava_JPA_Hibernate.Curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.CategoryRepository;
import com.CursoJava_JPA_Hibernate.Curso.Repositories.OrderRepository;
import com.CursoJava_JPA_Hibernate.Curso.Repositories.ProductRepository;
import com.CursoJava_JPA_Hibernate.Curso.Repositories.UserRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.Category;
import com.CursoJava_JPA_Hibernate.Curso.entities.Order;
import com.CursoJava_JPA_Hibernate.Curso.entities.Product;
import com.CursoJava_JPA_Hibernate.Curso.entities.User;
import com.CursoJava_JPA_Hibernate.Curso.enums.OrderStatus;

@Configuration
@Profile("test") // Vai executar apenas no perfil de teste no banco de dados
public class TestConfig implements CommandLineRunner {

    @Autowired // É a injeção de dependencia do framework
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    /*
     * A CommandLineRunner vai executar tudo que tiver no método rum quando a
     * aplicação for instanciada. É uma maneira se popular o banco quando a
     * aplicação for
     * instanciada.
     */
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", 
          "Lorem ipsum dolor sit amet, consectetur.", 90.5, 
          "", cat1);
        
        Product p2 = new Product(null, "Smart TV", 
         "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, 
         "", cat3);

        Product p3 = new Product(null, "Macbook Pro", 
         "Nam eleifend maximus tortor, at mollis.", 1250.0, 
         "", cat2);

        Product p4 = new Product(null, "PC Gamer", 
         "Donec aliquet odio ac rhoncus cursus.", 1200.0, 
         "", cat2);

        Product p5 = new Product(null, "Rails for Dummies", 
         "Cras fringilla convallis sem vel faucibus.", 100.99, 
         "", cat1);
        
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

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