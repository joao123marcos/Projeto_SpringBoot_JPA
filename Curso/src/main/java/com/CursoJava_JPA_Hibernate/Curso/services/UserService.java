package com.CursoJava_JPA_Hibernate.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.UserRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.User;

/*As classes de serviço contém a lógica de négocio e apontam 
  para a camada de repositórios*/

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();

        //A operação get pega o q está dentro de obj e transforma, neste caso 
        //para user
    }

    public User insertUser(User user){
       return userRepository.save(user);
    }
}
