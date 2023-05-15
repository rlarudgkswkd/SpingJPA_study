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

            Member memberA = new Member(200L,"memberA");
            em.persist(memberA);
            Member memberB = new Member(210L,"memberB");
            em.persist(memberB);
            Member memberC = new Member(220L,"member2022");
            em.persist(memberC);

            em.flush();

//            em.persist(member);

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