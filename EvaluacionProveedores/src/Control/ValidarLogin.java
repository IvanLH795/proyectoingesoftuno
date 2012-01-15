package Control;

import DAO.UsuarioJpaController;
import Entidad.Usuario;
import Frontera.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ValidarLogin {
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();
    public static EntityManagerFactory emf;
    public static EntityManager em;
    public ValidarLogin () {
        emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU", System.getProperties());
        em = emf.createEntityManager();
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