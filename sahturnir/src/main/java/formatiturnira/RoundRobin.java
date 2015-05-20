package formatiturnira;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class RoundRobin { // NIJE TESTIRANO, TREBA PROVJERITI

	public RoundRobin(){}


	public List<Mec> RoundRobinGenerator(List<Takmicar> takmicari, Turnir t) {
		List<Mec> mecevi = new ArrayList<Mec>();
		Mec m = new Mec();
		List<Takmicar> tmp = new LinkedList<Takmicar>();
		tmp = takmicari;
		int half = tmp.size() / 2;
		int rounds = tmp.size() - 1;

		for(int k = 0; k < rounds; k++)
		{
			for(int i = 0; i < half; i++)
			{
				m.setTakmicar1(tmp.get(i));
				m.setTakmicar2(tmp.get(tmp.size()-i-1));
				mecevi.add(m);
			}
			tmp.add(1, tmp.get(tmp.size()-1));
			tmp.remove(tmp.size()-1);
		}
		return mecevi;
	}
}

	