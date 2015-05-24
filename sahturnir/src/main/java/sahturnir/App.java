package sahturnir;

import java.awt.EventQueue;

import javax.swing.UIManager;

import gui.DodavanjeNovogIAzuriranjePostojecegTurnira;
import gui.GlavniProzor;
import gui.Prijava;

import org.apache.log4j.Logger;

public class App {

	public static void main(String[] args) {
		final Logger logger = Logger
				.getLogger(DodavanjeNovogIAzuriranjePostojecegTurnira.class);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Sorry, something wrong!", e);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava frame = new Prijava();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Sorry, something wrong!", e);
				}
			}
		});
	}
}
