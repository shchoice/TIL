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
      // 팀 저장
      Team team = new Team();
      team.setName("기반기술팀");
      em.persist(team);
      // SELECT * FROM MEMBER; 의 결과 (1, "기반기술팀")

      // 회원 저장
      Member member = new Member();
      member.setName("shchoi");

      // 역방향(주인이 아닌 방향)만 연관관계 설정
      team.getMembers().add(member);
      // 연관관계의 주인에 값 설정
      member.setTeam(team);

      em.persist(member);
      // SELECT * FROM TEAM; 의 결과 (2, 1, "shchoi") <- (member_id, team_id, username)

      em.flush();
      em.clear();

      Member findMember = em.find(Member.class, member.getId());
      List<Member> members = findMember.getTeam().getMembers();

      for (Member m : members) {
        System.out.println("member = " + m.getName());
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
