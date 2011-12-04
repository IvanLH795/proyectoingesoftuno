/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entidad.Proveedores;
import Entidad.Sistema;
import java.util.ArrayList;
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
    private static ControlEvaluadorProveedor validar = new ControlEvaluadorProveedor();
    private String Datos_Incorrectos = "Datos Incorrectos";
    private String ProveedorNo_Encontrado = "Proveedor No Encontrado";
    private String Proveedor_Encontrado = "Proveedor Encontrado";
    private String Datos_Correctos = "Datos Correctos";
    

    public EvaluadorProveedorTest() {
    }

     @BeforeClass
    public static void setUpClass() throws Exception {
    Sistema sistema= new Sistema();

    ArrayList<Proveedores> ProveedorP = new ArrayList<Proveedores>();
    Proveedores a = new Proveedores();
    Proveedores b = new Proveedores();
    Proveedores c = new Proveedores();
   

    a.setNombre("Proveedor1");
    a.setNit(1);
    b.setNombre("Proveedor2");
    b.setNit(2);
    c.setNombre("Proveedor3");
    c.setNit(3);

    ProveedorP.add(a);
    ProveedorP.add(b);
    ProveedorP.add(c);

    sistema.setProveedores(ProveedorP);
   validar.setSistem(sistema);
   for (Proveedores u : sistema.getProveedores()){
        System.out.println(u.getNombre());
        System.out.println(u.getNit());
        System.out.println("--------------");
    }
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

    /**
     * Test of verificarLongitudNombre method, of class ValidarLogin.
     */
    @Test
    public void testVerificarProveedor(){
        int Nit = 5 ;
        assertEquals(validar.buscar(Nit),ProveedorNo_Encontrado);
    }

    @Test
    public void testVerificarDatos() {
        double dato1,dato2;
        String dato3;
        dato1 = -5;
        dato2 = 0;
        dato3 = "0";
        
        assertEquals(validar.validar(dato1, dato2,dato3),Datos_Incorrectos);

        dato1 = 0;
        dato2 = -5;
        dato3 = "0";

        assertEquals(validar.validar(dato1, dato2,dato3),Datos_Incorrectos);
        dato1 = -1;
        dato2 = 0;
        dato3 = "";

        assertEquals(validar.validar(dato1, dato2,dato3),Datos_Incorrectos);
    }

   
     @Test
     public void testTodoCorrecto(){
         double dato1,dato2;
         String dato3;
         int Nit = 1 ;
        assertEquals(validar.buscar(Nit),Proveedor_Encontrado);
         Nit = 2 ;
        assertEquals(validar.buscar(Nit),Proveedor_Encontrado);
        Nit = 3;
        assertEquals(validar.buscar(Nit),Proveedor_Encontrado);
        dato1 = 5;
        dato2 = 0;
        dato3 = "0";
        assertEquals(validar.validar(dato1, dato2,dato3),Datos_Correctos);

        }
}