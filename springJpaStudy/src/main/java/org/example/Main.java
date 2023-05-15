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
            Member findMember1 = em.find(Member.class,101L);

            //똑같은거 조회할때는 select 쿼리가 안돌고 1차 캐시에서 가져옴을 볼수있음.
            Member findMember2 = em.find(Member.class,101L);

            //영속 엔티티의 동일성 보장
            System.out.println("result = " + (findMember1 == findMember2));

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