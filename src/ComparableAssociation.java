/**
 * @author Brandon Hernández 19376
 * @className Association
 * @since 17/03/2020
 * @version 17/03/2020
 *
 * @reference Java Structures, Duane Bailey
 * Se encarga de realizar las asociaciones
 */
public class ComparableAssociation<K extends Comparable<K>,V> extends Association<K,V> implements Comparable<ComparableAssociation<K,V>> {

    /**
     * Constructor
     * @param key valor que le da acceso al valor
     * @param value informacion que se guarda
     */
    public ComparableAssociation(K key, V value){
        super(key,value);
    }

    /**
     * Compara dos elementos
     * @param that valor que se comparara
     * @return 0 si son iguales, - si es menor y + si es mayor
     */
    public int compareTo(ComparableAssociation<K,V> that){
        return this.getKey().compareTo(that.getKey());
    }
}
