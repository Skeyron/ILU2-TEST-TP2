package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 15, 5);
		village.setChef(new Chef("Abra", 4, village));
		asterix = new Gaulois("Astérix", 4);
		village.ajouterHabitant(asterix);
		
	}	
	
	@Test
	void testControlVerifierIdentiteTest() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertEquals(controlVerifierIdentite.verifierIdentite("Astérix"), true);
		assertEquals(controlVerifierIdentite.verifierIdentite("Obama"), false);
	}

}
