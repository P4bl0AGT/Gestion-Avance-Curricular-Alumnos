public class AsignaturaInscrita extends Asignatura{
    //ATRIBUTOS
    private Enums.estadoAsignatura estado;
    private int nota;


    //CONSTRUCTOR
    public AsignaturaInscrita() {};

    public AsignaturaInscrita(String codigo, String nombre, int creditos, Enums.estadoAsignatura estado, int nota) {
        super(codigo, nombre, creditos);
        this.estado = estado;
        this.nota = nota;
    }

    public AsignaturaInscrita(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
        this.estado = Enums.estadoAsignatura.INSCRITO;
        this.nota = 0;
    }


    //SETTERS
    public void setEstado(Enums.estadoAsignatura estado) {
        this.estado = estado;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


    //GETTERS
    public int getNota() {
        return nota;
    }

    public Enums.estadoAsignatura getEstado() {
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
        estado = Enums.estadoAsignatura.INSCRITO;
    }

    public void aprobar() {
        estado = Enums.estadoAsignatura.APROBADO;
    }

    public void reprobar() {
        estado = Enums.estadoAsignatura.REPROBADO;
    }

    public void modificarParaInscribir(Asignatura asignatura) {
        setCodigo(asignatura.getCodigo());
        setNombre(asignatura.getNombre());
        setCreditos(asignatura.getCreditos());
        inscribir();
        nota = -1;
    }

    public void modificarNotaEstado(Enums.estadoAsignatura estado, int nota) {
        this.estado = estado;
        this.nota = nota;
    }
    
}
