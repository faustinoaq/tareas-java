
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

class LeerWeb {

  public static void main(String[] args) {
    // Se encarga de leer el sitio web
    String url, html, file;
    System.out.println("\n\tPROGRAMA PARA GESTIÓN DE DOCUMENTO HTML\n");
    LeerWeb web = new LeerWeb();
    url = web.capturaURL();
    html = web.filtrarHTML(url);
    file = web.generarNombre(url);
    web.guardarArchivo(html, file);
    ModificarWeb neoWeb = new ModificarWeb(file);
    neoWeb.cambiarTitulo();
    neoWeb.agregarParrafo();
    web.guardarArchivo(neoWeb.data, file);
  }

  public String capturaURL() {
    // CAptura la URL
    Scanner scan = new Scanner(System.in);
    System.out.print("Escribe una URL: ");
    return scan.nextLine();
  }

  public String generarNombre(String url) {
    // Genera un nombre adecuado para el archivo
    String nombre;
    Pattern dominio = Pattern.compile("http://([\\w.]+)");
    Matcher result = dominio.matcher(url);
    result.find();
    nombre = result.group(1);
    nombre += ".html";
    return nombre;
  }

  public String filtrarHTML(String url) {
    // Filtra el HTML extrayendo lo necesario usando REGEXX
    String inputLine, inputText="", htmlCode="";
    boolean titleTest, tagTest;
    try {
      System.out.println("Analizando URL...");
      URL URL = new URL(url);
      InputStreamReader isr = new InputStreamReader(URL.openStream());
      BufferedReader in = new BufferedReader(isr);
      while((inputLine = in.readLine()) != null) {
        inputText += inputLine;
      }
      in.close();
      Pattern title = Pattern.compile("(<title>)((.|\n)+?)(</title>)");
      Pattern tags = Pattern.compile("<(p|h1|h2|h3)(\\s(.*?))?>(.+?)</(p|h1|h2|h3)>");
      Matcher getTitle = title.matcher(inputText);
      Matcher getTags = tags.matcher(inputText);
      htmlCode = "<!DOCTYPE html>\n";
      htmlCode += "<html>\n";
      htmlCode += "<head>\n";
      htmlCode += "<meta charset=\"utf-8\">\n";
      while (getTitle.find()) {
        htmlCode += getTitle.group(0);
        htmlCode += "\n";
      }
      htmlCode += "</head>\n";
      htmlCode += "<body>\n";
      while (getTags.find()) {
        htmlCode += getTags.group(0);
        htmlCode += "\n";
      }
      htmlCode += "</body>\n";
      htmlCode += "</html>\n";
    } catch (Exception e) {
      System.out.println("Error al filtrar URL: " + e);
      System.exit(0);
    }
    return htmlCode;
  }

  public void guardarArchivo(String data, String file) {
    // Guarda ekl archivo creado
    try {
      File text = new File(file);
      BufferedWriter bw = new BufferedWriter(new FileWriter(text));
      bw.write(data);
      bw.close();
      System.out.println("Datos guardados en: " + file + "\n");
    } catch (Exception e) {
      System.out.println("Error al guardar archivo: " + e);
      System.exit(0);
    }
  }

}
