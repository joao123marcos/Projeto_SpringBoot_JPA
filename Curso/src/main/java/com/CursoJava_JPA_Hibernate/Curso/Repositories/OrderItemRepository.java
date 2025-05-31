package com.CursoJava_JPA_Hibernate.Curso.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CursoJava_JPA_Hibernate.Curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, 
 com.CursoJava_JPA_Hibernate.Curso.pk.OrderItemPK> {

}

/* Porque precisei colocar com.CursoJava_JPA_Hibernate.Curso.pk.OrderItemPK
 * ao invés de somente long, como vinha fazendo antes!
 * 
 * Ótima pergunta! Você precisa usar 
 * com.CursoJava_JPA_Hibernate.Curso.pk.OrderItemPK (uma classe) em vez de apenas 
 * Long porque a entidade OrderItem provavelmente utiliza uma chave primária 
 * composta.

  No JPA, quando uma entidade tem mais de um campo formando sua chave primária 
  (por exemplo, order_id e product_id juntos identificam um OrderItem), você 
  precisa criar uma classe especial para representar essa chave composta. Essa 
  classe geralmente é chamada de OrderItemPK e deve implementar Serializable, 
  além de sobrescrever equals() e hashCode().

  Já o tipo Long é usado quando a chave primária da entidade é um único campo 
  (por exemplo, @Id private Long id;). Como OrderItem tem uma chave composta, 
  o tipo do identificador no repositório precisa ser a classe que representa 
  essa chave, e não um tipo simples como Long.

  Resumindo:

  Chave simples: Usa Long, Integer, etc.
  Chave composta: Usa uma classe (ex: OrderItemPK) que representa todos os campos 
  da chave.

  Explicação obtida em conversa pelo git hub copilot
 */