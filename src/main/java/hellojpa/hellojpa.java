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
            Team team = new Team();
            team.setName("ATEAM");
            em.persist(team);
            member.setName("person");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

           // Member findMember = em.find(Member.class, member.getId());
            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
