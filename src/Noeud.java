public class Noeud {
    int m;
    int M;
    int T[];
    Noeud sag;
    Noeud sad;
    
    Noeud(int pm, int pM, int pT[], Noeud gauche, Noeud droite){
        this.m=pm;
        this.M=pM;
        this.T=pT;
        this.sag = gauche;
        this.sad=droite;
    }
    
    public void afficher(Noeud n) {
    	if(n==null) return;
    	afficher(n.sag);
    	System.out.print(n.m+" "+n.M+" "+n.T);
    	afficher(n.sad);
    }
    
    public Noeud rechercher(int k, Noeud n) {
    	if(n==null) return null;
    	else if(n.m==k)return n;
    	else if(k<n.m) return rechercher(k,n.sag);
    	else return rechercher(k,n.sad);
    }
    
    public void add(Noeud oldNoeud, Noeud newNoeud) {
        if(newNoeud.m<oldNoeud.m) {
            if(oldNoeud.sag==null) {
                oldNoeud.sag = newNoeud;
            }
            else {
                add(oldNoeud.sag, newNoeud);
            }
        }
        else if(newNoeud.m>oldNoeud.m) {
            if(oldNoeud.sad==null) {
                oldNoeud.sad = newNoeud;
            }else {
                add(oldNoeud.sad, newNoeud);
            }
        }else {
            System.out.println("Erreur valeur m introduit égale à la valeur du m du noeud actuel");
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