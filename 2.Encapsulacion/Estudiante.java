import java.util.*;

class Estudiante {

  // Contiene los atributos del estudiante
  private String nombre, sexo, cedula, codigo;
  private float puesto;
  CapturaDespliega input = new CapturaDespliega();

  Estudiante(){}
  Estudiante(String nombre, String sexo, String cedula, String codigo, float puesto) {
    // EL constructor asigna datos al estudiante
    this.nombre = nombre;
    this.sexo = sexo;
    this.cedula = cedula;
    this.codigo = codigo;
    this.puesto = puesto;
  }

  public void mayorPuesto(ArrayList<Estudiante> alumnos) {
    Estudiante maximo; // Estudiante de mayor puesto
    Asignaturas asg = new Asignaturas();
    String materia;
    maximo = alumnos.get(0);
    // Se calcula el máximo puesto
    for(Estudiante e: alumnos) {
      if(e.puesto > maximo.puesto){
        maximo = e;
      }
    }

    input.show("\nMayor Puesto\n============\n");
    input.show("Nombre: " + maximo.nombre + "\n");
    input.show("Género: " + maximo.sexo + "\n");
    input.show("Código de asignatura: " + maximo.codigo + "\n");
    // Si el código de asg. no corresponde
    // a ninguno en la clase Asignaturas
    // se muestra un mensaje de error.
    materia = asg.describirCodigo(maximo.codigo);
    if (materia != null) {
      input.show("Descripción de la Asignatura: " + materia + "\n");
    } else {
      input.show("Error: Código de asignatura no relacionado\n");
    }
  }

  public void notaPromedio(ArrayList<Estudiante> alumnos){
    // Calcula el promedio de las notas por cada
    // estudiante.
    int i;
    String opcion = "no";
    float suma;
    ArrayList<String> cedulas = new ArrayList<String>();
    ArrayList<Float> sumas = new ArrayList<Float>();
    ArrayList<Integer> notas = new ArrayList<Integer>();
    input.show("\n\tNotas de los estudiantes\n");
    for(Estudiante e: alumnos) {
      i=0;
      suma=0;
      input.show("\nEstudiante: " + e.nombre + "\n");
      do {
        suma += input.getNota(i);
        opcion = input.getOpcion();
        i++;
      } while (opcion.equalsIgnoreCase("si"));
      cedulas.add(e.cedula);
      sumas.add(suma);
      notas.add(i);
    }
    calcularPromedio(cedulas, sumas, notas);
  }

  public void calcularPromedio(ArrayList<String> cedulas,
                               ArrayList<Float> sumas,
                               ArrayList<Integer> notas) {
    String cedula, opcion;
    float promedio;
    int indice;
    input.show("\n\tPromedio de los estudiantes\n");
    do {
      cedula = input.getCedula();
      indice = cedulas.indexOf(cedula);
      if (indice >= 0) {
        promedio = sumas.get(indice)/notas.get(indice);
        input.show("\nPromedio de " + cedula + ": " + promedio + "\n");
      } else {
        input.show("Error: Cédula no encontrada\n");
      }
      opcion = input.getOpcion();
    } while (opcion.equalsIgnoreCase("si"));
  }

}
