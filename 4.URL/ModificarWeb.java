
// Clase para hacer modificaciones en el código HTML

import java.io.*;
import java.util.*;
import java.util.regex.*;

class ModificarWeb {

  public String data;
  private Scanner s = new Scanner(System.in);

  ModificarWeb (String path) {
    // El constructor asigna los datos de la pagina web a una variable
    this.data = leerHTML(path);
    System.out.println("\n\tMODIFICACIONES DEL DOCUMENTO HTML\n");
  }

  private String leerHTML(String path) {
    // Se encarga de obtener los datos de un archivo
    String inputText="", inputLine;
    try {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      while((inputLine = br.readLine()) != null) {
        inputText += inputLine;
      }
      br.close();
    } catch (IOException e) {
      System.out.println("Error al leer archivo: " + e);
      System.exit(0);
    }
    return inputText;
  }

  public void agregarParrafo() {
    // Se encarga de agragar un párrafo al HTML
    String p="<p>";
    System.out.print("Escriba un párrafo: ");
    p += s.nextLine();
    p += "</p></body>";
    this.data = this.data.replace("</body>", p);
  }

  public void cambiarTitulo() {
    // Cambia el título del HTML
    String t;
    System.out.print("Escriba un título: ");
    t = s.nextLine();
    t = "<title>" + t + "</title>";
    Pattern title = Pattern.compile("<title>((.|\n)+?)</title>");
    this.data = title.matcher(this.data).replaceAll(t);
  }

}
