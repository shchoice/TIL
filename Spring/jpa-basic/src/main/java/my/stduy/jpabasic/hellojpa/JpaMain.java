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
      Member member = new Member();
      member.setUsername("shchoice");

      System.out.println("==========");
      em.persist(member);
      // DB에 가서 SEQUENCE 정보를 받아오고 tx.commit에서 insert, DB 2번 다녀올 필요가 있나
      // -> 대안 allocationSize 을 크게 해서 DB와 통신을 줄임 (allocation = 50 하면, 50개를 미리 받고 다른 데에서는 51번부터 사용)
      System.out.println("member.id = " + member.getId());
      System.out.println("==========");
      /*
       ==========
       Hibernate:
          call next value for MEMBER_SEQ
       member.id = 1
       ==========
       */

      tx.commit();
      /*
        insert
        into
            Member
            (age, createDate, description, lastModifiedDate, roleType, name, id)
        values
            (?, ?, ?, ?, ?, ?, ?)
       */
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
