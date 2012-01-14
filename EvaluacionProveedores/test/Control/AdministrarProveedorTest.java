/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import Entidad.Evaluaciones;
import Entidad.Proveedores;
import Entidad.Sistema;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Darthian
 */
public class AdministrarProveedorTest {
    private static ControlAdministrarProveedor control = new ControlAdministrarProveedor();
    private String Nit_Incorrecto = "Nit invalido";
    private String Telefono_Incorrecto = "Telefono invalido";
    private String Exito = "Succes";

    public AdministrarProveedorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sistema sistema = new Sistema();
        Proveedores proveedor = new Proveedores();

        Evaluaciones evaluacion = new Evaluaciones();

        proveedor.setNombre("Mercados La Primera");
        evaluacion.setCalidad((float)78);
        evaluacion.setAdaptabilidad("Buena");
        evaluacion.setCercania("buena");
        evaluacion.setComentarios(null);
        proveedor.setNit(1);
        evaluacion.setFiabilidad((float)98);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        java.util.Date date = new java.util.Date();
        String datetime = dateFormat.format(date);
        evaluacion.setFecha(datetime);
        proveedor.getEvaluaciones().add(evaluacion);
        proveedor.setCorreo("laprimera@colombia.com");
        proveedor.setDireccion("Cra 6 # 65 - 18");
        proveedor.setRepresentante("Henry Murillo");

        //ProveedoresJpaController ProveedorJpa = new ProveedoresJpaController();
        //ProveedorJpa.create(proveedor);

        Proveedores proveedor2 = new Proveedores();
        Evaluaciones evaluacion2 = new Evaluaciones();

        proveedor2.setNombre("Mercados La Segunda");
        evaluacion2.setCalidad((float)87);
        evaluacion2.setAdaptabilidad("Buena");
        evaluacion2.setCercania("buena");
        evaluacion2.setComentarios(null);
        proveedor2.setNit(2);
        evaluacion2.setFiabilidad((float)96);
        java.util.Date date2 = new java.util.Date();
        String datetimes = dateFormat.format(date2);
        evaluacion2.setFecha(datetimes);
        proveedor2.getEvaluaciones().add(evaluacion2);
        proveedor2.setCorreo("lasegunda@colombia.com");
        proveedor2.setDireccion("Cra 7 # 40 - 29");
        proveedor2.setRepresentante("Andres Malzahar");

        List<Proveedores> listaProveedor = new ArrayList<Proveedores>();
        listaProveedor.add(proveedor);
        listaProveedor.add(proveedor2);

        sistema.setProveedores(listaProveedor);
        Frontera.Splash.sistema = sistema;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void verificarCrearProveedorNit(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(-5);

        assertEquals(control.crearProveedor(proveedor), Nit_Incorrecto);
    }

    @Test
    public void verificarModificarProveedorNit(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(-5);
        Proveedores proveedor2 = new Proveedores();

        assertEquals(control.modificarProveedor(proveedor2, proveedor), Nit_Incorrecto);
    }

    @Test
    public void verificarCrearProveedorTel(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(5);
        proveedor.setTelefono(-5);

        assertEquals(control.crearProveedor(proveedor), Telefono_Incorrecto);
    }

    @Test
    public void verificarModificarProveedorTel(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(5);
        proveedor.setTelefono(-5);
        Proveedores proveedor2;
        proveedor2 = control.buscarProveedor("Mercados La Primera");

        assertEquals(control.modificarProveedor(proveedor2, proveedor), Telefono_Incorrecto);
    }

    @Test
    public void verificarCrearProveedorTelLongitud(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(5);
        proveedor.setTelefono(5);

        assertEquals(control.crearProveedor(proveedor), Telefono_Incorrecto);
    }

    @Test
    public void verificarModificarProveedorTelLongitud(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(5);
        proveedor.setTelefono(5);
        Proveedores proveedor2;
        proveedor2 = control.buscarProveedor("Mercados La Primera");

        assertEquals(control.modificarProveedor(proveedor2, proveedor), Telefono_Incorrecto);
    }

    @Test
    public void verificarCrearProveedorDatosCorrectos(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNombre("Mercaditos");
        proveedor.setNit(5);
        proveedor.setTelefono(5234544);

        assertEquals(control.crearProveedor(proveedor), Exito);
    }

    @Test
    public void verificarModificarProveedorDatosCorrectos(){
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(5);
        proveedor.setTelefono(5345644);
        Proveedores proveedor2;
        proveedor2 = control.buscarProveedor("Mercados La Primera");

        assertEquals(control.modificarProveedor(proveedor2, proveedor), Exito);
    }
}