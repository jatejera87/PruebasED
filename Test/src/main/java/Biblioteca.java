import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    public Map<String, List<String>> prestamosPorUsuario;
    public Map<String, Integer> copiasPorLibro;

    public Biblioteca() {
        this.prestamosPorUsuario = new HashMap<>();
        this.copiasPorLibro = new HashMap<>();
    }

    public void prestarLibro(String usuario, String libro) {
        if (!this.copiasPorLibro.containsKey(libro)) {
            throw new IllegalArgumentException("El libro " + libro + " no está disponible.");
        }
        if (this.copiasPorLibro.get(libro) == 0) {
            throw new IllegalArgumentException("No hay copias disponibles del libro " + libro + ".");
        }
        if (!this.prestamosPorUsuario.containsKey(usuario)) {
            this.prestamosPorUsuario.put(usuario, new ArrayList<>());
        }
        this.prestamosPorUsuario.get(usuario).add(libro);
        this.copiasPorLibro.put(libro, this.copiasPorLibro.get(libro) - 1);
    }

    public void devolverLibro(String usuario, String libro) {
        if (!this.prestamosPorUsuario.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario " + usuario + " no ha prestado ningún libro.");
        }
        if (!this.prestamosPorUsuario.get(usuario).contains(libro)) {
            throw new IllegalArgumentException("El usuario " + usuario + " no ha prestado el libro " + libro + ".");
        }
        this.prestamosPorUsuario.get(usuario).remove(libro);
        this.copiasPorLibro.put(libro, this.copiasPorLibro.get(libro) + 1);
    }

    public void agregarLibro(String libro, int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de copias debe ser mayor o igual a cero.");
        }
        this.copiasPorLibro.put(libro, cantidad);
    }

    public int obtenerCopiasDisponibles(String libro) {
        if (!this.copiasPorLibro.containsKey(libro)) {
            throw new IllegalArgumentException("El libro " + libro + " no existe en la biblioteca.");
        }
        return this.copiasPorLibro.get(libro);
    }
}
