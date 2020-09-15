package io.github.dndanoff.impediments;

import javax.swing.JOptionPane;

public class PrivateMethodImpediment {
	
	public Object validate(Object arg) {
		if (arg == null) {
			showMSg("Null input");
		}
		showMSg("Valid input");
		return arg;
	}

	private void showMSg(String msg) {
		JOptionPane.showMessageDialog(null, "Null input");
	}
}
