package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean NomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if (!NomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " . Mais seuls les habitants du village peuvent vendre ici !\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			boolean EtalDispo = controlPrendreEtal.resteEtals();
			if (EtalDispo) {
				installerVendeur(nomVendeur);
				
			} else {
				System.out.println("Désolée "+ nomVendeur + ", Il n'y a plus aucun étal disponible");
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait ! Il me reste un étal\n");
		System.out.println("Il me faudrait quelques infos\n");
		System.out.println("Quel produit souhaitez-vous vendre ?\n");
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro : " + numEtal);
		}
	}
}
