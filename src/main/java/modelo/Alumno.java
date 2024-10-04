package modelo;

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
    @Override
    public void mostrar() {
        System.out.println("Nombre del Alumno: " + getNombre());
        System.out.println("Apellido del Alumno: " + getApellido());
        System.out.println("Edad del Alumno: " + getEdad());
        System.out.println("Rut del Alumno: " + getRut());
        System.out.println("Carrera del alumno: "+ carrera.getNombre());
        System.out.println("Creditos aprovados: "+ creditosAprobados);
    }

    @Override
    public void mostrar(boolean simple) {
        System.out.println(" | " + getNombre() + " | " + getRut() + " | " + carrera.getNombre() + " | ");
    }


    /*
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


    //cuidado con asignatura y asignaturainscrita en contenedor
    public void inscribirCarrera(Carrera carrera) {

        Carrera nuevaCarrera = carrera.copiaParaInscribir();

        for (int i = 0; i < carrera.cantidadAsignaturas(); i++) {
            Asignatura asignaturaActual = carrera.obtenerAsignatura(i);
            AsignaturaInscrita inscrita = new AsignaturaInscrita();
            inscrita.modificarParaInscribir(asignaturaActual);

            nuevaCarrera.agregarAsignatura(inscrita);
        }
        setCarrera(nuevaCarrera);
    }

    
    public int obtenerCantidadAsignaturas() {
        return carrera.cantidadAsignaturas();
    }
    
    @Override
    public String toString() {
       return (getNombre() + "," + getApellido() + "," + getRut() + "," + Integer.toString(getEdad()) + "," + creditosAprobados + "," + carrera.getNombre() + "\n");
    }

}

