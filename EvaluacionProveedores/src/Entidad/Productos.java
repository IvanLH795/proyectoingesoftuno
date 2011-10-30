/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

/**
 *
 * @author Beltrán
 */
public class Productos {
private String nombreProducto;
private Float dineroDisponible;

    public Productos() {
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
