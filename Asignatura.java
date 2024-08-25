public class Asignatura
{
    //ATRIBUTOS
    private String nombre;
    private String codigo;
    private String profesor;
    private int creditos;

    //CONSTRUCTOR
    public Asignatura(){}
    public Asignatura(String nombre, String codigo, String profesor, int creditos)
    {
        setNombre(nombre);
        setCodigo(codigo);
        setProfesor(profesor);
        setCreditos(creditos);
    }

    //SETTERS
    public void setNombre(String nombre)
    {
        if(nombre != null)
            this.nombre = nombre;
        else
            this.nombre = "nulo";
    }

    public void setCodigo(String codigo)
    {
        if(codigo != null)
            this.codigo = codigo;
        else
            this.codigo = "nulo";
    }

    public void setProfesor(String profesor)
    {
        if(profesor != null)
            this.profesor = profesor;
        else
            this.profesor = "no hay profesor a cargo";
    }

    public void setCreditos(int creditos)
    {
        if(creditos >= 0)
            this.creditos = creditos;
        else
            this.creditos = 0;
    }
}
