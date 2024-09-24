public class Excepciones extends Excepition{
    //SIMPLEMENTE LO TENEMOS PARA QUE EXISTA EL ARCHIVOS
}

class NotCovertToNumericException extends Exception{
    public NotCovertToNumericException(){
        super("La cadena que se ingreso no es numerica");
    }
}

class InvalidaAgeException extends Exception{
    public InvalidaAgeException(){
        super("La edad ingresada no es valida");
    }
}