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

      // 이렇게 작성할 경우 member1.city 와 member2.city 값 모두가 바뀌어 버그 찾기도 어려운 심각한 문제가 발생
      // 만약에 member1.city, member2.city 모두가 변하게 하는 것이 정말 의도라면 Address를 Entity로 설정했어야 한다.
      member1.getHomeAddress().setCity("newCity");


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
