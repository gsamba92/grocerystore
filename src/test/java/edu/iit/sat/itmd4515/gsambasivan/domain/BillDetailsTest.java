/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.BillDetails;
import edu.iit.sat.itmd4515.gsambasivan.domain.GiftVoucher;
import edu.iit.sat.itmd4515.gsambasivan.domain.Order;
import edu.iit.sat.itmd4515.gsambasivan.domain.Customer;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Swathi
 */
public class BillDetailsTest {
    
     private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    private static Validator validator;

    @BeforeClass
    public static void beforeClassTestFixture() {
        emf = Persistence.createEntityManagerFactory("itmd4515PU_TEST");
        validator =  Validation.buildDefaultValidatorFactory().getValidator();
    }

    @AfterClass
    public static void afterClassTestFixture() {
        emf.close();
    }
 @Before
    public void beforeEachTestMethod() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
   /* @Test
    public void validateRelationshipwithOrder(){
        Customer seed = new Customer("Abc", "Def", "Xyz", "dummyUser", "dummyPassword", "dummy@abc.com", "Male", "1234567890", new GregorianCalendar(1992, 11, 7).getTime(), false);
         Order o1=new Order( new GregorianCalendar(2017,1,1).getTime() ,100,20,"Credit",80);
         BillDetails b1=new BillDetails(new GregorianCalendar(2014,3,1).getTime(), "123456878","HDFC",80.0);
         GiftVoucher g1 = new GiftVoucher("Summer Sale", 10);
         b1.addOrder(o1);
         tx.begin();
         em.persist(g1);
         em.persist(seed);
         em.persist(o1);
         em.persist(b1);
         tx.commit();
         
         BillDetails findBill = em.find(BillDetails.class, b1.getBilId());
         System.out.println("Order object : "+findBill.getOrder());
         assertTrue(findBill.getOrder().getOrderId().equals(o1.getOrderId()));
        
    } */
}