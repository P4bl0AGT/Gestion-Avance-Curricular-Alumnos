package exception;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(){
        super("La edad ingresada no es valida");
    }
}