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

/**
 * Esta clase se encarga de hacer la lectura y escritura de datos
 */
public class Datos {
    
    //CARGAR ============================================================================
    /**
    * @param instituto El instituto donde cargaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de cargar datos de carreras desde un csv de carreras
    */
    public void cargarCsvCarreras(Instituto instituto) throws IOException {
        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/carreras.csv"), "UTF-8"));
        String linea;

        while((linea = lectorCsv.readLine()) != null) {
            String[] datosCarrera = linea.split(",");
            String idCarrera = datosCarrera[0];
            String nombreCarrera = datosCarrera[1];
            int semestresCarrera = Integer.parseInt(datosCarrera[2]);

            Carrera carrera = new Carrera(idCarrera, nombreCarrera, semestresCarrera);
            
            cargarCsvAsignaturas(carrera);
            if (carrera.cantidadAsignaturas() != 0)
                instituto.agregarCarrera(carrera);
        }
        lectorCsv.close();
    }
    /**
    * @param carrera La carrera donde cargaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de cargar datos de asignaturas desde un csv de asignaturas
    */
    private void cargarCsvAsignaturas(Carrera carrera) throws IOException {
        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/asignaturas.csv"), "UTF-8"));
        String linea;
        
        while((linea = lectorCsv.readLine()) != null) {
            String[] datosAsignatura = linea.split(",");
            String idCarrera = datosAsignatura[0];
            String idAsignatura = datosAsignatura[1];
            String nombreAsignatura = datosAsignatura[2];
            int creditosAsignatura = Integer.parseInt(datosAsignatura[3]);
            
            if (carrera.getId().equals(idCarrera)) {
                Asignatura asignatura = new Asignatura(idAsignatura, nombreAsignatura, creditosAsignatura);
                carrera.agregarAsignatura(asignatura);
            }
        }
        lectorCsv.close();
    }
    /**
    * @param instituto El instotuto donde cargaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de cargar datos de alumnos desde un csv de alumnos
    */
    public void cargarCsvAlumnos(Instituto instituto) throws IOException{
        
        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/alumnos.csv"), "UTF-8"));
        String linea;

        while((linea = lectorCsv.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String apellido = datos[1];
            String rut = datos[2];
            int edad = Integer.parseInt(datos[3]);
            int creditosApro = Integer.parseInt(datos[4]);
            String idCarrera = datos[5];
            
            Alumno alumno = new Alumno(nombre, apellido, rut, edad, creditosApro);
            Carrera carrera = instituto.obtenerCarrera(idCarrera);
            
            if (carrera != null) {
                alumno.inscribirCarrera(carrera);
                instituto.agregarAlumno(alumno);
            }
        }
        lectorCsv.close();
    }
    /**
    * @param instituto El instotuto donde cargaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de cargar datos de profesores desde un csv de profesores
    */
    public void cargarCsvProfesores(Instituto instituto) throws IOException{
        
        BufferedReader lectorCsv = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/datos/profesores.csv"), "UTF-8"));
        String linea;

        while((linea = lectorCsv.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String apellido = datos[1];
            String rut = datos[2];
            int edad = Integer.parseInt(datos[3]);
            
            Profesor profesor = new Profesor(nombre, apellido, rut, edad);
            
            String[] StringAsignaturas = datos[4].split("-");
            for (String idAsignatura: StringAsignaturas) {
                Asignatura asignatura = instituto.obtenerAsignatura(idAsignatura);
                if (asignatura != null) {
                    profesor.agregarAsignatura(asignatura);
                }
            }
            
            if (profesor.contarAsignaturas() == 0)
                profesor.agregarAsignatura(new Asignatura("0", "Sin Asignatura", 0));
            instituto.agregarProfesor(profesor);
        }
        lectorCsv.close();
    }
    
    
    //GUARDAR ============================================================================
    /**
    * @param instituto El instotuto desde donde guardaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de guardar datos de carreras a un csv de carreras
    */
    public void guardarCsvCarreras(Instituto instituto) throws IOException {
        File file = new File("src/main/java/datos/zCarreras.csv");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        
        String datos = instituto.listarCarreras();
        pw.write(datos);
        
        pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
    /**
    * @param instituto El instotuto desde donde guardaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de guardar datos de asignaturas a un csv de asignaturas
    */
    public void guardarCsvAsignaturas(Instituto instituto) throws IOException {
        File file = new File("src/main/java/datos/zAsignaturas.csv");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        
        String datos = instituto.listarAsignaturas();
        pw.write(datos);
        
        pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
    /**
    * @param instituto El instotuto desde donde guardaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de guardar datos de profesores a un csv de profesores
    */
    public void guardarCsvProfesores(Instituto instituto) throws IOException {
        File file = new File("src/main/java/datos/zProfesores.csv");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        
        String datos = instituto.listarProfesores(true);
        pw.write(datos);
        
        pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
    /**
    * @param instituto El instotuto desde donde guardaremos los datos
    * @throws IOException exepcion por si ocurre un error al intentar leer el archivo.
    * Metodo encargado de guardar datos de alumnos a un csv de alumnos
    */
    public void guardarCsvAlumnos(Instituto instituto) throws IOException {
        File file = new File("src/main/java/datos/zAlumnos.csv");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        
        String datos = instituto.listarAlumnos(true);
        pw.write(datos);
        
        pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
    
}
