package sahturnir;

import java.awt.EventQueue;

import gui.Prijava;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import klase.Takmicar;
import dal.GenericDAO;
import dal.TakmicarDAO;

public class App {

	public static void main(String[] args) {  
		final Logger logger = Logger.getLogger(App.class);
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
