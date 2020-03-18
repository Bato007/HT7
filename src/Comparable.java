/**
 * @author Brandon Hernández 19376
 * @className Comparable
 * @since 17/03/2020
 * @version 17/03/2020
 *
 * @reference Java Structures, Duane Bailey
 * @param <T>
 * Contrato de comparable
 */
public interface Comparable<T> {

    /**
     * Compara dos elementos
     * @param that valor que se comparara
     * @return 0 si son iguales, - si es menor y + si es mayor
     */
    public int compareTo(T that);
}
