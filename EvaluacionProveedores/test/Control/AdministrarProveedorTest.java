/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import Entidad.Evaluaciones;
import Entidad.Proveedores;
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
        proveedor.setNombre("Mercaditos");
        proveedor.setNit(5);
        proveedor.setTelefono(5345644);
        Proveedores proveedor2;
        proveedor2 = control.buscarProveedor("mercados");

        assertEquals(control.modificarProveedor(proveedor2, proveedor), Exito);
    }
}