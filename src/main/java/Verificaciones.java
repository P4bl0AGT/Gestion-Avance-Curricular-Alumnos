import java.io.BufferedReader;
import java.io.IOException;

public class Verificaciones {

    private boolean esNumero(char digito) {

            int codePoint = (int) digito;
        
            if( !(codePoint >= 48 && codePoint <= 57)) return false;
            return true;
    }

    public boolean validarNumero(String dato){
        for (int i = 0 ; i < dato.length() ; i++)
        {
            char caracter = dato.charAt(i);
            if(!esNumero(caracter)){
                return false;
            }
        }
        return true;
    }

    public int validarEntrada(BufferedReader lector, String mensaje) throws IOException{

        System.out.print(mensaje);
        String cadena = lector.readLine();

        try{
            if (!validarNumero(cadena))
                throw new NotCovertToNumericException();

        }
        catch (NotCovertToNumericException mensajeError){
            while(true)
            {
                
                System.out.println(mensajeError);
                System.out.print(mensaje);
                cadena = lector.readLine();

                if (validarNumero(cadena))
                    break;
            }
        }

        return Integer.parseInt(cadena);
    }
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