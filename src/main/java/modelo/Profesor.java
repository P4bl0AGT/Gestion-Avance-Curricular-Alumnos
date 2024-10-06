package modelo;

import java.util.Iterator;

/**
 * La clase {@code Profesor} representa a un profesor que extiende de {@code Persona}
 * tiene un nombre, apellido, RUT, edad y una colección de asignaturas que imparte.
 */
public class Profesor extends Persona{
    
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private Contenedor<String, Asignatura> ContenedorAsignaturas;
    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    /**
     * Crea una nueva instancia de {@code Profesor} con los datos especificados.
     * 
     * @param nombre  el nombre del profesor.
     * @param apellido  el apellido del profesor.
     * @param rut  el RUT del profesor.
     * @param edad  la edad del profesor.
     */
    public Profesor(String nombre, String apellido, String rut, int edad) {
        super(nombre, apellido, rut, edad);
        ContenedorAsignaturas = new Contenedor<>();
    }
    
    
    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================
    // No contiene ya que su atributo es una coleccion
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    // No contiene ya que su atributo es una coleccion
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================
    /**
     * Agrega una asignatura a la colección de asignaturas del profesor.
     * @param asignatura la asignatura a agregar.
     * @return {@code true} si la asignatura fue agregada exitosamente; 
     *         {@code false} si ya existe una asignatura con el mismo código.
     */
    public boolean agregarAsignatura(Asignatura asignatura) {
        return ContenedorAsignaturas.agregar(asignatura.getCodigo(), asignatura);
    }

    
    /**
     * Elimina una asignatura de la colección de asignaturas del profesor.
     * @param codigo el código de la asignatura a eliminar.
     * @return la asignatura eliminada, o {@code null} si no se encontró.
     */
    public Asignatura elimarAsignatura(String codigo) {
        return ContenedorAsignaturas.eliminar(codigo);
    }
    
    
    /**
     * Obtiene una asignatura de la colección utilizando su código.
     * @param id el código de la asignatura a obtener.
     * @return la asignatura correspondiente al código, o {@code null} si no se encontró.
     */
    public Asignatura obtenerAsignatura(String id) {
        return ContenedorAsignaturas.obtener(id);
    }
    
    
    /**
     * Cuenta la cantidad de asignaturas que el profesor imparte.
     * @return el número de asignaturas.
     */
    public int contarAsignaturas() {
        return ContenedorAsignaturas.talla();
    }
    
    
    /**
     * Devuelve una representación en cadena de los datos del profesor.
     * Sobrescribe Persona#obtenerString()
     * @return una cadena con el nombre, apellido, RUT y edad del profesor.
     */
    @Override
    public String obtenerString() {
       return (getNombre() + "," + getApellido() + "," + getRut() + "," + Integer.toString(getEdad()) + "\n");
    }
    
    
    /**
     * Devuelve una representación en cadena de los datos del profesor sin salto de línea.
     * @param sinSalto si no debe incluir el salto de línea.
     * @return una cadena con el nombre, apellido, RUT y edad del profesor.
     */
    public String obtenerString(boolean sinSalto) {
       return (getNombre() + "," + getApellido() + "," + getRut() + "," + Integer.toString(getEdad()));
    }
    
    
    /**
     * Lista todas las asignaturas que imparte el profesor.
     * @return una cadena que contiene la representación de todas las asignaturas.
     */
    public String listarAsignaturas(){
        String cc = "";
        Iterator<Asignatura> iterable = ContenedorAsignaturas.iterador();
        while (iterable.hasNext()) {
            Asignatura asignatura = iterable.next();
            cc += (asignatura.obtenerString());
        }
        return cc;
    }
    
    
    /**
     * Lista los códigos de todas las asignaturas que imparte el profesor.
     * @param separador si se debe devolver solo los códigos de las asignaturas.
     * @return una cadena con los códigos de las asignaturas, separados por guiones.
     */
    public String listarAsignaturas(boolean separador){
        String cc = "";
        Iterator<Asignatura> iterable = ContenedorAsignaturas.iterador();
        while (iterable.hasNext()) {
            Asignatura asignatura = iterable.next();
            cc += (asignatura.getCodigo() + "-");
        }
        cc = cc.replaceFirst(".$", "\n");
        return cc;
    }
    
    
    
    // =========================================================================
    // =========================== OBSOLETOS ===================================
    // =========================================================================
    {
    /*
        public void mostrar(boolean simple) {
            System.out.println(" | " + getNombre() + " | " + getRut() + " | " );

            Iterator<Asignatura> iterador = asignaturas.iterador();
            while (iterador.hasNext()) {
                Asignatura aux = iterador.next();
                aux.mostrar(true);
            }
        }

        public boolean agregarAsignatura(Asignatura asignatura) {
            return asignaturas.agregar(asignatura.getCodigo(), asignatura);
        }
    */
    }
}
