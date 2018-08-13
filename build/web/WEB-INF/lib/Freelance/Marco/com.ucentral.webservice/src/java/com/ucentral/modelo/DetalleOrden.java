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
public class DetalleOrden {
    public int idDetalleOrden;
    public int idOrden;
    public int idProducto;
    public int cantidad;
    public double precioRegistrado;

    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioRegistrado() {
        return precioRegistrado;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioRegistrado(double precioRegistrado) {
        this.precioRegistrado = precioRegistrado;
    }
    
    
}
