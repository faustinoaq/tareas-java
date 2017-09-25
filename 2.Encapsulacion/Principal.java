/*
En el compilador javac utilizado
la librería io es incluida por defecto
util Contiene ArrayList
*/
import java.util.ArrayList;

class Principal {
  // Clase Principal que invoca a las demás clases

  public static void main(String[] args) {
    // Variables a utilizar
    int i=0;
    float puesto;
    String nombre, sexo, cedula, codigo, opcion;
    ArrayList<Estudiante> alumnos = new ArrayList<Estudiante>();
    CapturaDespliega input = new CapturaDespliega();
    Estudiante E = new Estudiante();
    /*
    Se presentan las asignaturas
    y se comienzan a capturar datos de los
    estudiantes hasta que el usuario
    detenga la captura respondiendo "no"
    */
    input.show("\tPlataforma de organización Estudiantil\n");
    input.show("\nAsignaturas\n");
    input.show("MAT101: Matemáticas\n");
    input.show("ESP100: Español\n");
    input.show("ING121: Inglés\n");
    input.show("FIS112: Física\n");
    input.show("BIO122: Biología\n");
    input.show("QUI210: Química\n");
    try {
      do {
        i++;
        input.show("\nEstudiante " + i + "\n");
        // Lee los datos del estudiante
        nombre = input.getNombre();
        sexo = input.getSexo();
        cedula = input.getCedula();
        codigo = input.getCodigo();
        puesto = input.getPuesto();
        Estudiante est = new Estudiante(nombre, sexo, cedula, codigo, puesto);
        alumnos.add(est);
        opcion = input.getOpcion();
      } while (opcion.equalsIgnoreCase("si"));

      // Se utilizan los métodos de la clase
      // Estudiante para calcular el mayorPuesto
      // y el promedio de cada estudiante.
      E.mayorPuesto(alumnos);
      E.notaPromedio(alumnos);

      input.show("¡Gracias por utilizar la Plataforma!" + "\n");
    } catch (Exception e) {
      input.show("Ocurrió un error: " + e + "\n");
    }
  }

}
