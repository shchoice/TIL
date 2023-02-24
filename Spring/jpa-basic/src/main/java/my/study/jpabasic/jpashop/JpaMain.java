package my.study.jpabasic.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpashop.domain.Member;
import org.hibernate.Hibernate;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaShop");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Member member1 = new Member();
      member1.setName("shchoice1");
      em.persist(member1);

      em.flush();
      em.clear();

      Member refMember = em.getReference(Member.class, member1.getId());
      System.out.println("refMember : " + refMember.getClass());
      System.out.println("isLoaded : " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // isLoaded : false

      refMember.getName();
      System.out.println("isLoaded : " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // isLoaded : true

      // 프록시 강제 초기화
      Hibernate.initialize(refMember);
      // Hibernate:
      //    select
      //        member0_.id as id1_4_0_,
      //        member0_.created_by as created_2_4_0_,
      //        member0_.created_date as created_3_4_0_,
      //        member0_.last_modified_by as last_mod4_4_0_,
      //        member0_.last_modified_date as last_mod5_4_0_,
      //        member0_.city as city6_4_0_,
      //        member0_.name as name7_4_0_,
      //        member0_.street as street8_4_0_,
      //        member0_.zipcode as zipcode9_4_0_
      //    from
      //        member member0_
      //    where
      //        member0_.id=?
      //00:40:40.294 [main] DEB


      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }
    emf.close();
  }

  private static void isSameInstance(Member m1, Member m2) {
    System.out.println("m1 == m2: " + (m1 instanceof  Member));
    System.out.println("m1 == m2: " + (m2 instanceof  Member));
  }
}
