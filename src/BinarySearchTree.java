import java.util.ArrayList;

/**
 * @author Brandon Hernández 19376
 * @since 21/03/2020
 * @version 21/03/2020
 *
 * @reference https://www.youtube.com/watch?v=ZKnwBJ8q2TE&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=34
 * @reference https://www.youtube.com/watch?v=l8XPkY_q4Qs&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=35
 * @reference https://www.youtube.com/watch?v=SNU7J3kkrFY&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=39&t=0s
 * @param <E> es el tipo de dato, que extiende a comparable
 *
 * Encargada de guardar la informacion y buscarla
 */
public class BinarySearchTree<E extends Comparable<E>> {

    // La raiz del arbol binario
    private TreeNode<E> root;
    private ArrayList<E> inOrder = new ArrayList<>();

    /**
     * Constructor del arbol
     * @pre la raiz no esta inicializada
     * @pos hay una instancia
     */
    public BinarySearchTree(){
        root = null;
    }

    /**
     * Se encarga de agregar un elemento al arbol
     * @pre hay n cantidad de elementos
     * @pos hay (n + 1) cantidad de elementos
     * @param newData el valor que quiere ser agregado
     */
    public void add(E newData){
        TreeNode<E> newNode = new TreeNode<>(newData);

        // Observando si la raiz es null
        if(root == null){
            root = newNode;
        } else{
            TreeNode<E> aux = root;
            TreeNode<E> father;

            while(true){
                father = aux;

                if(newData.compareTo(aux.getData()) < 0){ // Agregando al lado izquierdo
                    aux = aux.getLeftSon();
                    if(aux == null){
                        father.setLeftSon(newNode);
                        return;
                    }

                } else{
                    aux = aux.getRightSon();
                    if(aux == null){
                        father.setRightSon(newNode);
                        return;
                    }

                }

            }

        }

    }

    /**
     * Se encarga de encontrar el valor
     * @pos se obtiene el dato buscado
     * @return el dato que tiene el nodo
     */
    public E findValue(E searchValue){
        TreeNode<E> aux = this.root;

        while (aux.getData() != searchValue){

            if(searchValue.compareTo(aux.getData()) < 0){
                aux = aux.getLeftSon();
            }else aux = aux.getRightSon();

            if(null == aux){
                return null;
            }
        }

        return aux.getData();
    }

    /**
     * Se recorre el arbol en order
     * @pos se obtienen los datos en orden del arbol
     * @param node el nodo de arbol que quiere ser conseguido
     */
    public void inOrder(TreeNode<E> node){
        if( node != null){
            inOrder(node.getLeftSon());
            inOrder.add(node.getData());
            inOrder(node.getRightSon());
        }
    }

    // GETTER
    public TreeNode<E> getRoot() {
        return root;
    }

    public ArrayList<E> getInOrder() {
        return inOrder;
    }
}
