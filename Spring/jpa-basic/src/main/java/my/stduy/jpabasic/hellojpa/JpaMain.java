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

    try {
      Member findMember01 = em.find(Member.class, 10L);
      Member findMember02 = em.find(Member.class, 10L);

      System.out.println("result = " + (findMember01 == findMember02)); // true

      // DB에 쿼리가 날아가 저장되는 시점
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }
  public void enroll() {

  }
}
