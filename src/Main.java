import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args){
        BinarySearchTree<ComparableAssociation<String, String>>  tree = new BinarySearchTree<>();
        ComparableAssociation<String, String> aux;

        String[] line, words;
        String readDicc = "", readTraduc = "";

        // Leyendo el archivo de texto y agregando los elementos al arbol
        try{
            FileReader file = new FileReader("diccionario.txt");
            BufferedReader buffer = new BufferedReader(file);

            while ((readDicc = buffer.readLine()) != null){
                line = readDicc.split(",");

                line[0] = line[0].replace("(", "");
                line[1] = line[1].replace(" ", "");
                line[1] = line[1].replace(")", "");

                line[0] = line[0].toLowerCase();
                line[1] = line[1].toLowerCase();
                tree.add(new ComparableAssociation<>(line[0], line[1]));
            }

        } catch (Exception e){
            System.out.print("HOLA BB");
        }

        // Mostrando lo que se guardara
        System.out.println("|----------Traductor Google---------");
        tree.inOrder(tree.getRoot());
        for(int i = 0; i < tree.getInOrder().size(); i++){
            System.out.println("| " + tree.getInOrder().get(i).getKey() + " - "+ tree.getInOrder().get(i).getValue());
        }
        tree.refresh();
        System.out.println("| \n| Se han guardado en el diccionario");

        // Se lee la linea de traduccion
        try{
            FileReader file = new FileReader("traduccion.txt");
            BufferedReader buffer = new BufferedReader(file);

            readTraduc = buffer.readLine();

        } catch (Exception e){
            System.out.print("HOLA BB");
        }

        // Iniciando la traduccion
        words = readTraduc.split(" ");
        System.out.print("|\n|\n| Realizando la traduccion: \n| ");

        for (int i = 0; i < words.length; i++){
             aux = tree.findValue(new ComparableAssociation<>(words[i].toLowerCase()));

            if(aux != null){
                System.out.print(aux.getValue() + " ");
            }else {
                System.out.print("*" + words[i].toLowerCase() + "* ");
            }

        }

    }

}
