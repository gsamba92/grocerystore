/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.Product;
import edu.iit.sat.itmd4515.gsambasivan.domain.UnitMeasurement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
public class ProductTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void beforeClassTestFixture() {
        emf = Persistence.createEntityManagerFactory("itmd4515PU_TEST");
    }

    @AfterClass
    public static void afterClassTestFixture() {
        emf.close();
    }

    @Before
    public void beforeEachTestMethod() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Product seed = new Product("Mock Product", 2);
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @After
    public void afterEachTestMethod() {

        Product seed
                = em.createNamedQuery("Product.findByProductName", Product.class)
                        .setParameter("productName", "Mock Product")
                        .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();
        em.close();

    }

    @Test
    public void firstCreateProductTest() {
        //create functionality

        Product o1 = new Product("HP notebook", 3);
        tx.begin();
        assertNull("Product ID should be null before persist and commit", o1.getProductId());
        em.persist(o1);
        assertNull("Product ID should be null after persist but before commit", o1.getProductId());
        tx.commit();
        assertNotNull("Product ID should not be null after persist and commit", o1.getProductId());
        assertTrue("Product ID should be greater than 0 after commit", o1.getProductId() > 0);

        //Read functionality
        Product o2 = em.find(Product.class, o1.getProductId());
        System.out.println("Product Id " + o2.getProductId() + " Product Name " + o2.getProductName());
        assertEquals("HP notebook", o2.getProductName());

    }
    @Test 
    public void secondUpdateProduct() {
        //update  functionality

        Product o2;
        tx.begin();
        o2 = em.find(Product.class, em.createNamedQuery("Product.findByProductName", Product.class)
                .setParameter("productName", "HP notebook")
                .getSingleResult().getProductId());
        o2.setProductName("Updated HP notebook");
        tx.commit();
        System.out.println("Product Id " + o2.getProductId() + " Product Name " + o2.getProductName());
        assertEquals("Updated HP notebook", o2.getProductName());
    }
    @Test(expected = RollbackException.class)
    public void uniqueConstraintFailTest() {
        // Rollback Exception due to duplicate entry for category name as its unique

        Product seed = new Product("Mock Product", 2);
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @Test(expected = RollbackException.class)
    public void updateFailTest() {
        // Rollback Exception due to setting the primary key column

        tx.begin();
        Product seed = em.find(Product.class, em.createNamedQuery("Product.findByProductName", Product.class)
                .setParameter("productName", "Updated HP notebook")
                .getSingleResult().getProductId());
        seed.setProductId(1l);
        tx.commit();
    }
@Test
    public void validateOneToOneRelationshipwithUnitMeasurement(){
        Product p1= new Product("Test Product1", 1320);
        Product p2= new Product("Test Product2", 132);
        UnitMeasurement u1= new UnitMeasurement("unit 1","desc");
        UnitMeasurement u2= new UnitMeasurement("unit 2","desc");
        p1.addUnitMeasurement(u1);
        p2.addUnitMeasurement(u2);
         tx.begin();
         em.persist(u1);
         em.persist(u2);
         em.persist(p1);
         em.persist(p2);
         tx.commit();
         
        Product findproducts = em.find(Product.class, p1.getProductId());
        assertTrue(findproducts.getUnitMeasurement().getUnitId()>=1);
        
    }
    
    @Test 
    public void deleteProductTest() {
        //delete functionality
        Product seed = new Product("Delete Product", 5);
        tx.begin();
        em.persist(seed);
        tx.commit();
        if (seed != null) {
            tx.begin();
            em.remove(seed);
            tx.commit();
        }
        List<Product> departments = em.createNamedQuery("Product.findByProductName", Product.class)
                .setParameter("productName", "Delete Product")
                .getResultList();

        assertEquals(0, departments.size());
        for (Product p : departments) {
            assertNull(p);
        }

    }
}
