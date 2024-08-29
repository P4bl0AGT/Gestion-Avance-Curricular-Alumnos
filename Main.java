import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        //leer
        System.out.println("== Leer alumno ==");
        for (int i = 0 ; i < 3 ; i++) {
            leerAlumno(lector);                 //temporal
        }

    
    }
}


public static void leerAlumno(BufferedReader lector) throws IOException {
    System.out.print("Ingrese nombre: ");
    String nombre = lector.readLine();

    System.out.print("Ingrese apellido: ");
    String apellido = lector.readLine();

    System.out.print("Ingrese edad: ");
    int edad = Integer.parseInt(lector.readLine());

    System.out.print("Ingrese rut: ");
    String rut = lector.readLine();

    System.out.print("Ingrese carrera: "); //Temporal
    int carrera = Integer.parseInt(lector.readLine());

    Alumno a = new Alumno(nombre, apellido, edad, rut, carrera);            //falta agregar a lista mapa

    System.out.println("********************");
 }