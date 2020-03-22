import java.lang.*;
/**
 * @author Brandon Hernández 19376
 * @className Association
 * @since 17/03/2020
 * @version 21/03/2020
 *
 * @reference Java Structures, Duane Bailey
 * Se encarga de realizar las asociaciones
 */
public class ComparableAssociation<K extends Comparable<K>,V> implements Comparable<ComparableAssociation<K,V>> {

    // Atributos de la clase association
    private K key;
    private V value;

    /**
     * Constructor cuando mandan ambos datos
     * @pos se crea un nuevo objeto tipo association
     * @param key valor de la llave que da acceso al valor
     * @param value el dato que tendra el valor
     */
    public ComparableAssociation(K key, V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Constructor cuando solo manda la llave
     * @pre el valor de key y value no tienen valor
     * @pos el valor de key y value son inicializados
     * @param key es el valor de la llave que se le quiere dar
     */
    public ComparableAssociation(K key){
        this.key = key;
        this.value = null;
    }

    /**
     * Compara dos elementos
     * @param that valor que se comparara
     * @return 0 si son iguales, - si es menor y + si es mayor
     */
    public int compareTo(ComparableAssociation<K,V> that){
        return key.compareTo(that.key);
    }

    /**
     * Conseguir el valor de la llave
     * @return la llave
     */
    public K getKey(){
        return this.key;
    }

    /**
     * Conseguir el valor del dato
     * @return el valor del dato
     */
    public V getValue() {
        return this.value;
    }
}
