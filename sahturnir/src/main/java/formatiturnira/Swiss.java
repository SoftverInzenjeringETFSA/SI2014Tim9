package formatiturnira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import klase.Mec;
import klase.Turnir;

import edu.emory.mathcs.backport.java.util.Collections;
import klase.Takmicar;


public class Swiss {
	
	List<Takmicar> takmicari;
	List<Mec> mecevi;
	
	/*Constructor*/
	public Swiss(){
		takmicari=new ArrayList<Takmicar>();
		mecevi=new ArrayList<Mec>();
	}
	
	/*generisanjeMeceva*/
	public List<Mec> GenerisiMeceve( ArrayList<Takmicar> t, Turnir turnir){
		
		
		for(Iterator<Takmicar> i= t.iterator(); i.hasNext();)
		{
			takmicari.addAll(t);
		}
		
		/*Sort*/
		Collections.sort(takmicari);
		
		
		for(int i=0;i<takmicari.size();i++)
		{
			if(i%2==0)
			{
				Mec m=new Mec();
				m.setTakmicar1(takmicari.get(i));
				m.setTakmicar2(takmicari.get(i+1));
				m.setRezultat1((double)0);
				m.setRezultat2((double)0);
				m.setTurnir(turnir);
				mecevi.add(m);
			}
		}
		
		return mecevi;
	}
	
	
	
	

}
