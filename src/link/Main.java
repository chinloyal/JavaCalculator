package link;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {  
			JOptionPane.showMessageDialog(null,"Cannot set UI");
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
					frame.setLocation(450, 200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
