package my.study.jpabasic.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Member member = new Member();
      member.setUsername("shchoice");
      // insert into MY_SEQUENCES(sequence_name, next_val) values ('MEMBER_SEQ',0)
      System.out.println("==========");
      em.persist(member);
      /*
           select tbl.next_val from MY_SEQUENCES tbl where tbl.sequence_name=? for update
           update MY_SEQUENCES set next_val=? where next_val=? and sequence_name=?
       */
      System.out.println("member.id = " + member.getId());
      System.out.println("==========");

      tx.commit();
      /*
        insert
        into
            Member
            (age, createDate, description, lastModifiedDate, roleType, name, id)
        values
            (?, ?, ?, ?, ?, ?, ?)
       */
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }
  public void enroll() {

  }
}
