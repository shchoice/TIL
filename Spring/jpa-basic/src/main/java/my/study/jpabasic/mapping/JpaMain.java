package my.study.jpabasic.mapping;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mapping");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Team team = new Team();
      team.setName("teamA");
      em.persist(team);

      Member member = new Member();
      member.setName("shchoi");
      member.setTeam(team);
      em.persist(member);

      em.flush();
      em.clear();

      Member m = em.find(Member.class, member.getId());
      System.out.println("m = " + m.getTeam().getClass()); // m = class my.study.jpabasic.mapping.Team$HibernateProxy$n5KUIeD9

      System.out.println("================");
      m.getTeam().getName();
      //    select
      //        team0_.team_id as team_id1_4_0_,
      //        team0_.created_by as created_2_4_0_,
      //        team0_.created_date as created_3_4_0_,
      //        team0_.last_modified_by as last_mod4_4_0_,
      //        team0_.last_modified_date as last_mod5_4_0_,
      //        team0_.name as name6_4_0_
      //    from
      //        team team0_
      //    where
      //        team0_.team_id=?
      System.out.println("================");

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }
    emf.close();
  }
}
