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

      // IDENTITY 전략을 사용할 경우에는 commit 이전에 persist에서 insert를 수행
      // 그렇지 않으면 ID를 매핑 시킬수 없기 때문
      System.out.println("===============");
      em.persist(member);
      System.out.println("===============");
      /*
      ===============
        insert
            into
        Member
            (id, age, createDate, description, lastModifiedDate, roleType, name)
        values
            (default, ?, ?, ?, ?, ?, ?)
      ===============
       */

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
