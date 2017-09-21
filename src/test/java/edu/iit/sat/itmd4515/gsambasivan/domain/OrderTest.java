/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.AfterClass;
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
public class OrderTest {
    
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

    
    
}
