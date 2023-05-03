import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Before
    public void inicializar() {
        biblioteca = new Biblioteca();
        biblioteca.agregarLibro("El principito", 3);
        biblioteca.agregarLibro("Don Quijote de la Mancha", 2);
    }

    @Test
    public void testPrestarLibro() {
        biblioteca.prestarLibro("Juan", "El principito");
        biblioteca.prestarLibro("Juan", "Don Quijote de la Mancha");
        assertEquals(2, biblioteca.obtenerCopiasDisponibles("El principito"));
        assertEquals(1, biblioteca.obtenerCopiasDisponibles("Don Quijote de la Mancha"));
        assertEquals(Arrays.asList("El principito", "Don Quijote de la Mancha"), biblioteca.prestamosPorUsuario.get("Juan"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrestarLibroNoDisponible() {
        biblioteca.prestarLibro("Juan", "Cien años de soledad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrestarLibroSinCopias() {
        biblioteca.prestarLibro("Juan", "El principito");
        biblioteca.prestarLibro("Pedro", "El principito");
        biblioteca.prestarLibro("Ana", "El principito");
        biblioteca.prestarLibro("Juan", "El principito");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDevolverLibroNoPrestado() {
        biblioteca.devolverLibro("Juan", "El Señor de los Anillos");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDevolverLibroNoPerteneceAUsuario() {
        biblioteca.prestarLibro("Juan", "El principito");
        biblioteca.devolverLibro("Pedro", "El principito");
    }

    @Test
    public void testDevolverLibro() {
        biblioteca.prestarLibro("Juan", "El principito");
        biblioteca.prestarLibro("Juan", "Don Quijote de la Mancha");
        biblioteca.devolverLibro("Juan", "El principito");
        assertEquals(3, biblioteca.obtenerCopiasDisponibles("El principito"));
        assertEquals(1, biblioteca.obtenerCopiasDisponibles("Don Quijote de la Mancha"));
        assertEquals(Arrays.asList("Don Quijote de la Mancha"), biblioteca.prestamosPorUsuario.get("Juan"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarLibroCantidadNegativa() {
        biblioteca.agregarLibro("Cien años de soledad", -1);
    }

    @Test
    public void testAgregarLibro() {
        biblioteca.agregarLibro("Cien años de soledad", 1);
        assertEquals(1, biblioteca.obtenerCopiasDisponibles("Cien años de soledad"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testObtenerCopiasDisponiblesLibroInexistente() {
        biblioteca.obtenerCopiasDisponibles("El Señor de los Anillos");
    }
}
