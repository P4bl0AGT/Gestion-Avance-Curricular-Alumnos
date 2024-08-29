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
}
