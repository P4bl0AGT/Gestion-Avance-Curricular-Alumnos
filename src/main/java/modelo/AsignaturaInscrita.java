package modelo;

/**
 * Esta clase representa un asignatura inscrita de un alumno que hereda de asignatura
 */

public class AsignaturaInscrita extends Asignatura{
    //=================================== ATRIBUTOS ===================================//
    private estadoAsignatura estado;
    private int nota;


    //=================================== CONSTRUCTORES ===================================//
    public AsignaturaInscrita() {};
    /**
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
    * @param codigo El codigo de la asignatura
    * @param nombre El nombre de la asignatura
    * @param creditos Los creditos de la asignatura
    */
    public AsignaturaInscrita(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
        this.estado = estadoAsignatura.INSCRITO;
        this.nota = 0;
    }

    //=================================== SETTERS ===================================//  
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

    //=================================== GETTERS ===================================//    
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

    //=================================== METODOS ===================================//  
    /**
     * @Override
     * Metodo que muestra por consola los atributos de la asignatura
     */
    public void mostrar() {
        System.out.println("Nombre asignatura: " + getNombre());
        System.out.println("Codigo asignatura: " + getCodigo());
        System.out.println("Creditos asignatura: " + getCreditos());
        System.out.println("Estado: " + estado);
        System.out.println("Nota: " + nota);
    }
    /**
     * @Override
     * Metodo que muestra por consola los atributos de la asignatura de manera simple
     */
    public void mostrar(boolean simple) { 
        System.out.println(" | " + getCodigo() + " | " + estado +  " | ");}
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
     * @param asignatura la asignatura que queremos modificar
     * nose que hace esto xde
     */
    public void modificarParaInscribir(Asignatura asignatura) {
        setCodigo(asignatura.getCodigo());
        setNombre(asignatura.getNombre());
        setCreditos(asignatura.getCreditos());
        inscribir();
        nota = -1;
    }
    /**
     * @param estado El estado que quiero modificar en una asignatura
     * @param nota La nota que quiero modificar en una asignatura
     * nose que hace esto xde
     */
    public void modificarNotaEstado(estadoAsignatura estado, int nota) {
        this.estado = estado;
        this.nota = nota;
    }
    /**
     * Representa los diferentes estados que puede tener una asignatura inscrita
     */
    public enum estadoAsignatura {
        INSCRITO,
        APROBADO,
        REPROBADO
    }
    
}
