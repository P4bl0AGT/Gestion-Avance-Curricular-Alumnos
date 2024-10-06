package modelo;

/**
 * Esta clase representa una asignatura con un código, un nombre y una cantidad de créditos.
 */
public class Asignatura
{
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private String codigo;
    private String nombre;
    private int creditos;
    
    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    /**
     * Crea una nueva instancia de {@code Asignatura} sin inicializar sus atributos.
     */
    public Asignatura(){}
    
    
    /**
     *Crea una nueva instancia de {@code Asignatura} con los datos especificados.
    * @param codigo El codigo de la asignatura
    * @param nombre El nombre de la asignatura
    * @param creditos Los creditos de la asignatura
    */
    public Asignatura(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    /**
     * Metodo que establece el nombre de la asignatura
     * @param nombre El nombre de la asignatura
     */
    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }
    
    
    /**
     * Metodo que establece el codigo de la asignatura
     * @param codigo El codigo de la asignatura
     */
    public void setCodigo(String codigo) {
        if(codigo != null)
            this.codigo = codigo;
        else
            this.codigo = "nulo";
    }
    
    
    /**
     * Metodo que establece los creditos de la asignatura
     * @param creditos Los creditos de la asignatura
     */
    public void setCreditos(int creditos) {
        if(creditos >= 0)
            this.creditos = creditos;
        else
            this.creditos = 0;
    }
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================  
    /**
     * Metodo que obtiene el codigo de la asignatura
     * @return El codigo de la asignatura
     */
    public String getCodigo() {
        return codigo;}
    
    
    /**
     * Metodo que obtiene el nombre de la asignatura
     * @return El nombre de la asignatura
     */
    public String getNombre() {
        return nombre;}
    
    
    /**
     * Metodo que obtiene los creditos de la asignatura
     * @return Los creditos de la asignatura
     */
    public int getCreditos() {
        return creditos;}
    
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================
    /**
     * Metodo que retorna los atributos de la asignatura de manera simple
     * @return cadena con los atributos
     */
    public String obtenerString() {
       return (codigo + "," + nombre + "," + creditos + "\n");
    }
    
    
    
    
    
    // =========================================================================
    // =========================== OBSOLETOS ===================================
    // =========================================================================
    {
    /*
        public void mostrar() {
            System.out.println("Codigo asignatura: " + codigo);
            System.out.println("Nombre asignatura: " + nombre);
            System.out.println("Creditos asignatura: " + creditos);
        }

        public void mostrar(boolean simple){ 
            System.out.println(" | " + codigo + " | ");
        }
    */
    }
}
