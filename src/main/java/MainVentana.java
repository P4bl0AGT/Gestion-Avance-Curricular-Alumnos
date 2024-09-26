import java.io.*;
import javax.swing.*;

public class MainVentana
{
    public static void main(String arr[]) throws IOException
    {
        //Instituto clase principal
        Instituto instituto = new Instituto();
        //Cargar 
        Datos datos = new Datos();
        datos.cargarCsvCarreras(instituto);
        datos.cargarCsvAlumnos(instituto);
        //Iniciar Ventana
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Menu menu = new Menu(instituto);
                menu.setVisible(true);
            }
        });
    }
}
