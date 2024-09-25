package sia;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

//Generics || K = key || T = type ||
public class Contenedor<K, T> {

    //ATRIBUTOS
    private HashMap<K, T> mapa;
    private ArrayList<T> lista;


    //CONSTRUCTOR
    public Contenedor() {
        this.mapa = new HashMap<>();
        this.lista = new ArrayList<>();
    }


    //METODOS
    public boolean agregar(K clave, T valor) {
        if (!mapa.containsKey(clave)) {
            mapa.put(clave, valor);
            lista.add(valor);
            return true;
        }
        return false;
    }

    public T obtener(K clave) {
        return mapa.get(clave);
    }

    public T obtener(int i) {
        return lista.get(i);
    }

    public T eliminar(K clave) {
        if (mapa.containsKey(clave)) {
            T objeto = mapa.get(clave);
            lista.remove(objeto);
            mapa.remove(clave);
            return objeto;
        }
        return null;
    }

    public int talla() {
        return lista.size();
    }

    public Iterator<T> iterador() {
        return lista.iterator();
    }
}
