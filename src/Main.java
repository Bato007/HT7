import java.io.*;

public class Main {

    public static void main(String[] args){
        BinarySearchTree<ComparableAssociation<String, String>>  tree = new BinarySearchTree<>();


        String[] line;
        String readTxt;

        // Leyendo el archivo de texto y agregando los elementos al arbol
        try {
            FileReader fr = new FileReader("diccionario.txt");
            BufferedReader bf = new BufferedReader(fr);

            // Generando números aleatorios y metiendolos al .txt
            while((readTxt = bf.readLine()) != null) {

            }

            bf.close();
        } catch (IOException e) {
            System.out.println("Did do");
        }
    }





}
