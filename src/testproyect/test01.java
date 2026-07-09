
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
            System.out.println("2. Entrada de mercadería (Sumar stock)");
            System.out.println("3. Salida de mercadería (Restar stock)");
            System.out.println("4. Ver inventario completo");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Escanee/Ingrese el código: ");
                    String codNuevo = scanner.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nomNuevo = scanner.nextLine();
                    System.out.print("Stock inicial: ");
                    int stockIni = Integer.parseInt(scanner.nextLine());
                    gestor.registrarProducto(codNuevo, nomNuevo, stockIni);
                    break;
                case "2":
                    System.out.print("Escanee/Ingrese el código: ");
                    String codEntrada = scanner.nextLine();
                    System.out.print("Cantidad a ingresar: ");
                    int cantEntrada = Integer.parseInt(scanner.nextLine());
                    gestor.movimientoStock(codEntrada, cantEntrada, "ENTRADA");
                    break;
                case "3":
                    System.out.print("Escanee/Ingrese el código: ");
                    String codSalida = scanner.nextLine();
                    System.out.print("Cantidad a retirar: ");
                    int cantSalida = Integer.parseInt(scanner.nextLine());
                    gestor.movimientoStock(codSalida, -cantSalida, "SALIDA"); // Se pasa en negativo
                    break;
                case "4":
                    gestor.mostrarInventario();
                    break;
                case "5":
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
