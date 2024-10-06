package modelo;

/**
 * Esta clase representa a un alumno que extiende de la clase {@code Persona}.
 * Un alumno tiene un nombre, apellido, RUT, edad, carrera y cantidad de créditos aprobados.
 */
public class Alumno extends Persona{

    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private int creditosAprobados;
    private Carrera carrera;

    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    /**
    * @param nombre El nombre del alumno
    * @param apellido El apellido del alumno
    * @param rut El rut del alumno
    * @param edad La edad del alumno
    * @param carrera La carrera del alumno
    */
    public Alumno(String nombre, String apellido, String rut, int edad, Carrera carrera) {
        super(nombre, apellido, rut, edad);
        this.carrera = carrera;
        creditosAprobados = 0;
    }
    
    
    /**
    * @param nombre El nombre del alumno
    * @param apellido El apellido del alumno
    * @param rut El rut del alumno
    * @param edad La edad del alumno
    */
    public Alumno(String nombre, String apellido, String rut, int edad) {
        super(nombre, apellido, rut, edad);
        carrera = null;
        creditosAprobados = 0;
    }
    
    
     /**
    * @param nombre El nombre del alumno
    * @param apellido El apellido del alumno
    * @param rut El rut del alumno
    * @param edad La edad del alumno
    * @param creditosAprobados La cantidad de creditos que el alumno tiene aprobados
    */
    public Alumno(String nombre, String apellido, String rut, int edad, int creditosAprobados) {
        super(nombre, apellido, rut, edad);
        carrera = null;
        this.creditosAprobados = creditosAprobados;
    }
    
    
    
    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================   
    /**
     * Metodo que obtiene la carrera del alumno
     * @return La carrera del alumno
     */
    public Carrera getCarrera() {
        return carrera;}
    
    
    /**
     * Metodo que obtiene los creditos aprobados del alumno
     * @return la cantidad de creditos aprobados del alumno
     */
    public int getCreditosAprobados() {
        return creditosAprobados;}
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    /**
     * Metodo que establece la carrera del alumno
     * @param carrera La carrera del alumno
     */
    public void setCarrera(Carrera carrera) {
        if(carrera != null ) 
            this.carrera = carrera;
        else
            this.carrera = null;
    }
     /**
     * Metodo que establece los creditos aprobados por el alumno
     * @param creditosAprobados Los creditos aprobados por el alumno
     */
    public void setCreditosAprobados(int creditosAprobados){
        if(creditosAprobados > 0)
            this.creditosAprobados = creditosAprobados;
        else
            this.creditosAprobados = 0;
    }
    
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================
    /**
     * Metodo que inscribe una carrera a un alumno
     * @param carrera Carrera a inscribir al alumno
     */
    public void inscribirCarrera(Carrera carrera) {

        Carrera carreraAlumno = carrera.copiaParaInscribir();

        for (int i = 0; i < carrera.cantidadAsignaturas(); i++) {
            Asignatura asignaturaActual = carrera.obtenerAsignatura(i);
            AsignaturaInscrita inscrita = new AsignaturaInscrita(asignaturaActual);

            carreraAlumno.agregarAsignatura(inscrita);
        }
        setCarrera(carreraAlumno);
    }

    
    /**
     * Metodo que obtiene la cantidad de asignaturas de un alumno
     * @return Cantidad de asignaturas del alumno
     */
    public int obtenerCantidadAsignaturas() {
        return carrera.cantidadAsignaturas();}
    
    
    /**
     * Metodo que obtiene una cadena con los atributos del alumno
     * Sobrescribe Persona#obtenerString()
     * @return cadena con los atributos del alumno
     */
    @Override
    public String obtenerString() {
       return (getNombre() + "," + getApellido() + "," + getRut() + "," + Integer.toString(getEdad()) + "," + carrera.getId() + "\n");
    }
    
    
    /**
     * @param completo Indica si incluye los creditos aprobados
     * Metodo que obtiene una cadena con los atributos del alumno
     * @return cadena con los atributos del alumno
     */
    public String obtenerString(boolean completo) {
       return (getNombre() + "," + getApellido() + "," + getRut() + "," + getEdad() + "," + creditosAprobados + "," + carrera.getId() + "\n");
    }

    
    
    
    // =========================================================================
    // =========================== OBSOLETOS ===================================
    // =========================================================================
    {
    /*
        public void mostrar() {
            System.out.println("Nombre del Alumno: " + getNombre());
            System.out.println("Apellido del Alumno: " + getApellido());
            System.out.println("Edad del Alumno: " + getEdad());
            System.out.println("Rut del Alumno: " + getRut());
            System.out.println("Carrera del alumno: "+ carrera.getNombre());
            System.out.println("Creditos aprovados: "+ creditosAprobados);
        }

        public void mostrar(boolean simple) {
            System.out.println(" | " + getNombre() + " | " + getRut() + " | " + carrera.getNombre() + " | ");
        }



        public AsignaturaInscrita incribirAsignatura(Asignatura asignatura) {
            String codigo = asignatura.getCodigo();
            String nombre = asignatura.getNombre();
            int creditos = asignatura.getCreditos();
            Enums.estadoAsignatura estado = Enums.estadoAsignatura.INSCRITO;
            int nota = 0;
            AsignaturaInscrita inscrita = new AsignaturaInscrita(codigo, nombre, creditos, estado, nota);
            return inscrita;
        }
    */
    } 
}

