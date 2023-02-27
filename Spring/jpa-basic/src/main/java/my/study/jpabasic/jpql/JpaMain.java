package my.study.jpabasic.jpql;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpql.domain.Member_JPQL;
import my.study.jpabasic.jpql.domain.Team;
import my.study.jpabasic.mapping.Member;

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

      String query = "update Member_JPQL m set m.age = 20";
      int result = em.createQuery(query).executeUpdate();

      System.out.println("result : " + result);
      //    /* update
      //        Member_JPQL m
      //    set
      //        m.age = 20 */ update
      //            member
      //        set
      //            age=20
      //result.size : 3

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
