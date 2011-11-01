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

/**
 *
 * @author Darthian
 */
public class ControlGestionarPresupuesto {
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
}
