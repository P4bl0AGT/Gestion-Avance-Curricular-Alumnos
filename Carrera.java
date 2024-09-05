import java.util.ArrayList;

public class Carrera {

    //Atributos
    private String id;
    private String nombre;
    private int semestres;
    private ArrayList listaAsignaturas;
    private int creditosTotales;

    //Constructor
    public Carrera() {}

    public Carrera(String id, String nombre, int semestres, ArrayList listaAsignaturas, int creditosTotales) {
        setId(id);
        setNombre(nombre);
        setSemestres(semestres);
        setListaAsignaturas(listaAsignaturas);
        setCreditosTotales(creditosTotales);
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

    public void setCreditosTotales(int creditosTotales)
    {
        if(creditosTotales >= 0)
            this.creditosTotales = creditosTotales;
        else
            this.creditosTotales = 0;
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

    public int getCreditosTotales()
    {
        return creditosTotales;
    }

    //Metodos
    public void mostrarDetalle() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Semestres: " + semestres);
        System.out.println("Creditos Totales: " + creditosTotales);
        System.out.println("Asignaturas: ");
        for (Object aux:listaAsignaturas) {
            Asignatura asignatura = (Asignatura) aux;
            System.out.println("    " + asignatura.getNombre());
        }
    }

    public void mostrarSimple(){System.out.println("Nombre: " + nombre + " | Semestres " + semestres);}
}
