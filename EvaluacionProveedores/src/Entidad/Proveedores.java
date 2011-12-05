/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Darthian
 */
public class Proveedores {
    String nombre;
    int nit;
    String representante;
    String direccion;
    int telefono;
    String correo;
    String paginaWeb;
    boolean evaluacionRealizada;
    List<Evaluaciones> evaluaciones = new ArrayList<Evaluaciones>();
    List<ProductoProveedor> productos = new ArrayList<ProductoProveedor>();

    public List<Evaluaciones> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluaciones> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Proveedores() {
        evaluacionRealizada = false;
        telefono = 0;
    }

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

    public boolean isEvaluacionRealizada() {
        return evaluacionRealizada;
    }

    public void setEvaluacionRealizada(boolean evaluacionRealizada) {
        this.evaluacionRealizada = evaluacionRealizada;
    }
}