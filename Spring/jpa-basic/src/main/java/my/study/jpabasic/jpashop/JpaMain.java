package my.study.jpabasic.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpashop.domain.Member;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaShop");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Member member1 = new Member();
      member1.setName("shchoice1");
      em.persist(member1);

      Member member2 = new Member();
      member2.setName("shchoice2");
      em.persist(member2);

      em.flush();
      em.clear();

      Member m1 = em.find(Member.class, member1.getId());
      Member m2 = em.find(Member.class, member2.getId());
      System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass())); // true

      em.clear();

      Member m11 = em.find(Member.class, member1.getId());
      Member m22 = em.getReference(Member.class, member2.getId());
      System.out.println("m11 == m22 : " + (m11.getClass() == m22.getClass())); // false


      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
