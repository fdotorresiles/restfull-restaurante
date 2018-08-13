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
public class MaestroOrden {
    public int idOrden;
    public int idSalonero;
    public String cliente;

    public int getIdOrden() {
        return idOrden;
    }

    public int getIdSalonero() {
        return idSalonero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public void setIdSalonero(int idSalonero) {
        this.idSalonero = idSalonero;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
}
