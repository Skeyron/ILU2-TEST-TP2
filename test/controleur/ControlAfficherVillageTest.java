package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private Village village;
	private Gaulois asterix;
	private Gaulois obelix;
	private Druide pano;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 15, 5);
		village.setChef(new Chef("Abra", 4, village));
		asterix = new Gaulois("Astérix", 5);
		obelix = new Gaulois("Obélix", 5);
		pano = new Druide("Panoramix", 5, 2, 5);
		
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(pano);
	}
	
	
	@Test
	void testControlAfficherVillage() {

		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0], "Abra");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1], "Astérix");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[2], "Obélix");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[3], "le druide Panoramix");
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
	}

}
