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
      Member member = new Member();
      member.setName("shchoi");
      member.setCreatedBy("shchoi");
      member.setCreatedDate(LocalDateTime.now());

      em.persist(member);

      Team team = new Team();
      team.setName("teamA");
      team.getMembers().add(member);
      em.persist(team);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
