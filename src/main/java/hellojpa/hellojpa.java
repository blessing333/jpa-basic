package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class hellojpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            //저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("UserB");
//            em.persist(member);

            //조회
//            Member findMember=em.find(Member.class,1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            //수정
//            Member member = em.find(Member.class, 2L);
//            member.setName("fixed Name");


            //리스트 조회
//            List<Member> members = em.createQuery("select m from Member as m", Member.class).getResultList();
//            for(Member m : members){
//                System.out.println(m.getName());
//            }


            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
