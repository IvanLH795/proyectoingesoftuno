/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;


import java.text.SimpleDateFormat;
import java.text.DateFormat;
import Entidad.Evaluaciones;
import Entidad.ProductoProveedor;
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