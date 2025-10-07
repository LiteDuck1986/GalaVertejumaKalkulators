package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GalvenaKlase {
	
	static int studSk, kritSk;
	static Scanner scan = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("0.#");
	static String[] studenti;
	static String[] kriteriji;
	static int[] kriterijaSvars;
	static int[][] kriterijaVertejums;
	static double[] semestraVertejums;
	
	static String teksts = "";
	
	public static void main(String[] args) {
		
		String izvele;
		String[] darbibuSaraksts = { "Ievadīt audzēkni", "Ievadīt kritērijus","Ievadīt kritērijas svaru", "Ievadīt vērtējumus", "Labot Kritērijus",
				"Labot kritērijas svaru", "Labot iegūto vērtējumu", "Aprēķināt gala vērtējumu", "Saglabāt failā", "Apskatīt failu",
				"Apturēt" };

		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību izvēle",
					JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);

			if (izvele == null)
				izvele = "Apturēt";

			switch (izvele) {
			case "Ievadīt audzēkni":
				IevaditAudz();
				break;
				
			case "Ievadīt kritērijus":
				IevaditKrit();
				break;
				
			case "Ievadīt kritērijas svaru":
				IevaditKritSvaru();
				break;
				
			case "Ievadīt vērtējumus":
				IevadiVertejumi();
				break;
				
			case "Labot Kritērijus":
//				to do;
				break;
				
			case "Labot Kritērijas svaru":
//				to do;
				break;
				
			case "Labot iegūto vērtējumu":
//				to do;
				break;
				
			case "Aprēķināt gala vērtējumu":
				AprekinatGalaVert();
				break;

			case "Saglabāt failā":
				DarbibasArFailiem.saglabat(teksts);
				break;

			case "Apskatīt failu":
				DarbibasArFailiem.nolasit();
				break;

			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta!", "Paziņojums",
						JOptionPane.INFORMATION_MESSAGE);

				break;
			}

		} while (!izvele.equals("Apturēt"));
		scan.close();
	}
		
	static void IevaditAudz() {
		// Audzēkņu skaita ievade
		do {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			while(!scan.hasNextInt()) {
				System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
				scan.next();
			}
			studSk = scan.nextInt();
		}while(studSk<1);
		
		
		studenti = new String[studSk];
		
		
		scan.nextLine();
		
		// Ievada audzēkņu vārdus, uzvārdus
		for(int i=0; i<studenti.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". studentu");
				studenti[i] = scan.nextLine().trim();
			} while(!studenti[i].matches("^[\\p{L} ]+$"));
		}
		}
	
	public static void IevaditKrit() {
		
		// Vērtēšanas kritēriju skaita ievade
				do {
					System.out.println("Kāds būs kritēriju skaits?");
					while(!scan.hasNextInt()) {
						System.out.println("Kāds būs kritēriju skaits?");
						scan.next();
					}
					kritSk = scan.nextInt();
				}while(kritSk<1);
				
				kriteriji = new String[kritSk];
		
		for(int i=0; i<kriteriji.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". kritēriju");
				kriteriji[i] = scan.nextLine().trim();
			} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
			
		}
	}
			
		public static void IevaditKritSvaru() {
			
			// Definē kritērijus
			int maxSvars = 100, sk = 1;
			double atlSvars;
			
			kriterijaSvars = new int[kritSk];
			
			for(int i=0; i<kriterijaSvars.length; i++) {
			// Norāda katra kritērija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
				while(!scan.hasNextInt()) {
					System.out.println("Ievadi "+(i+1)+". kritērija svaru");
					scan.next();
				}
				kriterijaSvars[i] = scan.nextInt();
				/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				*/
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
			scan.nextLine();
		}
		}
		
		
		public static void IevadiVertejumi() {
			
			kriterijaVertejums = new int[studSk][kritSk];
		// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
					while(!scan.hasNextInt()) {
						System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
						scan.next();
					}
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		}
		
		public static void AprekinatGalaVert() {
		
			semestraVertejums = new double[studSk];
			
		// Gala vērtējuma aprēķināšana
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
			
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
				
				teksts += "\nStudenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j];
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			
			teksts += "\nSemestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
		}
		
	}
	
}