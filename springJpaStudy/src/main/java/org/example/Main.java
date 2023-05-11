package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("helloJpa");

            //여기서 부터 영속 상태, 엔티티 매니저라는 곳에 영속성 컨텍스트에서 관리됌. 근데 아직 DB에 저장 안됌.
            System.out.println("====Before====");
            em.persist(member);
            System.out.println("====After====");

            //1차 캐시 응용한것. DB Select 안하고 조회
            Member findMember = em.find(Member.class, 101L);

            System.out.println("findmember.id : " + findMember.getId() );
            System.out.println("findmember.Name : " + findMember.getName() );

            //삭제, 실제 db에서 지우겠다.
//            em.remove(member);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        //code
        emf.close();
    }

}