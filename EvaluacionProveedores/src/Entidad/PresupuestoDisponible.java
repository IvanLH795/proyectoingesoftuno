/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PresupuestoDisponible implements Serializable {
    @Id
    private Float presupuesto;

    public PresupuestoDisponible(){
        this.presupuesto = new Float(0);
    }
    public Float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Float presupuesto) {
        this.presupuesto = presupuesto;
    }

}
