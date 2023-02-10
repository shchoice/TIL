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

      /*
        select
          member0_.id as id1_0_0_,
          member0_.name as name2_0_0_
        from
          Member member0_
        where
          member0_.id=?

        해설 : findMember01을 통해 DB에서 조회를 하고 1차 캐시에 저장을 하기에
              findMember02는 SQL을 통해 DB에 조회를 하지 않음을 확인할 수 있다.
      */

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
