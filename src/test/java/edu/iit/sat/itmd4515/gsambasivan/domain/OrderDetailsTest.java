/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.OrderDetails;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Swathi
 */
public class OrderDetailsTest {
    
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
    @Test
    public void createOrderDetailsDetailsTest() {
        //create functionality

        OrderDetails o1=new OrderDetails(100,80);
        tx.begin();
        assertNull("OrderDetails ID should be null before persist and commit", o1.getId());
        em.persist(o1);
        assertNull("OrderDetails ID should be null after persist but before commit", o1.getId());
        tx.commit();
        assertNotNull("OrderDetails ID should not be null after persist and commit", o1.getId());
        assertTrue("OrderDetails ID should be greater than 0 after commit", o1.getId() > 0);
    }
     @Test
    public void validateAmount(){
      OrderDetails o1=new OrderDetails(10,1);
     Set<ConstraintViolation<OrderDetails>> violations =  validator.validate(o1);
     assertFalse(violations.isEmpty());
     assertEquals(violations.size(),1);
    }
}
