package exception;

public class NotCovertToNumericException extends Exception{
    public NotCovertToNumericException(){
        super("La cadena que se ingreso no es numerica");
    }
}