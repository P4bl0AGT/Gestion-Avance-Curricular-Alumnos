import java.util.ArrayList;
import java.util.HashMap;

public class Instituto
{
    ArrayList listaAlumnos;
    HashMap mapaAlumnos;
    int cantidadAlumnos;

    public Instituto()
    {
        listaAlumnos = new ArrayList();
        mapaAlumnos = new HashMap();
        cantidadAlumnos = 0;
    }

    public void agregarAlumno(Alumno nuevoAlumno)
    {
        if(mapaAlumnos.get(nuevoAlumno.getRut()) == null)
        {
            listaAlumnos.add(nuevoAlumno);
            mapaAlumnos.put(nuevoAlumno.getRut(), nuevoAlumno);
            cantidadAlumnos++;
        }
    }

    public void mostrarAlumnos()
    {
        System.out.println("Lista alumnos");
        System.out.println("* * * * * * *");
        for(int i = 0 ; i < listaAlumnos.size() ; i++)
        {
            Alumno alumnoActual = (Alumno) listaAlumnos.get(i);
            alumnoActual.mostrarAlumno();
            System.out.println("");
        }
    }
}
