package my.study.jpabasic.mapping;

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
      em.persist(member);

      Team team = new Team();
      team.setName("teamA");
      team.getMembers().add(member);
      em.persist(team);
      // OneToMany 의 문제점
      // 1. team 을 수정했는데 member에 update Query가 나감
      //    /* create one-to-many row my.study.jpabasic.mapping.Team.members */ update
      //        member
      //    set
      //        team_id=?
      //    where
      //        id=?
      // 2. OnetoMany를 잘 이해했다고 해도 실무에서 쿼리가 엄청 많아서 헷갈림..

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
