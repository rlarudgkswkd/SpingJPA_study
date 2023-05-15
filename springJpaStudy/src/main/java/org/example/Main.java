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
            //INSERT
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("hellob");
//              em.persist(member);

            //Find
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id : " + findMember.getId());
//            System.out.println("findMember.name : " + findMember.getName());

            //Modify
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJpa");

            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZ"); //값만 변경해도 실행됌.
            //update 쿼리를 날리듯이 작동함 왜지?

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