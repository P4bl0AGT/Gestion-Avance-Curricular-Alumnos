public class AsignaturaInscrita extends Asignatura{
    //ATRIBUTOS
    private int estado;
    private int nota;


    //CONSTRUCTOR
    public AsignaturaInscrita(String codigo, String nombre, int creditos, int estado, int nota) {
        super(codigo, nombre, creditos);
        this.estado = estado;
        this.nota = nota;
    }

    //SETTERS
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


    //GETTERS
    public int getNota() {
        return nota;
    }

    public int getEstado() {
        return estado;
    }


    //METODOS
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
    
}
