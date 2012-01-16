package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PresupuestoDisponible implements Serializable {
    @Id
    private Float presupuesto;
    private Float presupuestoDisponible;

    public PresupuestoDisponible(){
        this.presupuesto = new Float(0);
        this.presupuestoDisponible = new Float(0);
    }

    public Float getPresupuestoDisponible() {
        return presupuestoDisponible;
    }

    public void setPresupuestoDisponible(Float presupuestoDisponible) {
        this.presupuestoDisponible = presupuestoDisponible;
    }
    public Float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Float presupuesto) {
        this.presupuesto = presupuesto;
    }

}
