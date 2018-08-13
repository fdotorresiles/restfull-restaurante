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
@Table(name = "saloneros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saloneros.findAll", query = "SELECT s FROM Saloneros s")
    , @NamedQuery(name = "Saloneros.findByIdSalonero", query = "SELECT s FROM Saloneros s WHERE s.idSalonero = :idSalonero")
    , @NamedQuery(name = "Saloneros.findByNombre", query = "SELECT s FROM Saloneros s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Saloneros.findByApellidos", query = "SELECT s FROM Saloneros s WHERE s.apellidos = :apellidos")})
public class Saloneros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalonerosPK salonerosPK;
    @Column(name = "idSalonero")
    private Integer idSalonero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000000000)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000000000)
    @Column(name = "apellidos")
    private String apellidos;

    public Saloneros() {
    }

    public Saloneros(SalonerosPK salonerosPK) {
        this.salonerosPK = salonerosPK;
    }

    public Saloneros(SalonerosPK salonerosPK, String nombre, String apellidos) {
        this.salonerosPK = salonerosPK;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public SalonerosPK getSalonerosPK() {
        return salonerosPK;
    }

    public void setSalonerosPK(SalonerosPK salonerosPK) {
        this.salonerosPK = salonerosPK;
    }

    public Integer getIdSalonero() {
        return idSalonero;
    }

    public void setIdSalonero(Integer idSalonero) {
        this.idSalonero = idSalonero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salonerosPK != null ? salonerosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saloneros)) {
            return false;
        }
        Saloneros other = (Saloneros) object;
        if ((this.salonerosPK == null && other.salonerosPK != null) || (this.salonerosPK != null && !this.salonerosPK.equals(other.salonerosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Saloneros[ salonerosPK=" + salonerosPK + " ]";
    }
    
}
