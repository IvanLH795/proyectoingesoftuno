/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Productos;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import Entidad.Sistema;

/**
 *
 * @author Darthian
 */
public class ControlGestionarPresupuesto {

    private Sistema sistema = new Sistema();

        /**
     * @return the sistema
     */
    public Sistema getSistema() {
        return sistema;
    }

    /**
     * @param sistema the sistema to set
     */
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }


    public void modificarProductos(Vector listaVector){
        if(!(listaVector == null)){
            List<Productos> lista = new ArrayList();
            for(int i=0; i<listaVector.size();i++){
                Productos producto = new Productos();
                producto.setNombreProducto((String)((Vector) listaVector.get(i)).get(0));
                producto.setDineroDisponible((Float)((Vector)listaVector.get(i)).get(1));
                if(!producto.getNombreProducto().equals(null))
                        lista.add(producto);
            }
        }
    }

    public String verificarProducto (Productos producto) {
        if (!verificarLongitudPrecio(producto.getNombreProducto())){
            return ("Longitud de nombre incorrecta");}

        if (!verificarLongitudPrecio(producto.getDineroDisponible()))
            return ("Precio incorrecto");

        return("Correcto");
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.C3D0DA41-6C85-B034-CD6F-281FB8395B50]
    // </editor-fold>
    public boolean verificarLongitudPrecio (String producto) {
        return(producto.length() > 3 && producto.length()<=12);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.2428B11A-C5F0-9E85-4B8B-3A2CB01CA09B]
    // </editor-fold>
    public boolean verificarLongitudPrecio (float precio) {
        return(precio >= 0 && precio<10000000);
    }



}
