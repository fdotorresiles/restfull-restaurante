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
@Path("productos")
public class Productos {
    
    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<com.ucentral.modelo.Productos> obtenerProductos() throws Exception {
        com.ucentral.dao.Productos oProductos = new com.ucentral.dao.Productos();
        
        return oProductos.consultarProductos();
    }
    
}