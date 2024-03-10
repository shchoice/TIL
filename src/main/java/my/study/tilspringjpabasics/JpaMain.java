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
      Member member = new Member();
      member.setId(1L);
      member.setName("Hello A");

      em.persist(member);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();

    }
    // persistence.xml 에서 show_sql property 를 true 로 했기 때문이며
    // format_sql로 출력을 pretty하게 수행
    // sql_comments 때문에 insert for my.study.tilspringjpabasics.query.entity.Member 가 추가 표시됨
    /*
     insert for
        my.study.tilspringjpabasics.query.entity.Member /insert
      into
        Member (name, id)
      values
        (?, ?)
     */
    emf.close();
  }
}
