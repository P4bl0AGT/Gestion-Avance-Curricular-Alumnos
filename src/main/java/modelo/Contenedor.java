package modelo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase representa uun contenedor
 * esta clase contiene una ArrayList y un HashMap
 */

//Generics || K = key || T = type ||
public class Contenedor<K, T> {

    //=================================== ATRIBUTOS ===================================//
    private HashMap<K, T> mapa;
    private ArrayList<T> lista;


    //=================================== CONSTRUCTORES ===================================//
    public Contenedor() {
        this.mapa = new HashMap<>();
        this.lista = new ArrayList<>();
    }
    
    //=================================== METODOS ===================================//  
    /**
    * @param clave La clave de lo que queremos agregar
    * @param valor El valor de lo que queremos agregar
    * @return Un estado bool para saber si se agrego o no
    */
    public boolean agregar(K clave, T valor) {
        if (!mapa.containsKey(clave)) {
            mapa.put(clave, valor);
            lista.add(valor);
            return true;
        }
        return false;
    }
    /**
    * @param clave La clave de lo que queremos obtener
    * @return retorna el objeto con la clave correspondiente
    */
    public T obtener(K clave) {
        return mapa.get(clave);}

    /**
    * @param i El indice de lo que queremos obtener
    * @return retorna el objeto con el indice correspondiente
    */
    public T obtener(int i) {
        return lista.get(i);}
    /**
    * @param clave La clave de lo que queremos eliminar
    * @return retorna el objeto con la clave correspondiente o null si no existe
    */
    public T eliminar(K clave) {
        if (mapa.containsKey(clave)) {
            T objeto = mapa.get(clave);
            lista.remove(objeto);
            mapa.remove(clave);
            return objeto;
        }
        return null;
    }
    /**
     * metodo que obtiene la talla del contenedor
    * @return retorna el objeto con la clave correspondiente o null si no existe
    */
    public int talla() {
        return lista.size();}
    /**
     * metodo que itera sobre la coleccion
    * @return retorna nose xd
    */
    public Iterator<T> iterador() {
        return lista.iterator();
    }
}
