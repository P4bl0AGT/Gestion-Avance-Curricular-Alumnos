package modelo;

/**
 * La clase Persona representa a una persona con atributos básicos como nombre, apellido, RUT y edad.
 * Proporciona métodos para acceder y modificar estos atributos, así como para obtener una representación
 * en forma de cadena de la persona.
 */
public class Persona {
    
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;

    

    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    /**
     * Constructor que inicializa una nueva instancia de Persona con el nombre, apellido, RUT y edad especificados.
     *
     * @param nombre el nombre de la persona
     * @param apellido el apellido de la persona
     * @param rut el RUT de la persona
     * @param edad la edad de la persona
     */
    public Persona(String nombre, String apellido,String rut, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.rut = rut;
    }
    

    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================
    /**
     * Obtiene el nombre de la persona.
     *
     * @return el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Obtiene el apellido de la persona.
     *
     * @return el apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }
    
    
    /**
     * Obtiene la edad de la persona.
     *
     * @return la edad de la persona
     */
    public int getEdad() {
        return edad;
    }
    
    
    /**
     * Obtiene el RUT de la persona.
     *
     * @return el RUT de la persona
     */
    public String getRut() {
        return rut;
    }
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    /**
     * Establece el nombre de la persona. Si el nombre es nulo, se establece como "nulo".
     *
     * @param nombre el nuevo nombre de la persona
     */
    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }
    
    
    /**
     * Establece el apellido de la persona. Si el apellido es nulo, se establece como "nulo".
     *
     * @param apellido el nuevo apellido de la persona
     */
    public void setApellido(String apellido) {
        if(apellido != null)
            this.apellido = apellido;
        else
            this.apellido = "nulo";
    }
    
    
    /**
     * Establece la edad de la persona. Si la edad es menor o igual a cero, se establece como 0.
     *
     * @param edad la nueva edad de la persona
     */
    public void setEdad(int edad) {
        if(edad > 0)
            this.edad = edad;
        else
            this.edad = 0;
    }
    
    
    /**
     * Establece el RUT de la persona. Si el RUT es nulo, se establece como "nulo".
     *
     * @param rut el nuevo RUT de la persona
     */
    public void setRut(String rut) {
        if(rut != null)
            this.rut = rut;
        else
            this.rut = "nulo";
    }
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================
    /**
     * Obtiene una representación en forma de cadena de la persona, incluyendo nombre, apellido, edad y RUT.
     *
     * @return una cadena con la información de la persona
     */
    public String obtenerString() {
        return (nombre +","+ apellido +","+ edad +","+ rut);
    }

}

