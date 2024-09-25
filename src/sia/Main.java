package sia;
import java.io.*;

public class Main {

    //LECTURAS
    public static void leerCarrera(BufferedReader lector, Instituto instituto) throws IOException {

        System.out.print("Ingrese id: ");
        String id = lector.readLine();
    
        System.out.print("Ingrese nombre: ");
        String nombre = lector.readLine();
    
        System.out.print("Ingrese semestres: ");
        int semestres = Integer.parseInt(lector.readLine());

        Carrera carrera = new Carrera(id, nombre, semestres);
    
        System.out.print("Ingrese total asignaturas: ");
        int talla = Integer.parseInt(lector.readLine());

        //validar lectura
        while (talla < 1) {
            System.out.print("Reingrese: ");
            talla = Integer.parseInt(lector.readLine());
        }
        
        //leer cada asignatura de la carrera actual
        for (int i = 0; i < talla; i++) {
            leerAsignatura(lector, carrera, i+1);
        }
    
        instituto.agregarCarrera(carrera);
    
        System.out.println("********************");
    }

    public static void leerProfesor(BufferedReader lector, Instituto instituto) throws IOException {

        Verificaciones verificaciones = new Verificaciones();

        System.out.print("Ingrese nombre: ");
        String nombre = lector.readLine();
    
        System.out.print("Ingrese apellido: ");
        String apellido = lector.readLine();
    
        //System.out.print("Ingrese edad: ");
        int edad = verificaciones.verificarEdad(lector, "Ingrese su edad: ");
    
        //System.out.print("Ingrese rut sin puntos ni digito verificador: ");
        //String rut = lector.readLine();
        int rut = verificaciones.validarEntrada(lector, "Ingrese su rut sin puntos ni digito verificador: ");
        String rutCadena = Integer.toString(rut);
    
        Profesor profesor = new Profesor(nombre, apellido, rutCadena, edad);
    
        instituto.agregarProfesor(profesor);
    
        System.out.println("********************");
    }
    
    public static void leerAlumno(BufferedReader lector, Instituto instituto) throws IOException {
        Verificaciones verificaciones = new Verificaciones();

        System.out.print("Ingrese nombre: ");
        String nombre = lector.readLine();
    
        System.out.print("Ingrese apellido: ");
        String apellido = lector.readLine();
    
        //System.out.print("Ingrese edad: ");
        int edad = verificaciones.verificarEdad(lector, "Ingrese su edad: ");
    
        //System.out.print("Ingrese rut sin puntos ni digito verificador: ");
        //String rut = lector.readLine();
        int rut = verificaciones.validarEntrada(lector, "Ingrese su rut sin puntos ni digito verificador: ");
        String rutCadena = Integer.toString(rut);
    
        System.out.println("Ingrese carrera: ");
        int talla = instituto.cantidadCarreras();
        for (int i = 0; i < talla; i++) {
            System.out.println("  » [" + i +"] " + instituto.obtenerCarrera(i).getNombre());
        }
        
        //validar lectura
        int indice = verificaciones.validarEntrada(lector, "Ingrese la opcion de su carrera: ");//AGREGAR RANGO A LAS VALIDACIONES
        
        Carrera carrera = instituto.obtenerCarrera(indice);
    
        Alumno alumno = new Alumno(nombre, apellido, rutCadena, edad);
        alumno.inscribirCarrera(carrera);
    
        instituto.agregarAlumno(alumno);
    
        System.out.println("********************");
    }
    
    public static void leerAsignatura(BufferedReader lector, Carrera carrera, int i) throws IOException {
        System.out.println("== Asignatura: " + i + "==");
        System.out.print("Ingrese codigo: ");
        String codigo = lector.readLine();
    
        System.out.print("Ingrese nombre: ");
        String nombre = lector.readLine();
    
        System.out.print("Ingrese creditos: ");
        int creditos = Integer.parseInt(lector.readLine());

        Asignatura asignatura = new Asignatura(codigo, nombre, creditos);

        carrera.agregarAsignatura(asignatura);
    }
    

    //MENUS
    public static void menuPrincipal() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║   [1] Carreras                  ║");
        System.out.println("║   [2] Profesores                ║");
        System.out.println("║   [3] Alumnos                   ║");
        System.out.println("║   [4] Varios                    ║");
        System.out.println("║                                 ║");
        System.out.println("║   [0] Salir                     ║");
        System.out.println("╚═════════════════════════════════╝");
    }

    public static void menuCarreras() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║   [1] Agregar Carrera           ║");
        System.out.println("║   [2] Mostrar Carreras          ║");
        System.out.println("║   [3] Buscar Carrera ID         ║");
        System.out.println("║   [4] Eliminar Carrera          ║");
        System.out.println("║                                 ║");
        System.out.println("║   [0] Volver                    ║");
        System.out.println("╚═════════════════════════════════╝");
    }

    public static void menuProfesores() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║   [1] Agregar Profesor          ║");
        System.out.println("║   [2] Mostrar Profesores        ║");
        System.out.println("║   [3] Buscar Profesor RUT       ║");
        System.out.println("║   [4] Eliminar Profesor         ║");
        System.out.println("║   [5] Agregar asignatura        ║");
        System.out.println("║   [6] Eliminar asignatura       ║");
        System.out.println("║                                 ║");
        System.out.println("║   [0] Volver                    ║");
        System.out.println("╚═════════════════════════════════╝");
    }

    public static void menuAlumnos() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║   [1] Agregar Alumno            ║");
        System.out.println("║   [2] Mostrar Alumnos           ║");
        System.out.println("║   [3] Buscar Alumno RUT         ║");
        System.out.println("║   [4] Eliminar Alumno           ║");
        System.out.println("║   [5] Buscar Alumno CARRERA     ║");
        System.out.println("║   [6] Actualizar Asignaturas    ║");
        System.out.println("║   [7] Estado Asignaturas        ║");
        System.out.println("║                                 ║");
        System.out.println("║   [0] Volver                    ║");
        System.out.println("╚═════════════════════════════════╝");
    }

    public static void menuVarios() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║   [1] IMPLEMENTAR               ║");
        System.out.println("║   [2] IMPLEMENTAR               ║");
        System.out.println("║                                 ║");
        System.out.println("║   [0] Volver                    ║");
        System.out.println("╚═════════════════════════════════╝");
    }


    //OPCIONES
    public static void opcionesCarrera(BufferedReader lector, Instituto instituto) throws IOException{

        String id;
        Verificaciones verificaciones = new Verificaciones();
        while (true) {
            limpiarPantalla();
            menuCarreras();
            //System.out.print("Seleccionar opcion: ");
            int opcion = verificaciones.validarEntrada(lector, "Seleccionar opcion: ");
            System.out.println("");

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    leerCarrera(lector, instituto);
                    break;
                case 2:
                    limpiarPantalla();
                    instituto.mostrarCarreras();
                    System.out.println("");
                    break;
                case 3:
                    limpiarPantalla();
                    id = leerID(lector, "carrera", opcionMsj.BUSCAR);
                    instituto.buscarCarreradId(id);
                    System.out.println("");
                    break;
                case 4:
                    limpiarPantalla();
                    id = leerID(lector, "carrera", opcionMsj.ELIMINAR);
                    instituto.eliminarCarrera(id);
                    System.out.println("");
                    break;
                case 0:
                    limpiarPantalla();
                    return;
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("");
                    break;
            }
            presionaParaContinuar(lector);
            limpiarPantalla();
        }

    }

    public static void opcionesProfesor(BufferedReader lector, Instituto instituto) throws IOException{
        String rutProfesor,idCarrera, idAsignatura;

        Verificaciones verificaciones = new Verificaciones();
        while (true) {
            limpiarPantalla();
            menuProfesores();
            //System.out.print("Seleccionar opcion: ");
            int opcion = verificaciones.validarEntrada(lector, "Seleccionar opcion: ");
            System.out.println("");

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    leerProfesor(lector, instituto);
                    break;
                case 2:
                    limpiarPantalla();
                    instituto.mostrarProfesores();
                    System.out.println("");
                    break;
                case 3:
                    limpiarPantalla();
                    rutProfesor = leerRUT(lector, "profesor", opcionMsj.BUSCAR);
                    instituto.buscarProfesoresRut(rutProfesor);
                    System.out.println("");
                    break;
                case 4:
                    limpiarPantalla();
                    rutProfesor = leerRUT(lector, "profesor", opcionMsj.ELIMINAR);
                    instituto.eliminarProfesor(rutProfesor);
                    System.out.println("");
                    break;
                case 5:
                    limpiarPantalla();
                    rutProfesor = leerRUT(lector, "profesor", opcionMsj.BUSCAR);
                    idCarrera = leerID(lector, "Carrera", opcionMsj.BUSCAR);
                    idAsignatura = leerID(lector, "asignatura", opcionMsj.BUSCAR);
                    instituto.agregarAsignaturaProfe(rutProfesor, idCarrera, idAsignatura);
                    System.out.println("");
                    break;
                case 6:
                    limpiarPantalla();
                    rutProfesor = leerRUT(lector, "profesor", opcionMsj.ACTUALIZAR);
                    idAsignatura = leerID(lector, "asignatura", opcionMsj.ELIMINAR);
                    instituto.eliminarAsignaturaProfe(rutProfesor, idAsignatura);
                    System.out.println("");
                    break;
                case 0:
                    limpiarPantalla();
                    return;
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("");
                    break;
            }
            presionaParaContinuar(lector);
            limpiarPantalla();
        }

    }

    public static void opcionesAlumno(BufferedReader lector, Instituto instituto) throws IOException{
        String rutAlumno,idCarrera;

        Verificaciones verificaciones = new Verificaciones();

        while (true) {
            limpiarPantalla();
            menuAlumnos();
            //System.out.print("Seleccionar opcion: ");
            int opcion = verificaciones.validarEntrada(lector, "Seleccionar opcion: ");
            System.out.println("");

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    leerAlumno(lector, instituto);
                    break;
                case 2:
                    limpiarPantalla();
                    instituto.mostrarAlumnos();
                    System.out.println("");
                    break;
                case 3:
                    limpiarPantalla();
                    rutAlumno = leerRUT(lector, "alumno", opcionMsj.BUSCAR);
                    instituto.buscarAlumnosRut(rutAlumno);
                    System.out.println("");
                    break;
                case 4:
                    limpiarPantalla();
                    rutAlumno = leerID(lector, "alumno", opcionMsj.ELIMINAR);
                    instituto.eliminarAlumno(rutAlumno);
                    System.out.println("");
                    break;
                case 5:
                    limpiarPantalla();
                    idCarrera = leerID(lector, "carrera", opcionMsj.BUSCAR);
                    instituto.buscarAlumnosPorCarrera(idCarrera);
                    System.out.println("");
                    break;
                case 6:
                    limpiarPantalla();
                    rutAlumno = leerRUT(lector, "alumno", opcionMsj.ACTUALIZAR);
                    instituto.actualizacionEstado(rutAlumno, lector);  ////////FALTA MOVER LECTURA
                    System.out.println("");
                    break;
                case 7:
                    limpiarPantalla();
                    rutAlumno = leerRUT(lector, "alumno", opcionMsj.MOSTRAR);
                    instituto.mostrarEstadoAsignaturas(rutAlumno);
                    System.out.println("");
                    break;
                case 0:
                    limpiarPantalla();
                    return;
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("");
                    break;
            }
            presionaParaContinuar(lector);
            limpiarPantalla();
        }

    }



    //VARIOS
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void presionaParaContinuar(BufferedReader lector) throws IOException {
        System.out.println("Presione ENTER para continuar");  
        lector.readLine();  
    }
    

    //LECTURA
    public static String leerID(BufferedReader lector, String mensaje, opcionMsj op) throws IOException {
        System.out.println("Porfavor ingresar el ID de la" + mensaje + " a " + op.name());
        String id = lector.readLine();
        return id;
    }

    public static String leerRUT(BufferedReader lector, String mensaje, opcionMsj op) throws IOException {
        System.out.println("Porfavor ingresar el RUT del " + mensaje + " a " + op.name());
        String rut = lector.readLine();
        return rut;
    }

    public static enum opcionMsj {
        BUSCAR,
        ELIMINAR,
        ACTUALIZAR,
        MOSTRAR
    }
    
    //PRINCIPAL
    public static void main(String[] args) throws IOException{
        limpiarPantalla();

        //VERIFICACION
        Verificaciones verificaciones = new Verificaciones();

        //Instituto clase principal
        Instituto instituto = new Instituto();
        
        //Lector
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        //Cargar
        Datos datos = new Datos();
        datos.cargarCsvCarreras(instituto);
        datos.cargarCsvAlumnos(instituto);
        datos.cargarCsvProfesores(instituto);


        while (true) {
            limpiarPantalla();
            menuPrincipal();
            //System.out.print("Seleccionar opcion: ");

            // ---- PRUEBA ----- //
            int opcion = verificaciones.validarEntrada(lector, "Seleccionar opcion: ");
            // ---- PRUEBA ----- //


            System.out.println("");

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    opcionesCarrera(lector, instituto);
                    break;
                case 2:
                    limpiarPantalla();
                    menuProfesores();
                    opcionesProfesor(lector, instituto);
                    break;
                case 3:
                    limpiarPantalla();
                    menuAlumnos();
                    opcionesAlumno(lector, instituto);
                    break;
                case 4:
                    limpiarPantalla();
                    menuVarios();
                    //Falta implementar
                    //opcionesvARIAS(lector, instituto);
                    break;
                case 0:
                    limpiarPantalla();
                    lector.close();
                    System.exit(0);
                    //Falta agregar persistencia de datos
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("");
                    break;
            }
            presionaParaContinuar(lector);
            limpiarPantalla();
        }

    }


}


