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
    //VENTANAS DE PROESOR
    private VentanaAgregarProfesor vAgregarProfesor;
    private VentanaMostrarProfesores vMostrarProfesores;
    private VentanaEliminarProfesor vEliminarProfesor;
    private VentanaBuscarProfesor vBuscarProfesor;
    //VENTANAS DE CARRERAS
    private VentanaAgregarCarrera vAgregarCarrera;
    private VentanaBuscarCarrera vBuscarCarrera;
    private VentanaEliminarCarrera vEliminarCarrera;
    private VentanaMostrarCarreras vMostrarCarreras;
    // ...
    //-------------------------------------------------------------------------------------------------------

    
    public void iniciar() throws IOException {
        instituto = new Instituto();
        Datos datos = new Datos();
        
        datos.cargarCsvCarreras(instituto);
        datos.cargarCsvAlumnos(instituto);
        datos.cargarCsvProfesores(instituto);
        //temporal
        datos.guardarCsvProfesores(instituto);
        datos.guardarCsvAlumnos(instituto);
        
        ventanaPrincipal = new VentanaPrincipal();
        
        //AQUI HAY QUE AGREGAR CADA NUEVA OPCION DE VENTANA PRINCIPAL --------------------------------------------
        //(VENTANAPRINCIPAL) (METODO GET CLASE VENTANA) (ACTIONLISTENER)
        //ASOCIAR EVENTOS DE PROFESOR
        ventanaPrincipal.getjMenuItemAgregarProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemMostrarProfesores().addActionListener(this);
        ventanaPrincipal.getjMenuItemEliminarProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemBuscarProfesor().addActionListener(this);
        //ASOCIAR EVENTOS DE CARRERAS
        ventanaPrincipal.getjMenuItemAgregarCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemBuscarCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemEliminarCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemMostrarCarreras().addActionListener(this);
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
        
        //MENU AGREGAR PROFESOR==================================================================================================
        if (ae.getSource() == ventanaPrincipal.getjMenuItemAgregarProfesor()){
            vAgregarProfesor = new VentanaAgregarProfesor();
            vAgregarProfesor.getjButtonAgregar().addActionListener(this);
            vAgregarProfesor.getjButtonCancelar().addActionListener(this);
            vAgregarProfesor.setAlwaysOnTop(true);     
            vAgregarProfesor.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON AGREGAR
        else if (vAgregarProfesor != null && ae.getSource() == vAgregarProfesor.getjButtonAgregar()){
            Profesor pp = new Profesor(vAgregarProfesor.getjTextFieldNombre().getText(),
                                       vAgregarProfesor.getjTextFieldApellido().getText(),
                                       vAgregarProfesor.getjTextFieldRut().getText(),
                                       Integer.parseInt(vAgregarProfesor.getjTextFieldEdad().getText()));
            instituto.agregarProfesor(pp);
            ventanaPrincipal.setVisible(true);
            vAgregarProfesor.dispose();
        }
        //BOTON CANCELAR
        else if (vAgregarProfesor != null && ae.getSource() == vAgregarProfesor.getjButtonCancelar()){
            ventanaPrincipal.setVisible(true);
            vAgregarProfesor.dispose();
        }
        
        
        //MENU MOSTRAR PROFESOR ==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarProfesores()) {
            vMostrarProfesores = new VentanaMostrarProfesores(instituto.listarProfesores());
            vMostrarProfesores.getjButtonVolver().addActionListener(this);
            vMostrarProfesores.setAlwaysOnTop(true);     
            vMostrarProfesores.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON VOLVER
        else if (vMostrarProfesores != null && ae.getSource() == vMostrarProfesores.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vMostrarProfesores.dispose();
        }
        
        
        //MENU ELIMINAR PROFESOR==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemEliminarProfesor()) {
            vEliminarProfesor = new VentanaEliminarProfesor();
            vEliminarProfesor.getjButtonVolver().addActionListener(this);
            vEliminarProfesor.getjButtonEliminar().addActionListener(this);
            vEliminarProfesor.setAlwaysOnTop(true);     
            vEliminarProfesor.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON ELIMINAR
        else if (vEliminarProfesor != null && ae.getSource() == vEliminarProfesor.getjButtonEliminar()){
            String rut = vEliminarProfesor.getjTextFieldRut().getText();
            if (instituto.eliminarProfesor(rut))
                vEliminarProfesor.getjTextFieldMensaje().setText("Profesor eliminado con éxito");
            else
                vEliminarProfesor.getjTextFieldMensaje().setText("Profesor no encontrado");
        }
        //BOTON VOLVER
        else if (vEliminarProfesor != null && ae.getSource() == vEliminarProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vEliminarProfesor.dispose();
        }
        
        
        //MENU BUSCAR PROFESOR==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemBuscarProfesor()) {
            vBuscarProfesor = new VentanaBuscarProfesor();
            vBuscarProfesor.getjButtonBuscar().addActionListener(this);
            vBuscarProfesor.getjButtonVolver().addActionListener(this);
            vBuscarProfesor.setAlwaysOnTop(true);     
            vBuscarProfesor.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON BUSCAR
        else if (vBuscarProfesor != null && ae.getSource() == vBuscarProfesor.getjButtonBuscar()){     
            String rut = vBuscarProfesor.getjTextFieldRut().getText();
            Profesor profesor = instituto.obtenerProfesor(rut);
            if (profesor != null)
                vBuscarProfesor.getjTextFieldMensaje().setText(profesor.toString());
            else
                vBuscarProfesor.getjTextFieldMensaje().setText("Profesor no encontrado"); 
        }
        //BOTON VOLVER
        else if (vBuscarProfesor != null && ae.getSource() == vBuscarProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vBuscarProfesor.dispose();
        }
 
        //===================== EVENTOS DE CARRERAS =====================//
        //AGREGAR CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemAgregarCarrera()){
            vAgregarCarrera = new VentanaAgregarCarrera();
            vAgregarCarrera.getjButtonVolver().addActionListener(this);
            vAgregarCarrera.setAlwaysOnTop(true);     
            vAgregarCarrera.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vAgregarCarrera != null && ae.getSource() == vAgregarCarrera.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vAgregarCarrera.dispose();
        }
        
        //BUSCAR CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemBuscarCarrera()){
            vBuscarCarrera = new VentanaBuscarCarrera();
            vBuscarCarrera.getjButtonBuscar().addActionListener(this);
            vBuscarCarrera.getjButtonVolver().addActionListener(this);
            vBuscarCarrera.setAlwaysOnTop(true);     
            vBuscarCarrera.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vBuscarCarrera != null && ae.getSource() == vBuscarCarrera.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vBuscarCarrera.dispose();
        }
        
        //ELIMINAR CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemEliminarCarrera()){
            vEliminarCarrera = new VentanaEliminarCarrera();
            vEliminarCarrera.getjButtonBuscar().addActionListener(this);
            vEliminarCarrera.getjButtonVolver().addActionListener(this);
            vEliminarCarrera.setAlwaysOnTop(true);     
            vEliminarCarrera.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vEliminarCarrera != null && ae.getSource() == vEliminarCarrera.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vEliminarCarrera.dispose();
        }
        
        //Mostrar CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarCarreras()){
            vMostrarCarreras = new VentanaMostrarCarreras();
            vMostrarCarreras.getjButtonVolver().addActionListener(this);
            vMostrarCarreras.setAlwaysOnTop(true);     
            vMostrarCarreras.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vMostrarCarreras != null && ae.getSource() == vMostrarCarreras.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vMostrarCarreras.dispose();
        }
    }
    
}
