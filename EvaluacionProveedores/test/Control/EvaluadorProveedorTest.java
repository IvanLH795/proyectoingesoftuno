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
public class EvaluadorProveedorTest {

    private static ControlEvaluadorProveedor control = new ControlEvaluadorProveedor();
    private String No_Encontrado = "Proveedor no encontrado";
    private String Encontrado = "Proveedor encontrado";
    private String Exito = "Succes";
    private String Fallo_Comentarios = "Error Comentarios";
    private String Fallo_Fiabilidad = "Error Fiabilidad";
    private String Fallo_Calidad = "Error Calidad";

   @BeforeClass
   public static void setUpClass() {
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
    public void verificarBuscarProveedorNoEncontrado(){
        assertEquals(control.compararProveedor(0), No_Encontrado);
    }

    @Test
    public void verificarBuscarProveedorEncontrado(){
        assertEquals(control.compararProveedor(1), Encontrado);
    }

    @Test
    public void verificarValidarDatosFalloCalidad(){
        assertEquals(control.validarDatos("-1", "2", "Alta", "Bueno"), Fallo_Calidad);
    }

    @Test
    public void verificarValidarDatosFalloFiabilidad(){
        assertEquals(control.validarDatos("1", "-2", "Alta", "Bueno"), Fallo_Fiabilidad);
    }
    @Test
    public void verificarValidarDatosExito(){
        assertEquals(control.validarDatos("1", "2", "Alta", "Bueno"), Exito);
    }
}