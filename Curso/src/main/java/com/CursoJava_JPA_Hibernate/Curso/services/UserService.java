package com.CursoJava_JPA_Hibernate.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.UserRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.User;
import com.CursoJava_JPA_Hibernate.Curso.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

        //A operação get pega o q está dentro de obj e transforma, neste caso 
        //para user
    }

    public User insertUser(User user){
       return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        /*Ao invés de ir no banco e recuperar o recurso a ser manipulado, como faz o findByid
          o getReferenceById monitora este recurso pelo JPA em memoria pra eu manipular ele e
          depois q vou salvar isso em banco*/
        
        updateDataUser(entity, obj);
        return userRepository.save(entity); 
    }

    private void updateDataUser(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());        
    }

    
}
