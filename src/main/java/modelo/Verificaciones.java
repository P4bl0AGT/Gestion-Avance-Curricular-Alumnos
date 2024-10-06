package modelo;

import java.io.BufferedReader;
import java.io.IOException;

public class Verificaciones {

    //ESTE METODO SOLO VERIFICA SI UN CARACTER ES NUMERICO
    private boolean esNumero(char digito) {

            int codePoint = (int) digito;
        
            if( !(codePoint >= 48 && codePoint <= 57)) return false;
            return true;
    }
    //ESTE METODO SOLO VERIFICA SI UNA CADENA ES NUMERICA
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
    //@overide
    public boolean validarEdad(String posibleEdad){
        int edadRevisar = Integer.parseInt(posibleEdad);
        if (edadRevisar >= 0 && edadRevisar <= 100)
            return true;
        return false;
    }
    
    public boolean validarNumeroRango(String cadena, int limSup, int limInf){
        if(!validarNumero(cadena)) return false;
        int numero = Integer.parseInt(cadena);

        if (numero >= limInf && numero <= limSup)
            return true;
        return false;
    }

    //@overide
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
    //@overide
    public int verificarEdad(BufferedReader lector, String mensaje) throws IOException{
        System.out.print(mensaje);
        String cadena = lector.readLine();

         try{
            if (!validarNumero(cadena))
                throw new NotCovertToNumericException();
            if(!validarEdad(cadena))
                throw new InvalidAgeException();

        }
        catch (NotCovertToNumericException mensajeError){
            while(true)
            {
                
                System.out.println(mensajeError);
                System.out.print(mensaje);
                cadena = lector.readLine();

                if (validarNumero(cadena) && validarEdad(cadena))
                    break;
            }
        }
        catch(InvalidAgeException mensajeError){
            while(true)
            {
                
                System.out.println(mensajeError);
                System.out.print(mensaje);
                cadena = lector.readLine();

                if (validarNumero(cadena) && validarEdad(cadena))
                    break;
            }
        }

        return Integer.parseInt(cadena);
    }
}   