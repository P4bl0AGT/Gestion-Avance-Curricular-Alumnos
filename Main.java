import java.io.*;
import java.util.*;

public class Main {

    public static void leerAlumno(BufferedReader lector, Instituto instituto, ArrayList carreras) throws IOException {
        System.out.print("Ingrese nombre: ");
        String nombre = lector.readLine();
    
        System.out.print("Ingrese apellido: ");
        String apellido = lector.readLine();
    
        System.out.print("Ingrese edad: ");
        int edad = Integer.parseInt(lector.readLine());
    
        System.out.print("Ingrese rut: ");
        String rut = lector.readLine();
    
        System.out.print("Ingrese carrera: ");
        int indice = Integer.parseInt(lector.readLine());
    
        Alumno alumno = new Alumno(nombre, apellido, edad, rut, (Carrera) carreras.get(indice));
    
        instituto.agregarAlumno(alumno);
    
        System.out.println("********************");
     }
    public static void main(String[] args) throws IOException{

        //Instituto
        Instituto instituto = new Instituto();
        //LECTOR
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        //CARRERAS
        ArrayList carreras = Datos.cargarCarreras();
        //OPCION
       

        //leer
        System.out.println("== Leer alumno ==");
        for (int i = 0 ; i < 3 ; i++) {
            leerAlumno(lector, instituto, carreras);
        }

    
    }
}


