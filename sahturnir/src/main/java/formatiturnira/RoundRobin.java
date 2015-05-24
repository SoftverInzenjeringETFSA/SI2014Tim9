package formatiturnira;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class RoundRobin { // NIJE TESTIRANO, TREBA PROVJERITI
	List<Mec> mecevi;
	List<Takmicar> tmp;

	public RoundRobin(){
		mecevi = new ArrayList<Mec>();
		tmp = new ArrayList<Takmicar>();
	}


	public List<Mec> RoundRobinGenerator(List<Takmicar> takmicari, Turnir t) throws Exception{
		
		if(takmicari.isEmpty())throw new Exception("Nema takmicara!");
		if(t.getId()==0)throw new Exception("Nepostoji turnir!");
		
		/*provjera broja takmicara*/
		//int broj=takmicari.size();
		//if(((broj & (broj-1))!=0)||(broj==0)||(broj==1))throw new Exception("Broj takmicara mora biti potencija broja 2!");
		
		tmp.addAll(takmicari);
		int half = tmp.size() / 2;
		int rounds = tmp.size() - 1;

		for(int k = 0; k < rounds; k++)
		{
			for(int i = 0; i < half; i++)
			{
				Mec m=new Mec();
				m.setTakmicar1(tmp.get(i));
				m.setTakmicar2(tmp.get(tmp.size()-i-1));
				m.setRezultat1((double)0);
				m.setRezultat2((double)0);
				m.setTurnir(t);
				m.setDatumPocetka(t.getDatumPocetka());
				mecevi.add(m);
			}
			tmp.add(1, tmp.get(tmp.size()-1));
			tmp.remove(tmp.size()-1);
		}
		return mecevi;
	}
}

	