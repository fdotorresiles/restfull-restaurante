/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.dao;

//Estos son los imports necesarios para crear minimo la conexión a la BD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Antaros
 */
public class Conexion {
    
    String DRIVERSQLITE = "org.sqlite.JDBC";
    String DRIVESQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String STRINGCONEXIONSQLITE = "jdbc:sqlite:/Users/luisfernandotorressiles/Documents/Personal/Freelance/Marco/com.ucentral.webservice/restauranteBD.db";
    
    private boolean _tipoConexion = false;
    
    public Conexion()
    {
        
    }
    
    
    public Conexion(boolean sqlite)
    {
        
    }
    
    public Connection conectarse() throws Exception
    {
        Connection con = null;
       
        try{
            Class.forName(DRIVERSQLITE);
            
            String connectionUrl = STRINGCONEXIONSQLITE;
            
            con = DriverManager.getConnection(connectionUrl);
            return con;
        }
        catch(SQLException e){
            throw e;
        }
        catch(ClassNotFoundException ex){
            throw ex;
        }
    }
    
    public boolean desconectarse(Connection con)throws Exception
    {
         try{
            Class.forName(DRIVERSQLITE);
            
            if(con != null)
                con.close();
            
            return true;
        }
        catch(SQLException e){
            return false;
        }
        catch(ClassNotFoundException ex){
            return false;
        }
    }
}
