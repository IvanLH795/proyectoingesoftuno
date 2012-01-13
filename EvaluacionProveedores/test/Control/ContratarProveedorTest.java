/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.ProductoProveedor;
import Entidad.Proveedores;
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
public class ContratarProveedorTest {

    private String ContratoNogenerado = "Error al generar el contrato";
    private String ProveedorNoEncontrado = "El proveedor no se encuentra en la lista";
    public ContratarProveedorTest() {
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
    @Test
    public void verificarContratarProveedor(){
        Proveedores proveedor = new Proveedores();
        ProductoProveedor producto = new ProductoProveedor();
        int cantidad = 20;
        ControlContratarProveedor contrato1 = new ControlContratarProveedor(proveedor,cantidad,producto);
        assertEquals(contrato1.generarContrato(), ContratoNogenerado);
        cantidad = -20;
        ControlContratarProveedor contrato2 = new ControlContratarProveedor(proveedor,cantidad,producto);
        assertEquals(contrato2.generarContrato(), ContratoNogenerado);
        cantidad = 0;
        ControlContratarProveedor contrato3 = new ControlContratarProveedor(proveedor,cantidad,producto);
        assertEquals(contrato3.generarContrato(), ContratoNogenerado);
    }

    @Test
    public void BuscarProveedor(){
        Proveedores proveedor = new Proveedores();
        ProductoProveedor producto = new ProductoProveedor();
        int cantidad = 20;
        ControlContratarProveedor contrato1 = new ControlContratarProveedor(proveedor,cantidad,producto);
        assertEquals(contrato1.buscaProveedor(1, proveedor), ProveedorNoEncontrado);
    }
}