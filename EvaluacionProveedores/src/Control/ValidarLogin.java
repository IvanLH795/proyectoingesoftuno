package Control;

import DAO.UsuarioJpaController;
import Entidad.Usuario;
import Frontera.Login;
import Frontera.Splash;
import javax.persistence.EntityManager;

public class ValidarLogin {
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();
    EntityManager em;
    public ValidarLogin () {
        em = Splash.em;
    }

    public String verificarLogin (Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getNombre())){
            return ("Longitud de nombre incorrecta");}

        if (!verificarLongitudPassword(usuario.getPassword()))
            return ("Longitud de password incorrecta");

        for(Usuario u: jpaUsuario.getUsuarios(em)){
            if(u.getNombre().equals(usuario.getNombre()) && u.getPassword().equals(usuario.getPassword())){
                Login.roll = u.getRoll();
                return("Bienvenido");
            }
        }
        return("Datos incorrectos");
    }
    public boolean verificarLongitudNombre (String nombre) {
        return(nombre.length() > 1 && nombre.length() <= 12);
    }

    public boolean verificarLongitudPassword (String password) {
        return(password.length() >= 3 && password.length()<8);
    }
}