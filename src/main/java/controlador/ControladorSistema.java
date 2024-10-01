/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import javax.swing.JFrame;
import modelo.*;
import vista.*;
import java.io.*;

/**
 *
 * @author Note
 */
public class ControladorSistema implements ActionListener{
    private Instituto instituto;
    private VentanaPrincipal ventanaPrincipal;
    
    //AQUI HAY QUE AGREGAR CADA NUEVA VENTANA COMO ATRIBUTO-------------------------------------------------------------
    //CREAR NUEVA VENTANA -> SE GENERA CLASE -> AGREGO ABAJO (PRIVATE) (NOMBRECLASEVENTANA) (VARIABLEVENTANA)
    private VentanaAgregarProfesor vAgregarProfesor;
    private VentanaMostrarProfesores vMostrarProfesores;
    // ...
    //-------------------------------------------------------------------------------------------------------

    
    public void iniciar() throws IOException {
        instituto = new Instituto();
        Datos datos = new Datos();
        
        datos.cargarCsvCarreras(instituto);
        datos.cargarCsvAlumnos(instituto);
        datos.cargarCsvProfesores(instituto);
        
        ventanaPrincipal = new VentanaPrincipal();
        
        //AQUI HAY QUE AGREGAR CADA NUEVA OPCION DE VENTANA PRINCIPAL --------------------------------------------
        //(VENTANAPRINCIPAL) (METODO GET CLASE VENTANA) (ACTIONLISTENER)
        ventanaPrincipal.getjMenuItemAgregarProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemMostrarProfesores().addActionListener(this);
        // ...
        //-------------------------------------------------------------------------------------------------------
        
        ventanaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //EN CADA IF AGREGAR CADA BOTON
        // SI LA ACCION == SUBITEM 
        //INSTANCIO VENTANA -> SELECCIONO BOTON -> AGREGO LISTENER
        
        //######################################################################
        //MENU AGREGAR PROFESOR
        if (ae.getSource() == ventanaPrincipal.getjMenuItemAgregarProfesor()){
            vAgregarProfesor = new VentanaAgregarProfesor();
            vAgregarProfesor.getjButtonAgregar().addActionListener(this);
            vAgregarProfesor.getjButtonCancelar().addActionListener(this);

            vAgregarProfesor.setAlwaysOnTop(true);     
            vAgregarProfesor.setVisible(true);
        }
        //BOTON AGREGAR
        else if (ae.getSource() == vAgregarProfesor.getjButtonAgregar()){
          vAgregarProfesor.dispose();
        }
        //BOTON CANCELAR
        else if (ae.getSource() == vAgregarProfesor.getjButtonCancelar()){
          vAgregarProfesor.dispose();
        }
        
        //######################################################################
        //MENU MOSTRAR PROFESOR
        else if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarProfesores()) {
            vMostrarProfesores = new VentanaMostrarProfesores();
            vMostrarProfesores.getjButtonVolver().addActionListener(this);
            vMostrarProfesores.setVisible(true);
        }
        //BOTON VOLVER
        else if (ae.getSource() == vMostrarProfesores.getjButtonVolver()){
          vMostrarProfesores.dispose();
        }
          
    }
    
}
