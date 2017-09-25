import java.util.*;

// Desarrollo del problema utilizando Arrays

class ArrayTest {

  // Atributos del la clase
  // Son simples arrays en comparación con los objetos Vector y List
  private String[] employeeCode = new String[5];
  private Integer[] employeeNameIndex = new Integer[5];
  private String[] employeeName = new String[5];

  ArrayTest() {
    this.employeeCode[0] = "B011";
    this.employeeCode[1] = "A001";
    this.employeeCode[2] = "A000";
    this.employeeCode[3] = "B010";
    this.employeeCode[4] = "C100";
    this.employeeNameIndex[0] = 3;
    this.employeeNameIndex[1] = 1;
    this.employeeNameIndex[2] = 0;
    this.employeeNameIndex[3] = 2;
    this.employeeNameIndex[4] = 4;
    this.employeeName[0] = "Faustino Aguilar";
    this.employeeName[1] = "Carlos Álvarez";
    this.employeeName[2] = "Alcides Zurita";
    this.employeeName[3] = "Efraín Aguilar";
    this.employeeName[4] = "Cristian Siu";
  }

  public static void main(String[] args) {
    ArrayTest employee = new ArrayTest();
    try {
      employee.getCodes();
    } catch (Exception e) {
      System.out.println("Ocurrió un error: " + e);
    }
  }

  private void getCodes() {
    // Obtiene los códigos y los almacena en un array a comparación con
    // las otras clases, utilizando un índice.
    Integer i, n;
    String code;
    Scanner input = new Scanner(System.in);
    System.out.println("\nPROGRAMA PARA GESTIÓN DE EMPLEADOS");
    System.out.print("Escriba la cantidad de códigos para analizar: ");
    n = input.nextInt();
    input.nextLine();
    String[] codeStack = new String[n];
    String[] nameStack = new String[n];
    for(i=1; i<=n; i++) {
      System.out.print("Escriba el código del " + i + "° empleado XXXX: ");
      code = input.nextLine();
      codeStack[i-1] = code;
      nameStack[i-1] = filterCodes(code);
    }
    printCodes(codeStack, nameStack);
  }

  private String filterCodes(String code) {
    // Foltra el código y restorna su resultado
    int index, element;
    index = Arrays.asList(this.employeeCode).indexOf(code);
    if (index >= 0) {
      element = this.employeeNameIndex[index];
      return this.employeeName[index];
    } else {
      return "¡Código Inválido!";
    }
  }

  private void printCodes(String[] nameStack, String[] codeStack) {
    // Imprime una serie de códigos con su respectivo
    // resultado en pantalla
    Hashtable<String, String> nameCodes = new Hashtable<String, String>();
    int i;
    for (i=0; i < codeStack.length; i++) {
      nameCodes.put(nameStack[i], codeStack[i]);
    }
    Arrays.sort(nameStack);
    System.out.println("\nCódigo | Empleado");
    System.out.println("------ | --------");
    for (String name : nameStack) {
      System.out.println(" " + nameCodes.get(name) + "  | " + name);
    }
    System.out.println();
  }

}
