import java.util.ArrayList;

public class Carrera {

    //Atributos
    private String id;
    private String nombre;
    private int semestres;
    private ArrayList listaAsignaturas;
    private int avance;

    //Constructor
    public Carrera() {}

    public Carrera(String id, String nombre, int semestres, ArrayList listaAsignaturas, int avance) {
        setId(id);
        setNombre(nombre);
        setSemestres(semestres);
        setListaAsignaturas(listaAsignaturas);
        setAvance(avance);
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

    public void setListaAsignaturas(ArrayList listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public void setAvance(int avance)
    {
        if(avance >= 0)
            this.avance = avance;
        else
            this.avance = 0;
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

    public ArrayList getListaAsignaturas() {
        return listaAsignaturas;
    }

    public int getAvance()
    {
        return avance;
    }

    //Metodos
    public void mostrar() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Semestres: " + semestres);
        System.out.println("Avance: " + avance);
        System.out.println("Asignaturas: ");
        for (Object aux:listaAsignaturas) {
            Asignatura asignatura = (Asignatura) aux;
            System.out.println("    " + asignatura.getNombre());
        }
    }
}
