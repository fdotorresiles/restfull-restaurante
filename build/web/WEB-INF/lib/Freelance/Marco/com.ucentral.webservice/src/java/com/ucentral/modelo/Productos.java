/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.modelo;

/**
 *
 * @author luisfernandotorressiles
 */
public class Productos {
    
    public int idProducto;
    public String descripcion;
    public String tipoProducto;
    public double precio;

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
