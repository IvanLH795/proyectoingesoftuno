package Entidad;

import java.util.ArrayList;

// <editor-fold defaultstate="collapsed" desc=" UML Marker ">
// #[regen=yes,id=DCE.D889AB50-0051-B99E-6C48-D11DE787C88F]
// </editor-fold>
public class Sistema {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.C747EF91-BE77-52FE-9A28-DB8377CC77A5]
    // </editor-fold>
    private Usuario mUsuario;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.6E0AC503-5DB5-9B9F-3FF5-A3C4F0CE04E5]
    // </editor-fold>
    private ArrayList<Usuario> Usuarios;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.6324B77D-CAF2-25C5-7EEF-888097E3D3A4]
    // </editor-fold>
    public Sistema () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.3646BEB9-A899-B18B-DED6-87A4D3711F4B]
    // </editor-fold>
    public ArrayList<Usuario> getUsuarios () {
        return Usuarios;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.8DB65F74-088E-CDFA-1EBF-299B6266DBFC]
    // </editor-fold>
    public void setUsuarios (ArrayList<Usuario> val) {
        this.Usuarios = val;
    }

}