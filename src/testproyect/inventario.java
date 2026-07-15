
package sistema.de.registro;
import java.util.ArrayList;

public class inventario {
    private ArrayList<empleado>listaEmpleados;
    private ArrayList<Distribuidor>listaDistribuidores;
    private ArrayList<Producto>listaProductos;
    
    public inventario() {
        
        this.listaEmpleados = new ArrayList<>();
        this.listaDistribuidores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }
    public void registrarEmpleado(String nombre, String dni) {
        listaEmpleados.add(new empleado(nombre, dni));
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
        listaProductos.add(new Producto(codigo, nombre, stock));
        System.out.println("Registro de Producto realizado con éxito");
    }

    
    public empleado buscarEmpleado(String dni) {
        for (empleado e : listaEmpleados) {
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
    public Producto buscarProducto(String codigo) {
        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
   public void registrarEntrada(String codProducto, int cantidad, String dniEmpleado, String RUCDistribuidor){
    Producto p = buscarProducto(codProducto);
    empleado e = buscarEmpleado(dniEmpleado);
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
        Producto p = buscarProducto(codProducto);
        empleado e = buscarEmpleado(dniEmpleado);
        
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
     System.out.println("\n--------REPORTE DEL SISTEMA---------");

        System.out.println("\n--- 1. INVENTARIO ---");
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : listaProductos) {
                System.out.println(p.toString());
            }
        }

        System.out.println("\n--- 2. PERSONAL REGISTRADO ---");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (empleado e : listaEmpleados) {
                System.out.println(e.toString());
            }
        }

        System.out.println("\n--- 3. DISTRIBUIDORES ASOCIADOS ---");
        if (listaDistribuidores.isEmpty()) {
            System.out.println("No hay distribuidores registrados.");
        } else {
            for (Distribuidor d : listaDistribuidores) {
                System.out.println(d.toString());
            }
        }
    }
}    
     
