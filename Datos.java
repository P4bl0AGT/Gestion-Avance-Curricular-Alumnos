import java.util.ArrayList;

public class Datos
{
    public static ArrayList  cargarCarreras()
    {
        ArrayList carreras = new ArrayList();

        //CARRERA INFORMATICA
        ArrayList asignaturasInformatica = new ArrayList();
        asignaturasInformatica.add(new Asignatura("Matematica", "MAT101", "Jorge Otto", 4));
        asignaturasInformatica.add(new Asignatura("Fisica", "FIS101", "Raphael Paredes", 3));
        asignaturasInformatica.add(new Asignatura("Programacion Av", "PRO102", "Claudio Cubillos", 5));
        Carrera informatica = new Carrera("INF", "Informatica", 1, asignaturasInformatica, 0);
        carreras.add(informatica);

        return carreras;
    }
} 
