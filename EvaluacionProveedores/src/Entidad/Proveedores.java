package Entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proveedores implements Serializable {
    @Id
    int nit;
    @Column(nullable = false)
    String nombre;
    String representante;
    String direccion;
    @Column(nullable = false)
    int telefono;
    String correo;
    String paginaWeb;
    boolean evaluacionRealizada;
    @OneToMany(mappedBy="proveedor")
    List<Evaluaciones> evaluaciones = new ArrayList<Evaluaciones>();
    @OneToMany(mappedBy="proveedor")
    List<ProductoProveedor> productos = new ArrayList<ProductoProveedor>();
    @OneToMany(mappedBy="proveedor")
    List<Contratos> contratos = new ArrayList<Contratos>();

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEvaluacionRealizada() {
        return evaluacionRealizada;
    }

    public void setEvaluacionRealizada(boolean evaluacionRealizada) {
        this.evaluacionRealizada = evaluacionRealizada;
    }

    public List<Evaluaciones> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluaciones> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public List<ProductoProveedor> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoProveedor> productos) {
        this.productos = productos;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
