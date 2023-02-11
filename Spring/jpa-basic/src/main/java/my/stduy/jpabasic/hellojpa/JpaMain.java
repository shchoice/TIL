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
      Member member01 = new Member(20L, "shchoi");
      Member member02 = new Member(21L, "shchoi");

      em.persist(member01);
      em.persist(member02);

      System.out.println("================");
      // DB에 쿼리가 날아가 저장되는 시점
      tx.commit();
      // insert 가 이 시점에 이루어지게 됨
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
