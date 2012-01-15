package Entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Productos implements Serializable {
    @Id
    private String nombreProducto;
    private Float dineroDisponible;
    @OneToMany(mappedBy="producto")
    private List<Contratos> contratos = new ArrayList<Contratos>();

    public List<Contratos> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contratos> contratos) {
        this.contratos = contratos;
    }

    public Float getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(Float dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}