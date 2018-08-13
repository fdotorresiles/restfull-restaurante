/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisfernandotorressiles
 */
@Entity
@Table(name = "bebidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bebidas.findAll", query = "SELECT b FROM Bebidas b")
    , @NamedQuery(name = "Bebidas.findByIdBebida", query = "SELECT b FROM Bebidas b WHERE b.idBebida = :idBebida")
    , @NamedQuery(name = "Bebidas.findByDescripcion", query = "SELECT b FROM Bebidas b WHERE b.descripcion = :descripcion")
    , @NamedQuery(name = "Bebidas.findByPrecio", query = "SELECT b FROM Bebidas b WHERE b.precio = :precio")})
public class Bebidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BebidasPK bebidasPK;
    @Column(name = "idBebida")
    private Integer idBebida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000000000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;

    public Bebidas() {
    }

    public Bebidas(BebidasPK bebidasPK) {
        this.bebidasPK = bebidasPK;
    }

    public Bebidas(BebidasPK bebidasPK, String descripcion, double precio) {
        this.bebidasPK = bebidasPK;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public BebidasPK getBebidasPK() {
        return bebidasPK;
    }

    public void setBebidasPK(BebidasPK bebidasPK) {
        this.bebidasPK = bebidasPK;
    }

    public Integer getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Integer idBebida) {
        this.idBebida = idBebida;
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
        hash += (bebidasPK != null ? bebidasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bebidas)) {
            return false;
        }
        Bebidas other = (Bebidas) object;
        if ((this.bebidasPK == null && other.bebidasPK != null) || (this.bebidasPK != null && !this.bebidasPK.equals(other.bebidasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bebidas[ bebidasPK=" + bebidasPK + " ]";
    }
    
}
