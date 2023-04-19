package controleur;

import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.*;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	
	public String[] Vendeurs(String produit) {
		Gaulois[] tab = village.rechercherVendeursProduit(produit);
		if (tab != null) {
			String[] vendeurs = new String[tab.length];
			for (int i = 0; i < vendeurs.length; i++) {
				vendeurs[i] = tab[i].getNom();
			}
			return vendeurs;
		}
		return null;
	}
	
	public int achat(int nombre, String vendeur ) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		return etal.acheterProduit(nombre);
	}
	
	
}
