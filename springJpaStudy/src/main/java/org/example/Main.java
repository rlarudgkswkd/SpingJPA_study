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

            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //JPA에서 관리를 안하게함. 결과에 Update가 없음.
//            em.detach(member);

            //영속성 콘텍스트를 통으로 날려버림. 마찬가지로 update 없음.
            em.clear();

            Member member2 = em.find(Member.class, 150L);

            System.out.println("================");

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