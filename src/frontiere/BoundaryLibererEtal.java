package frontiere;
import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean vendeurExiste = controlLibererEtal.isVendeur(nomVendeur);
		
		if (!vendeurExiste) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché aujourd'hui");
		} else {
			String[] tabEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = tabEtal[0];
			if (etalOccupe.equals("true")){
				String produit = tabEtal[2];
				String quantiteInit = tabEtal[3];
				String quantiteVendue = tabEtal[4];
				System.out.println("Vous avez vendu " + quantiteVendue + " sur " + quantiteInit + " " + produit +"\n");
				System.out.println("Au revoir " + tabEtal[0] + ", passez une bonne journée");
			}
		}
	}
}
