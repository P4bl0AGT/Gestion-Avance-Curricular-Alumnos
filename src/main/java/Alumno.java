
public class Alumno extends Persona{

    //ATRIBUTOS
    private int creditosAprobados;
    private Carrera carrera;


    //CONSTRUCTOR
    public Alumno(String nombre, String apellido, String rut, int edad, Carrera carrera) {
        super(nombre, apellido, rut, edad);
        this.carrera = carrera;
        creditosAprobados = 0;
    }

    public Alumno(String nombre, String apellido, String rut, int edad) {
        super(nombre, apellido, rut, edad);
        carrera = null;
        creditosAprobados = 0;
    }
    

    //GETTERS
    public Carrera getCarrera() {
        return carrera;
    }

    public int getCreditosAprobados() {
        return creditosAprobados;
    }


    //SETTERS
    public void setCarrera(Carrera carrera) {
        if(carrera != null ) 
            this.carrera = carrera;
        else
            this.carrera = null;
    }

    public void setCreditosAprobados(int creditosAprobados){
        if(creditosAprobados > 0)
            this.creditosAprobados = creditosAprobados;
        else
            this.creditosAprobados = 0;
    }


    //METODOS 
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
}

