
package testproyect;
import java.util.Scanner;

public class test01 {


    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        inventario gestor = new inventario();
        boolean salir = false;

        System.out.println("=== SISTEMA DE REGISTRO DE MERCADERÍA ===");

        while (!salir) {
            System.out.println("\n1. Registrar nuevo producto");
            System.out.println("2. Registrar entrada de distribuidor");
            System.out.println("3. Registrar nuevo producto de mercadería");
            System.out.println("4. Entrada de mercadería (Sumar stock)");
            System.out.println("5. Salida de mercadería (Restar stock)");
            System.out.println("6. Ver inventario completo");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("DNI del empleado: ");
                    String dniEmpleado = scanner.nextLine();
                    System.out.print("nombre completo: ");
                    String nomEmpleado = scanner.nextLine();
                    gestor.registrarEmpleado(nomEmpleado, dniEmpleado);
                    break;
                case "2":
                    System.out.print("RUC del distribuidor: ");
                    String RUCDistribuidor = scanner.nextLine();
                    System.out.print("Razon social: ");
                    String nomDistribuidor = scanner.nextLine();
                    gestor.registrarDistribuidor(RUCDistribuidor, nomDistribuidor);
                    break;
                case "3":
                    System.out.print("Escanee/Ingrese el código: ");
                    String codNuevo = scanner.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nomNuevo = scanner.nextLine();
                    System.out.print("Stock inicial: ");
                    int stockIni = Integer.parseInt(scanner.nextLine());
                    gestor.registrarProducto(codNuevo, nomNuevo, stockIni);
                    break;
                case "4":
                    System.out.print("DNI del empleado a cargo:");
                    String dniEntrada = scanner.nextLine();
                    System.out.print("RUC del distribuidor de entrega:");
                    String RUCEntrada = scanner.nextLine();
                    System.out.print("Codigo del producto a registrar:");
                    String codEntrada = scanner.nextLine();
                    System.out.print("Cantidad a ingresar: ");
                    int cantEntrada = Integer.parseInt(scanner.nextLine());
                    gestor.registrarEntrada(codEntrada, cantEntrada, dniEntrada, RUCEntrada);
                    break;
                case "5":
                    System.out.print("DNI del Empleado a cargo: ");
                    String dniSalida = scanner.nextLine();
                    System.out.print("Código del Producto: ");
                    String codSalida = scanner.nextLine();
                    System.out.print("Cantidad a retirar: ");
                    int cantSalida = Integer.parseInt(scanner.nextLine());
                    gestor.registrarSalida(codSalida, cantSalida, dniSalida);
                    break;
                case "6":
                    gestor.mostrarInventario();
                    break;
                case "7":
                    salir = true;
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
