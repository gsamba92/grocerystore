    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.After;
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
public class PersonTest {

   /* private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
     private static Validator validator;
    //SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");

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
    public void beforeEachTestMethod() throws ParseException {
        em = emf.createEntityManager();
        tx = em.getTransaction();

       Customer seed = new Customer("Abc", "Def", "Xyz", "dummy@abc.com", "Male", "1234567890", new GregorianCalendar(1992, 11, 7).getTime(), false);
       tx.begin();
       em.persist(seed);
       tx.commit();
    }

    @After
    public void afterEachTestMethod() {

        Customer seed
                = em.createNamedQuery("Customer.findByEmail", Customer.class)
                        .setParameter("email", "dummy@abc.com")
                        .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();
        em.close();

    }
   @Test 
   public void validateNotNullNames(){
        Customer seed = new Customer(null, null, null, "dummy@abc.com", "Male", "1234567890", new GregorianCalendar(1992, 11, 7).getTime(), false);
        Set<ConstraintViolation<Customer>> violations =  validator.validate(seed);
        assertFalse(violations.isEmpty());
        assertTrue(violations.size()==3);
        assertEquals(violations.size(),3);
    }
    @Test
    public void createPersonTest() throws ParseException {
        //create functionality

        Customer o1 = new Customer("FNU", "Gomathi", "Sambasivan",  "gomzi.gs@gmail.com", "Female", "1234567890", new GregorianCalendar(1950, 5, 7).getTime(), true);
        tx.begin();
        assertNull("Customer ID should be null before persist and commit", o1.getPersonId());
        em.persist(o1);
        assertNull("Customer ID should be null after persist but before commit", o1.getPersonId());
        tx.commit();
        assertNotNull("Customer ID should not be null after persist and commit", o1.getPersonId());
        assertTrue("Customer ID should be greater than 0 after commit", o1.getPersonId() > 0);
        //Read functionality
        Customer o2 = em.find(Customer.class, o1.getPersonId());
        
        assertEquals("Female", o2.getGender());

    }

    @Test
    public void updatePerson() {
        //update  functionality

        Customer o2;
        tx.begin();
        o2 = em.find(Customer.class, em.createNamedQuery("Customer.findByEmail", Customer.class)
                .setParameter("email", "gomzi.gs@gmail.com")
                .getSingleResult().getPersonId());
        o2.setContactNo("3123838806");
        tx.commit();
        System.out.println("Customer Id " + o2.getPersonId() + " Customer Contact " + o2.getContactNo());
        assertEquals("3123838806", o2.getContactNo());
    }

    @Test(expected = RollbackException.class)
    public void uniqueConstraintFailTest() throws ParseException {
        // Rollback Exception due to duplicate entry for category name as its unique

        Customer seed = new Customer("Abc", "Def", "Xyz", "dummy@abc.com", "Male", "1234567890", new GregorianCalendar(1950, 5, 7).getTime(), false);
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @Test(expected = RollbackException.class)
    public void updateFailTest() {
        // Rollback Exception due to setting the primary key column

        tx.begin();
        Customer seed = em.find(Customer.class, em.createNamedQuery("Customer.findByEmail", Customer.class)
                .setParameter("email", "gomzi.gs@gmail.com")
                .getSingleResult().getPersonId());
        seed.setPersonId(1l);
        tx.commit();
    }

    @Test
    public void deletePersonTest() throws ParseException {
        //delete functionality
        Customer seed = new Customer("Abc", "Def", "Xyz", "dumm@abc.com", "Male", "1234567890", new GregorianCalendar(1950, 5, 7).getTime(), false);
        tx.begin();
        em.persist(seed);
        tx.commit();
        if (seed != null) {
            tx.begin();
            em.remove(seed);
            tx.commit();
        }
        List<Customer> persons = em.createNamedQuery("Customer.findByEmail", Customer.class)
                .setParameter("email", "dumm@abc.com")
                .getResultList();

        assertEquals(0, persons.size());
        for (Customer p : persons) {
            assertNull(p);
        }

    }*/
}
