package formatiturnira;
import java.util.ArrayList;
import java.util.List;

import antlr.collections.impl.LList;
import edu.emory.mathcs.backport.java.util.Collections;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class DvostrukaEliminacija {
	
	List<Takmicar> takmicari; 
	List<Mec> mecevi; 
	JednostrukaEliminacija jel; 
	
	public DvostrukaEliminacija() {
		
		takmicari = new ArrayList<Takmicar>();
		jel = new JednostrukaEliminacija();
	}
		
	public List<Mec> GenerisiPrvuRundu(List<Takmicar> takmicari, Turnir turnir, boolean prvaRunda) throws Exception {
		
			mecevi = jel.GenerisiRundu(takmicari, turnir, true);
			return mecevi;		
	}
	
	List<Mec> GenerisiRunduWinners(List<Takmicar> winners, Turnir turnir) throws Exception
	{
		mecevi = jel.GenerisiRundu(winners, turnir, false);
		return mecevi;
	}
	
	List<Mec> GenerisiRunduLoosers(List<Takmicar> loosers, Turnir turnir) throws Exception
	{
	    //int[] brojaci = new int[takmicari.size()];
		
	    for (int i=0; i<takmicari.size(); i++)
	    	for (int j=0; j<loosers.size(); j++)
	    {
	    	int p = takmicari.get(i).getBrojacPoraza();
	    	if (takmicari.get(i).getId()==loosers.get(j).getId()) 
	    	{
	    		p++;
	    		if (p==2) {takmicari.remove(i); loosers.remove(j); }
	    		if (p==1) takmicari.get(i).setBrojacPoraza(p);
	    	}
	    } 
	    
		mecevi = jel.GenerisiRundu(loosers, turnir, false);
		return mecevi;	
	}
		
}

