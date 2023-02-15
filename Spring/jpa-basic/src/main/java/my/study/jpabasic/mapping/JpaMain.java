package my.study.jpabasic.mapping;

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
      // 팀 저장
      Team team = new Team();
      team.setName("기반기술팀");
      em.persist(team);
      // SELECT * FROM MEMBER; 의 결과 (1, "기반기술팀")

      // 회원 저장
      Member member = new Member();
      member.setName("shchoi");
      member.setTeamId(team.getId());
      em.persist(member);
      // SELECT * FROM TEAM; 의 결과 (2, 1, "shchoi") <- (member_id, team_id, username)

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
