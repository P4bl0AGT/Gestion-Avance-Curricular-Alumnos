package modelo;

import java.util.Iterator;

public class Carrera {
    //ATRIBUTOS
    private String id;
    private String nombre;
    private int semestres;
    private Contenedor<String, Asignatura> asignaturas;


    //CONSTRUCTOR
    public Carrera() {}

    public Carrera(String id, String nombre, int semestres) {
        this.id = id;
        this.nombre = nombre;
        this.semestres = semestres;
        asignaturas = new Contenedor<>();
    }


    //SETTERS
    public void setId(String id) {
        if(id != null)
            this.id = id;
        else
            this.id = "nulo";
    }

    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }

    public void setSemestres(int semestres) {
        if(semestres != 0)
            this.semestres = semestres;
        else
            this.semestres = 0;
    }


    //GETTERS
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestres() {
        return semestres;
    }


    //METODOS
    public void mostrar() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Semestres: " + semestres);
        System.out.println("Asignaturas: ");
        Iterator<Asignatura> iterador = asignaturas.iterador();
        while (iterador.hasNext()) {
            Asignatura aux = iterador.next();
            aux.mostrar();
        }
        System.out.println("");
    }

    public void mostrar(boolean simple) {
        System.out.println(" | " + id + " | " + nombre + " | " + semestres + " | ");
    }

    public int cantidadAsignaturas() {
        return asignaturas.talla();
    }

    public boolean agregarAsignatura(Asignatura asignatura) {
        return asignaturas.agregar(asignatura.getCodigo(), asignatura);
    }

    public Asignatura obtenerAsignatura(int i) {
        return asignaturas.obtener(i);
    }

    public Asignatura obtenerAsignatura(String codigo) {
        return asignaturas.obtener(codigo);
    }

    public int cantidadCreditos() {
        int total = 0;
        Iterator<Asignatura> iterador = asignaturas.iterador();
        while (iterador.hasNext()) {
            Asignatura aux = iterador.next();
            total += aux.getCreditos();
        }
        return total;
    }

    public Carrera copiaParaInscribir() {
        String idCopia = id;
        String nombreCopia = nombre;
        int semestresCopia = semestres;

        Carrera copia = new Carrera(idCopia, nombreCopia, semestresCopia);
        return copia;
    }
}
