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
      Address address = new Address("city", "street", "zipcode");

      Member member1 = new Member();
      member1.setName("shchoi1");
      member1.setHomeAddress(address);
      em.persist(member1);

      Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

      Member member2 = new Member();
      member2.setName("shchoi2");
      member2.setHomeAddress(copyAddress);
      em.persist(member2);

      // setter를 없애서 불변 객체로 만든다. 작은 제약을 통해 부작용이라는 대재앙을 막음!
      // member1.getHomeAddress().setCity("newCity");


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
