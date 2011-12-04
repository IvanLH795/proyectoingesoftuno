/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Familia MG
 */
public class ValidarLoginTest {
    private static ValidarLogin validar = new ValidarLogin();
    private String Long_Nombre_Incorrecto="Longitud de nombre incorrecta";
    private String Long_Contraseña_Incorrecto="Longitud de password incorrecta";
    private String Datos_Incorrectos="Datos incorrectos";
    private String Usuario_Autorizado="Bienvenido";

    public ValidarLoginTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    Sistema sistema=new Sistema();

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Usuario a = new Usuario();
    Usuario b = new Usuario();
    Usuario c = new Usuario();
    Usuario d = new Usuario();
    Usuario e = new Usuario();
    Usuario p = new Usuario();

    a.setNombre("vivibeltranb");
    a.setPassword("123456");
    a.setRoll("Rector");
    b.setNombre("darthian007");
    b.setPassword("123456");
    b.setRoll("Auxiliar");
    c.setNombre("freddyfofe");
    c.setPassword("123456");
    c.setRoll("Concejo");
    d.setNombre("daovallec");
    d.setPassword("123456");
    d.setRoll("Rector");
    e.setNombre("fmanrrique");
    e.setPassword("123456");
    e.setRoll("Auxiliar");
    p.setNombre("profesor");
    p.setPassword("123456");
    p.setRoll("Master");

    usuarios.add(a);
    usuarios.add(b);
    usuarios.add(c);
    usuarios.add(d);
    usuarios.add(e);
    usuarios.add(p);


    sistema.setUsuarios(usuarios);
    validar.setSistema(sistema);

    for (Usuario u : sistema.getUsuarios()){
        System.out.println(u.getNombre());
        System.out.println(u.getPassword());
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
    public void testVerificarLongitudNombre() {
        Usuario u = new Usuario();

        u.setNombre("r");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Long_Nombre_Incorrecto);

        u.setNombre("danielfernando");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Long_Nombre_Incorrecto);
    }

    /**
     * Test of verificarLongitudPassword method, of class ValidarLogin.
     */
    @Test
    public void testVerificarLongitudPassword() {
        Usuario u = new Usuario();

        u.setNombre("dfmanriqueg");
        u.setPassword("12");
        assertEquals(validar.verificarLogin(u),Long_Contraseña_Incorrecto);

        u.setNombre("dfmanriqueg");
        u.setPassword("123456789");
        assertEquals(validar.verificarLogin(u),Long_Contraseña_Incorrecto);
    }

    @Test
    public void testNombre(){
        Usuario u = new Usuario();

        u.setNombre("henry");
        u.setPassword("12345");
        assertEquals(validar.verificarLogin(u),Datos_Incorrectos);
        }

     @Test
    public void testContrasena(){
        Usuario u = new Usuario();

        u.setNombre("fmanrrique");
        u.setPassword("1234");
        assertEquals(validar.verificarLogin(u),Datos_Incorrectos);
        }

     @Test
     public void testDatos(){
        Usuario u = new Usuario();

        u.setNombre("henry");
        u.setPassword("1234");
        assertEquals(validar.verificarLogin(u),Datos_Incorrectos);
        }

     @Test
     public void testTodoCorrecto(){
        Usuario u = new Usuario();

        u.setNombre("vivibeltranb");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Usuario_Autorizado);


        u.setNombre("darthian007");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Usuario_Autorizado);


        u.setNombre("freddyfofe");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Usuario_Autorizado);

        u.setNombre("daovallec");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Usuario_Autorizado);

        u.setNombre("fmanrrique");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Usuario_Autorizado);

        u.setNombre("profesor");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Usuario_Autorizado);
        }
}