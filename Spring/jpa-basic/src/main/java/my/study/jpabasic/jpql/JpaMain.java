package my.study.jpabasic.jpql;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpql.domain.Member_JPQL;
import my.study.jpabasic.jpql.domain.Team;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Team team1= new Team();
      team1.setName("기반기술1팀");
      em.persist(team1);

      Team team2= new Team();
      team2.setName("기반기술2팀");
      em.persist(team2);

      Member_JPQL member1 = new Member_JPQL();
      member1.setUsername("shchoi");
      member1.setAge(32);
      member1.setTeam(team1);
      em.persist(member1);

      Member_JPQL member2 = new Member_JPQL();
      member2.setUsername("shchoi2");
      member2.setAge(33);
      member2.setTeam(team1);
      em.persist(member2);

      Member_JPQL member3 = new Member_JPQL();
      member3.setUsername("shchoi3");
      member3.setAge(33);
      member3.setTeam(team2);
      em.persist(member3);

      em.flush();
      em.clear();

      String jpql = "SELECT DISTINCT t FROM Team t JOIN FETCH t.members";
      List<Team> resultList = em.createQuery(jpql, Team.class).getResultList();

      System.out.println("result.size : " + resultList.size());
      for (Team team: resultList) {
        System.out.println("member = " + team.getName() + ", " + team.getMembers().size());
        for (Member_JPQL member_jpql: team.getMembers()) {
          System.out.println("-> Member = " + member_jpql);
        }
        // JOIN 과 FETCH JOIN 차이
        // JOIN // • 일반 조인 실행시 연관된 엔티티를 함께 조회하지 않음
        //    /* SELECT
        //        DISTINCT t
        //    FROM
        //        Team t
        //    JOIN
        //        t.members */ select
        //            distinct team0_.team_id as team_id1_3_,
        //            team0_.name as name2_3_
        //        from
        //            team team0_
        //        inner join
        //            member members1_
        //                on team0_.team_id=members1_.team_id

        // FETCH JOIN
        //     /* SELECT
        //        DISTINCT t
        //    FROM
        //        Team t
        //    JOIN
        //        FETCH t.members */ select
        //            distinct team0_.team_id as team_id1_3_0_,
        //            members1_.member_id as member_i1_0_1_,
        //            team0_.name as name2_3_0_,
        //            members1_.age as age2_0_1_,
        //            members1_.team_id as team_id4_0_1_,
        //            members1_.username as username3_0_1_,
        //            members1_.team_id as team_id4_0_0__,
        //            members1_.member_id as member_i1_0_0__
        //        from
        //            team team0_
        //        inner join
        //            member members1_
        //                on team0_.team_id=members1_.team_id

      }

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
