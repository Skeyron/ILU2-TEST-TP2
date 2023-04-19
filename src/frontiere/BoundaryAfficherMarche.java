package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Désolé mais le marché est actuellement vide !");
		} else {
			System.out.println(nomAcheteur + " vous trouverez au marché : \n ");
			int j = 0;
			for (int i = 0; i < infosMarche.length/3; i++) {
				StringBuilder texte = new StringBuilder();
				texte.append("-"+ infosMarche[j]);
				j++;
				texte.append(" qui vend " + infosMarche[j]);
				j++;
				texte.append(" "+ infosMarche[j]);
				j++;
				System.out.println(texte);
			}
			
		}
		
	}
}
