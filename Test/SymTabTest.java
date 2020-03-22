import static org.junit.Assert.*;

public class SymTabTest {

    public void Test(){
        BinarySearchTree<ComparableAssociation<String, String>>  tree = new BinarySearchTree<>();

        // Prueba add
        tree.add(new ComparableAssociation<>("house", "casa"));
        tree.add(new ComparableAssociation<>("dog", "perro"));
        tree.add(new ComparableAssociation<>("homework", "tarea"));
        tree.add(new ComparableAssociation<>("woman", "mujer"));
        tree.add(new ComparableAssociation<>("town", "pueblo"));

        // Prueba de buscar
        assertEquals("casa", tree.findValue(new ComparableAssociation<>("house")));

    }

}