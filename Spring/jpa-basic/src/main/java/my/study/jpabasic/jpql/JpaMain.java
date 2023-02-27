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
//        result.size : 2
//        member = 기반기술1팀, 2
//        -> Member = Member_JPQL(id=3, username=shchoi, age=32, team=my.study.jpabasic.jpql.domain.Team@781711b7, orders=[])
//        -> Member = Member_JPQL(id=4, username=shchoi2, age=33, team=my.study.jpabasic.jpql.domain.Team@781711b7, orders=[])
//        member = 기반기술2팀, 1
//        -> Member = Member_JPQL(id=5, username=shchoi3, age=33, team=my.study.jpabasic.jpql.domain.Team@65bb6275, orders=[])
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
