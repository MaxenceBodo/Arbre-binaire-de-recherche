package Noeud;
import java.util.ArrayList;

public class Noeud {
    int m;
    int M;
    int T[];
    Noeud sag = null;
    Noeud sad = null;
    
    public Noeud() {}
    public Noeud(int pm, int pM, int pT[]){
        this.m=pm;
        this.M=pM;
        this.T=pT;
    }
    
    //Getter & Setter
    public int getm() {
		return this.m;
	}

	public void setm(int m) {
		this.m = m;
	}

	public int getM() {
		return this.M;
	}

	public void setM(int M) {
		this.M = M;
	}

	public int[] getT() {
		return T;
	}

	public void setT(int[] tas) {
		this.T = tas;
	}

	public Noeud getSag() {
		return sag;
	}

	public void setSag(Noeud sag) {
		this.sag = sag;
	}

	public Noeud getSad() {
		return sad;
	}

	public void setSad(Noeud sad) {
		this.sad = sad;
	}
	
	//Affiche un noeud
    public void afficher(Noeud n) {
    	if(n==null) return;
    	afficher(n.sag);
    	System.out.print(n.m+" "+n.M+" "+n.T);
    	afficher(n.sad);
    }
     
    //Recherche une valeur dans un noeud
    public Noeud rechercher(int k, Noeud n) {
    	if(n==null) return null;
    	else if(n.m==k)return n;
    	else if(k<n.m) return rechercher(k,n.sag);
    	else return rechercher(k,n.sad);
    }
    
    public void add(Noeud n) {
    	System.out.println("M "+n.getM()+" m "+n.getm());
        if(n.getm()<this.m) {
            if(this.sag==null) {
                this.sag = n;
            }
            else {
                this.sag.add(n);
            }
        }
        else if(n.getm()>this.m) {
            if(this.sad==null) {
                this.sad = n;
            }else {
                this.sad.add(n);
            }
        }else {
            System.out.println("Erreur valeur m introduit egale a la valeur du m du noeud actuel");
        }
    }
    
    /*
     Demonstration
     t1---------------t2
            t3------------------t4
     */
    public boolean seCroise(int oldm, int oldM, int newm, int newM) {
        return(newM > oldm && newm < oldM);
    }
}