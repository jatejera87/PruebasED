import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromoTest {

    @Test
    public void pruebaPalindromo() {
        assertTrue(esPalindromo("anilina"));
        assertTrue(esPalindromo("ama"));
        assertFalse(esPalindromo("hola"));
        assertFalse(esPalindromo("programacion"));
    }

    private boolean esPalindromo(String palabra) {
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
