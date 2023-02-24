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
      Member member = new Member();
      member.setName("shchoice");

      em.persist(member);

      em.flush();
      em.clear();

//      Member findMember = em.find(Member.class, member.getId());
      Member findMember = em.getReference(Member.class, member.getId());
      System.out.println("findMember : " + findMember.getClass()); // findMember : class my.study.jpabasic.jpashop.domain.Member$HibernateProxy$18ilNFva
      System.out.println("findMember.id : " + findMember.getId());
      System.out.println("findMember.name : " + findMember.getName());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
