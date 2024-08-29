import java.io.*;
import java.util.*;

public class Main {

    public static void leerAlumno(BufferedReader lector, Instituto instituto, ArrayList<Carrera> listaCarreras) throws IOException {
        System.out.print("Ingrese nombre: ");
        String nombre = lector.readLine();
    
        System.out.print("Ingrese apellido: ");
        String apellido = lector.readLine();
    
        System.out.print("Ingrese edad: ");
        int edad = Integer.parseInt(lector.readLine());
    
        System.out.print("Ingrese rut: ");
        String rut = lector.readLine();
    
        System.out.println("Ingrese carrera: ");
        for (int i = 0; i < listaCarreras.size(); i++) {
            System.out.println("  » [" + i +"] " + listaCarreras.get(i).getNombre());
        }
        int indice = Integer.parseInt(lector.readLine());
    
        Alumno alumno = new Alumno(nombre, apellido, edad, rut, listaCarreras.get(indice));
    
        instituto.agregarAlumno(alumno);
    
        System.out.println("********************");
    }
    
    public static void mostrarMenu() {
        System.out.println("╔════════════════════════╗");
        System.out.println("║   [1] Agregar alumno   ║");
        System.out.println("║   [2] Mostrar alumno   ║");
        System.out.println("║   [0] Salir            ║");
        System.out.println("╚════════════════════════╝");
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void presionaParaContinuar(BufferedReader lector) throws IOException {
        System.out.println("Presione ENTER para continuar");  
        lector.readLine();  
    }
    
    public static void main(String[] args) throws IOException{

        //Instituto
        Instituto instituto = new Instituto();
        //LECTOR
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        //CARRERAS
        ArrayList listaCarreras = Datos.cargarCarreras();
        //OPCION

        while (true) {
            mostrarMenu();

            System.out.print("Seleccionar opcion: ");
            int opcion = Integer.parseInt(lector.readLine());
            System.out.println("");

            if (opcion == 1) {
                leerAlumno(lector, instituto, listaCarreras);
            } else if (opcion == 2) {
                instituto.mostrarAlumnos();
            } else if (opcion == 0) {
                System.exit(0);
            } else {
                System.out.println("Opcion no valida");
                System.out.println("");
            }
            presionaParaContinuar(lector);
            limpiarPantalla();
        }

    }
}


