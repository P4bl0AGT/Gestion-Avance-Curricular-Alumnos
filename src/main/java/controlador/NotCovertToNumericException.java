/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author pagui
 */
public class NotCovertToNumericException extends Exception{
    public NotCovertToNumericException(){
        super("La cadena que se ingreso no es numerica");
    }
}