package sahturnir;

import java.awt.EventQueue;

import gui.Prijava;

import java.util.List;
import java.util.ArrayList;

import javax.swing.UIManager;

import klase.Takmicar;
import dal.TakmicarDAO;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava frame = new Prijava();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
