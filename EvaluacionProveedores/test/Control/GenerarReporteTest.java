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
        area.setText("mercados");
        assertEquals(obj.imprimirPantallaReporte1(area), Fail);
    }
    @Test
    public void VerificarImprimirPantallaReporte2(){
        ControlGeneradorReporte obj = new ControlGeneradorReporte();
        JTextArea area = new JTextArea();
        area.setText("mercados");
        assertEquals(obj.imprimirPantallaReporte2(area, Exito), Fail);
    }
    @Test
    public void VerificarImprimirPantallaReporte3(){
        ControlGeneradorReporte obj = new ControlGeneradorReporte();
        Proveedores proveedor = new Proveedores();
        proveedor.setNit(-5);
        JTextArea area = new JTextArea();
        area.setText("mercados");
        assertEquals(obj.imprimirPantallaReporte3(area), Fail);
    }
}