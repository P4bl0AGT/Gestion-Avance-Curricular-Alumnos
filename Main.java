import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        //Instituto
        Instituto instituto = new Instituto();

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        //leer
        System.out.println("== Leer alumno ==");
        for (int i = 0 ; i < 3 ; i++) {
            leerAlumno(lector, instituto);
        }

    
    }
}


public static void leerAlumno(BufferedReader lector, Instituto instituto) throws IOException {
    System.out.print("Ingrese nombre: ");
    String nombre = lector.readLine();

    System.out.print("Ingrese apellido: ");
    String apellido = lector.readLine();

    System.out.print("Ingrese edad: ");
    int edad = Integer.parseInt(lector.readLine());

    System.out.print("Ingrese rut: ");
    String rut = lector.readLine();

    System.out.print("Ingrese carrera: ");
    int carrera = Integer.parseInt(lector.readLine());

    Alumno alumno = new Alumno(nombre, apellido, edad, rut, carrera);

    instituto.agregarAlumno(alumno);

    System.out.println("********************");
 }