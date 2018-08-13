/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.ucentral.ws;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luisfernandotorressiles
 */
@Path("saloneros")
public class Saloneros extends CrossOrigin {
    
    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<com.ucentral.modelo.Saloneros> obtenerSaloneros() throws Exception {
        com.ucentral.dao.Saloneros oSaloneros = new com.ucentral.dao.Saloneros();
        
        return oSaloneros.consultarProyectos();
    }
    
    @POST
    @Path("")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String crearSalonero(final com.ucentral.modelo.intoSaloner intoSalonero) throws Exception {
        com.ucentral.dao.Saloneros oSaloneros = new com.ucentral.dao.Saloneros();
        
        com.ucentral.modelo.Saloneros _salonero = new com.ucentral.modelo.Saloneros();
        _salonero.setIdSalonero(intoSalonero.idSalonero);
        _salonero.setNombre(intoSalonero.nombre);
        _salonero.setApellidos(intoSalonero.apellidos);
        
        String result = "";
        if(oSaloneros.createSalonero(_salonero)) {
            result = "{\"resultado\":\"creado\"}";
        } else {
            result = "{\"resultado\":\"error\"}";
        }
        return result;
    }
    
    
}