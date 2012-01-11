/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Darthian
 */
@Entity
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Usuario> usuarios;
    private List<Proveedores> proveedores;
    private List<Productos> productos;
    private List<ProductoProveedor> productosProveedor;
    private Float presupuestoT;
    private Float presupuestoD;
    private List<String> ListaContratos;

    public Sistema () {
        presupuestoT = new Float(0);
    }

    public List<String> getListaContratos() {
        return ListaContratos;
    }

    public void setListaContratos(List<String> ListaContratos) {
        this.ListaContratos = ListaContratos;
    }

    public Float getPresupuestoT() {
        return presupuestoT;
    }

    public void setPresupuestoT(Float presupuesto) {
        this.presupuestoT = presupuesto;
    }

    public Float getPresupuestoD() {
        return presupuestoD;
    }

    public void setPresupuestoD(Float presupuestoD) {
        this.presupuestoD = presupuestoD;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    public List<ProductoProveedor> getProductosProveedor() {
        return productosProveedor;
    }

    public void setProductosProveedor(List<ProductoProveedor> productosProveedor) {
        this.productosProveedor = productosProveedor;
    }

    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void agregarProducto(Productos producto){
        this.productos.add(producto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.SistemaDao[id=" + id + "]";
    }
}
