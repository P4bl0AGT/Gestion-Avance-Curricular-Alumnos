import java.util.ArrayList;

public class Carrera {

    //Atributos
    private String id;
    private String nombre;
    private int semestres;
    private ArrayList<Asignatura> listaAsignaturas;

    //Constructor
    public Carrera() {}

    public Carrera(String id, String nombre, int semestres, ArrayList<Asignatura> listaAsignaturas) {
        setId(id);
        setNombre(nombre);
        setSemestres(semestres);
        setListaAsignaturas(listaAsignaturas);
    }

    //Setters
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

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestres() {
        return semestres;
    }

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    //Metodos
    public void mostrar() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Semestres: " + semestres);
        System.out.println("Asignaturas: ");
        for (Asignatura aux:listaAsignaturas) {
            System.out.println("    " + aux.getNombre());
        }
    }

}
