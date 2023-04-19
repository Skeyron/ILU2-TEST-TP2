package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2 = new StringBuilder();
					System.out.println("Bienvenu villageois " + nomVisiteur);
					question2.append("Quelle est votre force ?\n");
					int choix = Clavier.entrerEntier(question2.toString());	
					controlEmmenager.ajouterGaulois(nomVisiteur, choix);
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionDruide = new StringBuilder();
		System.out.println("Bienvenu villageois " + nomVisiteur);
		questionDruide.append("Quelle est votre force ?\n");
		int force = Clavier.entrerEntier(questionDruide.toString());
		int min_pot,max_pot;
		do {
			min_pot = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous pouvez faire ?\n");
			max_pot = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous pouvez faire ?\n");
			if ( min_pot >= max_pot) {
				System.out.println("Attention, druide, vous inversez entre min et max ! \n");
			}
			
		} while (min_pot >= max_pot);
		controlEmmenager.ajouterDuide(nomVisiteur, force, min_pot, max_pot);
		
	}
}
