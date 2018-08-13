/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.ucentral.ws;

import com.ucentral.modelo.MaestroOrden;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luisfernandotorressiles
 */
@Path("orden")
public class Orden extends CrossOrigin {
    
    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<com.ucentral.modelo.MaestroOrden> obtenerOrdenes() throws Exception {
        com.ucentral.dao.Ordenes oOrdenes = new com.ucentral.dao.Ordenes();
        
        return oOrdenes.consultarMaestroOrdenes();
    }
    
    @GET
    @Path("/{idSalonero}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<com.ucentral.modelo.MaestroOrden> obtenerMaestroSalonero(@PathParam("idSalonero") int idSalonero) throws Exception {
        com.ucentral.dao.Ordenes oOrdenes = new com.ucentral.dao.Ordenes();

        return oOrdenes.consultarMaestroOrdenesSalonero(idSalonero);
    }
    
    @POST
    @Path("")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String crearOrden(final com.ucentral.modelo.intoMaestroOrden orden)  throws Exception {
        com.ucentral.dao.Ordenes oOrdenes = new com.ucentral.dao.Ordenes();
        
        com.ucentral.modelo.MaestroOrden mOrden = new MaestroOrden();
        mOrden.setCliente(orden.cliente);
        mOrden.setIdSalonero(orden.idSalonero);
        
        String result = "";
        int idOrden = oOrdenes.createMaestroOrden(mOrden); 
        if(idOrden != 0) {
            result = "{\"idOrden\":\""+idOrden+"\"}";
        } else {
            result = "{\"resultado\":\"error\"}";
        }
        
        return result;
    }
}