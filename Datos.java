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

        //CARRERA temp
        ArrayList asignaturaMatematicas = new ArrayList();
        asignaturaMatematicas.add(new Asignatura("Matematica", "MAT101", "Jorge Otto", 4));
        asignaturaMatematicas.add(new Asignatura("Fisica", "FIS101", "Raphael Paredes", 3));
        asignaturaMatematicas.add(new Asignatura("Programacion Av", "PRO102", "Claudio Cubillos", 5));
        Carrera matematicas = new Carrera("MAT", "Matematicas", 1, asignaturaMatematicas, 0);
        carreras.add(matematicas);

        //CARRERA temp
        ArrayList asignaturaQuimica = new ArrayList();
        asignaturaQuimica.add(new Asignatura("Matematica", "MAT101", "Jorge Otto", 4));
        asignaturaQuimica.add(new Asignatura("Fisica", "FIS101", "Raphael Paredes", 3));
        asignaturaQuimica.add(new Asignatura("Programacion Av", "PRO102", "Claudio Cubillos", 5));
        Carrera quimica = new Carrera("QUI", "Quimica", 1, asignaturaQuimica, 0);
        carreras.add(quimica);
        

        return carreras;
    }
} 
