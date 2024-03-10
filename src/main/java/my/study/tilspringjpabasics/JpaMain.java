package my.study.tilspringjpabasics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import my.study.tilspringjpabasics.query.entity.Member;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      // 1. 1차 캐시 비교 : findMember01 은 DB에서 읽어오지만 02는 1차 캐시로 읽어옴, 03은 DB에서 읽어옴
      Member findMember01 = em.find(Member.class, 1L);
      Member findMember02 = em.find(Member.class, 1L);
      Member findMember03 = em.find(Member.class, 2L);

      // 2. 동일성 비교
      System.out.println("isSame? = " + (findMember01 == findMember02)); // isSame? = true
      System.out.println("isSame? = " + (findMember01 == findMember03)); // isSame? = false

      // 3. 쓰기 지연
      Member member01 = new Member(4L, "shchoice04");
      Member member02 = new Member(5L, "shchoice05");

      em.persist(member01);
      em.persist(member02);
      System.out.println("====================");

      tx.commit();// 이 시점 이후로 persist가 동작함 <- 쓰기 지연으로 인해 버퍼링 기능을 사용할 수 있음
      // persist 때마다 DB에 반영이 된다면 최적화할 수 있는 여지가 없게됨
      // 한꺼번에 보내는 것을 JDBC Batch라 함
      // hibernate에는 batch_size 옵션이 있음, batch_size 만큼 모으고 한번에 넣을 수 있음

//      // 4. 변경 감지 (Dirty Caching엔티티 수정)
//      Member findMember04 = em.find(Member.class, 4L);
//      findMember04.setName("shchoice04-update");
//      // em.update(member) 이러한 부류의 명령어 없이도 바로 쿼리가 날아감
//      System.out.println("===============");
//      tx.commit();

    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
