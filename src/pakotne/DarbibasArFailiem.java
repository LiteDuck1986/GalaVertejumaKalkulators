package pakotne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class DarbibasArFailiem {

	static String failaNosaukums = "GalaVertejumi.txt";

	public static void saglabat(String teksts) {
		try {
			FileWriter fw = new FileWriter(failaNosaukums, true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(teksts);

			pw.close();
			JOptionPane.showMessageDialog(null, "Ierakstīts failā: " + failaNosaukums);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā!", "Kļūda", JOptionPane.ERROR_MESSAGE);

		}
	}

	public static void nolasit() {
		String teksts, str = "";
		try {
			FileReader fr = new FileReader(failaNosaukums);
			BufferedReader br = new BufferedReader(fr);
			while ((teksts = br.readLine()) != null) {
				str += teksts + "\n";
			}
			br.close();

			JTextArea ta = new JTextArea(str, 10, 40);
			ta.setEditable(false);
			JScrollPane sp = new JScrollPane(ta);
			sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JOptionPane.showMessageDialog(ta, sp, "Saglabātie gala vērtējumi", JOptionPane.PLAIN_MESSAGE);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot failu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
