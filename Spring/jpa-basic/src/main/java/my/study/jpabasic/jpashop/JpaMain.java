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

      Member refMember = em.getReference(Member.class, member1.getId());
      System.out.println("refMember : " + refMember.getClass());

      em.detach(refMember);

      System.out.println("refMember : " + refMember.getName());
      // org.hibernate.LazyInitializationException: could not initialize proxy [my.study.jpabasic.jpashop.domain.Member#1] - no Session
      //	at org.hibernate.proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer.java:176)
      //	at org.hibernate.proxy.AbstractLazyInitializer.getImplementation(AbstractLazyInitializer.java:322)
      //	at org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor.intercept(ByteBuddyInterceptor.java:45)
      //	at org.hibernate.proxy.ProxyConfiguration$InterceptorDispatcher.intercept(ProxyConfiguration.java:95)
      //	at my.study.jpabasic.jpashop.domain.Member$HibernateProxy$bsKnScm6.getName(Unknown Source)
      //	at my.study.jpabasic.jpashop.JpaMain.main(JpaMain.java:31)

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
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
