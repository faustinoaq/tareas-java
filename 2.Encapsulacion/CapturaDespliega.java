// util contiene Scanner
import java.util.Scanner;

class CapturaDespliega {

  private Scanner scan = new Scanner(System.in);

  public void show(String data) {
    System.out.print(data);
  }

  public String getOpcion(){
    // Captura la opcion para continuar capturando datos
    System.out.print("¿Desea introducir más datos? si/no: ");
    return this.scan.nextLine();
  }

  public String getNombre(){
    // Captura el Nombre
    System.out.print("Escriba el nombre: ");
    return this.scan.nextLine();
  }

  public String getSexo(){
    // Captura el sexo
    System.out.print("Escriba el sexo: ");
    return this.scan.nextLine();
  }

  public String getCedula(){
    // Captura la cedula
    System.out.print("Escriba una cedula: ");
    return this.scan.nextLine();
  }

  public String getCodigo(){
    // Captura el código de la asignatura
    System.out.print("Código de asignatura de mayor calificación: ");
    return this.scan.nextLine();
  }

  public float getPuesto(){
    /*
    Captuta el puntaje del puesto del estudiante
    Como es un numero flotante, no se captura
    el salto de linea y se tiene que utilizar
    nextLine para recogerlo.
    Si el puesto es negativo se responde con cero
    ya que es inválido, lo mismo pasa en getNota
    */
    float puesto;
    System.out.print("Número de puesto académico: ");
    puesto = this.scan.nextFloat();
    this.scan.nextLine();
    if (puesto >= 0) {
      return puesto;
    } else {
      System.out.println("Puesto minimo es 0");
      return 0;
    }
  }

  public float getNota(int i){
    // Captura la nota de un estudiante
    float nota;
    i++;
    System.out.print("Nota " + i + ": ");
    nota = this.scan.nextFloat();
    this.scan.nextLine();
    if (nota >= 0) {
      return nota;
    } else {
      System.out.println("nota minima es 0");
      return 0;
    }
  }
}
