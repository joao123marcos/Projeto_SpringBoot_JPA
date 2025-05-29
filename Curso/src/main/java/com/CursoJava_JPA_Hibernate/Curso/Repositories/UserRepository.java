package com.CursoJava_JPA_Hibernate.Curso.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CursoJava_JPA_Hibernate.Curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

  //Só com isso eu já consigo ter meios de acessar o banco  
 /*No JPA (Java Persistence API), um Repository (Repositório) é uma abstração que representa 
   uma coleção de objetos de uma determinada entidade (como Cliente, Produto, etc.) armazenados 
   no banco de dados. Ele serve como uma camada intermediária entre a sua lógica de negócios e 
   os mecanismos de persistência de dados.
   
   Basicamente, ele te ajuda a separar as preocupações: sua aplicação não precisa saber como os 
   dados são de fato salvos, atualizados ou buscados no banco. Ela apenas interage com o 
   repositório.
   
   - Para que serve um Repository? 🤔
   A principal função de um repositório é encapsular a lógica de acesso a dados. Isso significa 
   que todas as operações relacionadas à persistência (salvar, buscar, atualizar, deletar) para 
   uma entidade específica ficam concentradas em um único lugar.
   
   Pense nele como um "gerente" para suas entidades no banco de dados.
   
   - Por que você precisa de um Repository? 💡
   Você precisa de um repositório por vários motivos importantes:
   
    * Abstração do acesso a dados: Ele esconde os detalhes de como a persistência é implementada 
      (se é JDBC puro, Hibernate, EclipseLink, etc.). Se você precisar trocar o provedor JPA no 
      futuro, o impacto na sua lógica de negócios será mínimo.
    
    * Código mais limpo e organizado: Centraliza as consultas e operações de banco de dados, 
      tornando seu código mais fácil de entender, manter e testar. Em vez de espalhar EntityManager.
      persist(), EntityManager.find(), etc., por toda a sua aplicação, você chama métodos do 
      repositório (ex: clienteRepository.salvar(cliente)).
    
    * Facilita testes unitários: Você pode facilmente "mockar" (simular) um repositório durante os 
      testes, permitindo testar sua lógica de negócios sem a necessidade de um banco de dados real.
    
    * Reutilização de código: Consultas complexas podem ser definidas uma vez no repositório e 
      reutilizadas em várias partes da sua aplicação.
    
    * Implementação de padrões de projeto: Segue o padrão de projeto "Repository", que é uma 
      prática recomendada para construir aplicações robustas e escaláveis.

   Qual é a sua função? ⚙️
   A função de um repositório é fornecer métodos para realizar operações CRUD (Create, Read, 
   Update, Delete) e outras consultas personalizadas sobre as entidades.

   Exemplos comuns de métodos que você encontraria em um repositório:
   save(Entidade): Salva ou atualiza uma entidade no banco.
   findById(id): Busca uma entidade pelo seu identificador.
   findAll(): Busca todas as entidades de um tipo.
   delete(Entidade): Remove uma entidade do banco.
   deleteById(id): Remove uma entidade pelo seu identificador.
   M étodos de consulta personalizados (ex: findByNome(String nome), 
   findByPrecoMaiorQue(BigDecimal preco)).

   Frameworks como o Spring Data JPA simplificam enormemente a criação de repositórios. 
   Muitas vezes, você só precisa definir uma interface que estende JpaRepository 
   (ou outra interface similar) e o Spring automaticamente implementa os métodos básicos para você.
   
   https://docs.google.com/document/d/1iuLP1evpestf6nN0F0vHubhuN9_1I4tSA9t-bvwqqFw/edit?usp=sharing
   */

