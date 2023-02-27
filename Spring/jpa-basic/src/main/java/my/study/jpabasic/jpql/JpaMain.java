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

      String jpql = "SELECT m FROM Member_JPQL m";
      List<Member_JPQL> resultList = em.createQuery(jpql, Member_JPQL.class).getResultList();

      System.out.println("result.size : " + resultList.size());
      for (Member_JPQL member_jpql: resultList) {
        System.out.println("member = " + member_jpql.getUsername() + ", " + member_jpql.getTeam().getName());
        //     /* SELECT
        //        m
        //    FROM
        //        Member_JPQL m */ select
        //            member_jpq0_.member_id as member_i1_0_,
        //            member_jpq0_.age as age2_0_,
        //            member_jpq0_.team_id as team_id4_0_,
        //            member_jpq0_.username as username3_0_
        //        from
        //            member member_jpq0_
        //
        //     select
        //        team0_.team_id as team_id1_3_0_,
        //        team0_.name as name2_3_0_
        //    from
        //        team team0_
        //    where
        //        team0_.team_id=?
        //
        // 회원1, 팀A(SQL)
        // 회원2, 팀A(1차캐시)
        // 회원3, 팀B(SQL)
        // 쿼리 3번 돌음
        // 만약 회원 100명 -> 최악의 경우 N + 1번 돌음 -> fetch join으로 풀어라!!
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
