/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.ProductCategory;
import edu.iit.sat.itmd4515.gsambasivan.domain.SubCategory;
import java.util.List;
import java.util.Set;
import javax.validation.Validator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Swathi
 */
public class ProductCategoryTest {

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

        ProductCategory seed = new ProductCategory("Mock ProductCategory", "Mock Product Category Description");
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @After
    public void afterEachTestMethod() {

        ProductCategory seed
                = em.createNamedQuery("ProductCategory.findByName", ProductCategory.class)
                        .setParameter("categoryName", "Mock ProductCategory")
                        .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();
        em.close();

    }

    

    @Test
    public void validateNull() {
        ProductCategory seed = new ProductCategory(null, "Mock Product Category Description");
        Set<ConstraintViolation<ProductCategory>> violations = validator.validate(seed);

        
        assertFalse(violations.isEmpty());
    }
    @Test
    public void createProductCategoryTest() {
        //create functionality

        ProductCategory o1 = new ProductCategory("Frozen Food", "This section contains all frozen food which has all types of meat and vegetables.");
        tx.begin();
        assertNull("ProductCategory ID should be null before persist and commit", o1.getCategoryId());
        em.persist(o1);
        assertNull("ProductCategory ID should be null after persist but before commit", o1.getCategoryId());
        tx.commit();
            assertNotNull("ProductCategory ID should not be null after persist and commit", o1.getCategoryId());
        assertTrue("ProductCategory ID should be greater than 0 after commit", o1.getCategoryId() > 0);

        //Read functionality
        ProductCategory o2 = em.find(ProductCategory.class, o1.getCategoryId());
        System.out.println("Product Category Id " + o2.getCategoryId() + " Product Category Name " + o2.getCategoryName());
        assertEquals("Frozen Food", o2.getCategoryName());

    }

    @Test
    public void updateProductCategory() {
        //update  functionality

        ProductCategory o2;
        tx.begin();
        o2 = em.find(ProductCategory.class, em.createNamedQuery("ProductCategory.findByName", ProductCategory.class)
                        .setParameter("categoryName", "Frozen Food")
                        .getSingleResult().getCategoryId());
        o2.setCategoryName("Updated frozen");
        tx.commit();
        System.out.println("Product Category Id " + o2.getCategoryId() + " Product Category Name " + o2.getCategoryName());
        assertEquals("Updated frozen", o2.getCategoryName());
    }

    @Test(expected = RollbackException.class)
    public void uniqueConstraintFailTest() {
        // Rollback Exception due to duplicate entry for category name as its unique

        ProductCategory seed = new ProductCategory("Mock ProductCategory", "Mock description for failure");
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @Test(expected = RollbackException.class)
    public void updateFailTest() {
        // Rollback Exception due to setting the primary key column

        tx.begin();
        ProductCategory seed = em.find(ProductCategory.class, em.createNamedQuery("ProductCategory.findByName", ProductCategory.class)
                        .setParameter("categoryName", "Updated frozen")
                        .getSingleResult().getCategoryId());
        seed.setCategoryId(1l);
        tx.commit();
    }

    @Test
    public void validateOneToManyWwithSubCateory(){
        ProductCategory o1 = new ProductCategory("Milk", "This section contains all types of milk.");
        SubCategory s1 = new SubCategory("2%","desc");
        SubCategory s2 = new SubCategory("Full Fat","desc");
        o1.addSubCategory(s1);
        o1.addSubCategory(s2);
        tx.begin();
         em.persist(o1);
         em.persist(s1);
         em.persist(s2);
         
         tx.commit();
          ProductCategory cat = em.find(ProductCategory.class, o1.getCategoryId());
       
        assertTrue(cat.getSubCategory().size()==2);
    }
    @Test
    public void deleteProductCategoryTest() {
        //delete functionality
        ProductCategory seed = new ProductCategory("Delete ProductCategory", "Mock description");
        tx.begin();
        em.persist(seed);
        tx.commit();
        if (seed != null) {
            tx.begin();
            em.remove(seed);
            tx.commit();
        }
        List<ProductCategory> departments = em.createNamedQuery("ProductCategory.findByName", ProductCategory.class)
                .setParameter("categoryName", "Delete ProductCategory")
                .getResultList();

        assertEquals(0, departments.size());
        for (ProductCategory p : departments) {
            assertNull(p);
        }

    }

}
