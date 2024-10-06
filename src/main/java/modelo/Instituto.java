package modelo;

import java.io.*;
import java.util.Iterator;

public class Instituto
{
    //ATRIBUTOS
    private final Contenedor<String, Carrera> contenedorCarreras;
    private final Contenedor<String, Profesor> contenedorProfesores;
    private final Contenedor<String, Alumno> contenedorAlumnos;

    //CONSTRUCTOR
    public Instituto() {
        contenedorCarreras = new Contenedor<>();
        contenedorProfesores = new Contenedor<>();
        contenedorAlumnos = new Contenedor<>();
    }


    /* = = = = = = = = = = METODOS FUERA CLASE = = = = = = = = = = */
    public int cantidadCarreras() {return contenedorCarreras.talla();}
    public Carrera obtenerCarrera(int i) {return contenedorCarreras.obtener(i);}
    public Carrera obtenerCarrera(String ID) {return contenedorCarreras.obtener(ID);}
    public boolean agregarCarrera(Carrera carrera) {return contenedorCarreras.agregar(carrera.getId(), carrera);}

    public int cantidadProfesores() {return contenedorProfesores.talla();}
    public Profesor obtenerProfesor(int i) {return contenedorProfesores.obtener(i);}
    public Profesor obtenerProfesor(String rut) {return contenedorProfesores.obtener(rut);}
    public boolean agregarProfesor(Profesor profesor) {return contenedorProfesores.agregar(profesor.getRut(), profesor);}

    public int cantidadAlumnos() {return contenedorAlumnos.talla();}
    public Alumno obtenerAlumno(int i) {return contenedorAlumnos.obtener(i);}
    public Alumno obtenerAlumno(String rut) {return contenedorAlumnos.obtener(rut);}
    public boolean agregarAlumno(Alumno alumno) {return contenedorAlumnos.agregar(alumno.getRut(), alumno);}
    
    public Asignatura obtenerAsignatura(String id) {
        Iterator<Carrera> iterador = contenedorCarreras.iterador();
        while(iterador.hasNext()) {
            Carrera carreraActual = iterador.next();
            Asignatura asignaturaActual = carreraActual.obtenerAsignatura(id);
            if (asignaturaActual != null)
                return asignaturaActual;
        }
        return null;
    }
    


    /* = = = = = = = = = = METODOS MOSTRAR = = = = = = = = = = */
    public void mostrarCarreras() {
        System.out.println("Lista Carreras");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < contenedorCarreras.talla() ; i++)
        {
            Carrera carreraActual = contenedorCarreras.obtener(i);
            carreraActual.mostrar(true);
        }
    }

    public void mostrarProfesores() {
        System.out.println("Lista Profesores");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < contenedorProfesores.talla() ; i++)
        {
            Profesor profesorActual = contenedorProfesores.obtener(i);
            profesorActual.mostrar(true);
        }
    }

    public void mostrarAlumnos() {
        System.out.println("Lista Alumnos");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < contenedorAlumnos.talla() ; i++)
        {
            Alumno alumnoActual = contenedorAlumnos.obtener(i);
            alumnoActual.mostrar(true);
        }
    }
    
    /*preferir tostring
    public String obtenerNombreAlumno(int indice){
        Alumno alumnoActual = contenedorAlumnos.obtener(indice);
        return alumnoActual.getNombre() + " " + alumnoActual.getApellido();
    }
    */
    


    /* = = = = = = = = = = METODOS BUSCAR = = = = = = = = = = */
    public void buscarCarreradId(String idCarrera) {
        Carrera carreraBuscada = contenedorCarreras.obtener(idCarrera);
        if(carreraBuscada != null)
            carreraBuscada.mostrar();
        else
            System.out.println("No se encuentra la carrera con el id ingresado");
    }

    public void buscarProfesoresRut(String rutProfesor) {
        Profesor profesorBuscado = contenedorProfesores.obtener(rutProfesor);
        if(profesorBuscado != null)
            profesorBuscado.mostrar();
        else
            System.out.println("No se encuentra el alumno con el rut ingresado");
    }

    public void buscarAlumnosRut(String rutAlumno) {
        Alumno alumnoBuscado = contenedorAlumnos.obtener(rutAlumno);
        if(alumnoBuscado != null)
            alumnoBuscado.mostrar();
        else
            System.out.println("No se encuentra el alumno con el rut ingresado");
    }

    public void buscarAlumnosPorCarrera(String idCarrera) {
        boolean hayAlumnosCarrera = false;
        
        if (contenedorAlumnos.talla() != 0) {
            for (int i = 0; i < contenedorAlumnos.talla() ; i++) {
                Alumno alumnoActual = contenedorAlumnos.obtener(i);
                String nombreCarrera = alumnoActual.getCarrera().getNombre();

                if (nombreCarrera.equals(idCarrera)) {
                    alumnoActual.mostrar();
                    System.out.println("");
                    hayAlumnosCarrera = true;
                }
            }

            if (!hayAlumnosCarrera)
                System.out.println("No hay alumnos inscritos en la carrera");
        }
        else
            System.out.println("No hay alumnos inscritos en el instituto");
    }


    /* = = = = = = = = = = METODOS ELIMINAR = = = = = = = = = = */
    /*public void eliminarCarrera(String idCarrera) {
        Carrera carreraEliminar = contenedorCarreras.eliminar(idCarrera);

        if(carreraEliminar != null)
            carreraEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra la carrera con el id ingresado");
            return;
        }
        
        Iterator<Alumno> iterador = contenedorAlumnos.iterador();
        while (iterador.hasNext()) {
            Alumno alumnoActual = iterador.next();
            String idCarreraAlumno = alumnoActual.getCarrera().getId();
            if (idCarrera.equals(idCarreraAlumno)) {
                alumnoActual.setCarrera(new Carrera());
            }
        }
    }*/
    public boolean eliminarCarrera(String ID){
        Carrera actual = contenedorCarreras.eliminar(ID);
        return actual != null;
        
    }

    /*
    public void eliminarProfesor(String rutProfesor) {
        Profesor profesorEliminar = contenedorProfesores.eliminar(rutProfesor);

        if(profesorEliminar != null)
            profesorEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra el rut ingresado");
            return;
        }
    }
    */
    //MOD-VENTANA
    public boolean eliminarProfesor(String rutProfesor) {
        Profesor profesorEliminar = contenedorProfesores.eliminar(rutProfesor);
        return profesorEliminar != null;
    }

    /*public void eliminarAlumno(String rutAlumno) {
        Alumno alumnoEliminar = contenedorAlumnos.eliminar(rutAlumno);

        if(alumnoEliminar != null)
            alumnoEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra el rut ingresado");
            return;
        }
    }*/
    
    public boolean eliminarAlumno(String rutAlumno) {
        Alumno alumnoEliminar = contenedorAlumnos.eliminar(rutAlumno);
        return alumnoEliminar != null;
    }





    /* = = = = = = = = = =           = = = = = = = = = = */
    public void actualizacionEstado(String rutAlumno, BufferedReader lector)throws IOException{ // FALTA SACAR LECTOR
        
        int creditosAprobados = 0;
        Alumno alumnoBuscado = contenedorAlumnos.obtener(rutAlumno);

        if (alumnoBuscado == null) {
            System.out.println("Alumno NO encontrado");
            return;
        }

        alumnoBuscado.mostrar(true);
        
        Carrera carreraAlumno = alumnoBuscado.getCarrera();

        System.out.println("");
        System.out.println("Asignaturas:");
        System.out.println("============");

        for (int i = 0 ; i < carreraAlumno.cantidadAsignaturas() ; i++){
            AsignaturaInscrita asigaturaActual = (AsignaturaInscrita) carreraAlumno.obtenerAsignatura(i);

            System.out.println(asigaturaActual.getNombre());
            System.out.println("1.- APROBADO");
            System.out.println("2.- REPORBADO");
            System.out.println("0.- MANTENER");
            int estadoActualizado = Integer.parseInt(lector.readLine());
            if(estadoActualizado == 1) {
                creditosAprobados += asigaturaActual.getCreditos();
                asigaturaActual.aprobar();
            }
            else if (estadoActualizado == 2){
                asigaturaActual.reprobar();
            }
        }   

        System.out.println("Tus estados de asignatura han sido actualizados con exito");
        alumnoBuscado.setCreditosAprobados(creditosAprobados);
    }

    public void mostrarEstadoAsignaturas(String rutAlumno) {
        Alumno alumnoBuscado = contenedorAlumnos.obtener(rutAlumno);

        if (alumnoBuscado == null){
            System.out.println("Alumno NO encontrado");
            return;
        }
        alumnoBuscado.mostrar(true);
        
        Carrera carreraAlumno = alumnoBuscado.getCarrera();
        carreraAlumno.mostrar(true);

        for (int i = 0 ; i < carreraAlumno.cantidadAsignaturas() ; i++) {
            AsignaturaInscrita asignatura = (AsignaturaInscrita) carreraAlumno.obtenerAsignatura(i);
            System.out.println("La asignatura " + asignatura.getNombre() + " esta " + asignatura.getEstado().name());
        }
        System.out.println("Creditos aprobados: " + alumnoBuscado.getCreditosAprobados());
        System.out.println("Creditos totales: " + carreraAlumno.cantidadCreditos());
    }


    /* = = = = = = = = = =           = = = = = = = = = = */

    public void agregarAsignaturaProfe(String rutProfesor, String idCarrera, String codigoAsignatura) {
        mostrarProfesores();
        Profesor profesor = contenedorProfesores.obtener(rutProfesor);
        if (profesor == null) {
            System.out.print("profesor no encontrado");
            return;
        }
        profesor.mostrar(true);
        
        mostrarCarreras();
        Carrera carrera = contenedorCarreras.obtener(idCarrera);
        if (carrera == null) {
            System.out.print("Carrera no encontrada");
            return;
        }
        carrera.mostrar();
        
        Asignatura asignatura = carrera.obtenerAsignatura(codigoAsignatura);
        if (asignatura == null) {
            System.out.print("Asignatura no encontrada");
            return;
        }
        asignatura.mostrar();

        boolean flag = profesor.agregarAsignatura(asignatura);
        if (!flag) {
            System.out.print("Problemas al agregar");
            return;
        }
        System.out.print("agregado");
    }


    public void eliminarAsignaturaProfe(String rutProfesor, String codigoAsignatura){
        Profesor profesor = contenedorProfesores.obtener(rutProfesor);
        if (profesor == null) {
            System.out.print("profesor no encontrado");
            return;
        }
        profesor.mostrar(true);

        Asignatura asignatura = profesor.elimarAsignatura(codigoAsignatura);
        if (asignatura == null) {
            System.out.print("no encontrado");
            return;
        }
        System.out.print("eliminado");
        asignatura.mostrar();

    }
    
    
    //para ventanas -----------------------
    public String listarProfesores(){
        String cc = "";
        Iterator iterable = contenedorProfesores.iterador();
        while (iterable.hasNext()) {
            cc += iterable.next().toString(); //HAY QUE HACER EL TOSTRING PARA CADA CLASE
        }
        return cc;
    }
    
    public String listarProfesores(boolean completo){
        String cc = "";
        Iterator<Profesor> iterable = contenedorProfesores.iterador();
        while (iterable.hasNext()) {
            Profesor profesor = iterable.next();
            String strAsignaturas = profesor.listarAsignaturas(true);
            cc += (profesor.toString(true) + "," + strAsignaturas + "\n");
        }
        return cc;
    }
    
    public String listarAlumnos(){
        String cc = "";
        Iterator iterable = contenedorAlumnos.iterador();
        while (iterable.hasNext()) {
            cc += iterable.next().toString(); //HAY QUE HACER EL TOSTRING PARA CADA CLASE
        }
        return cc;
    }
    
    public String listarAlumnos(boolean simple){
        String cc = "";
        Iterator<Alumno> iterable = contenedorAlumnos.iterador();
        while (iterable.hasNext()) {
            Alumno alumno = iterable.next();
            cc += alumno.toString(true); //HAY QUE HACER EL TOSTRING PARA CADA CLASE
        }
        return cc;
    }
    
    public String listarCarreras(){
        String cc = "";
        Iterator iterable = contenedorCarreras.iterador();
        while (iterable.hasNext()) {
            cc += iterable.next().toString(); //HAY QUE HACER EL TOSTRING PARA CADA CLASE
        }
        return cc;
    }
    
    public String listarAsignaturas(){
        String ca = "";
        Iterator<Carrera> iterable = contenedorCarreras.iterador();
        while (iterable.hasNext()) {
            Carrera carrera = iterable.next();
            ca += carrera.listarAsignaturas(true);
        }
        return ca;
    }
    
    public void cargarDatosPredefinidos() throws IOException{
        Datos datos = new Datos();
        datos.cargarCsvCarreras(this);
        datos.cargarCsvProfesores(this);
        datos.cargarCsvAlumnos(this);
    }
    
    public void guardarDatos() throws IOException{
        Datos datos = new Datos();
        datos.guardarCsvCarreras(this);
        datos.guardarCsvAsignaturas(this);
        datos.guardarCsvProfesores(this);
        datos.guardarCsvAlumnos(this);
    }
}

