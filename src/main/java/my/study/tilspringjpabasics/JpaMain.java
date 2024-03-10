package my.study.tilspringjpabasics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import my.study.tilspringjpabasics.query.entity.Member;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      // 회원 객체 수정 - 수정할 때는 em.persist 를 사용하지 않아도 됨, Java Collection 하듯이 JPA가 만들어짐
      Member findMember = em.find(Member.class, 1L);
      findMember.setName("shchoice");
      /*
      Hibernate:
        select
            m1_0.id,
            m1_0.name
        from
            Member m1_0
        where
            m1_0.id=?
      Hibernate:
      / * update
          for my.study.tilspringjpabasics.query.entity.Member * /update Member
      set
        name=?
      where
        id=?
      */
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();

    }
    emf.close();
  }
}
