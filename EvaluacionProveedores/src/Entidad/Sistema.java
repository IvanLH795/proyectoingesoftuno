/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

/**
 *
 * @author Darthian
 */
import java.util.List;

public class Sistema {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.08D9144D-9239-8F3F-D57C-05EFE1C62978]
    // </editor-fold>
    private List<Usuario> usuarios;
    private List<Proveedores> proveedores;
    private List<Productos> productos;
    private List<ProductoProveedor> productosProveedor;
    private Float presupuesto;
    private Float presupuestoD;

    public Float getPresupuestoT() {
        return presupuesto;
    }

    public void setPresupuestoT(Float presupuesto) {
        this.presupuesto = presupuesto;
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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.1B36C9B1-1E42-26F9-165F-B956DDF5ADB1]
    // </editor-fold>
    public Sistema () {
        presupuesto = new Float(0);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.AE80FCF3-50DB-FE81-8F1B-810A47594B57]
    // </editor-fold>
    public List<Usuario> getUsuarios () {
        return usuarios;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.6568C11F-F840-E3CB-37AE-4FC73DF4BD33]
    // </editor-fold>
    public void setUsuarios (List<Usuario> val) {
        this.usuarios = val;
    }

    public void agregarProducto(Productos producto){
        this.productos.add(producto);
    }

    /**
     * @return the presupuestoD
     */
    public Float getPresupuestoD() {
        return presupuestoD;
    }

    /**
     * @param presupuestoD the presupuestoD to set
     */
    public void setPresupuestoD(Float presupuestoD) {
        this.presupuestoD = presupuestoD;
    }
}




