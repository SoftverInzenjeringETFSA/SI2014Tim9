package formatiturnira;

import java.util.ArrayList;
import java.util.List;

import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class RoundRobin { // NIJE TESTIRANO, TREBA PROVJERITI

	public RoundRobin(){}


	public List<Mec> RoundRobinGenerator(List<Takmicar> takmicari, Turnir t) {
		List<Mec> mecevi = new ArrayList<Mec>();
		Mec m = new Mec();
		
		/*for(int i = 0; i < takmicari.size() - 1; i = i + 2)
		{
			for (int j = 1; j < takmicari.size(); j = j + 2)
			{
				m.setTakmicar1(takmicari.get(i));
				m.setTakmicar2(takmicari.get(j));
				mecevi.add(m);
			}
		}*/		

	    int rounds = takmicari.size() - 1;
	    int halfSize = takmicari.size() / 2;

	    for (int round = 0; round < rounds; round++)
	    {
	        for (int idx = 1; idx < halfSize; idx++)
	        {   			
	            int takmicar1 = (round + idx) % (1+ mecevi.size());
	            int takmicar2 = (round  + (1+ mecevi.size()) - idx) % (1+ mecevi.size());
	            m.setTakmicar1(takmicari.get(takmicar1));
	            m.setTakmicar2(takmicari.get(takmicar2));
	            mecevi.add(m);
	        }
	    }		
		return mecevi;
	}
}

