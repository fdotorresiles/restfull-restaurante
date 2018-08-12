/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.ucentral.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author luisfernandotorressiles
 */
@Path("pruebas")
public class ServicioPruebas {
    
    @GET
    @Path("pruebaservicio")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String comprobarServicioArriba() {
        return "Hola";
    }
}
