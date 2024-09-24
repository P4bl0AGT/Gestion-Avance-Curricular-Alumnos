import java.io.BufferedReader;

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


    
    public int validarEntrada(BufferedReader lector, String dato, String mensaje){

        System.out.print(mensaje);
        String cadena = lector.readLine();

        try{
            if (validarNumero(cadena))
                return Integer.parseInt(cadena);
        } catch (NotCovertToNumericException mensajeError){
            while(true)
            {
                System.out.println(mensajeError);

                System.out.print(mensaje);
                cadena = lector.readLine();

                if (validarNumero(cadena))
                    return Integer.parseInt(cadena);
            }
        }

    }

}
