
package testproyect;
import java.util.ArrayList;

public class inventario {
    
    private ArrayList<Empleado>listaEmpleados;
    private ArrayList<Distribuidor>listaDistribuidores;
    private ArrayList<Produc>listaProductos;
    
    public inventario() {
        
        this.listaEmpleados = new ArrayList<>();
        this.listaDistribuidores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }
    public void registrarEmpleado(String nombre, String dni) {
        listaEmpleados.add(new Empleado(nombre, dni));
        System.out.println("Registro de Empleado realizado con éxito");
    }
    public void registrarDistribuidor(String RUC, String nombre) {
        listaDistribuidores.add(new Distribuidor(RUC, nombre));
        System.out.println("Registro de Distribuidor realizado con éxito");
    }

    public void registrarProducto(String codigo, String nombre, int stock) {
        // Validación: Revisar si el código ya existe
        if (buscarProducto(codigo) != null) {
            System.out.println("Error: El código " + codigo + " ya está registrado.");
            return;
        }
        listaProductos.add(new Produc(codigo, nombre, stock));
        System.out.println("Registro de Producto realizado con éxito");
    }

    
    public Empleado buscarEmpleado(String dni) {
        for (Empleado e : listaEmpleados) {
            if (e.getDni().equals(dni)) return e;
        }
        return null;
    }
    public Distribuidor buscarDistribuidor(String RUC) {
        for (Distribuidor d : listaDistribuidores) {
            if (d.getRUC().equals(RUC)) return d;
        }
        return null;
    }
    public Produc buscarProducto(String codigo) {
        for (Produc p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
   public void registrarEntrada(String codProducto, int cantidad, String dniEmpleado, String RUCDistribuidor){
    Produc p = buscarProducto(codProducto);
    Empleado e = buscarEmpleado(dniEmpleado);
    Distribuidor d = buscarDistribuidor(RUCDistribuidor);
    
    if (p == null) {
        System.out.println("Error: Verificar, Producto no encontrado.");
        return;
    }
    if (e == null) {
        System.out.println("Error: Verificar, Empleado no encontrado.");
        return;
    }
    if (d == null) {
        System.out.println("Error: Verificar, Distribuidor no encontrado.");
        return;
    }
    p.actualizarStock(cantidad);
        System.out.println("\n--Comprobante de entrada--");
        System.out.println("Registrado por: " + e.toString());
        System.out.println("Entregado por : " + d.toString());
        System.out.println("Producto: " + p.toString());
        System.out.println("Nuevo Stock - Cantidad ingresada: " + p.getStock());
    }

    

    public void registrarSalida(String codProducto, int cantidad, String dniEmpleado){
        Produc p = buscarProducto(codProducto);
        Empleado e = buscarEmpleado(dniEmpleado);
        
        if (p == null) {
            System.out.println("Error: Verificar, Producto no encontrado.");
            return;
        }
        if (e == null) {
            System.out.println("Error: Verificar, Empleado no encontrado.");
            return;
        }
        if (p.getStock() < cantidad) {
            System.out.println("Error: Stock insuficiente para realizar la salida.");
            return;
        
        }
        p.actualizarStock(-cantidad);
        System.out.println("\n--Comprobante de salida--");
        System.out.println("Despacho por: " + e.toString());   
        System.out.println("Producto: " + p.getNombre());
        System.out.println("Nuevo Stock " + p.getStock());
        
    }

    public void mostrarInventario() {
        System.out.println("\n--- ESTADO DEL INVENTARIO ---");
        for (Produc p : listaProductos) {
            System.out.println(p.toString());
        }
        System.out.println("-----------------------------");
    }
}
