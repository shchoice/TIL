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
      Member findMember01 = em.find(Member.class, 1L);
      findMember01.setName("shchoice01-detach");

      em.detach(findMember01); // em.clear() 를 사용해도 됨
      System.out.println("==============");
      tx.commit();
      // detach를 했기 때문에 select 문 일어나고 insert가 일어나지 않음을 확인할 수 있음
      /*
      Hibernate:
      select
          m1_0.id,
          m1_0.name
      from
          Member m1_0
      where
          m1_0.id=?
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
