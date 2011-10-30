/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Darthian
 */
public class Usuario {

    private String nombre;
    private String password;

    public Usuario(){

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
