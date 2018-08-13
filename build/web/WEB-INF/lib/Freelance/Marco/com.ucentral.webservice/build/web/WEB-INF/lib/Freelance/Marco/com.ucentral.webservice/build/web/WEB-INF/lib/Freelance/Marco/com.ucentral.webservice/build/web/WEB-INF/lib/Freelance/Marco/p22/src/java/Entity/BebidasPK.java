/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author luisfernandotorressiles
 */
@Embeddable
public class BebidasPK implements Serializable {

    public BebidasPK() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BebidasPK)) {
            return false;
        }
        BebidasPK other = (BebidasPK) object;
        return true;
    }

    @Override
    public String toString() {
        return ("");
    }
    
}
