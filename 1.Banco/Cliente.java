// Librería que contiene la clase Scanner
import java.util.*;

class Cliente {
  // Clase principal que crea objetos de la clase Banco

  public static void main(String[] args) {
    // Variables a utilizar
    int opcion = 4;
    String nombre;
    float saldo, dinero;
    Scanner scan = new Scanner(System.in);  // Maneja la entrada por tecladoddddddddddffdfgdfgdffffffffffffffffffffffffffffffffffffffffffffffff
    System.out.println("¡Bienvenido a el Banco Feliz!");
    // Utiliza try para manejar flujo de excepciones
    try {
      // Lee los datos del cuentahabiente
      System.out.print("Escriba su nombre: ");
      nombre = scan.nextLine();
      System.out.print("Escriba su saldo inicial: ");
      saldo = scan.nextFloat()
      // Instancia la clase Banco con los datos anteriores
      Banco cuenta = new Banco(nombre, saldo);
      do {
        // Menu con opciones que representan a
        // los métodos de la clase Banco
        System.out.println("_________\nServicios");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Mostrar Datos");
        System.out.println("4. Salir");
        System.out.print("¿Qué desea hacer?: ");
        opcion = scan.nextInt();
        if (opcion == 1) {
          System.out.print("Escriba la cantidad a depositar: ");
          dinero = scan.nextFloat();
          if (cuenta.deposito(dinero)) {
            System.out.println("¡Transacción exitosa!");
          } else {
            System.out.println("Cantidad inválida");
          };
        } else if (opcion == 2) {
          System.out.print("Escriba la cantidad a retirar: ");
          dinero = scan.nextFloat();
          if (cuenta.retiro(dinero)) {
            System.out.println("¡Transacción exitosa!");
          } else {
            System.out.println("Cantidad inválida o saldo insuficiente");
          };
        } else if (opcion == 3) {
          cuenta.despliega();
        }
      } while (opcion != 4);
      System.out.println("¡Gracias por confiar en nosotros!");
    } catch (Exception e) {
      System.out.println("Ocurrió un error: " + e);
    }
  }

}
