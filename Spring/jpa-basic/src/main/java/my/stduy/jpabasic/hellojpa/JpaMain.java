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
      Member member = em.find(Member.class, 20L);
      member.setName("shchoiii");

      // em.persist(member); JDBC와 같이 persist를 통해 update를 수행해야할 것 같지만 JPA는 아니다.
      // 마치 Collection 객체의 arrayList에 담듯이 set만 해주면 된다.

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
