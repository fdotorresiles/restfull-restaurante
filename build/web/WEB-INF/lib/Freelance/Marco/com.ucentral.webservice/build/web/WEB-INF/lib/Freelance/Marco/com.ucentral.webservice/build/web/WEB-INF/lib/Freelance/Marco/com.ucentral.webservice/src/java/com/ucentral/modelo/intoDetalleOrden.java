/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisfernandotorressiles
 */
@XmlRootElement
public class intoDetalleOrden {
    @XmlElement public int idOrden;
    @XmlElement public int idProducto;
    @XmlElement public int cantidad;
    @XmlElement public String precioRegistrado;
}
