/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

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
    String calidad;
    String fiabilidad;
    String cercania;
    String adaptabilidad;
    String comentarios;

    public String getAdaptabilidad() {
        return adaptabilidad;
    }

    public void setAdaptabilidad(String adaptabilidad) {
        this.adaptabilidad = adaptabilidad;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
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

    public String getFiabilidad() {
        return fiabilidad;
    }

    public void setFiabilidad(String fiabilidad) {
        this.fiabilidad = fiabilidad;
    }
    List<ProductoProveedor> productos = new ArrayList<ProductoProveedor>();

    public List<ProductoProveedor> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoProveedor> productos) {
        this.productos = productos;
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
