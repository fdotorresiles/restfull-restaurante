/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;


@Path("/")
public class Ordenes {
    
    public List<com.ucentral.modelo.MaestroOrden> consultarMaestroOrdenes() throws Exception {
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        String sqlCosulta = "SELECT idOrden, "
                + "idSalonero, "
                + "cliente FROM maestroOrden";
        
        com.ucentral.modelo.MaestroOrden oOrden;
        List<com.ucentral.modelo.MaestroOrden> oLista = new ArrayList<>();
        
        try
        {
         conn = oConexion.conectarse();
         Statement objStatment = conn.createStatement();
         ResultSet objResultado = objStatment.executeQuery(sqlCosulta);
         
         while(objResultado.next())
         {
             oOrden = new com.ucentral.modelo.MaestroOrden();
             oOrden.setIdOrden(objResultado.getInt("IdOrden"));
             oOrden.setIdSalonero(objResultado.getInt("IdSalonero"));
             oOrden.setCliente(objResultado.getString("Cliente"));
             oLista.add(oOrden);
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
    
        public boolean createSalonero(com.ucentral.modelo.Saloneros eSalonero) {
        
        try {
            
            com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
            String sql = "INSERT INTO saloneros(idSalonero, Nombre, Apellidos) VALUES(?,?,?)";
            Connection conn = null;

            conn = oConexion.conectarse();

            PreparedStatement pstmnt = conn.prepareStatement(sql);

            pstmnt.setInt(1, eSalonero.getIdSalonero());
            pstmnt.setString(2, eSalonero.getNombre());
            pstmnt.setString(3, eSalonero.getApellidos());
        
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
                return false;
        }
        
    }
}
