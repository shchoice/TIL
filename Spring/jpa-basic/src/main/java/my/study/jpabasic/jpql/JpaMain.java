package my.study.jpabasic.jpql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import my.study.jpabasic.jpql.domain.Member_JPQL;

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

      // 이름기준, 웬만하면 이름기준 사용하자(위치기준은 순서가 꼬일 수도 있음)
      TypedQuery<Member_JPQL> query = em.createQuery("SELECT m FROM Member_JPQL m where m.username=:username", Member_JPQL.class);
      query.setParameter("username", "shchoi");

      // 위치기준
      query = em.createQuery("SELECT m FROM Member_JPQL m where m.username=?1", Member_JPQL.class);
      query.setParameter(1, "shchoi");

      List<Member_JPQL> resultList = query.getResultList();
      for (Member_JPQL member_jpql: resultList) {
        System.out.println("member.username = " +member_jpql.getUsername());
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
