package modelo;

import java.util.Iterator;

/**
 * La clase Carrera representa una carrera académica que incluye un conjunto
 * de asignaturas, su identificación, nombre y cantidad de semestres.
 */
public class Carrera {
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private String id;
    private String nombre;
    private int semestres;
    private Contenedor<String, Asignatura> asignaturas;
    
    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    public Carrera() {}
    /**
     * Constructor que inicializa los atributos de la carrera.
     * @param id El id  de la carrera
     * @param nombre El nombre de la carrera
     * @param semestres Los creditos de la carrera
     */
    public Carrera(String id, String nombre, int semestres) {
        this.id = id;
        this.nombre = nombre;
        this.semestres = semestres;
        asignaturas = new Contenedor<>();
    }
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    /**
     * Metodo que establece el id de la carrera
     * @param id El identificador de la carrera
     */
    public void setId(String id) {
        if(id != null)
            this.id = id;
        else
            this.id = "nulo";
    }
    
    
    /**
     * Metodo que establece el nombre de la carrera
     * @param nombre El nombre de la carrera
     */
    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }
    
    
    /**
     * Metodo que establece la cantidad de semestres de la carrera
     * @param semestres La cantidad de semestres de la carrera
     */
    public void setSemestres(int semestres) {
        if(semestres != 0)
            this.semestres = semestres;
        else
            this.semestres = 0;
    }
    
    
    
    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================
    /**
     * Metodo que obtiene el id de la carrera
     * @return El id de la carrera
     */
    public String getId() {
        return id;}
    
    
    /**
     * Metodo que obtiene el nombre de la carrera
     * @return El nombre de la carrera
     */
    public String getNombre() {
        return nombre;}
    
    
    /**
     * Metodo que obtiene la cantidad de semestres de la carrera
     * @return La cantidad de semestrese de la carrera
     */
    public int getSemestres() {
        return semestres;}
    
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================
    /**
     * Metodo que obtiene la cantidad de asignaturas de la carrera
     * @returns La cantidad de asignaturas de la carrera
     */
    public int cantidadAsignaturas() {
        return asignaturas.talla();}
    
    
    /**
     * Metodo que agrega una asignatura a la carrera
     * @returns un bool que es true si se agrego y un false si no
     */
    public boolean agregarAsignatura(Asignatura asignatura) {
        return asignaturas.agregar(asignatura.getCodigo(), asignatura);}
    
    
    /**
     * Metodo que obtiene una asignatura de la carrera
     * @param i El indice de la asignatura que quiero
     * @returns la asignatura con el indice correspondiente
     */
    public Asignatura obtenerAsignatura(int i) {
        return asignaturas.obtener(i);}
    
    
    /**
     * Metodo que obtiene una asignatura de la carrera
     * @param codigo El codigo de la asignatura que quiero
     * @returns la asignatura con el codigo correspondiente
     */
    public Asignatura obtenerAsignatura(String codigo) {
        return asignaturas.obtener(codigo);
    }
    
    
    /**
     * Metodo que calcula la cantidad de creditos de la carrera
     * @returns La cantidad de creditos de la carrera
     */
    public int cantidadCreditos() {
        int total = 0;
        Iterator<Asignatura> iterador = asignaturas.iterador();
        while (iterador.hasNext()) {
            Asignatura aux = iterador.next();
            total += aux.getCreditos();
        }
        return total;
    }
    
    
    /**
     * Metodo que copia y retorna una carrera
     * @returns Una nueva instancia de la carrera con los mismos atributos
     */
    public Carrera copiaParaInscribir() {
        String idCopia = id;
        String nombreCopia = nombre;
        int semestresCopia = semestres;

        Carrera copia = new Carrera(idCopia, nombreCopia, semestresCopia);
        return copia;
    }
    
    
    /**
     * Retorna una cadena que representa los atributos de la carrera.
     * Metodo que retorna una cadena con los atributos de la carrera
     * @returns Una cadena con los atributos de la carrera
     */
    public String obtenerString() {
       return (id + "," + nombre + "," + Integer.toString(semestres) + "\n");
    }
    
    
    /**
     * Metodo que enlista las asignaturas de manera simple
     * @returns Una cadena con las asignaturas
     */
    public String listarAsignaturas(){
        String cc = "";
        Iterator<Asignatura> iterable = asignaturas.iterador();
        while (iterable.hasNext()) {
            Asignatura asignatura = iterable.next();
            cc += asignatura.obtenerString();
        }
        return cc;
    }
    
    
    /**
     * Metodo que enlista las asignaturas de manera completa
     * @returns Una cadena con las asignatura
     * @param completo boleano que indica que quiero el id de la carrera tambien
     */
    public String listarAsignaturas(boolean completo){
        String cc = "";
        Iterator<Asignatura> iterable = asignaturas.iterador();
        while (iterable.hasNext()) {
            Asignatura asignatura = iterable.next();
            cc += (this.id + "," + asignatura.obtenerString());
        }
        return cc;
    }
    
    
    
    
    // =========================================================================
    // =========================== OBSOLETOS ===================================
    // =========================================================================
    {
    /*
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
    */
    }
}
