import java.io.*;
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
            alumnoActual.mostrarSimple();
            System.out.println("");
        }
    }

    public void buscarAlumnosRut(HashMap mapaAlumnos, BufferedReader lector)throws IOException{
    
        
        System.out.println("PORFAVOR INGRESAR EL RUT DEL ALUMNO A BUSCAR");
        String rut = lector.readLine();

        if(mapaAlumnos.get(rut) != null){

            Alumno alumnoBuscado = (Alumno)mapaAlumnos.get(rut);
            alumnoBuscado.mostrarDetalle();
        }
        else{
            System.out.println("No se encuentra alumnos con el rut ingresado");
        }
        
    }

    public void buscarAlumnosCarrera(ArrayList listaAlumnos,BufferedReader lector)throws IOException{
    
        System.out.println("PORFAVOR INGRESAR la Carrera a buscar: ");
        String carrera = lector.readLine();
        Alumno alumnoCarrera;
        boolean hayAlumnosCarrera = false;
        
        if (cantidadAlumnos != 0)
        {
            for (int i = 0; i < listaAlumnos.size() ; i++)
            {
                alumnoCarrera = (Alumno)listaAlumnos.get(i);

                if (alumnoCarrera.getCarrera().getNombre().equals(carrera))
                {
                    alumnoCarrera.mostrarDetalle();
                    hayAlumnosCarrera = true;
                }
            }

            if (!hayAlumnosCarrera)System.out.println("NO HAY ALUMNOS INSCRITOS EN ESTA CARRERA");

        }
        else{
            System.out.println("NO HAY ALUMNOS INSCRITOS EN EL INSTITUTO");
        }



    }

}
