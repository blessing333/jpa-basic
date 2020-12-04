package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Jpashop {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{

        }catch(Exception e){
            transaction.rollback();
        }
        finally{
            transaction.commit();
            em.close();
            emf.close();
        }

    }
}
