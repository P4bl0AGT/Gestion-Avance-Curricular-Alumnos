package modelo;

public class Asignatura
{
    //ATRIBUTOS
    private String codigo;
    private String nombre;
    private int creditos;


    //CONSTRUCTOR
    public Asignatura(){}
    
    public Asignatura(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    //SETTERS
    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }

    public void setCodigo(String codigo) {
        if(codigo != null)
            this.codigo = codigo;
        else
            this.codigo = "nulo";
    }


    public void setCreditos(int creditos) {
        if(creditos >= 0)
            this.creditos = creditos;
        else
            this.creditos = 0;
    }


    //GETTERS
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }


    //METODOS
    public void mostrar() {
        System.out.println("Codigo asignatura: " + codigo);
        System.out.println("Nombre asignatura: " + nombre);
        System.out.println("Creditos asignatura: " + creditos);
    }
    
    public void mostrar(boolean simple){ 
        System.out.println(" | " + codigo + " | ");
    }
    
    @Override
    public String toString() {
       return (codigo + "," + nombre + "," + creditos + "\n");
    }
}
