package modelo;

/**
 * La clase AsignaturaInscrita representa una asignatura que ha sido inscrita
 * por un estudiante, incluyendo su estado actual y la nota obtenida.
 * Extiende de la clase Asignatura.
 */
public class AsignaturaInscrita extends Asignatura{
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private estadoAsignatura estado;
    private int nota;
    
    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    /**
     * Constructor por defecto de la clase AsignaturaInscrita.
     */
    public AsignaturaInscrita() {};
    
    
    /**
     * Constructor que inicializa los atributos de la asignatura inscrita.
     * @param codigo El codigo de la asignatura
     * @param nombre El nombre de la asignatura
     * @param creditos Los creditos de la asignatura
     * @param estado El estado de la asignatura
     * @param nota La nota de la asignatura
     */
    public AsignaturaInscrita(String codigo, String nombre, int creditos, estadoAsignatura estado, int nota) {
        super(codigo, nombre, creditos);
        this.estado = estado;
        this.nota = nota;
    }
    
    
    /**
     * Constructor que inicializa los atributos de la asignatura inscrita con estado INSCRITO y nota 0.
     * @param codigo El codigo de la asignatura
     * @param nombre El nombre de la asignatura
     * @param creditos Los creditos de la asignatura
     */
    public AsignaturaInscrita(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
        this.estado = estadoAsignatura.INSCRITO;
        this.nota = 0;
    }
    
    
    /**
     * Constructor que inicializa la asignatura inscrita a partir de una asignatura existente.
     *
     * @param asignatura La asignatura de la cual se creará la asignatura inscrita.
     */
    public AsignaturaInscrita (Asignatura asignatura) {
        this.setCodigo(asignatura.getCodigo());
        this.setNombre(asignatura.getNombre());
        this.setCreditos(asignatura.getCreditos());
        inscribir();
        nota = 0;
    }
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // ========================================================================= 
    /**
     * Metodo que establece el estado de la asignatura
     * @param estado El estado de la asignatura
     */
    public void setEstado(estadoAsignatura estado) {
        this.estado = estado;}
    
    
    /**
     * Metodo que establece la nota de la asignatura
     * @param nota La nota de la asignatura
     */
    public void setNota(int nota) {
        this.nota = nota;}
    
    
    
    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================   
    /**
     * Metodo que obtiene la nota de la asignatura
     * @return La nota de la asignatura
     */
    public int getNota() {
        return nota;}
    /**
     * Metodo que obtiene el estado de la asignatura
     * @return El estado de la asignatura
     */
    public estadoAsignatura getEstado() {
        return estado;}
    
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // ========================================================================= 
    /**
     * Metodo que establece el estado de la asignatura en INSCRITO
     */
    public void inscribir() {
        estado = estadoAsignatura.INSCRITO;}
    
    
    /**
     * Metodo que establece el estado de la asignatura en APROBADO
     */
    public void aprobar() {
        estado = estadoAsignatura.APROBADO;}
    
    
    /**
     * Metodo que establece el estado de la asignatura en REPROBADO
     */
    public void reprobar() {
        estado = estadoAsignatura.REPROBADO;}
    
    
    /**
     * Modifica la nota y el estado de la asignatura inscrita.
     *
     * @param estado El nuevo estado de la asignatura.
     * @param nota La nueva nota de la asignatura.
     */
    public void modificarNotayEstado(estadoAsignatura estado, int nota) {
        this.estado = estado;
        this.nota = nota;
    }
    
    
    /**
     * Enum que representa los diferentes estados que puede tener una asignatura inscrita
     */
    public enum estadoAsignatura {
        INSCRITO,
        APROBADO,
        REPROBADO
    }
    
    @Override
    public String obtenerString() {
       return (getCodigo() + "," + getNombre() +","+ getCreditos() +","+ estado.name() +","+ nota + "\n");
    }
    
    
    
    
    // =========================================================================
    // =========================== OBSOLETOS ===================================
    // =========================================================================
    {
    /*
        public void mostrar() {
            System.out.println("Nombre asignatura: " + getNombre());
            System.out.println("Codigo asignatura: " + getCodigo());
            System.out.println("Creditos asignatura: " + getCreditos());
            System.out.println("Estado: " + estado);
            System.out.println("Nota: " + nota);
        }
        
        public void mostrar(boolean simple) { 
            System.out.println(" | " + getCodigo() + " | " + estado +  " | ");
        }
    */
    }
}

