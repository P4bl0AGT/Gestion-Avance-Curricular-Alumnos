/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import modelo.*;
import vista.*;
import java.io.*;

/**
 *
 * @author Note
 */
public class ControladorSistema implements ActionListener {
    private Instituto instituto;
    private VentanaPrincipal ventanaPrincipal;

    //AQUI HAY QUE AGREGAR CADA NUEVA VENTANA COMO ATRIBUTO-------------------------------------------------------------
    //CREAR NUEVA VENTANA -> SE GENERA CLASE -> AGREGO ABAJO (PRIVATE) (NOMBRECLASEVENTANA) (VARIABLEVENTANA)
    
    //VENTANAS DE PROESOR
    private VentanaAgregarProfesor vAgregarProfesor;
    private VentanaMostrarProfesores vMostrarProfesores;
    private VentanaEliminarProfesor vEliminarProfesor;
    private VentanaBuscarProfesor vBuscarProfesor;
    private VentanaAgregarAsignaturaProfesor vAgregarAsignaturaProfesor;
    private VentanaEliminarAsignaturaProfesor vEliminarAsignaturaProfesor;
    private VentanaMostrarAsignaturasProfesor vMostrarAsignaturaProfesor;

    //VENTANAS DE CARRERAS
    private VentanaAgregarCarrera vAgregarCarrera;
    private VentanaBuscarCarrera vBuscarCarrera;
    private VentanaEliminarCarrera vEliminarCarrera;
    private VentanaMostrarCarreras vMostrarCarreras;

    // VENTANAS DE ALUMNO
    private VentanaActualizacionEstadoAsignaturaAlumno vActualizarEstadoAsignaturaAlumno;
    private VentanaAgregarAlumno vAgregarAlumno;
    private VentanaBuscarAlumno vBuscarAlumno;
    private VentanaBuscarAlumnoCarrera vBuscarAlumnoCarrera;
    private VentanaEliminarAlumno vEliminarAlumno;
    private VentanaEstadoAsignaturaAlumno vEstadoAsignaturaAlumno;
    private VentanaMostrarAlumnos vMostrarAlumnos;
   
    
    //-------------------------------------------------------------------------------------------------------

    
    public void iniciar() throws IOException {
        instituto = new Instituto();
        instituto.cargarDatosPredefinidos();
        
        //hay que ver donde colocarla
        instituto.guardarDatos();
        
        ventanaPrincipal = new VentanaPrincipal();
        
        //AQUI HAY QUE AGREGAR CADA NUEVA OPCION DE VENTANA PRINCIPAL --------------------------------------------
        //(VENTANAPRINCIPAL) (METODO GET CLASE VENTANA) (ACTIONLISTENER)
        ventanaPrincipal.getjButtonSalir().addActionListener(this);
        
        //ASOCIAR EVENTOS DE PROFESOR
        ventanaPrincipal.getjMenuItemAgregarProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemMostrarProfesores().addActionListener(this);
        ventanaPrincipal.getjMenuItemEliminarProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemBuscarProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemjMenuItemAgregarAsignaturaProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemEliminarAsignaturaProfesor().addActionListener(this);
        ventanaPrincipal.getjMenuItemMostrarAsignaturasProfesor().addActionListener(this);
        
        
        //ASOCIAR EVENTOS DE CARRERAS
        ventanaPrincipal.getjMenuItemAgregarCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemBuscarCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemEliminarCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemMostrarCarreras().addActionListener(this);
        
        
        // ASOCIAR EVENTOS DE ALUMNO
        ventanaPrincipal.getjMenuItemActualizacionEstadoAsignaturaAlumno().addActionListener(this);
        ventanaPrincipal.getjMenuItemAgregarAlumno().addActionListener(this);
        ventanaPrincipal.getjMenuItemBuscarPorRut().addActionListener(this);
        ventanaPrincipal.getjMenuItemBuscarPorCarrera().addActionListener(this);
        ventanaPrincipal.getjMenuItemEliminarAlumno().addActionListener(this);    
        ventanaPrincipal.getjMenuItemEstadoAsignatura().addActionListener(this); 
        ventanaPrincipal.getjMenuItemMostrarAlumnos().addActionListener(this);



        
        //-------------------------------------------------------------------------------------------------------
        
        ventanaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaPrincipal.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == ventanaPrincipal.getjButtonSalir()) {
            ventanaPrincipal.dispose();
        }
        
//EN CADA IF AGREGAR CADA BOTON
        // SI LA ACCION == SUBITEM 
        //INSTANCIO VENTANA -> SELECCIONO BOTON -> AGREGO LISTENER
        
        //MENU AGREGAR PROFESOR==================================================================================================
        if (ae.getSource() == ventanaPrincipal.getjMenuItemAgregarProfesor()){
            vAgregarProfesor = new VentanaAgregarProfesor();
            vAgregarProfesor.getjButtonAgregar().addActionListener(this);
            vAgregarProfesor.getjButtonVolver().addActionListener(this);
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
            vAgregarProfesor.getjTextFieldMensaje().setText("Agregado");
        }
        //BOTON VOLVER
        else if (vAgregarProfesor != null && ae.getSource() == vAgregarProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vAgregarProfesor.dispose();
        }
        
        
        //MENU MOSTRAR PROFESORES ==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarProfesores()) {
            vMostrarProfesores = new VentanaMostrarProfesores();
            vMostrarProfesores.rellenarTabla(instituto.listarProfesores());
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
                vEliminarProfesor.getjTextFieldMensaje().setText("Profesor eliminado");
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
            if (profesor != null) {
                vBuscarProfesor.rellenarTabla(profesor.toString());
                vBuscarProfesor.getjTextFieldMensaje().setText("Encontrado");
            }
            else
                vBuscarProfesor.getjTextFieldMensaje().setText("Profesor no encontrado"); 
        }
        //BOTON VOLVER
        else if (vBuscarProfesor != null && ae.getSource() == vBuscarProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vBuscarProfesor.dispose();
        }
        
        
        //MENU AGREGAR ASIGNATURA PROFESOR ==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemjMenuItemAgregarAsignaturaProfesor()) {
            vAgregarAsignaturaProfesor = new VentanaAgregarAsignaturaProfesor();
            vAgregarAsignaturaProfesor.getjButtonBuscar().addActionListener(this);
            vAgregarAsignaturaProfesor.getjButtonAgregar().addActionListener(this);
            vAgregarAsignaturaProfesor.getjButtonVolver().addActionListener(this);
            vAgregarAsignaturaProfesor.setAlwaysOnTop(true);     
            vAgregarAsignaturaProfesor.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON BUSCAR
        else if (vAgregarAsignaturaProfesor != null && ae.getSource() == vAgregarAsignaturaProfesor.getjButtonBuscar()){
            String rut = vAgregarAsignaturaProfesor.getjTextFieldRut().getText();
            String id = vAgregarAsignaturaProfesor.getjTextFieldIDCarrera().getText();
            Profesor profesor = instituto.obtenerProfesor(rut);
            Carrera carrera = instituto.obtenerCarrera(id);
            if (profesor != null && carrera != null) {
                vAgregarAsignaturaProfesor.rellenarTabla(carrera.listarAsignaturas());
                vAgregarAsignaturaProfesor.getjTextFieldMensaje().setText(" - - - ");
            }
            else {
                vAgregarAsignaturaProfesor.limpiarTabla();
                vAgregarAsignaturaProfesor.getjTextFieldMensaje().setText("No encontrado");
            }
             
        }
        //BOTON AGREGAR
        else if (vAgregarAsignaturaProfesor != null && ae.getSource() == vAgregarAsignaturaProfesor.getjButtonAgregar()){
            String idAsignatura = vAgregarAsignaturaProfesor.getjTextFieldIDAsignatura().getText();
            String rut = vAgregarAsignaturaProfesor.getjTextFieldRut().getText();
            String idCarrera = vAgregarAsignaturaProfesor.getjTextFieldIDCarrera().getText();
            
            Profesor profesor = instituto.obtenerProfesor(rut);
            Carrera carrera = instituto.obtenerCarrera(idCarrera);
            
            if (profesor != null && carrera != null) {
                Asignatura asignatura = carrera.obtenerAsignatura(idAsignatura);
                
                if (asignatura != null) {
                    profesor.agregarAsignatura(asignatura);
                    vAgregarAsignaturaProfesor.getjTextFieldMensaje().setText("Agregado");
                }
                else {
                    vAgregarAsignaturaProfesor.getjTextFieldMensaje().setText("Asignatura INCORRECTA");
                }
            }
            else {
                vAgregarAsignaturaProfesor.getjTextFieldMensaje().setText("No encontrado");
            }
        }
        //BOTON VOLVER
        else if (vAgregarAsignaturaProfesor != null && ae.getSource() == vAgregarAsignaturaProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vAgregarAsignaturaProfesor.dispose();
        }
        
        
        //MENU ELIMINAR ASIGNATURA PROFESOR ==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemEliminarAsignaturaProfesor()) {
            vEliminarAsignaturaProfesor = new VentanaEliminarAsignaturaProfesor();
            vEliminarAsignaturaProfesor.getjButtonBuscar().addActionListener(this);
            vEliminarAsignaturaProfesor.getjButtonEliminar().addActionListener(this);
            vEliminarAsignaturaProfesor.getjButtonVolver().addActionListener(this);
            vEliminarAsignaturaProfesor.setAlwaysOnTop(true);     
            vEliminarAsignaturaProfesor.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON BUSCAR
        else if (vEliminarAsignaturaProfesor != null && ae.getSource() == vEliminarAsignaturaProfesor.getjButtonBuscar()){
            String rut = vEliminarAsignaturaProfesor.getjTextFieldRut().getText();
            Profesor profesor = instituto.obtenerProfesor(rut);
            if (profesor != null) {
                vEliminarAsignaturaProfesor.rellenarTabla(profesor.listarAsignaturas());
                vEliminarAsignaturaProfesor.getjTextFieldMensaje().setText(profesor.contarAsignaturas() + " Asignaturas");
            }
            else {
                vEliminarAsignaturaProfesor.limpiarTabla();
                vEliminarAsignaturaProfesor.getjTextFieldMensaje().setText("No encontrado");
            }  
        }
        //BOTON ELIMINAR
        else if (vEliminarAsignaturaProfesor != null && ae.getSource() == vEliminarAsignaturaProfesor.getjButtonEliminar()){
            String idAsignatura = vEliminarAsignaturaProfesor.getjTextFieldIDAsignatura().getText();
            String rut = vEliminarAsignaturaProfesor.getjTextFieldRut().getText();

            Profesor profesor = instituto.obtenerProfesor(rut);
            
            if (profesor != null) {
                Asignatura asignatura = profesor.obtenerAsignatura(idAsignatura);
                
                if (asignatura != null) {
                    profesor.elimarAsignatura(asignatura.getCodigo());
                    vEliminarAsignaturaProfesor.getjTextFieldMensaje().setText("Eliminado");
                }
                else {
                    vEliminarAsignaturaProfesor.getjTextFieldMensaje().setText("Asignatura INCORRECTA");
                }
            }
            else {
                vEliminarAsignaturaProfesor.getjTextFieldMensaje().setText("No encontrado");
            }
        }
        //BOTON VOLVER
        else if (vEliminarAsignaturaProfesor != null && ae.getSource() == vEliminarAsignaturaProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vEliminarAsignaturaProfesor.dispose();
        }
        
        
        //MENU MOSTRAR ASIGNATURAS PROFESORES ==================================================================================================
        if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarAsignaturasProfesor()) {
            vMostrarAsignaturaProfesor = new VentanaMostrarAsignaturasProfesor();
            vMostrarAsignaturaProfesor.getjButtonBuscar().addActionListener(this);
            vMostrarAsignaturaProfesor.getjButtonVolver().addActionListener(this);
            vMostrarAsignaturaProfesor.setAlwaysOnTop(true);     
            vMostrarAsignaturaProfesor.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        //BOTON BUSCAR
        else if (vMostrarAsignaturaProfesor != null && ae.getSource() == vMostrarAsignaturaProfesor.getjButtonBuscar()){
            String rut = vMostrarAsignaturaProfesor.getjTextFieldRut().getText();
            Profesor profesor = instituto.obtenerProfesor(rut);

            if (profesor != null) {
                vMostrarAsignaturaProfesor.rellenarTabla(profesor.listarAsignaturas());
                vMostrarAsignaturaProfesor.getjTextFieldMensaje().setText(profesor.contarAsignaturas() + " Asignaturas");
            }
            else {
                vMostrarAsignaturaProfesor.limpiarTabla();
                vMostrarAsignaturaProfesor.getjTextFieldMensaje().setText("No encontrado");
            }  
        }
        
        //BOTON VOLVER
        else if (vMostrarAsignaturaProfesor != null && ae.getSource() == vMostrarAsignaturaProfesor.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vMostrarAsignaturaProfesor.dispose();
        }
        
        
 
        //===================== EVENTOS DE CARRERAS =====================//
        //AGREGAR CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemAgregarCarrera()){
            vAgregarCarrera = new VentanaAgregarCarrera();
            vAgregarCarrera.getjButtonVolver().addActionListener(this);
            vAgregarCarrera.getjButtonAgregar().addActionListener(this);
            vAgregarCarrera.setAlwaysOnTop(true);     
            vAgregarCarrera.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vAgregarCarrera != null && ae.getSource() == vAgregarCarrera.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vAgregarCarrera.dispose();
        }
        else if(vAgregarCarrera != null && ae.getSource() == vAgregarCarrera.getjButtonAgregar()){
            Object lector;
            String lectorString;
            Verificaciones verificaciones = new Verificaciones();
            String ID = vAgregarCarrera.getjTextFieldID().getText().toString();
            String nombre = vAgregarCarrera.getjTextFieldNombre().getText().toString();
            
            //TRY, CATCH PARA SEMESTRES
            lector = vAgregarCarrera.getjTextFieldSemestres().getText();
            lectorString = lector.toString();
            try{
                if(!verificaciones.validarNumero(lectorString))
                        throw new NotCovertToNumericException();
            }catch(NotCovertToNumericException mensajeError){
                vAgregarCarrera.getjTextFieldMensaje().setText("ERROR: SOLO SE PERMITEN NUMERO EN SEMESTRES");
                return;
            }
            int semestres = Integer.parseInt(lectorString);
            
            //TRY, CATCH PARA ASIGNATURAS
            lector = vAgregarCarrera.getjTextFieldAsignaturas().getText();
            lectorString = lector.toString();
            try{
                if(!verificaciones.validarNumero(lectorString))
                        throw new NotCovertToNumericException();
            }catch(NotCovertToNumericException mensajeError){
                vAgregarCarrera.getjTextFieldMensaje().setText("ERROR: SOLO SE PERMITEN NUMERO EN ASIGNATURAS");
                return;
            }
            int asignaturas = Integer.parseInt(lectorString);

            Carrera nuevaCarrera = new Carrera(ID, nombre, semestres);
                      
            for(int i = 0 ; i < asignaturas ; i++){
                lector = vAgregarCarrera.getjTableLectura().getValueAt(i, 0);
                String codigo = "";
                if(lector != null)
                    codigo = lector.toString();
                
                lector = null;
                lector = vAgregarCarrera.getjTableLectura().getValueAt(i, 1);
                String nombreAs = "";
                if(lector != null)
                        nombreAs = lector.toString();
                
                lector = null;
                lector = vAgregarCarrera.getjTableLectura().getValueAt(i, 2);
                int creditos = 0;
                if(lector != null)
                    creditos = Integer.parseInt(lector.toString());

                
 
                Asignatura nuevaAsignatura = new Asignatura(codigo, nombreAs, creditos);
                nuevaCarrera.agregarAsignatura(nuevaAsignatura);
            }
            instituto.agregarCarrera(nuevaCarrera);
            vAgregarCarrera.getjTextFieldMensaje().setText("CARRERA INGRESADA CON EXITO");
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
        else if(vBuscarCarrera != null && ae.getSource() == vBuscarCarrera.getjButtonBuscar()){
            String ID = vBuscarCarrera.getjTextFieldBuscarID().getText();
            Carrera actual = instituto.obtenerCarrera(ID);
            if(actual != null)
            {
                vBuscarCarrera.getjTextFieldMensaje().setText("ENCONTRADO");
                vBuscarCarrera.getjTableMostrar().setValueAt(actual.getId(), 0, 0);
                vBuscarCarrera.getjTableMostrar().setValueAt(actual.getNombre(), 0, 1);
                vBuscarCarrera.getjTableMostrar().setValueAt(actual.cantidadCreditos(), 0, 2);
            }
            else
                vBuscarCarrera.getjTextFieldMensaje().setText("NO ENCONTADO");
            
            
        
        }
            
        //ELIMINAR CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemEliminarCarrera()){
            vEliminarCarrera = new VentanaEliminarCarrera();
            vEliminarCarrera.getjButtonEliminar().addActionListener(this);
            vEliminarCarrera.getjButtonVolver().addActionListener(this);
            vEliminarCarrera.setAlwaysOnTop(true);     
            vEliminarCarrera.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vEliminarCarrera != null && ae.getSource() == vEliminarCarrera.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vEliminarCarrera.dispose();
        }
        else if(vEliminarCarrera != null && ae.getSource() == vEliminarCarrera.getjButtonEliminar()){
            String ID = vEliminarCarrera.getjTextFieldBuscarID().getText();
            if(instituto.eliminarCarrera(ID))
                vEliminarCarrera.getjTextFieldMensaje().setText("Carrera eliminada exitosamente");
            else
                vEliminarCarrera.getjTextFieldMensaje().setText("No se encontro la carrera indicada");
        }    
        
        //MOSTRAR CARRERAS
        if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarCarreras()){
            vMostrarCarreras = new VentanaMostrarCarreras();
            vMostrarCarreras.getjButtonVolver().addActionListener(this);
            vMostrarCarreras.getjButtonLectura().addActionListener(this);
            vMostrarCarreras.setAlwaysOnTop(true);     
            vMostrarCarreras.setVisible(true);
            ventanaPrincipal.setVisible(false);
            
            //MOSTRAR
            for(int i = 0 ; i < instituto.cantidadCarreras() ; i++)
            {
                Carrera actual = instituto.obtenerCarrera(i);
                vMostrarCarreras.getjTableMostrar().setValueAt(actual.getId(), i, 0);
                vMostrarCarreras.getjTableMostrar().setValueAt(actual.getNombre(), i, 1);
                vMostrarCarreras.getjTableMostrar().setValueAt(actual.getSemestres(), i, 2);
                
                
            }
        }
        else if(vMostrarCarreras != null && ae.getSource() == vMostrarCarreras.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vMostrarCarreras.dispose();
        }
        //PRUEBA
        else if(vMostrarCarreras != null && ae.getSource() == vMostrarCarreras.getjButtonLectura()){
            System.out.println("LECTURA");
            JTable tabla = vMostrarCarreras.getjTableMostrar();
            int filasTabla = tabla.getRowCount();
            int columTabla = tabla.getColumnCount();
            System.out.println(filasTabla + " " + columTabla);
            String cadena = tabla.getValueAt(1, 1).toString();
            System.out.println("lectura" + cadena);
        }
        
        /* LECTURA DESDE UN PANEL
            System.out.println("LECTURA");
            JTable tabla = vMostrarCarreras.getjTableMostrar();
            int filasTabla = tabla.getRowCount();
            int columTabla = tabla.getColumnCount();
            System.out.println(filasTabla + " " + columTabla);
            String cadena = tabla.getValueAt(1, 1).toString();
            System.out.println("lectura" + cadena);
        */
        
        //EVENTOS ALUMNOS
        //ACTUALIZACION ESTADO AGREGAR Y INTERACCION EN AGREGAR
        if(ae.getSource() == ventanaPrincipal.getjMenuItemAgregarAlumno()){
            vAgregarAlumno = new VentanaAgregarAlumno();
            vAgregarAlumno.rellenarTabla(instituto.listarCarreras());
            vAgregarAlumno.getjButtonAgregar().addActionListener(this);
            vAgregarAlumno.getjButtonVolver().addActionListener(this);
            vAgregarAlumno.setAlwaysOnTop(true);     
            vAgregarAlumno.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if (vAgregarAlumno != null && ae.getSource() == vAgregarAlumno.getjButtonAgregar()){
            Alumno alumno = new Alumno(vAgregarAlumno.getjTextFieldNombre().getText(),
                                       vAgregarAlumno.getjTextFieldApellido().getText(),
                                       vAgregarAlumno.getjTextFieldRut().getText(),
                                       Integer.parseInt(vAgregarAlumno.getjTextFieldEdad().getText()));
            
            
            Carrera carrera = instituto.obtenerCarrera(vAgregarAlumno.getjTextFieldIdCarrera().getText());
            
            if (carrera != null)
            {
                alumno.setCarrera(carrera);
                instituto.agregarAlumno(alumno);
                vAgregarAlumno.getjTextFieldMensaje().setText("ALUMNO AGREGADO");
            }
            else{
                vAgregarAlumno.getjTextFieldMensaje().setText("ALUMNO NO AGREGADO");
            }
        }
        else if(vAgregarAlumno != null && ae.getSource() == vAgregarAlumno.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vAgregarAlumno.dispose();
        }
        
        //ACTUALIZACION ESTADO BUSCAR POR RUT
        if(ae.getSource() == ventanaPrincipal.getjMenuItemBuscarPorRut()){
            vBuscarAlumno = new VentanaBuscarAlumno();
            vBuscarAlumno.getjButtonBuscar().addActionListener(this);
            vBuscarAlumno.getjButtonVolver().addActionListener(this);
            vBuscarAlumno.setAlwaysOnTop(true);     
            vBuscarAlumno.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vBuscarAlumno != null && ae.getSource() == vBuscarAlumno.getjButtonBuscar()){
            String rut = vBuscarAlumno.getjTextFieldRut().getText();
            Alumno actual = instituto.obtenerAlumno(rut);
            if(actual != null)
            {
                vBuscarAlumno.getjTextFieldMensaje().setText("ALUMNO ENCONTRADO");
                vBuscarAlumno.getjTableDatos().setValueAt(actual.getNombre(), 0, 0);
                vBuscarAlumno.getjTableDatos().setValueAt(actual.getApellido(), 0, 1);
                vBuscarAlumno.getjTableDatos().setValueAt(actual.getRut(), 0, 2);
                vBuscarAlumno.getjTableDatos().setValueAt(actual.getEdad(), 0, 3);
                vBuscarAlumno.getjTableDatos().setValueAt(actual.getCarrera(), 0, 4);
            }
            else
                vBuscarAlumno.getjTextFieldMensaje().setText("ALUMNO NO ENCONTADO");
        }
        else if(vBuscarAlumno != null && ae.getSource() == vBuscarAlumno.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vBuscarAlumno.dispose();
        }
        
        //ACTUALIZACION ESTADO BUSCAR POR CARRERA
        if(ae.getSource() == ventanaPrincipal.getjMenuItemBuscarPorCarrera()){
            vBuscarAlumnoCarrera = new VentanaBuscarAlumnoCarrera();
            vBuscarAlumnoCarrera.getjButtonBuscar().addActionListener(this);
            vBuscarAlumnoCarrera.getjButtonVolver().addActionListener(this);
            vBuscarAlumnoCarrera.setAlwaysOnTop(true);     
            vBuscarAlumnoCarrera.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vBuscarAlumnoCarrera != null && ae.getSource() == vBuscarAlumnoCarrera.getjButtonBuscar()){
            String ID = vBuscarAlumnoCarrera.getjTextFieldIdCarrera().getText();
            Carrera carrera = instituto.obtenerCarrera(ID);
            boolean hayAlumnosCarrera = false;
            int contador = 0;
            if(carrera != null)
            {
                if (instituto.cantidadAlumnos() != 0) {
                    for (int i = 0; i < instituto.cantidadAlumnos() ; i++) {
                        Alumno alumnoActual = instituto.obtenerAlumno(i);
                        String idCarreraAlumno = alumnoActual.getCarrera().getId();
                        

                        if (ID.equals(idCarreraAlumno)) {
                            vBuscarAlumnoCarrera.getjTextFieldMensaje().setText("ALUMNOS ENCONTRADO");
                            vBuscarAlumnoCarrera.getjTable1Datos().setValueAt(alumnoActual.getNombre(), contador, 0);
                            vBuscarAlumnoCarrera.getjTable1Datos().setValueAt(alumnoActual.getApellido(), contador, 1);
                            vBuscarAlumnoCarrera.getjTable1Datos().setValueAt(alumnoActual.getRut(), contador, 2);
                            vBuscarAlumnoCarrera.getjTable1Datos().setValueAt(alumnoActual.getEdad(), contador, 3);
                            vBuscarAlumnoCarrera.getjTable1Datos().setValueAt(alumnoActual.getCarrera(), contador, 4);
                            vBuscarAlumnoCarrera.getjTable1Datos().setValueAt(alumnoActual.getCreditosAprobados(), contador, 5);
                            contador ++;
                            hayAlumnosCarrera = true;
                        }
                    }
                if(hayAlumnosCarrera)
                {
                    vBuscarAlumnoCarrera.getjTextFieldMensaje().setText("ALUMNOS INSCRITOS");
                }
                else{
                    vBuscarAlumnoCarrera.getjTextFieldMensaje().setText("NO HAY ALUMNOS INSCRITOS EN ESTA CARRERA");
                }
            }
            else
                vBuscarAlumnoCarrera.getjTextFieldMensaje().setText("NO ENCONTADO");
            }
        }
        else if(vBuscarAlumnoCarrera != null && ae.getSource() == vBuscarAlumnoCarrera.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vBuscarAlumnoCarrera.dispose();
        }
        
        //ACTUALIZACION ESTADO ELIMINAR ALUMNO 
        if(ae.getSource() == ventanaPrincipal.getjMenuItemEliminarAlumno()){
            vEliminarAlumno = new VentanaEliminarAlumno();
            vEliminarAlumno.getjButtonEliminar().addActionListener(this);
            vEliminarAlumno.getjButtonVolver().addActionListener(this);
            vEliminarAlumno.setAlwaysOnTop(true);     
            vEliminarAlumno.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if (vEliminarAlumno != null && ae.getSource() == vEliminarAlumno.getjButtonEliminar()){
            String rut = vEliminarAlumno.getjTextFieldRut().getText();
            if (instituto.eliminarAlumno(rut))
                vEliminarAlumno.getjTextFieldMensaje().setText("Alumno eliminado con éxito");
            else
                vEliminarAlumno.getjTextFieldMensaje().setText("Alumno no encontrado");
        }
        else if(vEliminarAlumno != null && ae.getSource() == vEliminarAlumno.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vEliminarAlumno.dispose();
        }
        //ACTUALIZACION ESTADO ACTUALIZACION ESTADO ASIGNATURA ALUMNO
        if(ae.getSource() == ventanaPrincipal.getjMenuItemActualizacionEstadoAsignaturaAlumno()){
            vActualizarEstadoAsignaturaAlumno = new VentanaActualizacionEstadoAsignaturaAlumno();
            vActualizarEstadoAsignaturaAlumno.getjButtonActualizar().addActionListener(this);
            vActualizarEstadoAsignaturaAlumno.getjButtonBuscar().addActionListener(this);
            vActualizarEstadoAsignaturaAlumno.getjButtonVolver().addActionListener(this);
            vActualizarEstadoAsignaturaAlumno.setAlwaysOnTop(true);     
            vActualizarEstadoAsignaturaAlumno.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vActualizarEstadoAsignaturaAlumno != null && ae.getSource() == vActualizarEstadoAsignaturaAlumno.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vActualizarEstadoAsignaturaAlumno.dispose();
        }
        else if(vActualizarEstadoAsignaturaAlumno != null && ae.getSource() == vActualizarEstadoAsignaturaAlumno.getjButtonBuscar()){
            String rut = vActualizarEstadoAsignaturaAlumno.getjTextFieldRut().getText();
            Alumno actual = instituto.obtenerAlumno(rut);
            Carrera carrera = actual.getCarrera();
            
            if(actual != null)
            {
                for (int i = 0 ; i < carrera.cantidadAsignaturas(); i++)
                {
                    AsignaturaInscrita asignaturaActual = (AsignaturaInscrita)carrera.obtenerAsignatura(i);
                    vActualizarEstadoAsignaturaAlumno.getjTextFieldMensaje().setText("ALUMNO ENCONTRADO");
                    vActualizarEstadoAsignaturaAlumno.getjTableDatos().setValueAt(asignaturaActual.getCodigo(), i, 0);      
                }
            }
            else
                vActualizarEstadoAsignaturaAlumno.getjTextFieldMensaje().setText("ALUMNO NO ENCONTADO");
        }
        
         else if(vActualizarEstadoAsignaturaAlumno != null && ae.getSource() == vActualizarEstadoAsignaturaAlumno.getjButtonActualizar()){
            JTable tabla = vActualizarEstadoAsignaturaAlumno.getjTableDatos();
            String rut = vActualizarEstadoAsignaturaAlumno.getjTextFieldRut().getText();
            Alumno actual = instituto.obtenerAlumno(rut);
            Carrera carreraActual = actual.getCarrera();
            
            for (int i = 0 ; i < carreraActual.cantidadAsignaturas() ; i++)
            {
                AsignaturaInscrita asignatura = (AsignaturaInscrita)carreraActual.obtenerAsignatura(i);
                Object estadoAprobado = tabla.getValueAt(i, 1);
                Object estadoReprobado = tabla.getValueAt(i, 2);
                Object estadoInscrito = tabla.getValueAt(i, 3);
                
                if (estadoAprobado != null)
                {
                    asignatura.aprobar();
                }
                else if (estadoReprobado != null)
                {
                    asignatura.reprobar();
                }
                else if (estadoInscrito != null){
                    asignatura.inscribir();
                }
                
            }
            
        }
        
        //ACTUALIZACION ESTADO ASIGNATURA ALUMNO
        if(ae.getSource() == ventanaPrincipal.getjMenuItemEstadoAsignatura()){
            vEstadoAsignaturaAlumno = new VentanaEstadoAsignaturaAlumno();
            vEstadoAsignaturaAlumno.getjButtonBuscar().addActionListener(this); 
            vEstadoAsignaturaAlumno.getjButtonVolver().addActionListener(this);
            vEstadoAsignaturaAlumno.setAlwaysOnTop(true);     
            vEstadoAsignaturaAlumno.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        else if(vEstadoAsignaturaAlumno != null && ae.getSource() == vEstadoAsignaturaAlumno.getjButtonBuscar()){
            String rut = vEstadoAsignaturaAlumno.getjTextFieldRut().getText();
            Alumno actual = instituto.obtenerAlumno(rut);
            Carrera carrera = actual.getCarrera();
            if(actual != null)
            {
                for (int i = 0 ; i < carrera.cantidadAsignaturas(); i++)
                {
                    AsignaturaInscrita asignaturaActual = (AsignaturaInscrita)carrera.obtenerAsignatura(i);
                    vEstadoAsignaturaAlumno.getjTextFieldMensaje().setText("ALUMNO ENCONTRADO");
                    vEstadoAsignaturaAlumno.getjTableDatos().setValueAt(asignaturaActual.getNombre(), i, 0);
                    vEstadoAsignaturaAlumno.getjTableDatos().setValueAt(asignaturaActual.getEstado(), i, 1);
                }
            }
            else
                vEstadoAsignaturaAlumno.getjTextFieldMensaje().setText("ALUMNO NO ENCONTADO");
        }
        else if(vEstadoAsignaturaAlumno != null && ae.getSource() == vEstadoAsignaturaAlumno.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vEstadoAsignaturaAlumno.dispose();
        }
        //ACTUALIZACION ESTADO MOSTRAR ALUMNO
        if(ae.getSource() == ventanaPrincipal.getjMenuItemMostrarAlumnos()){
            vMostrarAlumnos = new VentanaMostrarAlumnos();
            vMostrarAlumnos.rellenarTabla(instituto.listarAlumnos());
            vMostrarAlumnos.getjButtonVolver().addActionListener(this);
            vMostrarAlumnos.setAlwaysOnTop(true);     
            vMostrarAlumnos.setVisible(true);
            ventanaPrincipal.setVisible(false);
        }
        
        
        else if(vMostrarAlumnos != null && ae.getSource() == vMostrarAlumnos.getjButtonVolver()){
            ventanaPrincipal.setVisible(true);
            vMostrarAlumnos.dispose();
        }
        
        
        
        
    }
    
 }
