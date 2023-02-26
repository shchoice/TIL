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

      TypedQuery<Member_JPQL> query1 = em.createQuery("SELECT m FROM Member_JPQL m", Member_JPQL.class);
      TypedQuery<String> query2 = em.createQuery("SELECT m.username FROM Member_JPQL m", String.class);
      Query query3 = em.createQuery("SELECT m.username, m.username FROM Member_JPQL m");

      List<Member_JPQL> resultList = query1.getResultList();
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
