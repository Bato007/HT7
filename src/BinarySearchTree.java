import java.util.Comparator;
/**
 *
 * @reference https://www.youtube.com/watch?v=ZKnwBJ8q2TE&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=34
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {


    /**
     * A reference to the root of the tree
     */
    protected TreeNode<E> root;

    /**
     * The node used as all leaves, in this implementation.
     */
    protected final TreeNode<E> EMPTY = new TreeNode<E>();

    /**
     * The number of nodes in the tree
     */
    protected int count;
    /**
     * The ordering used on this search tree.
     */
    protected Comparator<E> ordering;

    public BinarySearchTree(){
            this(new NaturalComparator<E>());
    }

    public BinarySearchTree(Comparator<E> alternateOrder){
        root = EMPTY;
        count = 0;
        ordering = alternateOrder;
    }

    public boolean isEmpty(){
        return root == EMPTY;
    }

    public void clear(){
        root = new TreeNode<E>();
        count = 0;
    }

    public int size(){
        return count;
    }

    protected TreeNode<E> locate(TreeNode<E> root, E value)
    {
        E rootValue = root.getData();
        TreeNode<E> child;

        // found at root: done
        if (rootValue.equals(value)) return root;
        // look left if less-than, right if greater-than
        if (ordering.compare(rootValue,value) < 0)
        {
            child = root.getRightSon();
        } else {
            child = root.getLeftSon();
        }
        // no child there: not in tree, return this node,
        // else keep searching
        if (child.isEmpty()) {
            return root;
        } else {
            return locate(child, value);
        }
    }

    protected TreeNode<E> predecessor(TreeNode<E> root) {
        TreeNode<E> result = root.getLeftSon();
        while (!result.getRightSon().isEmpty()) {
            result = result.getRightSon();
        }
        return result;
    }

    protected TreeNode<E> successor(TreeNode<E> root){
        TreeNode<E> result = root.getRightSon();
        while (!result.getLeftSon().isEmpty()) {
            result = result.getLeftSon();
        }
        return result;
    }

    public void add(E value)
    {
        TreeNode<E> newNode = new TreeNode<E>(value,EMPTY,EMPTY);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            TreeNode<E> insertLocation = locate(root,value);
            E nodeValue = insertLocation.getData();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            if (ordering.compare(nodeValue,value) < 0) {
                insertLocation.setRightSon(newNode);
            } else {
                if (!insertLocation.getLeftSon().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRightSon(newNode);
                } else {
                    insertLocation.setLeftSon(newNode);
                }
            }
        }
        count++;
    }

    public boolean contains(E value)
    {
        if (root.isEmpty()) return false;

        TreeNode<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.getData());
    }

    public E get(E value)
    {
        if (root.isEmpty()) return null;

        TreeNode<E> possibleLocation = locate(root,value);
        if (value.equals(possibleLocation.getData()))
            return possibleLocation.getData();
        else
            return null;
    }

    public E remove(E value)
    {
        if (isEmpty()) return null;

        if (value.equals(root.getData())) // delete root value
        {
            TreeNode<E> newroot = removeTop(root);
            count--;
            E result = root.getData();
            root = newroot;
            return result;
        }
        else
        {
            TreeNode<E> location = locate(root,value);

            if (value.equals(location.getData())) {
                count--;
                TreeNode<E> parent = location.getParent();
                if (parent.getRightSon() == location) {
                    parent.setRightSon(removeTop(location));
                } else {
                    parent.setLeftSon(removeTop(location));
                }
                return location.getData();
            }
        }
        return null;
    }

    /**
     * Removes the top node of the tree rooted, performs the necissary
     * rotations to reconnect the tree.
     *
     * @pre topNode contains the value we want to remove
     * @post We return an binary tree rooted with the predecessor of topnode.
     * @param topNode Contains the value we want to remove
     * @return The root of a new binary tree containing all of topNodes
     * descendents and rooted at topNode's predecessor
     */
    protected TreeNode<E> removeTop(TreeNode<E> topNode)
    {
        // remove topmost TreeNode from a binary search tree
        TreeNode<E> left  = topNode.getLeftSon();
        TreeNode<E> right = topNode.getRightSon();
        // disconnect top node
        topNode.setLeftSon(EMPTY);
        topNode.setRightSon(EMPTY);
        // Case a, no left TreeNode
        //   easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right TreeNode
        //   easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        //   easy: make right subtree of left
        TreeNode<E> predecessor = left.getRightSon();
        if (predecessor.isEmpty())
        {
            left.setRightSon(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        TreeNode<E> parent = left;
        while (!predecessor.getRightSon().isEmpty())
        {
            parent = predecessor;
            predecessor = predecessor.getRightSon();
        }
        // Assert: predecessor is predecessor of root
        parent.setRightSon(predecessor.getLeftSon());
        predecessor.setLeftSon(left);
        predecessor.setRightSon(right);
        return predecessor;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<BinarySearchTree:");
        if (!root.isEmpty()) {
            s.append(root);
        }
        s.append(">");
        return s.toString();
    }
}
