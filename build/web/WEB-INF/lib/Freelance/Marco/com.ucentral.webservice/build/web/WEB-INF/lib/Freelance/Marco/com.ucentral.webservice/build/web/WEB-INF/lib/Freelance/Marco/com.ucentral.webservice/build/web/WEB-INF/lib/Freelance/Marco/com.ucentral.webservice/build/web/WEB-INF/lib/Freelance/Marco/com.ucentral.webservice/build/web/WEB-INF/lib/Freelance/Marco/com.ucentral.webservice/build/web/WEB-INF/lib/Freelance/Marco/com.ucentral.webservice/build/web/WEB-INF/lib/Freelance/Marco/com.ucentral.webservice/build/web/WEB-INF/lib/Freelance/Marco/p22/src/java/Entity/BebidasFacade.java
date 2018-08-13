/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisfernandotorressiles
 */
@Stateless
public class BebidasFacade extends AbstractFacade<Bebidas> {

    @PersistenceContext(unitName = "p22PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BebidasFacade() {
        super(Bebidas.class);
    }
    
}
