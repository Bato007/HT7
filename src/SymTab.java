public class SymTab<S extends Comparable<S>, T>{

    protected BinarySearchTree<ComparableAssociation<S,T>> dictionary;

    public SymTab(){
        dictionary = new BinarySearchTree<>();
    }

    public boolean contains(S symbol){
        ComparableAssociation<S,T> a = new ComparableAssociation<>(symbol, null);
        return dictionary.contains(a);
    }

    public void add(S symbol, T value){
        ComparableAssociation<S,T> a = new ComparableAssociation<>(symbol, value);
        if(dictionary.contains(a)){
            dictionary.remove(a);
        }
        dictionary.add(a);
    }

    public T get(S symbol){
        ComparableAssociation<S,T> a = new ComparableAssociation<>(symbol, null);
        if (dictionary.contains(a)){
            a = dictionary.get(a);
            return a.getValue();
        }else {
            return null;
        }
    }


}
