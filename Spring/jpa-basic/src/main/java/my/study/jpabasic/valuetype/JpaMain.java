package my.study.jpabasic.valuetype;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.mapping.Team;
import my.study.jpabasic.valuetype.domain.Address;
import my.study.jpabasic.valuetype.domain.Member;
import my.study.jpabasic.valuetype.domain.Period;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("valuetype");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Member member = new Member();
      member.setName("shchoi");
      member.setHomeAddress(new Address("city", "street", "zipcode"));
      member.setWorkPeriod(new Period());

      em.persist(member);


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
