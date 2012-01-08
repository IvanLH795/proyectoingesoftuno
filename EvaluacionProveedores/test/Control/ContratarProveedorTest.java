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

    private static ControlContratarProveedor validarContrato = new ControlContratarProveedor();
    private String ContratoNogenerado = "Error al generar el contrato";
    private String PedidoInvalido = "Pedido Invalido";
    private String Succes = "Succes";
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
        ControlContratarProveedor contrato = new ControlContratarProveedor(proveedor,cantidad,producto);       
        assertEquals(contrato.generarContrato(), ContratoNogenerado);
        cantidad = -20;
        ControlContratarProveedor contrato1 = new ControlContratarProveedor(proveedor,cantidad,producto);
        assertEquals(contrato1.generarContrato(), ContratoNogenerado);
        cantidad = 0;
        ControlContratarProveedor contrato2 = new ControlContratarProveedor(proveedor,cantidad,producto);
        assertEquals(contrato2.generarContrato(), ContratoNogenerado);
    }

}