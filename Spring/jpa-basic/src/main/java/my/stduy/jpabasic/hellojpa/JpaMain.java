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
      // 비영속
      Member member01 = new Member(10L, "shchoi");
      Member member02 = new Member(11L, "shchoi");

      // 영속
      em.persist(member01);
      em.persist(member02);

      Member findMember = em.find(Member.class, 10L);

      System.out.println("findMember.id = " + findMember.getId());
      System.out.println("findMember.name = " + findMember.getName());
      /*
        findMember.id = 10
        findMember.name = shchoi

        insert my.stduy.jpabasic.hellojpa.Member
        insert
          into
        Member
            (name, id)
        values
            (?, ?)

      Hibernate:
        insert my.stduy.jpabasic.hellojpa.Member
        insert
          into
        Member
          (name, id)
        values
          (?, ?)

        // select Query 가 나오지 않음을 알 수 있다.(1차 캐시에 있는 것을 조회했기 때문, DB에서 x)
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
