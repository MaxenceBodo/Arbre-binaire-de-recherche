import java.io.IOException;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        List<String> listeValeur = new ArrayList<String>();
        ReadTextFile.function("src/fichier.txt", listeValeur);
        System.out.println(listeValeur);
        
    }

}