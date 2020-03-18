/**
 * @author Brandon Hernández 19376
 * @since 17/03/2020
 * @version 20/03/2020
 *
 * @param <E>
 */
public class TreeNode<E> {

    //Atributos del arbol
    private E data;
    private TreeNode<E> parent, leftSon, rightSon;

    /**
     * Constructor de un nodo de arbol
     * @pos se crea un nodo de arbol vacio
     */
    public TreeNode(){
        data = null;
        parent = null;
        leftSon = rightSon = this;
    }

    /**
     * Constructor del nodo del arbol con un parametro
     * @param newData dato que quiere ser gaurdado
     * @pos se crea un nuevo nodo de arbol
     */
    public TreeNode(E newData) {
        data = newData;
        leftSon = rightSon = new TreeNode<>();
        setLeftSon(leftSon);
        setRightSon(rightSon);
    }

    /**
     * Constructor con un valor y dos hijos de una
     * @pos devuelve un arbol que tiene dos referencias
     * @param value el dato que se le quiere asignar
     * @param left el nodo izquierdo que se quiere asignar
     * @param right el nodo derecho que se le quiere asignar
     */
    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right){
        data = value;

        if (left == null){
            left = new TreeNode<>();
        }
        setLeftSon(left);
        if (right == null){
            right = new TreeNode<>();
        }
        setRightSon(right);
    }

    public Boolean isEmpty(){
        return (parent == null && leftSon == null && rightSon == null);
    }


    // Seccion de GETTERS
    /**
     * Se encarga de obtener al papa
     * @return al papa
     */
    public TreeNode<E> getParent(){
        return parent;
    }

    /**
     * Se encarga de obtener el hijo izquierdo
     * @return el hijo izquierdo
     */
    public TreeNode<E> getLeftSon() {
        return leftSon;
    }

    /**
     * Se encarga de obtener el nodo derecho
     * @return el hijo derecho
     */
    public TreeNode<E> getRightSon(){
        return rightSon;
    }

    /**
     * Se encarga de obtener el dato de data
     * @return atributo data
     */
    public E getData(){
        return data;
    }

    // Seccion de SETTERS

    /**
     * Asigna un valor al papa
     * @pos el papa tiene una nueva referencia
     * @param newParent la referencia que se quiere dar
     */
    public void setParent(TreeNode<E> newParent){
        parent = newParent;
    }

    /**
     * Asignarle un valor al hijo izquierdo
     * @pos el hijo izquierdo tiene un nuevo valor y un padre
     * @param newLeftSon valor que se le quiere dar al hijo
     */
    public void setLeftSon(TreeNode<E> newLeftSon){
        if(leftSon != null && leftSon.getParent() == this){
            leftSon.setParent(null);
        }
        this.leftSon = newLeftSon;
        leftSon.setParent(this);
    }

    /**
     * Asignarle un valor al hijo derehco
     * @pos el hijo derecho tiene un nuevo valor
     * @param newRightSon valor que se le quiere dar al hijo
     */
    public void setRightSon(TreeNode<E> newRightSon){
        if(rightSon != null && rightSon.getParent() == this){
            rightSon.setParent(null);
        }
        this.rightSon = newRightSon;
        rightSon.setParent(this);
    }

    /**
     * Asigna un valor al dato
     * @param newData el valor que se le quiere asignar
     */
    public void setData(E newData){
        data = newData;
    }

}
