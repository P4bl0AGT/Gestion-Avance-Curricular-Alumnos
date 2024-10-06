package modelo;

import java.io.*;
import java.util.Iterator;

/**
 * Esta clase principal del dominio y representa un Instituto que gestiona carreras, profesores y alumnos.
 * Utiliza contenedores genéricos para almacenar y organizar estos elementos.
 */
public class Instituto
{
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private final Contenedor<String, Carrera> contenedorCarreras;
    private final Contenedor<String, Profesor> contenedorProfesores;
    private final Contenedor<String, Alumno> contenedorAlumnos;
    
    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    /**
     * Constructor que inicializa el Instituto creando contenedores vacíos
     * para almacenar carreras, profesores y alumnos.
     */
    public Instituto() {
        contenedorCarreras = new Contenedor<>();
        contenedorProfesores = new Contenedor<>();
        contenedorAlumnos = new Contenedor<>();
    }
    
    
    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================
    // Como Contenedor es una clase wrapper que encapsula-envuelve colecciones no puede tener setters
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    // Como Contenedor es una clase wrapper que encapsula-envuelve colecciones no puede tener getters
    
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================

    // - - - - - - - - - - TALLA - - - - - - - - - -
    /**
     * Devuelve la cantidad total de carreras en el sistema.
     * @return el número de carreras registradas.
     */
    public int cantidadCarreras() {return contenedorCarreras.talla();}
    
    /**
     * Devuelve la cantidad total de profesores en el sistema.
     * @return el número de profesores registrados.
     */
    public int cantidadProfesores() {return contenedorProfesores.talla();}
    
    /**
     * Devuelve la cantidad total de alumnos en el sistema.
     * @return el número de alumnos registrados.
     */
    public int cantidadAlumnos() {return contenedorAlumnos.talla();}
    
    
    
    // - - - - - - - - - - BUSCAR - - - - - - - - - -
    /**
     * Obtiene una carrera del sistema por su índice.
     * @param i el índice de la carrera en el contenedor.
     * @return la carrera correspondiente al índice especificado
     */
    public Carrera obtenerCarrera(int i) {return contenedorCarreras.obtener(i);}
    
    /**
     * Obtiene una carrera del sistema por su identificador.
     * @param id el índice de la carrera en el contenedor.
     * @return la carrera correspondiente al identificador especificado o null si no existe
     */
    public Carrera obtenerCarrera(String id) {return contenedorCarreras.obtener(id);}
    
    /**
     * Obtiene un profesor del sistema por su índice.
     * @param i el índice del profesor en el contenedor.
     * @return el profesor correspondiente al índice especificado
     */
    public Profesor obtenerProfesor(int i) {return contenedorProfesores.obtener(i);}
    
    /**
     * Obtiene un profesor del sistema por su identificador.
     * @param rut el identificador del profesor en el contenedor.
     * @return el profesor correspondiente al índice especificado o null si no existe
     */
    public Profesor obtenerProfesor(String rut) {return contenedorProfesores.obtener(rut);}
    
    /**
     * Obtiene un alumno del sistema por su índice.
     * @param i el índice del alumno en el contenedor.
     * @return el profesor correspondiente al índice especificado
     */
    public Alumno obtenerAlumno(int i) {return contenedorAlumnos.obtener(i);}
    
    /**
     * Obtiene un alumno del sistema por su identificador.
     * @param rut el identificador del alumno en el contenedor.
     * @return el alumno correspondiente al índice especificado o null si no existe
     */
    public Alumno obtenerAlumno(String rut) {return contenedorAlumnos.obtener(rut);}
    
    /**
     * Obtiene una asignatura del sistema por su identificador.
     * @param id el identificador de la asignatura en el contenedor de carreras.
     * @return la asignatura correspondiente al identificador especificado o nill si no existe
     */
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
    
    
    
    // - - - - - - - - - - AGREGAR - - - - - - - - - -
    /**
     * Agrega una nueva carrera al sistema.
     * @param carrera la carrera a agregar.
     * @return true si la carrera fue agregada exitosamente, false en caso contrario.
     */
    public boolean agregarCarrera(Carrera carrera) {return contenedorCarreras.agregar(carrera.getId(), carrera);}
    
    /**
     * Agrega un nuevo profesor al sistema.
     * @param profesor el profesor a agregar.
     * @return true si el profesor fue agregada exitosamente, false en caso contrario.
     */
    public boolean agregarProfesor(Profesor profesor) {return contenedorProfesores.agregar(profesor.getRut(), profesor);}
    
    /**
     * Agrega un nuevo alumno al sistema.
     * @param alumno el alumno a agregar.
     * @return true si el alumno fue agregada exitosamente, false en caso contrario.
     */
    public boolean agregarAlumno(Alumno alumno) {return contenedorAlumnos.agregar(alumno.getRut(), alumno);}
    
    
    
    // - - - - - - - - - - ELIMINAR - - - - - - - - - -
    /**
     * Elimina una carrera del sistema por su identificador.
     * @param id el identificador de la carrera a eliminar.
     * @return true si la carrera fue eliminada exitosamente, false en caso contrario.
     */
    public boolean eliminarCarrera(String id){
        Carrera carreraEliminar = contenedorCarreras.eliminar(id);
        return carreraEliminar != null;
    }
    
        /**
     * Elimina un profesor del sistema por su RUT.
     * @param rutProfesor el RUT del profesor a eliminar.
     * @return true si el profesor fue eliminado exitosamente, false en caso contrario.
     */
    public boolean eliminarProfesor(String rutProfesor) {
        Profesor profesorEliminar = contenedorProfesores.eliminar(rutProfesor);
        return profesorEliminar != null;
    }
    
    /**
     * Elimina un alumno del sistema por su RUT.
     * @param rutAlumno el RUT del alumno a eliminar.
     * @return true si el alumno fue eliminado exitosamente, false en caso contrario.
     */
    public boolean eliminarAlumno(String rutAlumno) {
        Alumno alumnoEliminar = contenedorAlumnos.eliminar(rutAlumno);
        return alumnoEliminar != null;
    }
    
    
    
    // - - - - - - - - - - LISTAR - - - - - - - - - -
    /**
     * Lista todos los profesores del sistema.
     * @return una cadena de texto que contiene la información de todos los profesores.
     */
    public String listarProfesores(){
        String cc = "";
        Iterator<Profesor> iterable = contenedorProfesores.iterador();
        while (iterable.hasNext()) {
            Profesor profesor = iterable.next();
            cc += profesor.obtenerString();
        }
        return cc;
    }
    
    /**
     * Lista todos los profesores del sistema, con opción de mostrar información detallada.
     * @param completo true para obtener información completa de los profesores
     * @return una cadena de texto que contiene la información de todos los profesores,
     *         incluyendo sus asignaturas
     */
    public String listarProfesores(boolean completo){
        String cc = "";
        Iterator<Profesor> iterable = contenedorProfesores.iterador();
        while (iterable.hasNext()) {
            Profesor profesor = iterable.next();
            String strAsignaturas = profesor.listarAsignaturas(true);
            cc += (profesor.obtenerString(true) + "," + strAsignaturas);
        }
        return cc;
    }
    
    /**
     * Lista todos los alumnos del sistema.
     * @return una cadena de texto que contiene la información de todos los alumnos.
     */
    public String listarAlumnos(){
        String cc = "";
        Iterator<Alumno> iterable = contenedorAlumnos.iterador();
        while (iterable.hasNext()) {
            Alumno alumno = iterable.next();
            cc += alumno.obtenerString();
        }
        return cc;
    }
    
    /**
     * Lista todos los alumnos del sistema, con opción de mostrar información resumida.
     * @param simple true para obtener información simple de los alumnos
     * @return una cadena de texto que contiene la información de todos los alumnos,
     *         en formato simple.
     */
    public String listarAlumnos(boolean simple){
        String cc = "";
        Iterator<Alumno> iterable = contenedorAlumnos.iterador();
        while (iterable.hasNext()) {
            Alumno alumno = iterable.next();
            cc += alumno.obtenerString(true);
        }
        return cc;
    }
    
    /**
     * Lista todas las carreras del sistema.
     * @return una cadena de texto que contiene la información de todas las carreras.
     */
    public String listarCarreras(){
        String cc = "";
        Iterator<Carrera> iterable = contenedorCarreras.iterador();
        while (iterable.hasNext()) {
            Carrera carrera = iterable.next();
            cc += carrera.obtenerString();
        }
        return cc;
    }
    
    /**
     * Lista todas las asignaturas de todas las carreras del sistema.
     * @return una cadena de texto que contiene la información de todas las asignaturas.
     */
    public String listarAsignaturas(){
        String ca = "";
        Iterator<Carrera> iterable = contenedorCarreras.iterador();
        while (iterable.hasNext()) {
            Carrera carrera = iterable.next();
            ca += carrera.listarAsignaturas(true);
        }
        return ca;
    }
    
    /**
     * Carga datos predefinidos desde archivos CSV en el sistema.
     * @throws IOException si ocurre un error al leer los archivos CSV.
     */
    public void cargarDatosPredefinidos() throws IOException{
        Datos datos = new Datos();
        datos.cargarCsvCarreras(this);
        datos.cargarCsvProfesores(this);
        datos.cargarCsvAlumnos(this);
    }
    
    /**
     * Guarda los datos actuales del sistema en archivos CSV y genera un informe
     * @throws IOException si ocurre un error al escribir en los archivos CSV.
     */
    public void guardarDatos() throws IOException{
        Datos datos = new Datos();
        datos.guardarCsvCarreras(this);
        datos.guardarCsvAsignaturas(this);
        datos.guardarCsvProfesores(this);
        datos.guardarCsvAlumnos(this);
        datos.generarInforme(this);
    }
    
    
    /**
     * Este metodo obtiene metricas del instituto.
     * @return una cadena de texto que contiene la información requerida para generar un reporte
     */
    public String obtenerDatosReporte() {
        String msj = "";
        msj += ("Informe Instituto\n\n");
        int cantAlum = this.cantidadAlumnos();
        int cantProf = this.cantidadProfesores();
        int cantCarr = this.cantidadCarreras();
        
        // Cantidades almacenada
        msj += ("Cantidades:\n"); 
        msj += ("***********\n");
        msj += ("Cantidad Alumnos: " + cantAlum +"\n");
        msj += ("Cantidad Profesores: " + cantProf +"\n");
        msj += ("Cantidad Carreras: " + cantCarr +"\n");
        msj += ("\n");
        
        // Detalles de los alumnos
        msj += ("Detalles de Alumnos:\n");
        msj += ("********************\n");
        for (int i = 0; i <  cantAlum; i++) {
            Alumno alumno = this.obtenerAlumno(i);
            Carrera carrera = alumno.getCarrera();
            int aprobados = alumno.getCreditosAprobados();
            int totales = carrera.cantidadCreditos();
            msj += ("   Rut: "+ alumno.getRut() +
                    ", Carrera: "+ carrera.getNombre() +
                    ", Creditos: "+ aprobados + " de " + totales);
            if (aprobados >= totales/2)
                msj += (" - SUPERO EL 50% MALLA \n");
            else
                msj += (" - AUN NO SUPERA EL 50% MALLA \n");
        }
        msj += ("\n");
        
        
        // Detalles de los Profesores
        msj += ("Detalles de Profesores:\n");
        msj += ("***********************\n");
        for (int i = 0; i <  cantProf; i++) {
            Profesor profesor = this.obtenerProfesor(i);
            int totalAsignaturas = profesor.contarAsignaturas();
            msj += ("   Nombre: "+ profesor.getNombre() +
                    ", Rut: "+ profesor.getRut() +
                    ", Asignaturas: "+ totalAsignaturas);
            if (totalAsignaturas > 3)
                msj += (" - BONO POR CANTIDAD ASIGNATURAS \n");
            else
                msj += (" - NO CUMPLE REQUISITOS BONO \n");
        }
        msj += ("\n");
        
        
        // Detalles de las carreras
        msj += ("Detalles de Carreras:\n");
        msj += ("**********************\n");
        int mayor = 0;
        int menor = 99;
        int promedio = 0;
        int posMayor = 0;
        int posMenor = 0;
        for (int i = 0; i <  cantCarr; i++) {
            Carrera carrera = this.obtenerCarrera(i);
            int totalAsignaturas = carrera.cantidadAsignaturas();
            if (totalAsignaturas >= mayor) {
                posMayor = i;
                mayor = totalAsignaturas;
            }
            if (totalAsignaturas <= menor) {
                posMenor = i;
                menor = totalAsignaturas;
            }
            promedio += totalAsignaturas;
        }
        promedio = promedio / cantCarr;
        msj += ("Carrera con menor cantidad de Asignaturas: " + this.obtenerCarrera(posMenor).getNombre() +" con "+ menor +"\n");
        msj += ("Carrera con mayor cantidad de Asignaturas: " + this.obtenerCarrera(posMayor).getNombre() +" con "+ mayor +"\n");
        msj += ("En promedio una carrera tiene: " + promedio +" Asignaturas\n");
        msj += ("\n");

        return msj;
    }
    
    
    // =========================================================================
    // =========================== OBSOLETOS ===================================
    // =========================================================================
    {
    /*
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
 
    public void eliminarCarrera(String idCarrera) {
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
    }
    
    
    public void eliminarProfesor(String rutProfesor) {
        Profesor profesorEliminar = contenedorProfesores.eliminar(rutProfesor);

        if(profesorEliminar != null)
            profesorEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra el rut ingresado");
            return;
        }
    }
    
    public void eliminarAlumno(String rutAlumno) {
        Alumno alumnoEliminar = contenedorAlumnos.eliminar(rutAlumno);

        if(alumnoEliminar != null)
            alumnoEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra el rut ingresado");
            return;
        }
    }
    
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
    
    
    
    */
    }
}

