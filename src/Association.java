/**
 * @author Brandon Hernández 19376
 * @className Association
 * @since 17/03/2020
 * @version 17/03/2020
 *
 * @reference Java Structures, Duane Bailey
 * Se encarga de simular un mapa
 */
public class Association<K, V> {

    // Atributos de la clase association
    private K key;
    private V value;

    /**
     * Constructor
     * @pos se crea un nuevo objeto tipo association
     * @param key valor de la llave que da acceso al valor
     * @param value el dato que tendra el valor
     */
    public Association(K key, V value){
        this.key = key;
        this.value = value;
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
