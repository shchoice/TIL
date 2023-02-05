package my.stduy.jpabasic.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    Member member = new Member();

    member.setId(1L);
    member.setName("Hello First");

    em.persist(member);

    tx.commit();
    entityManagerFactory.close();
    em.close();
  }
}
