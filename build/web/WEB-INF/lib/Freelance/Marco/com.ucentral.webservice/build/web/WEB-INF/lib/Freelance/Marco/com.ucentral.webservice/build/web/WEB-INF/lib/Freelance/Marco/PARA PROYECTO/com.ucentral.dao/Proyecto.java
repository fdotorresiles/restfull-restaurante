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

@Path("proyecto")
public class Proyecto {
    
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
    
    public List<com.ucentral.modelo.Proyecto> consultarProyectos() throws Exception{
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        String sqlCosulta = "SELECT Codigo_Proyecto, "
                + "Nombre, "
                + "Descripcion, "
                + "Fecha_Inicio, "
                + "Fecha_Final, "
                + "Presupuesto FROM Proyectos";
        
        com.ucentral.modelo.Proyecto oProyectos;
        List<com.ucentral.modelo.Proyecto> oLista = new ArrayList<>();
        
        try
        {
         conn = oConexion.conectarse();
         Statement objStatment = conn.createStatement();
         ResultSet objResultado = objStatment.executeQuery(sqlCosulta);
         
         while(objResultado.next())
         {
             oProyectos = new com.ucentral.modelo.Proyecto();
             oProyectos.setCodigoProyecto(objResultado.getLong("Codigo_Proyecto"));
             oProyectos.setNombre(objResultado.getString("Nombre"));
             oProyectos.setDescripcion(objResultado.getString("Descripcion"));
             oProyectos.setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(objResultado.getString("Fecha_Inicio")));
             oProyectos.setFechaFinal(new SimpleDateFormat("yyyy-MM-dd").parse(objResultado.getString("Fecha_Final")));
             oProyectos.setPresupuesto(objResultado.getDouble("Presupuesto"));
          
             oLista.add(oProyectos);
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
