import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Datos {
    
    public void cargarCsvCarreras(Instituto instituto) throws IOException{

        BufferedReader lectorCsv = new BufferedReader(new FileReader("src/main/java/datos/carreras.csv"));
        String linea;

        while((linea = lectorCsv.readLine()) != null) {
            
            if (linea.trim().startsWith("#")) {
                
                //leer carreras
                linea = lectorCsv.readLine();
                String[] datosCarrera = linea.split(",");
                String idCarrera = datosCarrera[0];
                String nombreCarrera = datosCarrera[1];
                int semestresCarrera = Integer.parseInt(datosCarrera[2]);

                Carrera carrera = new Carrera(idCarrera, nombreCarrera, semestresCarrera);

                //leer asignaturas
                for (int i = 0; i < 10; i++) {
                    linea = lectorCsv.readLine();
                    String[] datosAsignatura = linea.split(",");


                    String codigoAsignatura = datosAsignatura[0];
                    String nombreAsignatura = datosAsignatura[1];
                    int creditosAsignatura = Integer.parseInt(datosAsignatura[2].trim());

                    Asignatura asignatura = new Asignatura(codigoAsignatura, nombreAsignatura, creditosAsignatura);

                    carrera.agregarAsignatura(asignatura);
                }

                //agregar carrera a mapa y lista de clase instituto
                boolean flag = instituto.agregarCarrera(carrera);
                if (!flag)
                    System.out.println("No fue posible cargar datos");
            }
        }
        lectorCsv.close();
    }

    public void cargarCsvAlumnos(Instituto instituto) throws IOException{
        BufferedReader lectorCsv = new BufferedReader(new FileReader("src/main/java/datos/alumnos.csv"));
        String linea;
        int talla = instituto.cantidadCarreras();
        int posRandom;

        while((linea = lectorCsv.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String apellido = datos[1];
            String rut = datos[2];
            int edad = Integer.parseInt(datos[3].trim());

            Alumno alumno = new Alumno(nombre, apellido, rut, edad);
            
            Random random = new Random();
            posRandom = random.nextInt(talla);  // entre [0 y talla[

            alumno.inscribirCarrera(instituto.obtenerCarrera(posRandom));

            //agregar alumno a mapa y lista de clase instituto
            boolean flag = instituto.agregarAlumno(alumno);
            if (!flag)
                System.out.println("No fue posible cargar datos");
        }
        lectorCsv.close();
    }

    public void cargarCsvProfesores(Instituto instituto) throws IOException{
        BufferedReader lectorCsv = new BufferedReader(new FileReader("src/main/java/datos/profesores.csv"));
        String linea;
        int cantidadCarreras = instituto.cantidadCarreras();
        int posRandom;

        while((linea = lectorCsv.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String apellido = datos[1];
            String rut = datos[2];
            int edad = Integer.parseInt(datos[3].trim());

            Profesor profesor = new Profesor(nombre, apellido, rut, edad);
            
            Random random = new Random();
            posRandom = random.nextInt(cantidadCarreras);  // entre [0 y talla[

            profesor.agregarAsignatura(instituto.obtenerCarrera(posRandom).obtenerAsignatura(0));

            //agregar PROFE a mapa y lista de clase instituto
            boolean flag = instituto.agregarProfesor(profesor);
            if (!flag)
                System.out.println("No fue posible cargar datos");
        }
        lectorCsv.close();
    }    
}
