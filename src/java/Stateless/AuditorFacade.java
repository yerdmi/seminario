/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateless;

import Entities.Auditor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yerdmi
 */
@Stateless
public class AuditorFacade extends AbstractFacade<Auditor> {

    @PersistenceContext(unitName = "EJBSeminarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditorFacade() {
        super(Auditor.class);
    }
    
}
