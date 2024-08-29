public class Alumno{

    /* ATRIBUTOS */

    private String nombre;
    private String apellido;
    private int edad;
    private String rut;
    private Carrera carrera;


    public Alumno(String nombre, String apellido, int edad, String rut, Carrera carrera){

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.rut = rut;
        this.carrera = carrera;
    }
    
    /* GETTER */
    
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public int getEdad(){return edad;}
    public String getRut(){return rut;}
    public Carrera getCarrera(){return carrera;}

    /*SETTER */

    public void setNombre(String nombre){

        if(nombre != null){this.nombre = nombre;}
        else{this.nombre = "SIN DATOS";}
    }

    public void setApellido(String apellido){

        if(apellido != null){this.apellido = apellido;}
        else{this.apellido = "SIN DATOS";}
    }

    public void setEdad(int edad){

        if(edad > 0){this.edad = edad;}
        else{this.edad = 0;}
    }

    public void setRut(String rut){

        if(rut != null){this.rut = rut;}
        else{this.rut = "SIN DATOS";}
    }

    public void setCarrera(Carrera carrera){
        
        if(carrera != null ){this.carrera = carrera;}
        else{this.carrera = null;}
    }

    /*METODOS */

    public void mostrarDatos(){ 

        System.out.println("Nombre del Alumno: " + nombre);
        System.out.println("Apellido del Alumno: " + apellido);
        System.out.println("Edad del Alumno: " + edad);
        System.out.println("Rut del Alumno: " + rut);
        System.out.println("Carrera del alumno: "+ carrera);

    }

}

