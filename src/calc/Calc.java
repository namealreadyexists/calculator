package calc;

import javax.swing.SwingUtilities;

public class Calc {

	public static void main(String[] args) {
		// initialize interface		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UserInterface ui = new UserInterface();
			}
		});
	}	
}