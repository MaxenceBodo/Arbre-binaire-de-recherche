import java.util.ArrayList;
import java.util.Random;

import Util.ReadTextFile;
import Noeud.Noeud;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Arbre.Arbre;

public class creationABR {
	public Arbre creation() {
		ArrayList<String> lignes = new ArrayList<>();
		lignes = ReadTextFile.lecture("src/fichier.txt");
		
		Noeud racine = new Noeud();
		Arbre arbre = new Arbre(racine);
		
		boolean estRacine = true;
		
		for(String ligne : lignes) {
			int m = 0;
			int M = 0;
			ArrayList<Integer> liste = new ArrayList<Integer>();
			
			boolean mOk = false;
			boolean MOk = false;
			String mStr = "";
			String MStr = "";
			String val = "";
			
			for(int i=0;i<ligne.length();i++) {
				char c = ligne.charAt(i);
				if(!mOk) {
					if(c!=':') {
						mStr = mStr+c;
					}else {
							mOk = true;
					}
				}else {
					if (!MOk) { // on est dans M
						if (c != ';')
							MStr = MStr + c;
						else
							MOk = true;
					} else { // on est dans les tas
						if (c != ':') {
							val = val + c;
							if (i == ligne.length() - 1)
								liste.add(Integer.parseInt(val));
						} else {
							liste.add(Integer.parseInt(val));
							val = "";
						}

					}
				}
			}
			int[] tas = new int[liste.size()];
			for (int i = 0; i < liste.size(); i++) {
				tas[i] = liste.get(i);
			}

			m = Integer.parseInt(mStr);
			M = Integer.parseInt(MStr);

			// Definition du noeud courant
			Noeud current = arbre.getRacine();

			// Definie le noeud racine lors du premier tour de boucle
			if (estRacine) {
				arbre.getRacine().setm(m);
				arbre.getRacine().setM(M);
				arbre.getRacine().setT(tas);
				estRacine = false;
			} else {
				Noeud n = new Noeud(M, m,tas);
				boolean place = false;
				while (!place) {
					if (M <= current.getm()) { // On le met dans le sag
						if (current.getSag() != null) { // Si le sag n'est pas null il devient le noeud courant
							current = current.getSag();
						} else { // si le sag est null alors le noeud en cours y est place
							place = true;
							System.out.println("------------------");
							System.out.println("SAG de " + current.getM());
							System.out.print("m = " + n.getm() + ":" + n.getM() + ";");
							for (int val2 : tas) {
								System.out.print(val2 + ":");
							}
							System.out.println("");
							current.setSag(n);
						}
					}
					if (m > current.getM()) { // On le met dans le sad
						if (current.getSad() != null) { // Si le sad n'est pas null il devient le noeud courant
							current = current.getSad();
						} else { // si le sad est null alors le noeud en cours y est place
							place = true;
							System.out.println("------------------");
							System.out.println("SAD de " + current.getM());
							System.out.print("m = " + n.getm() + ":" + n.getM() + ";");
							for (int val2 : tas) {
								System.out.print(val2 + ":");
							}
							System.out.println("");
							current.setSad(n);
						}
					} 
				}
			}
		}
		return arbre;
	}
	
	public void sauvegarderABR(Arbre abr) {
		try {
			File f = new File("src/test");
			System.out.println(f.getAbsolutePath());
			FileWriter fw = new FileWriter(f);
			Noeud n = abr.getRacine();
			ecritureP(fw,n);
			fw.close();
			
		}catch(Exception e) {
			System.out.println("Erreur sauvegarde : "+ e);
		}
	}
	
	public void ecritureP(FileWriter fw, Noeud n) {
		int[] tas =  n.getT();
		int M =  n.getM();
		int m =  n.getm();
		String ligne = m + ":" + M + ";";

		for (int i = 0; i < tas.length; i++) {
			ligne = ligne + tas[i];
			if (i != tas.length - 1)
				ligne = ligne + ":";
		}
		try {
			System.out.println("ligne ecrite : " + ligne);
			fw.write(ligne + "\r");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if ( n.getSag() != null)
			ecritureP(fw,  n.getSag());
		if ( n.getSad() != null)
			ecritureP(fw,  n.getSad());
	}
	
	public void affichage(Arbre a) {
		lectureP(a.getRacine());
	}
	
	public void lectureP(Noeud n) {
		int[] tas = n.getT();
		int M = n.getM();
		int m = n.getm();
		String ligne = m + ":" + M + ";";

		for (int i = 0; i < tas.length; i++) {
			ligne = ligne + tas[i];
			if (i != tas.length - 1)
				ligne = ligne + ":";
		}
		System.out.println(ligne);

		if (n.getSag() != null)
			lectureP(n.getSag());
		if (n.getSad() != null)
			lectureP(n.getSad());
	}
	
	public Arbre aleatoireTest(int p, int q, int tailleTab) {
		Noeud noeud = new Noeud();
		Arbre arbre = new Arbre(noeud);
		int intervalMin =1;
		int intervalMax = (int)q/p;
		int m = intervalMin;
		int M = intervalMax;
		int[] T;
		boolean racine = true;
		for(int i=0; i<p; i++)
		{
			T = new int[tailleTab];
			for(int j = 0;j<T.length;j++) {
				T[j] = m + (int)(Math.random() * ((M - m) + 1));
			}
			if(racine) {
				arbre.getRacine().setm(m);
				arbre.getRacine().setM(M);
				arbre.getRacine().setT(T);
				racine = false;
			}else {
				noeud.setm(m);
				noeud.setM(M);
				noeud.setT(T);
				//System.out.println("M "+noeud.getM()+" m "+noeud.getm());
				arbre.getRacine().add(noeud);
			}	
			M +=  intervalMax;
			m += intervalMax;
		}
		return arbre;
			
	}
	
	public void insererABRTB(Noeud abr, Noeud n) {
		if(abr==null) {
			abr = n;
		}else {
			if(abr.getm()<n.getm()) {
				insererABRTB(abr.getSag(), n);
			}
			if(abr.getm()>n.getm()) {
				insererABRTB(abr.getSad(),n);
			}
		}
	}

	
	
	public Arbre aleatoireABRTB(int p, int q, int tailleTab) {
		Noeud noeud = new Noeud();
		Arbre a = new Arbre(noeud);
		int m =0;
		int M=0;
		int T[] = new int[tailleTab]; // A REVOIR
		
		for(int i =0; i<p;i++) {
			//generer tableau
			M = 0 + (int)(Math.random() * ((q - 0) + 1));
			m = 0 + (int)(Math.random() * ((M - 0) + 1));
			
			for(int j = 0;j<T.length;j++) {
				T[j] = m + (int)(Math.random() * ((M - m) + 1));
			}
			noeud.setm(m);
			noeud.setM(M);
			noeud.setT(T);
			insererABRTB(a.getRacine(),noeud);
		}
		
		return a;
	}
	
	public Arbre aleatoireABR(int p, int q, int tailleTab) {
		Noeud noeud = new Noeud();
		Arbre arbre = new Arbre(noeud);
		int m=0;
		int M=0;
		boolean estRacine = true;
		int[] tas;
		for(int i =0; i<p; i++) {
			M = 0 + (int)(Math.random() * ((q - 0) + 1));
			m = 0 + (int)(Math.random() * ((M - 0) + 1));
			
			tas = new int[tailleTab];
			for(int j = 0;j<tas.length;j++) {
				tas[j] = m + (int)(Math.random() * ((M - m) + 1));
			}
			
			Noeud current = arbre.getRacine();
			
			if(estRacine) {
				arbre.getRacine().setm(m);
				arbre.getRacine().setM(M);
				arbre.getRacine().setT(tas);
				estRacine = false;
			}else {
				Noeud n = new Noeud(M,m,tas);
				boolean place = false;
				while(!place) {
					if(M<=current.getm()) {
						if(current.getSag()!=null) {
							current = current.getSag();
							System.out.println("Test M<");
						}else {
							place = true;
							System.out.println("------------------");
							System.out.println("SAG de " + current.getM());
							System.out.print("m = " + n.getm() + ":" + n.getM() + ";");
							for(int val:tas) {
								System.out.println(val+":");
							}
							System.out.println("");
							current.setSag(n);
						}
					}
					if(m>current.getM()) {
						if(current.getSad()!=null) {
							current=current.getSad();
						}else {
							System.out.println("Test m>");
							place = true;
							System.out.println("------------------");
							System.out.println("SAD de " + current.getM());
							System.out.print("m = " + n.getm() + ":" + n.getM() + ";");
							for(int val:tas) {
								System.out.println(val+":");
							}
							System.out.println("");
							current.setSad(n);
						}
					}
				}
				
			}
		}
		
		return arbre;
	}
	

	public void verificationABR(Arbre A) {
		//a est un ABR sur les m
		
		
		// Tous les intervales sont disjoints
		
		//Tous les tableaux T des noeuds de A sont des max-tas-binaires
	}
	
	public boolean isABR(Arbre A) {
		
		return true;
	}
	
}
