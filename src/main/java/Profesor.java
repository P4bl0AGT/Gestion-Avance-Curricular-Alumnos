import java.util.ArrayList;

public class Profesor extends Persona{
    //ATRIBUTOS
    private ArrayList<Asignatura> asignaturas;

    //CONSTRUCTOR
    public Profesor(String nombre, String apellido, String rut, int edad) {
        super(nombre, apellido, rut, edad);
        asignaturas = new ArrayList<>();
    }

    //METODOS
    public void mostrar() {
        for (Asignatura aux:asignaturas) {
            aux.mostrar();
        }
    }

    public void mostrar(boolean simple) {
        for (Asignatura aux:asignaturas) {
            aux.mostrar(true);
        }

    }
}
