package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;



public class Datos {
    
    public void cargarCsvCarreras(Instituto instituto) throws IOException{

        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/carreras.csv"), "UTF-8"));
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
        
        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/alumnos.csv"), "UTF-8"));
        String linea;
        int talla = instituto.cantidadCarreras();
        int posRandom;

        while((linea = lectorCsv.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String apellido = datos[1];
            String rut = datos[2];
            int edad = Integer.parseInt(datos[3].trim());
            //no utilizados por el momento
            int creditosApro = Integer.parseInt(datos[4].trim());
            String carrera = datos[5];
            

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
        
        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/profesores.csv"), "UTF-8"));
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
    
    public void guardarCsvProfesores(Instituto instituto) throws IOException {
        File file = new File("src/main/java/datos/pruebaProfesores.csv");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        
        String datos = instituto.listarProfesores();
        pw.write(datos);
        
        pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
    
    public void guardarCsvAlumnos(Instituto instituto) throws IOException {
        File file = new File("src/main/java/datos/pruebaAlumnos.csv");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        
        String datos = instituto.listarAlumnos();
        pw.write(datos);
        
        pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
}
