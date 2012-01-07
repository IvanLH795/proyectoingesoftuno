/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Darthian
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
