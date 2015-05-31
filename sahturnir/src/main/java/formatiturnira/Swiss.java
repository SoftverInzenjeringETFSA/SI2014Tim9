package formatiturnira;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import klase.Mec;
import klase.Turnir;
import edu.emory.mathcs.backport.java.util.Collections;
import klase.Takmicar;


public class Swiss {
	
	public List<Takmicar> takmicari;
	public List<Mec> mecevi;
	
	/*Constructor*/
	public Swiss(){
		takmicari=new ArrayList<Takmicar>();
		mecevi=new ArrayList<Mec>();
	}
	
	/*generisanjeMeceva*/
	public List<Mec> GenerisiMeceve( List<Takmicar> t, Turnir turnir)throws Exception{
		
		if(t.isEmpty())throw new Exception("Nema takmicara!");
		if(turnir.getId()==0)throw new Exception("Nepostoji turnir!");
		
		/*provjera broja takmicara*/
		//int broj=t.size();
		//if(((broj & (broj-1))!=0)||(broj==0)||(broj==1))throw new Exception("Broj takmicara mora biti potencija broja 2!");		
		
		/*for(Iterator<Takmicar> i= t.iterator(); i.hasNext();)
		{*/
			takmicari.addAll(t);
		/*}
		
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
				m.setDatumPocetka(turnir.getDatumPocetka());
				mecevi.add(m);
			}	
		}
		return mecevi;
	}
}
