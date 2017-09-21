/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.ejb;

import edu.iit.sat.itmd4515.gsambasivan.domain.Admins;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Swathi
 */
@Stateless

public class AdminService extends BaseService<Admins> {
    public AdminService() {
        super(Admins.class);
    }

    @Override
    public List<Admins> findAll() {
        return getEntityManager().createNamedQuery("Admins.findAll", Admins.class).getResultList();
    }

    public Admins findByUsername(String username) {
        return getEntityManager()
                .createNamedQuery("Admins.findByUserName", Admins.class)
                .setParameter("username", username)
                .getSingleResult();
    }

}
