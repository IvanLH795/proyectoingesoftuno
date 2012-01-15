/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioJpaController;
import Entidad.Usuario;
import Frontera.Splash;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();
    public static EntityManagerFactory emf;
    public static EntityManager em;

    public ValidarLoginTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("EvaluacionProveedoresPU", System.getProperties());
        em = emf.createEntityManager();
        Splash.em=em;
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
    public void testVerificarLongitudNombre() {
        Usuario u = new Usuario();

        u.setNombre("r");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Long_Nombre_Incorrecto);

        u.setNombre("danielfernando");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u),Long_Nombre_Incorrecto);
    }

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