/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.service;

import entity.Saloneros;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luisfernandotorressiles
 */
public class SalonerosFacadeREST extends AbstractFacade<Saloneros>{    

    public SalonerosFacadeREST(Class<Saloneros> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GET
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Saloneros> findAll(){
        return super.findAll();
    }
    
    
}
