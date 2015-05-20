package formatiturnira;
import java.util.ArrayList;
import java.util.List;

import antlr.collections.impl.LList;
import edu.emory.mathcs.backport.java.util.Collections;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class JednostrukaEliminacija {
	
	//List<Takmicar> takmicari; 
	List<Mec> mecevi; 
	//List<Takmicar> novaListaTakmicara;
	//List<Mec> novaListaMeceva;
	Mec m;
	//int runda;
	
 public JednostrukaEliminacija() {
	 
//		takmicari = new ArrayList<Takmicar>();
		mecevi = new ArrayList<Mec>();
//		runda = (int) Math.pow( 2, Math.ceil( Math.log( takmicari.size() ) / Math.log( 2 ) ) );
		//ogranicenje: broj takmicara mora biti potencija broja 2
//		novaListaTakmicara = new ArrayList<Takmicar>();
//		novaListaMeceva = new ArrayList<Mec>();
		
		m = new Mec();
}
	
	
 	List<Mec> GenerisiRundu(List<Takmicar> takmicari, Turnir turnir, boolean prvaRunda){
 		if (prvaRunda){
 			Collections.shuffle(takmicari);
 			prvaRunda = true;
 		}
 		for (int i = 0; i < takmicari.size() - 1; i = i + 2){
 			m.setTakmicar1(takmicari.get(i));
 			m.setTakmicar2(takmicari.get(i+1));
 			mecevi.add(m);
 		}
 		return mecevi;
 	}
}


// MERIMIN ALGORITAM
 /*
 List<Mec> GenerisiMeceveJednostruka (ArrayList<Takmicar> takmicari, Turnir turnir) {
	 
	 Collections.shuffle(takmicari);
	 
	 for (int i=0; i <takmicari.size(); i+=2)	
	 {
		 mecevi.add(new Mec(runda, takmicari.get(i*2), takmicari.get(i*2+1)));
		 
	 }
	 rekurzija(takmicari, mecevi, runda);
			
	return mecevi;
		
}
*/
/*
public void rekurzija(List<Takmicar> t, List<Mec> matches, int r) {
    if (r==0) return;       
	for (int i=0; i<matches.size(); i++)
           {
        	   if (matches.get(i).getRezultat1()> matches.get(i).getRezultat2()) 
       			novaListaTakmicara.add(takmicari.get(i*2));
       		else novaListaTakmicara.add(takmicari.get(i*2+1));   //prepolovi se br takmicara
           }
           
           runda = r-1;
           matches.clear();
           
           for (int i=0; i<novaListaTakmicara.size(); i++)
       	{
       		mecevi.add(new Mec(r, takmicari.get(i*2), takmicari.get(i*2+1)));
       		matches.add(new Mec(r, takmicari.get(i*2), takmicari.get(i*2+1)));
    } 
           rekurzija(novaListaTakmicara, matches, r);
    
}

}*/