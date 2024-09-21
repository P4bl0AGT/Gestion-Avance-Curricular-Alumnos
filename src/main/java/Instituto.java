import java.io.*;

public class Instituto
{
    //ATRIBUTOS
    private Contenedor<String, Carrera> contenedorCarreras;
    private Contenedor<String, Alumno> contenedorAlumnos;
    private Contenedor<String, Profesor> contenedorProfesores;

    //CONSTRUCTOR
    public Instituto() {
        contenedorCarreras = new Contenedor<>();
        contenedorAlumnos = new Contenedor<>();
        contenedorProfesores = new Contenedor<>();
    }

    public int cantidadCarreras() {
        return contenedorCarreras.cantidadElementos();
    }
    public Carrera obtenerCarrera(int i) {
        return contenedorCarreras.obtener(i);
    }
    public boolean agregarCarrera(Carrera carrera) {
        return contenedorCarreras.agregar(carrera.getId(), carrera);
    }

    public boolean agregarAlumno(Alumno alumno) {
        return contenedorAlumnos.agregar(alumno.getRut(), alumno);
    }

    //METODOS
    public void mostrarCarreras() {
        System.out.println("Lista Carreras");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < contenedorCarreras.cantidadElementos() ; i++)
        {
            Carrera carreraActual = contenedorCarreras.obtener(i);
            carreraActual.mostrar(true);
        }
    }

    public void mostrarAlumnos() {
        System.out.println("Lista Alumnos");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < contenedorAlumnos.cantidadElementos() ; i++)
        {
            Alumno alumnoActual = contenedorAlumnos.obtener(i);
            alumnoActual.mostrar(true);
        }
    }

    public void mostrarProfesores() {
        System.out.println("Lista Carreras");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < contenedorProfesores.cantidadElementos() ; i++)
        {
            Profesor profesorActual = contenedorProfesores.obtener(i);
            profesorActual.mostrar(true);
        }
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


    public void buscarAlumnosPorCarrera(BufferedReader lector)throws IOException{
        System.out.println("Porfavor ingresar la Carrera a buscar: ");
        String carrera = lector.readLine();
        Alumno alumnoCarrera;
        boolean hayAlumnosCarrera = false;
        
        if (contenedorAlumnos.cantidadElementos() != 0) {
            for (int i = 0; i < contenedorAlumnos.cantidadElementos() ; i++) {
                alumnoCarrera = contenedorAlumnos.obtener(i);
                if (alumnoCarrera.getCarrera().getNombre().equals(carrera)) {
                    alumnoCarrera.mostrar();
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

    

    //modificar, hay que dividirla entre las clases participantes
    public void actualizacionEstado(BufferedReader lector)throws IOException{
        
        int creditosAprobados = 0;
        System.out.println("Hola podrias darme el rut del Alumno al cual actualizar su estado");
        String rut = lector.readLine();

        Alumno alumnoBuscado = contenedorAlumnos.obtener(rut);

        if (alumnoBuscado == null){
            System.out.println("Alumno NO encontrado");
            return;
        }
        System.out.println("Alumno : " + alumnoBuscado.getNombre() + " " + alumnoBuscado.getApellido());
        
        Carrera carreraAlumno = alumnoBuscado.getCarrera();

        System.out.println("Deseas actualizar los estados de asignaturas");
        System.out.println("1.- SI");
        System.out.println("2.- NO");
        String opcion = lector.readLine();

        if (Integer.parseInt(opcion) == 2)
        {
            System.out.println("Muchas Gracias");
            return;
        }
        else{

            for (int i = 0 ; i < carreraAlumno.cantidadAsignaturas() ; i++)
            {
                AsignaturaInscrita asignaturaInscrita = (AsignaturaInscrita) carreraAlumno.obtenerAsignatura(i);

                System.out.println("Porfavor selecciona una opcion para ver si cursaste o ya aprobaste la asignatura de : " + asignaturaInscrita.getNombre());
                System.out.println("0.- SIN INICIAR");
                System.out.println("1.- EN CURSO");
                System.out.println("2.- COMPLETADO");
                int estadoActualizado = Integer.parseInt(lector.readLine());
                if(estadoActualizado == 2) creditosAprobados += asignaturaInscrita.getCreditos();
                asignaturaInscrita.setEstado(estadoActualizado);
            }   

            System.out.println("Tus estados de asignatura han sido actualizados con exito");
        }
        alumnoBuscado.setCreditosAprobados(creditosAprobados);

    }

    public void mostrarEstadoAsignaturas(BufferedReader lector)throws IOException{
                
        System.out.println("Hola podrias darme el rut del Alumno al cual actualizar su estado");
        String rut = lector.readLine();

        Alumno alumnoBuscado = contenedorAlumnos.obtener(rut);

        if (alumnoBuscado == null){
            System.out.println("Alumno NO encontrado");
            return;
        }
        alumnoBuscado.mostrar();
        
        Carrera carreraAlumno = alumnoBuscado.getCarrera();

        for (int i = 0 ; i < carreraAlumno.cantidadAsignaturas() ; i++)
            {
                AsignaturaInscrita asignatura = (AsignaturaInscrita) carreraAlumno.obtenerAsignatura(i);
                
                if(asignatura.getEstado() == 0) {
                    System.out.println("La asignatura " + asignatura.getNombre() + " aun no inicia");
                }
                else if (asignatura.getEstado() == 1){
                    System.out.println("La asignatura " + asignatura.getNombre() + " esta en proceso");
                }
                else if (asignatura.getEstado() == 2){
                    System.out.println("La asignatura " + asignatura.getNombre() + " esta completa");
                }

            }
            System.out.println("Creditos totales: " + alumnoBuscado.getCreditosAprobados());
        }

    }
