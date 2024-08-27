import java.util.ArrayList;

public class ClaseAlumno{

    /* ATRIBUTOS */

    private String nombreAlumno;
    private String apellidoAlumno;
    private int edad;
    private String rut;
    private ArrayList carrera;


    public ClaseAlumno(String nombreAlumno, String apellidoAlumno, int edad, String rut, ArrayList carrera){

        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.edad = edad;
        this.rut = rut;
        this.carrera = carrera;

    }
    
    /* GETTER */
    
    public String getNombreAlumno(){return nombreAlumno;}
    public String getApellidoAlumno(){return apellidoAlumno;}
    public int getEdad(){return edad;}
    public String getRut(){return rut;}
    public ArrayList getCarrera(){return carrera;}

    /*SETTER */

    public void setNombreAlumno(String nombreAlumno){

        if(nombreAlumno != null){this.nombreAlumno = nombreAlumno;}
        else{this.nombreAlumno = "SIN DATOS";}
    }

    public void setApellidoAlumno(String apellidoAlumno){

        if(apellidoAlumno != null){this.apellidoAlumno = apellidoAlumno;}
        else{this.apellidoAlumno = "SIN DATOS";}
    }

    public void setEdad(int edad){

        if(edad > 0){this.edad = edad;}
        else{this.edad = 0;}
    }

    public void setRut(String rut){

        if(rut != null){this.rut = rut;}
        else{this.rut = "SIN DATOS";}
    }

    public void setCarrera(ArrayList carrera){
        
        if(carrera != null ){this.carrera = carrera;}
        else{this.carrera = new ArrayList();}
    }

    /*METODOS */

    public void mostrarDatos(String nombreAlumno, String apellidoAlumno, int edad, String rut, ArrayList carrera){

        System.out.println("Nombre del Alumno: " + nombreAlumno);
        System.out.println("Apellido del Alumno: " + apellidoAlumno);
        System.out.println("Edad del Alumno: " + edad);
        System.out.println("Rut del Alumno: " + rut);
        System.out.println("Carrera del alumno: "+ carrera);

    }

}
