package Control;


import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.Login;
import Frontera.Splash;

// <editor-fold defaultstate="collapsed" desc=" UML Marker ">
// #[regen=yes,id=DCE.75B6C54F-9E71-718D-4919-1B99E3957F82]
// </editor-fold>
public class ValidarLogin {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.5118F757-8C9A-1A8A-F4F4-FB3ACEA7482A]
    // </editor-fold>
    //private Sistema sistema = new Sistema();
    private Sistema sistema = Splash.sistema;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.5816F43B-264E-A14E-7956-769C10BE049F]
    // </editor-fold>
    public ValidarLogin () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.D3C74F9F-BE39-C9DB-4A70-32C074701FBB]
    // </editor-fold>
    public Sistema getSistema () {
        return sistema;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.85067A55-AE8F-D6E6-92E3-C98DF740119C]
    // </editor-fold>
    public void setSistema (Sistema val) {
        this.sistema = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.D5100373-996B-BE46-06AC-DA0AED5644C4]
    // </editor-fold>
    public String verificarLogin (Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getNombre())){
            return ("Longitud de nombre incorrecta");}

        if (!verificarLongitudPassword(usuario.getPassword()))
            return ("Longitud de password incorrecta");

        for(Usuario u: getSistema().getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre()) && u.getPassword().equals(usuario.getPassword())){
                Login.roll = u.getRoll();
                return("Bienvenido");
            }
        }
    return("Datos incorrectos");
}

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.C3D0DA41-6C85-B034-CD6F-281FB8395B50]
    // </editor-fold>
    public boolean verificarLongitudNombre (String nombre) {
        return(nombre.length() > 1 && nombre.length()<=12);

    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.2428B11A-C5F0-9E85-4B8B-3A2CB01CA09B]
    // </editor-fold>
    public boolean verificarLongitudPassword (String password) {
        return(password.length() >= 3 && password.length()<8);
    }

}