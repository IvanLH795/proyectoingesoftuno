/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

/**
 *
 * @author Camilo
 */
public class Evaluaciones {
    float calidad;
    float fiabilidad;
    String cercania;
    String adaptabilidad;
    String comentarios;
    int dia;
    int mes;
    int anio;
    int hora;
    int min;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getAdaptabilidad() {
        return adaptabilidad;
    }

    public void setAdaptabilidad(String adaptabilidad) {
        this.adaptabilidad = adaptabilidad;
    }

    public float getCalidad() {
        return calidad;
    }

    public void setCalidad(float calidad) {
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

    public float getFiabilidad() {
        return fiabilidad;
    }

    public void setFiabilidad(float fiabilidad) {
        this.fiabilidad = fiabilidad;
    }
}
