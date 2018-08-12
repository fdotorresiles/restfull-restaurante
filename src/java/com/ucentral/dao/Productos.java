/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;


@Path("/")
public class Productos {
    
    public List<com.ucentral.modelo.Productos> consultarProductos() throws Exception{
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        String sqlCosulta = "SELECT idProducto, "
                + "descripcion, "
                + "tipoProducto, "
                + "precio FROM producto";
        
        com.ucentral.modelo.Productos oProductos;
        List<com.ucentral.modelo.Productos> oLista = new ArrayList<>();
        
        try
        {
         conn = oConexion.conectarse();
         Statement objStatment = conn.createStatement();
         ResultSet objResultado = objStatment.executeQuery(sqlCosulta);
         
         while(objResultado.next())
         {
             oProductos = new com.ucentral.modelo.Productos();
             oProductos.setIdProducto(objResultado.getInt("idProducto"));
             oProductos.setDescripcion(objResultado.getString("descripcion"));
             oProductos.setTipoProducto(objResultado.getString("tipoProducto"));
             oProductos.setPrecio(objResultado.getDouble("precio"));
             oLista.add(oProductos);
         }
         return oLista;
        }
        catch(SQLException e)
        {
            throw new Exception("Ocurrió el siguiente error general: " + e.getMessage());
        }
        finally
        {
            try
            {
                if(conn != null)
                    oConexion.desconectarse(conn);
            }
            catch(SQLException ex)
            {
                throw new Exception ("Ocurrió el siguiente error en BD: " + ex.getMessage());
            }
        }
    }
}
