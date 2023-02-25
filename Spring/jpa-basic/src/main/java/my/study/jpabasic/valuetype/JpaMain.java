package my.study.jpabasic.valuetype;

import java.util.List;
import java.util.Set;
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
      Member member1 = new Member();
      member1.setName("shchoi1");
      member1.setHomeAddress(new Address("city", "street", "zipcode"));
      member1.getFavoriteFoods().add("피자");
      member1.getFavoriteFoods().add("치킨");
      member1.getFavoriteFoods().add("탕수육");

      member1.getAddresseHistory().add(new Address("city1", "street1", "zipcode1"));
      member1.getAddresseHistory().add(new Address("city2", "street2", "zipcode2"));

      em.persist(member1);
      
      em.flush();
      em.clear();

      Member findMember = em.find(Member.class, member1.getId());
      // city1 -> city_new 로 변경하고 싶을 경우
      Address newAddress = findMember.getHomeAddress();
      findMember.setHomeAddress(new Address("newCity", newAddress.getStreet(), newAddress.getZipcode()));

      // 탕수육 -> 짜장면
      findMember.getFavoriteFoods().remove("탕수육");
      findMember.getFavoriteFoods().add("짜장면");

      // city1 -> city1_new 로 변경
      // equals() 를 반드시 제대로 구현해 주어야함
      findMember.getAddresseHistory().remove(new Address("city1", "street1", "zipcode1"));
      findMember.getAddresseHistory().add(new Address("city1_new", "street1", "zipcode1"));

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
