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
      // JPA 입장에서는 코드를 짤 때 테이블을 대상으로 코드를 짜지 않고 멤버 객체를 대상으로 함
      List<Member> members = em.createQuery("select m from Member as m", Member.class)
          .getResultList();
      for (Member member: members) {
        System.out.println("member.getName() = " + member.getName());
      }
      /*
       Hibernate:
        / * select
            m
        from
            Member as m * / select
            m1_0.id,
                m1_0.name
            from
            Member m1_0
      member.getName() = shchoice
      member.getName() = jpa
      */

      List<Member> members2 = em.createQuery("select m from Member as m", Member.class)
          .setFirstResult(0)
          .setMaxResults(10)
          .getResultList();
      for (Member member: members2) {
        System.out.println("member.getName() = " + member.getName());
      }
      /*
       Hibernate:
        /* select
            m
          from
              Member as m * / select
                m1_0.id,
                m1_0.name
            from
                Member m1_0
            offset
                ? rows
            fetch
                first ? rows only
        member.getName() = shchoice
        member.getName() = jpa
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
