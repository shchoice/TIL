package my.study.jpabasic.jpql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import my.study.jpabasic.jpql.domain.MemberDTO;
import my.study.jpabasic.jpql.domain.Member_JPQL;
import my.study.jpabasic.jpql.domain.Team;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Team team = new Team();
      team.setName("기반기술");
      em.persist(team);

      Member_JPQL member = new Member_JPQL();
      member.setUsername("shchoi");
      member.setAge(32);
      member.setTeam(team);
      em.persist(member);

      em.flush();
      em.clear();

      String jpql = "SELECT m FROM Member_JPQL m INNER JOIN m.team t";
      List<Member_JPQL> resultList = em.createQuery(jpql, Member_JPQL.class)
          .getResultList();

      System.out.println("result.size : " + resultList.size());
      for (Member_JPQL member_jpql: resultList) {
        System.out.println("member = " + member_jpql);
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
