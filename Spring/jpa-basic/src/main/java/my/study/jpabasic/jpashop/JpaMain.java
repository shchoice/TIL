package my.study.jpabasic.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.jpashop.domain.Book;
import my.study.jpabasic.jpashop.domain.Order;
import my.study.jpabasic.jpashop.domain.OrderItem;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaShop");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Book book = new Book();
      book.setName("JPA");
      book.setAuthor("shchoi");

      em.persist(book);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
