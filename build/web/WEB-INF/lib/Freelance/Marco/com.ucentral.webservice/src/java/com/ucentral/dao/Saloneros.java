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
import java.sql.PreparedStatement;


@Path("proyecto")
public class Saloneros {
    
    public String pruebaConexion() throws Exception{
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        try
        {
            conn = oConexion.conectarse();
            return "Se ha establecido la conexión con la base de datos.";
        }
        catch(SQLException e)
        {
            return "Ocurrió el siguiente error: " + e.getMessage();
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
                return "Ocurrió el siguiente error: " + ex.getMessage();
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
    
    public List<com.ucentral.modelo.Saloneros> consultarProyectos() throws Exception{
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        String sqlCosulta = "SELECT idSalonero, "
                + "Nombre, "
                + "Apellidos FROM saloneros";
        
        com.ucentral.modelo.Saloneros oSaloneros;
        List<com.ucentral.modelo.Saloneros> oLista = new ArrayList<>();
        
        try
        {
         conn = oConexion.conectarse();
         Statement objStatment = conn.createStatement();
         ResultSet objResultado = objStatment.executeQuery(sqlCosulta);
         
         while(objResultado.next())
         {
             oSaloneros = new com.ucentral.modelo.Saloneros();
             oSaloneros.setIdSalonero(objResultado.getInt("idSalonero"));
             oSaloneros.setNombre(objResultado.getString("Nombre"));
             oSaloneros.setApellidos(objResultado.getString("Apellidos"));
             oLista.add(oSaloneros);
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
