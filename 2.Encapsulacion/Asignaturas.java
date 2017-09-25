// Contiene clase Hashtable
import java.util.Hashtable;

public class Asignaturas {
  // Clase que relacina las asignaturas y sus codigos
  private Hashtable<String, String> asg = new Hashtable<String, String>();

  Asignaturas() {
    // Asignaturas que cubre el programa
    this.asg.put("MAT101", "Matemáticas");
    this.asg.put("ESP100", "Español");
    this.asg.put("ING121", "Inglés");
    this.asg.put("FIS112", "Física");
    this.asg.put("BIO122", "Biología");
    this.asg.put("QUIM210", "Química");
  }

  public String describirCodigo(String code){
    /*
    Método para obtener la descripcion del
    código de la asignatura.
    No es necesario un metodo para agregar
    asignaturas ya que no es el objetivo del
    problema:
    */
    return this.asg.get(code);
  }

}
