/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;


// <editor-fold defaultstate="collapsed" desc=" UML Marker ">
// #[regen=yes,id=DCE.945FD1E1-929A-6466-62F3-288AA03F765C]
// </editor-fold>
public class Usuario {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.9217C970-A2BB-947B-5467-2159AFEF932E]
    // </editor-fold>
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.66EEAEFE-57FD-C5FC-2781-21BE46090937]
    // </editor-fold>
    private String password;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.297507C4-7242-389F-2063-C40F2F90E3D3]
    // </editor-fold>
    public Usuario () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.C1FBEE5F-A285-E6F4-58D1-0E053027BF41]
    // </editor-fold>
    public String getNombre () {
        return nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.86DFC99C-4072-363B-06F4-8E23D15ED6BF]
    // </editor-fold>
    public void setNombre (String val) {
        this.nombre = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.B3C7B26E-AC9E-6A07-134E-C21A104C9357]
    // </editor-fold>
    public String getPassword () {
        return password;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.11EF1599-884E-1225-B382-9A2D9279A54F]
    // </editor-fold>
    public void setPassword (String val) {
        this.password = val;
    }

}
