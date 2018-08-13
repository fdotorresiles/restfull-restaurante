/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisfernandotorressiles
 */
@MappedSuperclass
@Table(name = "postres")
@XmlRootElement
public class Postres implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PostresPK postresPK;
    @Column(name = "idPostre")
    private Integer idPostre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000000000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;

    public Postres() {
    }

    public Postres(PostresPK postresPK) {
        this.postresPK = postresPK;
    }

    public Postres(PostresPK postresPK, String descripcion, double precio) {
        this.postresPK = postresPK;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public PostresPK getPostresPK() {
        return postresPK;
    }

    public void setPostresPK(PostresPK postresPK) {
        this.postresPK = postresPK;
    }

    public Integer getIdPostre() {
        return idPostre;
    }

    public void setIdPostre(Integer idPostre) {
        this.idPostre = idPostre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postresPK != null ? postresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postres)) {
            return false;
        }
        Postres other = (Postres) object;
        if ((this.postresPK == null && other.postresPK != null) || (this.postresPK != null && !this.postresPK.equals(other.postresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Postres[ postresPK=" + postresPK + " ]";
    }
    
}
