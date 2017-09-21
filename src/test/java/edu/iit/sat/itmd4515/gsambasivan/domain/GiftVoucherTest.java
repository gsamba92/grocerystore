/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.GiftVoucher;
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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Swathi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftVoucherTest {
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

        GiftVoucher seed = new GiftVoucher("Mock GiftVoucher", 20);
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @After
    public void afterEachTestMethod() {

        GiftVoucher seed
                = em.createNamedQuery("GiftVoucher.findByVoucherName", GiftVoucher.class)
                        .setParameter("giftvoucherName", "Mock GiftVoucher")
                        .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();
        em.close();

    }

    

    @Test
    public void validateNull() {
        GiftVoucher seed = new GiftVoucher(null, 20);
        Set<ConstraintViolation<GiftVoucher>> violations = validator.validate(seed);

        
        assertFalse(violations.isEmpty());
    }
    @Test
    public void firstCreateGiftVoucherTest() {
        //create functionality

        GiftVoucher o1 = new GiftVoucher("Frozen Food", 10);
        tx.begin();
        assertNull("GiftVoucher ID should be null before persist and commit", o1.getGiftVoucherId());
        em.persist(o1);
        assertNull("GiftVoucher ID should be null after persist but before commit", o1.getGiftVoucherId());
        tx.commit();
        assertNotNull("GiftVoucher ID should not be null after persist and commit", o1.getGiftVoucherId());
        assertTrue("GiftVoucher ID should be greater than 0 after commit", o1.getGiftVoucherId() > 0);

        //Read functionality
        GiftVoucher o2 = em.find(GiftVoucher.class, o1.getGiftVoucherId());
        System.out.println("GiftVoucher Id " + o2.getGiftVoucherId() + " GiftVoucher Name " + o2.getGiftvoucherName());
        assertEquals("Frozen Food", o2.getGiftvoucherName());

    }

    @Test
    public void secondUpdateGiftVoucher() {
        //update  functionality

        GiftVoucher o2;
        tx.begin();
        o2 = em.find(GiftVoucher.class, em.createNamedQuery("GiftVoucher.findByVoucherName", GiftVoucher.class)
                        .setParameter("giftvoucherName", "Frozen Food")
                        .getSingleResult().getGiftVoucherId());
        o2.setGiftvoucherName("Updated frozen");
        tx.commit();
        System.out.println("Product Category Id " + o2.getGiftVoucherId() + " Product Category Name " + o2.getGiftvoucherName());
        assertEquals("Updated frozen", o2.getGiftvoucherName());
    }
    @Test(expected = RollbackException.class)
    public void updateFailTest() {
        // Rollback Exception due to setting the primary key column

        tx.begin();
        GiftVoucher seed = em.find(GiftVoucher.class, em.createNamedQuery("GiftVoucher.findByVoucherName", GiftVoucher.class)
                        .setParameter("giftvoucherName", "Updated frozen")
                        .getSingleResult().getGiftVoucherId());
        seed.setGiftVoucherId(1l);
        tx.commit();
    }

    @Test
    public void deleteGiftVoucherTest() {
        //delete functionality
        GiftVoucher seed = new GiftVoucher("Delete GiftVoucher",5);
        tx.begin();
        em.persist(seed);
        tx.commit();
        if (seed != null) {
            tx.begin();
            em.remove(seed);
            tx.commit();
        }
        List<GiftVoucher> departments = em.createNamedQuery("GiftVoucher.findByVoucherName", GiftVoucher.class)
                .setParameter("giftvoucherName", "Delete GiftVoucher")
                .getResultList();

        assertEquals(0, departments.size());
        for (GiftVoucher p : departments) {
            assertNull(p);
        }

    }

}
