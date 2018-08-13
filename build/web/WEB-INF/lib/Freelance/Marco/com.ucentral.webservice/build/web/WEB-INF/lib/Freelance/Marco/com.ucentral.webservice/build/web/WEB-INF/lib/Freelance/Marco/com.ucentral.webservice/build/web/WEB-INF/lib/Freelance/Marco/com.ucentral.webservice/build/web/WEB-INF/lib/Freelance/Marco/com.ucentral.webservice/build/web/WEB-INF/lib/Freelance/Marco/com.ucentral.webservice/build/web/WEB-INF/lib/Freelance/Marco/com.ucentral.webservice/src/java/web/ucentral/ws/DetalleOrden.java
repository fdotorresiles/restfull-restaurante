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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pachi
 */
@Path("detalleOrden")
public class DetalleOrden extends CrossOrigin {
    @GET
    @Path("/{idOrden}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<com.ucentral.modelo.DetalleOrden> obtenerDetalleOrden(@PathParam("idOrden")int idOrden) throws Exception {
        com.ucentral.dao.Ordenes oOrdenes = new com.ucentral.dao.Ordenes();
        
        return oOrdenes.consultarDetalleOrdenes(idOrden);
    }
    
    @POST
    @Path("")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String GuardarDetalleOrden(final com.ucentral.modelo.intoDetalleOrden intoDetalleOrden) throws Exception {
        com.ucentral.dao.Ordenes oOrdenes = new com.ucentral.dao.Ordenes();
        com.ucentral.modelo.DetalleOrden _detalleOrden = new com.ucentral.modelo.DetalleOrden();
     
        _detalleOrden.setIdOrden(intoDetalleOrden.idOrden);
        _detalleOrden.setIdProducto(intoDetalleOrden.idProducto);
        _detalleOrden.setCantidad(intoDetalleOrden.cantidad);
        _detalleOrden.setPrecioRegistrado(Double.parseDouble(intoDetalleOrden.precioRegistrado) );
        
        String result = "";
        if(oOrdenes.createDetalle(_detalleOrden)) {
            result = "{\"resultado\":\"creado\"}";
        } else {
            result = "{\"resultado\":\"error\"}";
        }
        return result;
    }
    
}
