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
      Member_JPQL member = new Member_JPQL();
      member.setUsername("shchoi");
      member.setAge(32);
      em.persist(member);

      em.flush();
      em.clear();

      List<Member_JPQL> resultList = em.createQuery("SELECT m FROM Member_JPQL m", Member_JPQL.class).getResultList();
      Member_JPQL findMember = resultList.get(0);
      findMember.setAge(33);
      for (Member_JPQL member_jpql: resultList) {
        System.out.println("member.username = " +member_jpql.getUsername());
      }

      // SELECT m.team FROM Member m 로 표현가능하지만 명시적으로 표현하는게 더 좋다
      List<Team> resultTeamList = em.createQuery("SELECT t FROM Member_JPQL m JOIN m.team t", Team.class).getResultList();

      List<MemberDTO> resultDTO = em.createQuery("SELECT new my.study.jpabasic.jpql.domain.MemberDTO(m.username, m.age) FROM Member_JPQL m", MemberDTO.class).getResultList();
      MemberDTO memberDTO = resultDTO.get(0);
      System.out.println("memberDTO = " + memberDTO.getUsername());
      System.out.println("memberDTO = " + memberDTO.getAge());

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
