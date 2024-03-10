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
      // 비영속
      Member member = new Member();
      member.setId(4L);
      member.setName("persistence-detach");

      // 영속
      System.out.println("--- before ---");
      em.persist(member);
      em.detach(member);
      System.out.println("--- after ---");

      // 준영속 상태로 영속 상태 처럼 로그는 아래와 같이 찍히지만 실제로는 DB에 반영이 안됨
      /*
      --- before ---
      --- after ---
      Hibernate:
          / * insert for
              my.study.tilspringjpabasics.query.entity.Member * /insert
                into
                  Member (name, id)
                values
                  (?, ?)
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
