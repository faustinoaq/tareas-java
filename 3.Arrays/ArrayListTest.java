import java.util.*;

// Este programa usa ArrayList para resolver el problema

class ArrayListTest {

  /* Los atributos princioales son
  los ectores del problema */
  private ArrayList<String> employeeCode = new ArrayList<String>();
  private ArrayList<Integer> employeeNameIndex = new ArrayList<Integer>();
  private ArrayList<String> employeeName = new ArrayList<String>();

  ArrayListTest() {
    /*
    En este caso se crean los ArrayList de códigos,
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
    /*En la función  principal de crea la
    instancia de la clase ArrayListTest y se
    llama al método que hace funcional el
    programa y que enlaza a los demás métodos*/
    ArrayListTest employee = new ArrayListTest();
    try {
      employee.getCodes();
    } catch (Exception e) {
      System.out.println("Ocurrió un error: " + e);
    }
  }

  private void getCodes() {
    // Función para obtener los códigos a analizar
    Integer i, n;
    String code;
    Scanner input = new Scanner(System.in);
    ArrayList<String> codeStack = new ArrayList<String>();
    ArrayList<String> nameStack = new ArrayList<String>();
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
    // Esta función permite que los códigos sean parseados en los demas arreglos
    int index, element;
    index = this.employeeCode.indexOf(code);
    if (index >= 0) {
      element = this.employeeNameIndex.get(index);
      return this.employeeName.get(index);
    } else {
      return "¡Código Inválido!";
    }
  }

  private void printCodes(ArrayList<String> nameStack, ArrayList<String> codeStack) {
    // Esta función imprime los códigos de manéra agradable.
    // Se usó HashTable con el motivo de tener una mejor visualización
    // y no forma parte de la lógica del problema.
    Hashtable<String, String> nameCodes = new Hashtable<String, String>();
    int i;
    for (i=0; i < codeStack.size(); i++) {
      nameCodes.put(nameStack.get(i), codeStack.get(i));
    }
    Collections.sort(nameStack);
    System.out.println("\nCódigo | Empleado");
    System.out.println("------ | --------");
    for (String name : nameStack) {
      System.out.print(" " + nameCodes.get(name));
      System.out.println("  | " + name);
    }
    System.out.println();
  }
}
