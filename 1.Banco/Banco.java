// Librería que contiene System.out
import java.io.*;

class Banco {
  /// Clase que contiene los métodos y atributos
  // del cuentahabiente.

  // Nombre y saldo del cliente
  private String cliente;
  private float saldo;

  // Constructor de la Clase Banco
  Banco(String cliente, float saldo) {
    this.cliente = cliente;
    this.saldo = saldo;
    // Lanza una excepción cuando el saldo inicial es negativo
    if (!verificaSaldo(saldo)) {
      throw new IllegalArgumentException("El saldo inicial debe ser positivo");
    }
  }

  // Los métodos deposito, retiro y verificaSaldo son booleanos
  public boolean deposito(float dinero) {
    // Solo deposita si la cantidad es válida
    if (dinero > 0) {
      this.saldo += dinero;
      System.out.println("Nuevo saldo: " + this.saldo);
      return true;
    } else {
      return false;
    }
  }

  public boolean retiro(float dinero){
    // Primero utiliza el método verificaSaldo
    if (this.verificaSaldo(dinero)) {
      this.saldo -= dinero;
      System.out.println("Nuevo saldo: " + this.saldo);
      return true;
    } else {
      return false;
    }
  }

  public boolean verificaSaldo(float dinero){
    // Verifica si el saldo es suficiente
    if (this.saldo >= dinero && dinero > 0) {
      return true;
    } else {
      return false;
    }
  }

  public void despliega(){
    // Muestra información sobre el cuentahabiente
    System.out.println("Nombre: " + this.cliente);
    System.out.println("Saldo: " + this.saldo);
  }

}
