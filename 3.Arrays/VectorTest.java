import java.util.*;

class VectorTest {

  /* Los atributos princioales son
  los ectores del problema */
  private Vector<String> employeeCode = new Vector<String>();
  private Vector<Integer> employeeNameIndex = new Vector<Integer>();
  private Vector<String> employeeName = new Vector<String>();

  VectorTest() {
    /*
    En este caso se crean los vectores de códigos,
    índices y nombres de los empleados.
    */
    this.employeeCode.add("B011");
    this.employeeCode.add("A001");
    this.employeeCode.add("A000");
    this.employeeCode.add("B010");
    this.employeeCode.add("C100");
    this.employeeNameIndex.add(3);
    this.employeeNameIndex.add(1);
    this.employeeNameIndex.add(0);
    this.employeeNameIndex.add(2);
    this.employeeNameIndex.add(4);
    this.employeeName.add("Faustino Aguilar");
    this.employeeName.add("Carlos Álvarez");
    this.employeeName.add("Alcides Zurita");
    this.employeeName.add("Efraín Aguilar");
    this.employeeName.add("Cristian Siu");
  }

  public static void main(String[] args) {
    /*EN la funcipn  principal de crea la
    instancia de la clase VectorTest y se
    llama al método que hace funcional el
    programa y que enlaza a los demás métodos*/
    VectorTest employee = new VectorTest();
    try {
      employee.getCodes();
    } catch (Exception e) {
      System.out.println("Ocurrió un error: " + e);
    }
  }

  private void getCodes() {
    // Obtención de códigos
    Integer i, n;
    String code;
    Scanner input = new Scanner(System.in);
    Vector<String> codeStack = new Vector<String>();
    Vector<String> nameStack = new Vector<String>();
    System.out.println("\nPROGRAMA PARA GESTIÓN DE EMPLEADOS");
    System.out.print("Escriba la cantidad de códigos para analizar: ");
    n = input.nextInt();
    input.nextLine();
    for(i=1; i<=n; i++) {
      System.out.print("Escriba el código del " + i + "° empleado XXXX: ");
      code = input.nextLine();
      codeStack.add(code);
      nameStack.add(filterCodes(code));
    }
    printCodes(codeStack, nameStack);
  }

  private String filterCodes(String code) {
    // Filtra los códigos en los vectores
    int index, element;
    index = this.employeeCode.indexOf(code);
    if (index >= 0) {
      element = this.employeeNameIndex.get(index);
      return this.employeeName.get(index);
    } else {
      return "¡Código Inválido!";
    }
  }

  private void printCodes(Vector<String> nameStack, Vector<String> codeStack) {
    // Imprime en pantalla el resultado
    // Hashtable solo es un ebellecedor
    Hashtable<String, String> nameCodes = new Hashtable<String, String>();
    int i;
    for (i=0; i < codeStack.size(); i++) {
      nameCodes.put(nameStack.get(i), codeStack.get(i));
    }
    Collections.sort(nameStack);
    System.out.println("\nCódigo | Empleado");
    System.out.println("------ | --------");
    for (String name : nameStack) {
      System.out.println(" " + nameCodes.get(name) + "  | " + name);
    }
    System.out.println();
  }
}
