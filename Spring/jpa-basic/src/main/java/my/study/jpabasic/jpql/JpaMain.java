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

      String jpql = "SELECT m FROM Member_JPQL m JOIN FETCH m.team";
      List<Member_JPQL> resultList = em.createQuery(jpql, Member_JPQL.class).getResultList();

      System.out.println("result.size : " + resultList.size());
      for (Member_JPQL member_jpql: resultList) {
        System.out.println("member = " + member_jpql.getUsername() + ", " + member_jpql.getTeam().getName());
        //     /* SELECT
        //        m
        //    FROM
        //        Member_JPQL m
        //    JOIN
        //        FETCH m.team */ select
        //            member_jpq0_.member_id as member_i1_0_0_,
        //            team1_.team_id as team_id1_3_1_,
        //            member_jpq0_.age as age2_0_0_,
        //            member_jpq0_.team_id as team_id4_0_0_,
        //            member_jpq0_.username as username3_0_0_,
        //            team1_.name as name2_3_1_
        //        from
        //            member member_jpq0_
        //        inner join
        //            team team1_
        //                on member_jpq0_.team_id=team1_.team_id
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
