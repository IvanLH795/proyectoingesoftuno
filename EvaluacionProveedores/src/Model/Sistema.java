/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

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

    public List<Productos> getProducto() {
        return productos;
    }

    public void setProducto(List<Productos> producto) {
        this.productos = producto;
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
}




