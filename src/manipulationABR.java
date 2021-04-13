import Arbre.Arbre;
import Noeud.Noeud;
public class manipulationABR {
	public void rechercheEntier(Arbre abr, int x) {
		boolean trouveInterval = false;
		boolean trouveValeur = false;
		Noeud current = abr.getRacine();
		
		while(!trouveInterval) {
			System.out.println("m :"+current.getm()+" M: "+current.getM()+" x: "+x);
			if(x>current.getm() && x<current.getM()) {
				int i =0;
				while(i<abr.getRacine().getT().length && trouveValeur==false) {
					if(x==abr.getRacine().getT()[i]) {
						trouveValeur = true;
					}
					i++;
				}
				trouveInterval = false;
			}else if(x<current.getm()) {
				current = current.getSag();
			}else if(x>current.getM()) {
				current = current.getSad();
			}
			
		}
		if(trouveValeur) {
			System.out.println("Valeur trouvee dans l'intervale m:"+current.getm()+" M: "+current.getM());
		}else {
			if(trouveInterval) {
				System.out.println("Aucun interval ne contient x");
			}else {
				System.out.println("l'intervale m:"+current.getm()+" M: "+current.getM()+" peut contenir x mais il n'y est pas présent");
			}
		}
	}
	
	public void suppressionEntier(Arbre a, int x) {
		
	}
	
	public void insertionEntier(Arbre a, int x) {
		
	}
	
	public void ABRTBVersABR(Arbre a) {
		
	}
	
	public void ABRTBVersABR(Arbre a, int k) {
		
	}
}
