import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Arbre.Arbre;

import Util.ReadTextFile;

public class Main {

    public static void main(String[] args) throws IOException{
    	Arbre A = null;
        System.out.println("-----------------------------------------");
        System.out.println("Projet conception : Implementation et Manipulation d ABR de Tas Binaires");
        Scanner sc = new Scanner(System.in);
        int choix1 = 0;
        int choix2 = 0;
        boolean arret1 = false;
        boolean arret2 = false;
        
        while(!arret1) {
        	choix1=-1;
	        while(choix1<1 || choix1>3) {
	        	System.out.println("-----------------------------------------");
	        	System.out.println("Que souhaitez vous essayer");
	        	System.out.println("Tapez 1 pour la Generation, sauvegarde et affichage des ABRTBs");
	        	System.out.println("Tapez 2 pour la Manipulation des ABRTBs");
	        	System.out.println("Tapez 3 pour quitter");
	        	choix1 = sc.nextInt();
	        	
	        }
	        switch(choix1) {
	        case 1:
	        	arret2 = false;
	        	creationABR abr = new creationABR();
	        	while(!arret2) {
	        		choix2=-1;
		        	while(choix2<1 || choix2>6) {
		        		System.out.println("-----------------------------------------");
			        	System.out.println("Que souhaitez vous essayer");
			        	System.out.println("Tapez 1 pour creer un ABRTB A a partir d’un fichier");
			        	System.out.println("Tapez 2 pour sauvegarder un ABRTB dans un fichier");
			        	System.out.println("Tapez 3 pour afficher un ABRTB a l’ecran");
			        	System.out.println("Tapez 4 pour creer un ABRTB A a p noeuds");
			        	System.out.println("Tapez 5 pour verifier si un ABRTB construit a partir d un fichier donne en argument est correct,");
			        	System.out.println("Tapez 6 pour quitter");
			        	choix2 = sc.nextInt();
		        	}
		        	switch(choix2) {
		        	case 1:
		        		A = abr.creation();
		        		System.out.println("Arbre cree");
		        		break;
		        	case 2:
		        		abr.sauvegarderABR(A);
		        		break;
		        	case 3:
		        		try {
		        		abr.affichage(A);
		        		}catch(java.lang.NullPointerException e) {
		        			System.out.println("Erreur veuillez créer un arbre avant");
		        		}
		        		break;
		        	case 4:
		        		System.out.println("Combien de noeud voulez vous ?");
		        		int p = sc.nextInt();
		        		System.out.println("Indiquez le nombre le plus grand de votre arbre");
		        		int M = sc.nextInt();
		        		System.out.println("Indiquez la taille des tableaux");
		        		int tailleNoeud = sc.nextInt();
		        		A = abr.aleatoireTest(p,M,tailleNoeud);
		        		break;
		        	case 5:
		        		//abr.verificationABR();
		        		break;
		        	case 6:
		        		arret2 = true;
		        		break;
		        	}
	        	}
	        	break;
	        case 2:
	        	manipulationABR manipulation = new manipulationABR();
	        	arret2 = false;
	        	while(!arret2) {
	        		choix2=-1;
		        	while(choix2<1 || choix2>6) {
			        	System.out.println("Que souhaitez vous essayer");
			        	System.out.println("Tapez 1 pour rechercher un entier");
			        	System.out.println("Tapez 2 pour Supprimer un noeud");
			        	System.out.println("Tapez 3 pour Inserer un entier");
			        	System.out.println("Tapez 4 pour construire un ABR a partie d un ABRTB");
			        	System.out.println("Tapez 5 pour construire un ABR contenant les k-ieme plus grand elements de TB");
			        	System.out.println("Tapez 6 pour quitter");
			        	choix2 = sc.nextInt();
		        	}
		        	switch(choix2) {
		        	case 1:
		        		System.out.println("Quel x cherchez vous ?");
		        		int x = sc.nextInt();
		        		manipulation.rechercheEntier(A, x);
		        		break;
		        	case 2:
		        		break;
		        	case 3:
		        		break;
		        	case 4:
		        		break;
		        	case 5:
		        		break;
		        	case 6:
		        		arret2 = true;
		        		break;
		        	}
	        	}
	        	break;
	        case 3:
	        	arret1=true;
	        	break;
	        }
    	}
    }

}