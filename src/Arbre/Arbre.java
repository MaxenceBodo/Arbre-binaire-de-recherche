package Arbre;

import Noeud.Noeud;

public class Arbre {
	private Noeud racine;
	
	public Arbre(Noeud rac) {
		this.racine=rac;
	}
	
	public Noeud getRacine() {
		return this.racine;
	}
	
	public void setRacine(Noeud rac) {
		this.racine=rac;
	}

}