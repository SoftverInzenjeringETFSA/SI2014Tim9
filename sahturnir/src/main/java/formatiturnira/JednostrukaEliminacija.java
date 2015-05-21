package formatiturnira;
import java.util.ArrayList;
import java.util.List;

import antlr.collections.impl.LList;
import edu.emory.mathcs.backport.java.util.Collections;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class JednostrukaEliminacija {
	
	List<Mec> mecevi;
	
 public JednostrukaEliminacija() {
	 
		mecevi = new ArrayList<Mec>();
}
	
	
 	List<Mec> GenerisiRundu(List<Takmicar> takmicari, Turnir turnir, boolean prvaRunda) throws Exception{
 		
 		if (takmicari.size()==0) throw new Exception ("Nema takmicara");
 		if (turnir == null || turnir.getId()==0) throw new Exception ("Nema turnira");
 		
 		int p=takmicari.size();
 		if (!provjeriStepen(p)) throw new Exception("Broj takmicara nije stepen od 2");
 		
 		if (prvaRunda){
 			Collections.shuffle(takmicari);
 		}
 		for (int i = 0; i < takmicari.size() - 1; i = i + 2){
 			
 			Mec m=new Mec();
			m.setTakmicar1(takmicari.get(i));
			m.setTakmicar2(takmicari.get(i+1));
			m.setRezultat1((double)0);
			m.setRezultat2((double)0);
			m.setTurnir(turnir);
			mecevi.add(m);
 		}
 		return mecevi;
 	}
 	
 	boolean provjeriStepen (int n)
 	
 	{
 		if (n%2!=0) return false;
 		if (n==2) return true;
 		n=n/2; return provjeriStepen(n); 
 
 		
 	}
}
			

