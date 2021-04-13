import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
 
public class ReadTextFile
{
    public static void function(String nomFichier,List<String> listeValeur) throws IOException
    { 
        BufferedReader in = new BufferedReader(new FileReader(nomFichier));
        String line;
        while ((line = in.readLine()) != null)
        {
            listeValeur.add(line);
        }
        in.close();
    }
}