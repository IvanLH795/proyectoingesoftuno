/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Productos;
import Entidad.Sistema;
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
public class GestionarPresupuestoTest {
    private static ControlGestionarPresupuesto validar = new ControlGestionarPresupuesto();
    private String Long_Nombre_Incorrecto="Longitud de nombre incorrecta";
    private String Long_Precio_Incorrecto="Precio incorrecto";
    private String Producto_Correcto="Correcto";

    public GestionarPresupuestoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Sistema sistema=new Sistema();
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
    public void testVerificarLongitudNombre() {
        Productos u = new Productos();

        u.setNombreProducto("mar");
        u.setDineroDisponible(new Float(200));
        assertEquals(validar.verificarProducto(u),Long_Nombre_Incorrecto);

        u.setNombreProducto("supermarcadores");
        u.setDineroDisponible(new Float(200));
        assertEquals(validar.verificarProducto(u),Long_Nombre_Incorrecto);
    }

    /**
     * Test of verificarLongitudPassword method, of class ValidarLogin.
     */
    @Test
    public void testVerificarLongitudPrecio() {
        Productos u = new Productos();

        u.setNombreProducto("marcadores");
        u.setDineroDisponible(new Float(-2));
        assertEquals(validar.verificarProducto(u),Long_Precio_Incorrecto);

        u.setNombreProducto("marcadores");
        u.setDineroDisponible(new Float(11000000));
        assertEquals(validar.verificarProducto(u),Long_Precio_Incorrecto);
    }

     @Test
     public void testTodoCorrecto(){
        Productos u = new Productos();

        u.setNombreProducto("marcadores");
        u.setDineroDisponible(new Float(2500));
        assertEquals(validar.verificarProducto(u),Producto_Correcto);

        u.setNombreProducto("borradores");
        u.setDineroDisponible(new Float(3000));
        assertEquals(validar.verificarProducto(u),Producto_Correcto);
     }


}