/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.iit.sat.itmd4515.gsambasivan.domain.Customer;

/**
 *
 * @author Swathi
 */
public class CustomerService {
     @PersistenceContext(unitName = "itmd4515PU") private EntityManager em;

    public CustomerService() {
    }

   public void create(Customer user){
       em.persist(user);
   }   
 
   public void update(Customer user){
       em.merge(user);
   }

   public void remove(Customer user){
       em.remove(em.merge(user));
   }

   public Customer find(Long id){
       
       return em.find(Customer.class, id);
   }

   public List<Customer> findAll(){
       return em.createNamedQuery("Customer.findAll",Customer.class).getResultList();
   }
   
    public Customer findByUsername(String username){
        return em.createNamedQuery("Customer.findByUsername", Customer.class)
                .setParameter("username", username)
                .getSingleResult();
    }
   
}
