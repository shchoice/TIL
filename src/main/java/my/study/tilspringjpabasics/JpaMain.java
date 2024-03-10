package my.study.tilspringjpabasics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import my.study.tilspringjpabasics.query.entity.Member;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member findMember = em.find(Member.class, 1L);
      System.out.println("findMember.getId() = " + findMember.getId());
      System.out.println("findMember.getName() = " + findMember.getName());

      /*
      Hibernate:
        select
            m1_0.id,
            m1_0.name
        from
            Member m1_0
        where
            m1_0.id=?
      findMember.getId() = 1
      findMember.getName() = Hello A
      */
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();

    }
    emf.close();
  }
}
