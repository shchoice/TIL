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
      System.out.println("m = " + m.getTeam().getClass()); // m = class my.study.jpabasic.mapping.Team

      System.out.println("================");
      m.getTeam().getName();
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
