package com.CursoJava_JPA_Hibernate.Curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CursoJava_JPA_Hibernate.Curso.entities.User;
import com.CursoJava_JPA_Hibernate.Curso.services.UserService;

/*O meu controle depende da camada de serviço */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        
        return ResponseEntity.ok().body(list); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    //@RequestBody transforma o Json no meu objeto user
    public ResponseEntity<User> insertUser(@RequestBody User user){ 
        user = userService.insertUser(user);

        /*Sempre que eu for inserir um novo recurso na minha aplicação é uma boa prática retornar
         * o código http 201, pois ele indica que o recurso foi add porém este código retorna a
         * localização o recurso inserido, um uri. Desta forma eu preciso ajustar a api para tal
         * ação.*/
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(user.getId()).toUri();
        
        /*Não posso simplmesmente fazer  ResponseEntity.ok().body() foi isso retornaria o código 
         * 200, para retornar o código 201 eu preciso usar o ResponseEntity.created().body(obj)
         * e esse created espera como paramentro um URI location, por isso fiz a linha acima*/

        return ResponseEntity.created(uri).body(user);
        //https://docs.google.com/document/d/1oguYmD5tzcyQ4_WpW9Ob80AD3Dt15WkyI9HMQkYgaGA/edit?usp=sharing
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

        /*Nos casos em que o meu endpoint não vai retornar nada o código http é o 204, desta
        * forma o noContent é a fomra correta de usar*/
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        user = userService.updateUser(id, user);
        return ResponseEntity.ok().body(user);
    }
}
