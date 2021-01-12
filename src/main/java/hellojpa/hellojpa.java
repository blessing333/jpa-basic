package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class hellojpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member();
            member.setName("이민재");
            member.setAddress(new Address("dd","aa","dd"));
            System.out.println(new Address("bb","aa","dd").equals(new Address("dd","aa","dd")));
            em.persist(member);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();




        } finally {
            em.close();
        }
        emf.close();
    }
}
