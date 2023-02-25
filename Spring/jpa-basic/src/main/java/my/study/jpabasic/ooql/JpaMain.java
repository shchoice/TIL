package my.study.jpabasic.ooql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.ooql.domain.Member;
import my.study.jpabasic.valuetype.domain.Address;
import my.study.jpabasic.valuetype.domain.AddressEntity;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ooql");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      String jpql = "select m From Member m where m.name like '%sh%'";
      List<Member> result = em.createQuery(jpql, Member.class).getResultList();

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
