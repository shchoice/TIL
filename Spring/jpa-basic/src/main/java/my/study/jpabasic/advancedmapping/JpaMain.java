package my.study.jpabasic.advancedmapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import my.study.jpabasic.advancedmapping.domain.Movie;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("advancedmapping");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      Movie movie = new Movie();
      movie.setDirector("아이브");
      movie.setActor("안유진");
      movie.setName("Like");
      movie.setPrice(10000);

      em.persist(movie);

      em.flush();
      em.clear();

      Movie findMovie = em.find(Movie.class, movie.getId());
      System.out.println("findMove : " + findMovie.getName());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
