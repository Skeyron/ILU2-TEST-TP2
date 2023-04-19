package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	public String afficherVendeurs(String[] vendeurs) {
		StringBuilder choix = new StringBuilder();
		for (int i = 0; i < vendeurs.length; i++) {
				choix.append(i+1 +"-" + vendeurs[i] +"\n");
		}
		return choix.toString();
	}
	
	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifIdentite(nomAcheteur)) {
			System.out.println("Désolé, seuls les habitants du village peuvent acheter ! \n");
		} else {
			System.out.println("Que voulez-vous acheter ? \n");
			String produit = scan.nextLine();
			String[] vendeurs =controlAcheterProduit.Vendeurs(produit);
			if (vendeurs==null) {
				System.out.println("Désolé, personne ne vends ce produit au marché ! \n");
			} else {
				StringBuilder question = new StringBuilder();
				int choixUtilisateur = -1;
				question.append("Chez quel commerçant voulez-vous acheter ce produit \n");	
				question.append(afficherVendeurs(vendeurs));
				
				do {
					choixUtilisateur = Clavier.entrerEntier(question.toString());
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurs[choixUtilisateur-1]);
					int nombre = -1;
					do {
						nombre = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
					} while ( nombre <= 0);
					int achat = controlAcheterProduit.achat(nombre, vendeurs[choixUtilisateur-1]);
					if (achat == 0) {
						System.out.println(nomAcheteur + " veut acheter " + nombre + " " + produit + ", malheureusement"
								+ " il n'y en a plus !");
						break;
					} else if (achat < nombre ) {
						System.out.println(nomAcheteur + " veut acheter " + nombre + " " + produit + ", malheureusement "
								+ vendeurs[choixUtilisateur-1] + " n'en a plus que " + achat + ". " + nomAcheteur 
								+ " achète tout le stock de " + vendeurs[choixUtilisateur-1]);
						break;
					} else {
						System.out.println(nomAcheteur + " achète " + achat + " " + produit + " à " + vendeurs[choixUtilisateur-1]);
						break;
					}
				} while ( 1 <= choixUtilisateur  && choixUtilisateur <= vendeurs.length );	
			}
		}
		
	}
}
