

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DiscoDuroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DiscoDuroTest
{
    /**
     * Default constructor for test class DiscoDuroTest
     */
    public DiscoDuroTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void agregarSistemasCommit5()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 7, 2, 2019, true);
        assertEquals("1. Windows 10.0 con parche de seguridad de 2019-02-07 es estable\n", discoDur1.mostrarSistemas());
        discoDur1.agregarSistema("Ubuntu", 18.06, 1, 2, 2019, true);
        assertEquals("1. Windows 10.0 con parche de seguridad de 2019-02-07 es estable\n2. Ubuntu 18.06 con parche de seguridad de 2019-02-01 es estable\n", discoDur1.mostrarSistemas());
    }
    
    @Test
    public void retornarSistemasEnStringCommit6()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 7, 2, 2019, true);
        assertEquals("1. Windows 10.0 con parche de seguridad de 2019-02-07 es estable\n", discoDur1.mostrarSistemas());
        discoDur1.agregarSistema("Ubuntu", 18.06, 1, 2, 2019, true);
        assertEquals("1. Windows 10.0 con parche de seguridad de 2019-02-07 es estable\n2. Ubuntu 18.06 con parche de seguridad de 2019-02-01 es estable\n", discoDur1.mostrarSistemas());
    }

    @Test
    public void clasificacionSegunUnaCaracteristicaCommit7()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 1, 1, 2000, true);
        discoDur1.agregarSistema("Windows", 7, 1, 1, 2000, true);
        discoDur1.agregarSistema("Windows", 8.1, 1, 1, 2000, true);
        discoDur1.agregarSistema("Ubuntu", 18.06, 1, 1, 2000, true);
        assertEquals("Windows7.0\nWindows8.1\nWindows10.0\n", discoDur1.clasificacionPorVersion("Windows"));
        assertEquals("Ubuntu18.06\n", discoDur1.clasificacionPorVersion("Ubuntu"));
    }

    @Test
    public void clasificacionSegunUnaCaracteristicaYQueCumplanUnaCondicionCommit8()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 7, 2, 2019, true);
        discoDur1.agregarSistema("Windows", 8.1, 25, 12, 2019, true);
        discoDur1.agregarSistema("Windows", 7, 1, 1, 2020, false);
        discoDur1.agregarSistema("Ubuntu", 18.04, 2, 7, 2019, true);
        assertEquals("Windows 10.0 2019-02-07\nUbuntu 18.04 2019-07-02\nWindows 8.1 2019-12-25\n", discoDur1.clasificacionParcheDeSeguridadYEstables());
    }

    @Test
    public void modificarUnaCaracteristicaCommit9()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 1, 1, 2000, true);
        discoDur1.agregarSistema("Windows", 7, 1, 1, 2000, false);
        java.lang.String result = discoDur1.mostrarSistemas();
        assertEquals("1. Windows 10.0 con parche de seguridad de 2000-01-01 es estable\n2. Windows 7.0 con parche de seguridad de 2000-01-01 no es estable\n", discoDur1.mostrarSistemas());
        discoDur1.cambiarEstabilidad(2, true);
        assertEquals("1. Windows 10.0 con parche de seguridad de 2000-01-01 es estable\n2. Windows 7.0 con parche de seguridad de 2000-01-01 es estable\n", discoDur1.mostrarSistemas());
        discoDur1.cambiarEstabilidad(1, false);
        assertEquals("1. Windows 10.0 con parche de seguridad de 2000-01-01 no es estable\n2. Windows 7.0 con parche de seguridad de 2000-01-01 es estable\n", discoDur1.mostrarSistemas());
    }

    @Test
    public void eliminarObjetosQueCumplanUnaCondicionCommit10()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 1, 1, 2000, true);
        discoDur1.agregarSistema("Windows", 7, 1, 1, 2000, false);
        discoDur1.agregarSistema("Windows", 8.1, 1, 1, 2000, false);
        java.lang.String result = discoDur1.mostrarSistemas();
        assertEquals("1. Windows 10.0 con parche de seguridad de 2000-01-01 es estable\n2. Windows 7.0 con parche de seguridad de 2000-01-01 no es estable\n3. Windows 8.1 con parche de seguridad de 2000-01-01 no es estable\n", discoDur1.mostrarSistemas());
        discoDur1.borrarLosNoEstables();
        assertEquals("1. Windows 10.0 con parche de seguridad de 2000-01-01 es estable\n", discoDur1.mostrarSistemas());
    }

    @Test
    public void ordenarPorUnaCondicionCommit11()
    {
        DiscoDuro discoDur1 = new DiscoDuro();
        discoDur1.agregarSistema("Windows", 10, 7, 2, 2020, true);
        discoDur1.agregarSistema("Windows", 7, 31, 12, 2018, true);
        discoDur1.agregarSistema("Windows", 8.1, 1, 1, 2020, true);
        discoDur1.agregarSistema("Ubuntu", 18.04, 6, 2, 2020, true);
        assertEquals("Windows 7.0 2018-12-31\nWindows 8.1 2020-01-01\nWindows 10.0 2020-02-07\n", discoDur1.ordenarPorVersionYParcheDeSeguridadSiHayEmpate("Windows"));
    }
}






