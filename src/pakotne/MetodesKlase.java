package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MetodesKlase {
	
	// Viss padevos.
	

	public static void StudentiUnKriterijas() {

		String izvele;
		String[] darbibuSaraksts = { "Ievadīt audzēkni", "Ievadīt kritērijus", "Ievadīt vērtējumus", "Labot Kritērijus",
				"Labot iegūto vērtējumu", "Aprēķināt gala vērtējumu", "Saglabāt failā", "Apskatīt failu",
				"Apturēt" };

		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību izvēle",
					JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);

			if (izvele == null)
				izvele = "Apturēt";

			switch (izvele) {
			case "Ievadīt audzēkni":
				StudentiUnKriterijas();
				break;
				
			case "Ievadīt kritērijus":
				IevadiKriterijus();
				break;
				
			case "Ievadīt vērtējumus":
				StudentiUnKriterijas();
				break;
				
			case "Labot Kritērijus":
				StudentiUnKriterijas();
				break;
				
			case "Labot iegūto vērtējumu":
				MetodesKlase.StudentiUnKriterijas();
				break;
				
			case "Aprēķināt gala vērtējumu":
				MetodesKlase.StudentiUnKriterijas();
				break;

			case "Saglabāt failā":

				break;

			case "Apskatīt failu":

				break;

			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta!", "Paziņojums",
						JOptionPane.INFORMATION_MESSAGE);

				break;
			}

		} while (!izvele.equals("Apturēt"));
	}
}
