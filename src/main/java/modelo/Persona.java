package modelo;

public class Persona {
    //ATRIBUTOS
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;


    //CONSTRUCTOR
    public Persona(String nombre, String apellido,String rut, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.rut = rut;
    }
    

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public int getEdad() {
        return edad;
    }

    public String getRut() {
        return rut;
    }


    //SETTERS
    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }

    public void setApellido(String apellido) {
        if(apellido != null)
            this.apellido = apellido;
        else
            this.apellido = "nulo";
    }

    public void setEdad(int edad) {
        if(edad > 0)
            this.edad = edad;
        else
            this.edad = 0;
    }

    public void setRut(String rut) {
        if(rut != null)
            this.rut = rut;
        else
            this.rut = "nulo";
    }


    //METODOS 
    public void mostrar() { 
        System.out.println("Nombre del Alumno: " + nombre);
        System.out.println("Apellido del Alumno: " + apellido);
        System.out.println("Edad del Alumno: " + edad);
        System.out.println("Rut del Alumno: " + rut);
    }

    public void mostrar(boolean simple) {
        System.out.println(" | " + nombre + " | " + rut + " | " );
    }

}

