package my.study.jpabasic.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpashop.domain.Member;

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

      Member m1 = em.find(Member.class, member1.getId());
      System.out.println("m1 : " + m1.getClass()); // m1 : class my.study.jpabasic.jpashop.domain.Member

      Member reference1 = em.getReference(Member.class, member1.getId());
      System.out.println("reference1 : " + reference1.getClass()); // reference1 : class my.study.jpabasic.jpashop.domain.Member

      System.out.println("m1 == reference : " + (m1 == reference1));
      // true jpa는 한 영속성 컨텍스트에서 가져오고 동일한 pk를 사용하면 같게 해야하기 때문에,
      // reference는 프록시가 아닌 실제 엔티티를 반환, 또한 1차 캐시를 사용하는 것이 프록시를 사용하는 것보다 낫기 때문

      em.clear();


      Member m2 = em.getReference(Member.class, member1.getId());
      System.out.println("m2 : " + m2.getClass()); // m2 : class my.study.jpabasic.jpashop.domain.Member$HibernateProxy$E3jINkwO

      Member reference2 = em.find(Member.class, member1.getId());
      System.out.println("reference2 : " + reference2.getClass()); // reference2 : class my.study.jpabasic.jpashop.domain.Member$HibernateProxy$E3jINkwO

      System.out.println("m2 == reference2 : " + (m2 == reference2)); // true

      em.clear();


      Member reference3 = em.getReference(Member.class, member1.getId());
      System.out.println("reference3 : " + reference3.getClass()); // reference3 : class my.study.jpabasic.jpashop.domain.Member$HibernateProxy$E3jINkwO

      Member reference4 = em.find(Member.class, member1.getId());
      System.out.println("reference4 : " + reference4.getClass()); // reference4 : class my.study.jpabasic.jpashop.domain.Member$HibernateProxy$E3jINkwO

      System.out.println("reference3 == reference4 : " + (reference3 == reference4)); // true


      tx.commit();
    } catch (Exception e) {
      tx.rollback();
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
