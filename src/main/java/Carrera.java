import java.util.ArrayList;

public class Carrera {
    //ATRIBUTOS
    private String id;
    private String nombre;
    private int semestres;
    private ArrayList<Asignatura> listaAsignaturas;


    //CONSTRUCTOR
    public Carrera() {}

    public Carrera(String id, String nombre, int semestres) {
        this.id = id;
        this.nombre = nombre;
        this.semestres = semestres;
        listaAsignaturas = new ArrayList<Asignatura>();
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
        for (Asignatura asignaturaActual:listaAsignaturas) {
            System.out.print("  ");
            asignaturaActual.mostrar(true);
        }
        System.out.println("");
    }

    public void mostrar(boolean simple) {
        System.out.println(" | " + id + " | " + nombre + " | " + semestres + " | ");
    }


    public int cantidadAsignaturas() {
        return listaAsignaturas.size();
    }

    public void agregarAsignatura(Asignatura asignatura) {
        listaAsignaturas.add(asignatura);
    }

    public Asignatura obtenerAsignatura(int i) {
        return listaAsignaturas.get(i);
    }

    public int cantidadCreditos() {
        int total = 0;
        for (Asignatura aux:listaAsignaturas)
            total += aux.getCreditos();
        return total;
    }

    public AsignaturaInscrita incribirAsignatura(Asignatura asignatura) {
        String codigo = asignatura.getCodigo();
        String nombre = asignatura.getNombre();
        int creditos = asignatura.getCreditos();
        int estado = 0;
        int nota = 0;
        AsignaturaInscrita inscrita = new AsignaturaInscrita(codigo, nombre, creditos, estado, nota);
        return inscrita;
    }

    public Carrera inscribirCarrera()
    {
        String id = getId();
        String nombre = getNombre();
        int semestres = getSemestres();
        Carrera nuevaCarrera = new Carrera(id, nombre, semestres);

        for (Asignatura aux:listaAsignaturas) {
            AsignaturaInscrita nuevaAsignatura = incribirAsignatura(aux);
            nuevaCarrera.agregarAsignatura(nuevaAsignatura);
        }

        return nuevaCarrera;
    }
}
