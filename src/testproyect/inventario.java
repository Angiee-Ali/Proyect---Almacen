
package testproyect;
import java.util.ArrayList;

public class inventario {
    private ArrayList<Produc>listaProductos;
    
    public inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void registrarProducto(String codigo, String nombre, int stock) {
        // Validación: Revisar si el código ya existe
        if (buscarProducto(codigo) != null) {
            System.out.println("Error: El código " + codigo + " ya está registrado.");
            return;
        }
        Produc nuevo = new Produc(codigo, nombre, stock);
        listaProductos.add(nuevo);
        System.out.println("¡Producto registrado con éxito!");
    }

    public Produc buscarProducto(String codigo) {
        for (Produc p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null; // Si no lo encuentra
    }

    public void movimientoStock(String codigo, int cantidad, String tipoMovimiento) {
        Produc p = buscarProducto(codigo);
        if (p == null) {
            System.out.println("Error: Producto no encontrado.");
            return;
        }

        if (tipoMovimiento.equals("SALIDA") && p.getStock() < Math.abs(cantidad)) {
            System.out.println("Alerta: Stock insuficiente. Solo hay " + p.getStock() + " en existencias.");
            return;
        }

        p.actualizarStock(cantidad);
        System.out.println("Movimiento exitoso. Nuevo stock de " + p.getNombre() + ": " + p.getStock());
    }

    public void mostrarInventario() {
        System.out.println("\n--- ESTADO DEL INVENTARIO ---");
        for (Produc p : listaProductos) {
            System.out.println(p.toString());
        }
        System.out.println("-----------------------------");
    }
}