package my.study.jpabasic.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpashop.domain.Order;
import my.study.jpabasic.jpashop.domain.OrderItem;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaShop");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Order order = new Order();
      order.addOrderItem(new OrderItem()); // 양방향일 경우
      /* 단방향일 경우 // 양방향이 아니고 단방향으로도 다 코드 구현 가능하다 // 하지만 실무에서는 JPQL과 코드를 편하게 짜려다 보니 양방향으로 짜게되는 경우가 생긴다.
       * Order order = new Order();
       * em.persist(order);
       *
       * OrderItem orderItem = new OrderItem();
       * orderItem.setOrder(order);
       * em.persist(orderItem);
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
