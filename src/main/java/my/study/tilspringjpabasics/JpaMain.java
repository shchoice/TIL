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
      member.setId(3L);
      member.setName("persistence");

      // 영속
      System.out.println("--- before ---");
      em.persist(member);
      System.out.println("--- after ---");

      // 예상으로는 before 와 after 사이에서 영속성이 일어나 Query가 날아가야할 것 같지만
      // 실제로는 영속 상태가 된다고 해서 DB의 Query가 날아가는 것이 아님
      // Transaction을 commit 하는 시점에 영속성 context에 있는 얘가 DB의 쿼리로 날아가게됨
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
