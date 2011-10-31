/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

/**
 *
 * @author Darthian
 */
public class Usuario {

    private String nombre;
    private String password;
    private String roll;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String val){
        nombre = val;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String val){
        password = val;
    }
}
