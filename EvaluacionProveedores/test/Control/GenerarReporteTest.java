/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import Entidad.Evaluaciones;
import Entidad.Proveedores;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
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
public class GenerarReporteTest {

    private String Exito = "Succes";
    private String Fail = "Fail";
    public GenerarReporteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
    @Test
    public void VerificarImprimirReporte() throws IOException{
        ControlGeneradorReporte obj = new ControlGeneradorReporte();
        Proveedores proveedor = new Proveedores();
        File fichero = File.createTempFile(Fail, Exito);
        proveedor.setNit(-5);
        assertEquals(obj.imprimirReporte(fichero, Exito), Fail);
    }
    @Test
    public void VerificarImprimirPantallaReporte1(){
        ControlGeneradorReporte obj = new ControlGeneradorReporte();
        JTextArea area = new JTextArea();
        area.setText("Mercaditos");
        assertEquals(obj.imprimirPantallaReporte1(area), Fail);
    }
    @Test
    public void VerificarImprimirPantallaReporte2(){
        ControlGeneradorReporte obj = new ControlGeneradorReporte();
        JTextArea area = new JTextArea();
        area.setText("Mercaditos");
        assertEquals(obj.imprimirPantallaReporte2(area, Exito), Fail);
    }
    @Test
    public void VerificarImprimirPantallaReporte3(){
        ControlGeneradorReporte obj = new ControlGeneradorReporte();
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(-5);
        JTextArea area = new JTextArea();
        area.setText("Mercaditos");
        assertEquals(obj.imprimirPantallaReporte3(area), Fail);
    }
}