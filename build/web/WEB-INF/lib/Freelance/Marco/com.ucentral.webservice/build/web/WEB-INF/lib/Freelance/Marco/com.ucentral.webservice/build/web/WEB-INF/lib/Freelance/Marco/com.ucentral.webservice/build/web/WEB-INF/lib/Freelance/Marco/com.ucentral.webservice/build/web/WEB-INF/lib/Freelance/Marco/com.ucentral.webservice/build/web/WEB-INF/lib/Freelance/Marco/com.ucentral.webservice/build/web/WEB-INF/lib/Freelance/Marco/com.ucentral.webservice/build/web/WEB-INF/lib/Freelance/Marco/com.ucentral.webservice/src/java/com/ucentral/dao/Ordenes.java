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
    
    public List<com.ucentral.modelo.MaestroOrden> consultarMaestroOrdenesSalonero(int idSalonero) throws Exception {
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        String sqlCosulta = "SELECT idOrden, "
                + "idSalonero, "
                + "cliente FROM maestroOrden "
                + "WHERE idSalonero = ?";
        
        com.ucentral.modelo.MaestroOrden oOrden;
        List<com.ucentral.modelo.MaestroOrden> oLista = new ArrayList<>();
        
        try
        {
         conn = oConexion.conectarse();
         
         PreparedStatement  objStatment = conn.prepareStatement(sqlCosulta);
         objStatment.setString(1, String.valueOf(idSalonero));
         
         ResultSet objResultado = objStatment.executeQuery();
         
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
    
    public boolean createMaestroOrden(com.ucentral.modelo.MaestroOrden maestroOrden) {    
        try {
            
            com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
            String sql = "INSERT INTO maestroOrden(idSalonero, cliente) VALUES(?,?)";
            Connection conn = null;

            conn = oConexion.conectarse();

            PreparedStatement pstmnt = conn.prepareStatement(sql);

            pstmnt.setInt(1, maestroOrden.getIdSalonero());
            pstmnt.setString(2, maestroOrden.getCliente());
        
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
                return false;
        }        
    }
    
      public List<com.ucentral.modelo.DetalleOrden> consultarDetalleOrdenes(int idOrden) throws Exception {
        com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
        Connection conn = null;
        
        String sqlCosulta = "SELECT d.idDetalleOrden, "
                + "d.idOrden, "
                + "d.idProducto, "
                + "d.cantidad, "
                + "d.precioRegistrado "
                + "FROM detalleOrden d "
                + "WHERE d.idOrden = ?";
        
        com.ucentral.modelo.DetalleOrden oOrden;
        List<com.ucentral.modelo.DetalleOrden> oLista = new ArrayList<>();
        
        try
        {
         conn = oConexion.conectarse();         
         PreparedStatement  objStatment = conn.prepareStatement(sqlCosulta);
         objStatment.setString(1, String.valueOf(idOrden));
         
         ResultSet objResultado = objStatment.executeQuery();
         
         while(objResultado.next())
         {
             oOrden = new com.ucentral.modelo.DetalleOrden();
             oOrden.setIdDetalleOrden(objResultado.getInt("idDetalleOrden"));
             oOrden.setIdOrden(objResultado.getInt("IdOrden"));
             oOrden.setIdProducto(objResultado.getInt("idProducto"));
             oOrden.setCantidad(objResultado.getInt("cantidad"));
             oOrden.setPrecioRegistrado(objResultado.getDouble("precioRegistrado"));
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
       
    public boolean createDetalle(com.ucentral.modelo.DetalleOrden detalleOrden) {        
        try {            
            com.ucentral.dao.Conexion oConexion = new com.ucentral.dao.Conexion();
        
            String sql = "INSERT INTO detalleOrden\n" +
            "( idOrden, idProducto, cantidad, precioRegistrado) VALUES ( ?, ?, ?, ? );";
            Connection conn = null;

            conn = oConexion.conectarse();

            PreparedStatement pstmnt = conn.prepareStatement(sql);
            
            pstmnt.setInt(1, detalleOrden.getIdOrden());
            pstmnt.setInt(2, detalleOrden.getIdProducto());
            pstmnt.setInt(3, detalleOrden.getCantidad());
            pstmnt.setDouble(4, detalleOrden.getPrecioRegistrado());
        
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
                return false;
        }        
    }
}
