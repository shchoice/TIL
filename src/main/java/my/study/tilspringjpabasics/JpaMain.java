package my.study.tilspringjpabasics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import my.study.tilspringjpabasics.query.entity.Member;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member = new Member(1L, "shchoice01");
      em.persist(member);

      em.flush();
      System.out.println("==============");
      tx.commit();
      // flush 로 인해 commit 이전 시점에 일어난 것을 볼 수 있음
      /*
      Hibernate:
      / * insert for
            my.study.tilspringjpabasics.query.entity.Member * /insert
        into
            Member (name, id)
        values
            (?, ?)
        ==============
       */

    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
