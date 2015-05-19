package sahturnir;

import java.awt.EventQueue;

import gui.Prijava;

import java.util.List;
import java.util.ArrayList;

import klase.Takmicar;
import dal.TakmicarDAO;

public class App {

	public static void main(String[] args) {  
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
		
		/*List<Takmicar> takmicari = new ArrayList<Takmicar>();
		TakmicarDAO tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);
		for (int i = 0; i < takmicari.size(); i++)
			System.out.println(takmicari.get(i).getIme());*/
	}	
}
