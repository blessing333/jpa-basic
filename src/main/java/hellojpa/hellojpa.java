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
            Parent parent = new Parent();
            parent.setName("father");
            Child child = new Child();
            child.setName("child a");
            Child child1 = new Child();
            child1.setName("child2");

            parent.addChild(child);
            parent.addChild(child1);

//            em.persist(parent);
//            em.persist(child);
            em.persist(child1);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
