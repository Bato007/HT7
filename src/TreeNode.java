/**
 * @author Brandon Hernández 19376
 * @since 17/03/2020
 * @version 21/03/2020
 *
 * @reference https://www.youtube.com/watch?v=ZKnwBJ8q2TE&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=35&t=898s
 * @param <E> tipo de dato; string en este caso
 *
 * Encargado de
 */
public class TreeNode<E> {

    // Atributos de de clase
    protected E data;
    protected TreeNode<E> leftSon, rightSon;

    /**
     * Constructor del nodo del arbol
     * @param newData valor que se le va a agregar al nodo
     */
    public TreeNode(E newData){
        this.data = newData;
        this.leftSon = this.rightSon = null;
    }

    // SETTERS
    public void setLeftSon(TreeNode<E> leftSon) {
        this.leftSon = leftSon;
    }

    public void setRightSon(TreeNode<E> rightSon) {
        this.rightSon = rightSon;
    }

    public void setData(E data) {
        this.data = data;
    }

    // GETTERS
    public TreeNode<E> getLeftSon() {
        return leftSon;
    }

    public TreeNode<E> getRightSon(){
        return rightSon;
    }

    public E getData() {
        return data;
    }
}
