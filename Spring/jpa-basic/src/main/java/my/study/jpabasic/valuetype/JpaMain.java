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
      // 지연 로딩
      List<Address> addresseHistory = findMember.getAddresseHistory();
      for (Address address : addresseHistory) {
        System.out.println("address = " + address.getCity());
      }
      Set<String> favoriteFoods = findMember.getFavoriteFoods();
      for (String favoriteFood : favoriteFoods) {
        System.out.println("favoriteFood = " + favoriteFood);
      }

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
