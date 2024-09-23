import java.io.*;
import java.util.Iterator;

public class Instituto
{
    //ATRIBUTOS
    private Contenedor<String, Carrera> contenedorCarreras;
    private Contenedor<String, Profesor> contenedorProfesores;
    private Contenedor<String, Alumno> contenedorAlumnos;

    //CONSTRUCTOR
    public Instituto() {
        contenedorCarreras = new Contenedor<>();
        contenedorProfesores = new Contenedor<>();
        contenedorAlumnos = new Contenedor<>();
    }


    /* = = = = = = = = = = METODOS FUERA CLASE = = = = = = = = = = */
    public int cantidadCarreras() {return contenedorCarreras.talla();}
    public Carrera obtenerCarrera(int i) {return contenedorCarreras.obtener(i);}
    public boolean agregarCarrera(Carrera carrera) {return contenedorCarreras.agregar(carrera.getId(), carrera);}

    public int cantidadProfesores() {return contenedorProfesores.talla();}
    public Profesor obtenerProfesor(int i) {return contenedorProfesores.obtener(i);}
    public boolean agregarProfesor(Profesor profesor) {return contenedorProfesores.agregar(profesor.getRut(), profesor);}

    public int cantidadAlumnos() {return contenedorAlumnos.talla();}
    public Alumno obteneraAlumno(int i) {return contenedorAlumnos.obtener(i);}
    public boolean agregarAlumno(Alumno alumno) {return contenedorAlumnos.agregar(alumno.getRut(), alumno);}


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


    /* = = = = = = = = = = METODOS BUSCAR = = = = = = = = = = */
    public void buscarCarreradId(BufferedReader lector) throws IOException {
        System.out.println("Porfavor ingresar el ID de la carrera a buscar");
        String id = lector.readLine();

        Carrera carreraBuscada = contenedorCarreras.obtener(id);
        if(carreraBuscada != null)
            carreraBuscada.mostrar();
        else
            System.out.println("No se encuentra la carrera con el id ingresado");
    }

    public void buscarProfesoresRut(BufferedReader lector) throws IOException {
        System.out.println("Porfavor ingresar el RUT del profesor a buscar");
        String rut = lector.readLine();

        Profesor profesorBuscado = contenedorProfesores.obtener(rut);
        if(profesorBuscado != null)
            profesorBuscado.mostrar();
        else
            System.out.println("No se encuentra el alumno con el rut ingresado");
    }

    public void buscarAlumnosRut(BufferedReader lector) throws IOException {
        System.out.println("Porfavor ingresar el RUT del alumno a buscar");
        String rut = lector.readLine();

        Alumno alumnoBuscado = contenedorAlumnos.obtener(rut);
        if(alumnoBuscado != null)
            alumnoBuscado.mostrar();
        else
            System.out.println("No se encuentra el alumno con el rut ingresado");
    }

    public void buscarAlumnosPorCarrera(BufferedReader lector)throws IOException{
        System.out.println("Porfavor ingresar la Carrera a buscar: ");
        String carreraBuscada = lector.readLine();
        boolean hayAlumnosCarrera = false;
        
        if (contenedorAlumnos.talla() != 0) {
            for (int i = 0; i < contenedorAlumnos.talla() ; i++) {
                Alumno alumnoActual = contenedorAlumnos.obtener(i);
                String nombreCarrera = alumnoActual.getCarrera().getNombre();

                if (nombreCarrera.equals(carreraBuscada)) {
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
    public void eliminarCarrera(BufferedReader lector) throws IOException{
        System.out.println("Porfavor ingresar el ID de la carrera a eliminar");
        String idEliminar = lector.readLine();
        
        Carrera carreraEliminar = contenedorCarreras.eliminar(idEliminar);

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
            if (idEliminar.equals(idCarreraAlumno)) {
                alumnoActual.setCarrera(new Carrera());
            }
        }
    }

    public void eliminarProfesor(BufferedReader lector) throws IOException{
        System.out.println("Porfavor ingresar el rut del profesor a eliminar");
        String rutEliminar = lector.readLine();

        Profesor profesorEliminar = contenedorProfesores.eliminar(rutEliminar);

        if(profesorEliminar != null)
            profesorEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra el rut ingresado");
            return;
        }
    }

    public void eliminarAlumno(BufferedReader lector) throws IOException{
        System.out.println("Porfavor ingresar el rut del alumno a eliminar");
        String rutEliminar = lector.readLine();

        Alumno alumnoEliminar = contenedorAlumnos.eliminar(rutEliminar);

        if(alumnoEliminar != null)
            alumnoEliminar.mostrar(true);
        else {
            System.out.println("No se encuentra el rut ingresado");
            return;
        }
    }





    /* = = = = = = = = = =           = = = = = = = = = = */

    //modificar, hay que dividirla entre las clases participantes
    public void actualizacionEstado(BufferedReader lector)throws IOException{
        
        int creditosAprobados = 0;
        System.out.println("Ingresa el rut del Alumno al cual actualizar su estado");
        String rut = lector.readLine();

        Alumno alumnoBuscado = contenedorAlumnos.obtener(rut);

        if (alumnoBuscado == null) {
            System.out.println("Alumno NO encontrado");
            return;
        }

        alumnoBuscado.mostrar(true);
        
        Carrera carreraAlumno = alumnoBuscado.getCarrera();

        System.out.println("Deseas actualizar los estados de asignaturas");
        System.out.println("1.- SI");
        System.out.println("2.- NO");
        String opcion = lector.readLine();

        if (Integer.parseInt(opcion) == 2){
            System.out.println("Muchas Gracias");
            return;
        }
        else {

            for (int i = 0 ; i < carreraAlumno.cantidadAsignaturas() ; i++){
                AsignaturaInscrita asigaturaActual = (AsignaturaInscrita) carreraAlumno.obtenerAsignatura(i);

                System.out.println("Porfavor selecciona una opcion para ver si cursaste o ya aprobaste la asignatura de : " + asigaturaActual.getNombre());
                System.out.println("1.- APROBADO");
                System.out.println("2.- REPORBADO");
                int estadoActualizado = Integer.parseInt(lector.readLine());
                if(estadoActualizado == 1) {
                    creditosAprobados += asigaturaActual.getCreditos();
                    asigaturaActual.aprobar();
                }
                else {
                    asigaturaActual.reprobar();
                }
            }   

            System.out.println("Tus estados de asignatura han sido actualizados con exito");
        }
        alumnoBuscado.setCreditosAprobados(creditosAprobados);
    }

    public void mostrarEstadoAsignaturas(BufferedReader lector)throws IOException {
                
        System.out.println("Hola podrias darme el rut del Alumno al cual actualizar su estado");
        String rut = lector.readLine();

        Alumno alumnoBuscado = contenedorAlumnos.obtener(rut);

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

    public void agregarAsignaturaProfe(BufferedReader lector) throws IOException {
        mostrarProfesores();
        System.out.print("Ingresa RUT profesor: ");
        String rutProfesor = lector.readLine();
        Profesor profesor = contenedorProfesores.obtener(rutProfesor);
        if (profesor == null) {
            System.out.print("profesor no encontrado");
            return;
        }
        profesor.mostrar(true);
        
        mostrarCarreras();
        System.out.print("Ingresa Id carrera: ");
        String idCarrera = lector.readLine();
        Carrera carrera = contenedorCarreras.obtener(idCarrera);
        if (carrera == null) {
            System.out.print("Carrera no encontrada");
            return;
        }
        carrera.mostrar();
        
        System.out.print("Ingresa el codigo de la asignatura: ");
        String codigoAsignatura = lector.readLine();
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


    public void eliminarAsignaturaProfe(BufferedReader lector)  throws IOException {
        System.out.print("Ingresa profesor: ");
        String rutProfesor = lector.readLine();
        Profesor profesor = contenedorProfesores.obtener(rutProfesor);
        if (profesor == null) {
            System.out.print("profesor no encontrado");
            return;
        }
        profesor.mostrar(true);

        System.out.print("Ingresa codigo: ");
        String codigoAsignatura = lector.readLine();
        Asignatura asignatura = profesor.elimarAsignatura(codigoAsignatura);
        if (asignatura == null) {
            System.out.print("no encontrado");
            return;
        }
        System.out.print("eliminado");
        asignatura.mostrar();

    }
}

