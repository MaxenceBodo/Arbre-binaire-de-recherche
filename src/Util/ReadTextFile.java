package Util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
 
public class ReadTextFile
{
    public static ArrayList<String> lecture(String nomFichier)
    { 
    	ArrayList<String> listeValeur = new ArrayList<>();
    	
    	//lecture de fichier
		FileReader file = null;
		//Ouverture du fichier
		try {
			file = new FileReader(nomFichier);
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouve");
			//e.printStackTrace();
		}
		
        BufferedReader br = new BufferedReader(file);
        String line="";
        while (line != null) {
			try {
				//lecture de la ligne
				line = br.readLine();
				//ajout dans la liste
				if(line!=null)
					listeValeur.add(line);
			} catch (IOException e) {
				System.out.println("Erreur lors de la lecture de la ligne");
				e.printStackTrace();
			}
			
		}
        try {
			br.close();
		} catch (IOException e) {
			//erreur lors de la fermeture du fichier
			e.printStackTrace();
		}
        return listeValeur;
    }
}