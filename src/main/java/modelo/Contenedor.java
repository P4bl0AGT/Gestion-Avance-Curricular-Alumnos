package modelo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * Esta clase representa un contenedor genérico que combina un HashMap
 * y un ArrayList. Permite almacenar elementos utilizando una clave y
 * acceder a ellos tanto por clave como por índice.
 * @param <K> Key = Tipo de la clave
 * @param <T> Type = Tipo del objeto
 */
public class Contenedor<K, T> {
    // =========================================================================
    // ============================ ATRIBUTOS ==================================
    // =========================================================================
    private HashMap<K, T> mapa;
    private ArrayList<T> lista;
    
    
    
    
    // =========================================================================
    // ========================== CONSTRUCTOR ==================================
    // =========================================================================
    public Contenedor() {
        this.mapa = new HashMap<>();
        this.lista = new ArrayList<>();
    }
    
    
    
    // =========================================================================
    // ============================= GETTERS ===================================
    // =========================================================================
    // Al ser una clase wrapper que encapsula-envuelve colecciones no puede tener getters
    
    
    
    
    // =========================================================================
    // ============================= SETTERS ===================================
    // =========================================================================
    // Al ser una clase wrapper que encapsula-envuelve colecciones no puede tener setters
    
    
    
    
    // =========================================================================
    // ============================= METODOS ===================================
    // =========================================================================
    /**
     * Agrega un elemento al contenedor.
     * @param clave La clave de lo que queremos agregar
     * @param objeto El objeto que queremos agregar al contenedor
     * @return Un estado bool para saber si se agrego o no
     */
    public boolean agregar(K clave, T objeto) {
        if (!mapa.containsKey(clave)) {
            mapa.put(clave, objeto);
            lista.add(objeto);
            return true;
        }
        return false;
    }
    
    
    /**
     * Obtiene un elemento del contenedor utilizando su clave.
     * @param clave La clave de lo que queremos obtener
     * @return retorna el objeto con la clave correspondiente
     */
    public T obtener(K clave) {
        return mapa.get(clave);}
    
    
    /**
     * Obtiene un elemento del contenedor utilizando su índice.
     * @param i El indice de lo que queremos obtener
     * @return retorna el objeto con el indice correspondiente
     */
    public T obtener(int i) {
        return lista.get(i);}
    
    
    /**
     * Elimina un elemento del contenedor utilizando su clave.
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
     * Metodo que obtiene la cantidad de elementos en el contenedor.
    * @return El número de elementos almacenados en el contenedor.
    */
    public int talla() {
        return lista.size();}
    
    
    /**
     * Retorna un iterador sobre los elementos del contenedor.
     * @return Un iterador para recorrer los elementos almacenados en el contenedor.
     */
    public Iterator<T> iterador() {
        return lista.iterator();
    }
}
