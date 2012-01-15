package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evaluaciones implements Serializable {
    @Id
    @Column(name = "fecha")
    private String fecha;
    float calidad;
    float fiabilidad;
    String cercania;
    String adaptabilidad;
    String comentarios;
    @ManyToOne
    private Proveedores proveedor;

    public String getAdaptabilidad() {
        return adaptabilidad;
    }

    public void setAdaptabilidad(String adaptabilidad) {
        this.adaptabilidad = adaptabilidad;
    }

    public float getCalidad() {
        return calidad;
    }

    public void setCalidad(float calidad) {
        this.calidad = calidad;
    }

    public String getCercania() {
        return cercania;
    }

    public void setCercania(String cercania) {
        this.cercania = cercania;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getFiabilidad() {
        return fiabilidad;
    }

    public void setFiabilidad(float fiabilidad) {
        this.fiabilidad = fiabilidad;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }
}
