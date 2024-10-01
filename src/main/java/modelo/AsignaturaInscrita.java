package modelo;

public class AsignaturaInscrita extends Asignatura{
    //ATRIBUTOS
    private estadoAsignatura estado;
    private int nota;


    //CONSTRUCTOR
    public AsignaturaInscrita() {};

    public AsignaturaInscrita(String codigo, String nombre, int creditos, estadoAsignatura estado, int nota) {
        super(codigo, nombre, creditos);
        this.estado = estado;
        this.nota = nota;
    }

    public AsignaturaInscrita(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
        this.estado = estadoAsignatura.INSCRITO;
        this.nota = 0;
    }


    //SETTERS
    public void setEstado(estadoAsignatura estado) {
        this.estado = estado;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


    //GETTERS
    public int getNota() {
        return nota;
    }

    public estadoAsignatura getEstado() {
        return estado;
    }


    //METODOS
    @Override
    public void mostrar() {
        System.out.println("Nombre asignatura: " + getNombre());
        System.out.println("Codigo asignatura: " + getCodigo());
        System.out.println("Creditos asignatura: " + getCreditos());
        System.out.println("Estado: " + estado);
        System.out.println("Nota: " + nota);
    }

    @Override
    public void mostrar(boolean simple) { 
        System.out.println(" | " + getCodigo() + " | " + estado +  " | ");
    }

    public void inscribir() {
        estado = estadoAsignatura.INSCRITO;
    }

    public void aprobar() {
        estado = estadoAsignatura.APROBADO;
    }

    public void reprobar() {
        estado = estadoAsignatura.REPROBADO;
    }

    public void modificarParaInscribir(Asignatura asignatura) {
        setCodigo(asignatura.getCodigo());
        setNombre(asignatura.getNombre());
        setCreditos(asignatura.getCreditos());
        inscribir();
        nota = -1;
    }

    public void modificarNotaEstado(estadoAsignatura estado, int nota) {
        this.estado = estado;
        this.nota = nota;
    }

    public enum estadoAsignatura {
        INSCRITO,
        APROBADO,
        REPROBADO
    }
    
}
