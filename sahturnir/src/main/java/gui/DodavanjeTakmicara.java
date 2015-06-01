package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import org.apache.log4j.Logger;

import utils.JTableUtil;
import dal.GenericDAO;
import dal.KorisnikDAO;
import dal.TakmicarDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import klase.Klub;
import klase.Korisnik;
import klase.Takmicar;
import dal.KlubDAO;

public class DodavanjeTakmicara extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnDatumRoenja;
	private JTextPane txtpnJmbg;
	private JTextField textField_1;
	private JTextPane txtpnKategorija;
	protected final JTextPane textPane_1;
	private JSpinner timeSpinner;
	private JSpinner spinner;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextPane textPane_4;
	private JTextPane textPane_3;
	Takmicar t = new Takmicar();
	private JFrame parentFrame;
	private GlavniProzor gpf;
	/**
	 * Launch the application.
	 */

	public static Boolean validirajPrazno(String t1) {
		Boolean izlaz = false;
		
		if(t1.isEmpty() || t1.trim().length() == 0) 
			izlaz = false;
		else
			izlaz = true;
		
		return izlaz;
	}
	
	 public static Boolean validirajCifre(String c)
     {
         Boolean da=false;
         
         char[] prebaciString=c.toCharArray();
         for (int i = 0; i < prebaciString.length; i++)
         {
             da = false;
             if (((prebaciString[i] >= '0') && (prebaciString[i] <= '9')))
                 da = true;
         }
         return da;
     }
	
	public static Boolean validirajJmbg(String JMBG) {
    	List<Integer> l3 = new ArrayList<Integer>();
		if(validirajCifre(JMBG))
		{
			for(char ch : JMBG.toCharArray())
			{
			 l3.add( Integer.valueOf(String.valueOf(ch)));
			}
		
			if (l3.size()!= 13)
	            return false;

	        else
	        {
	            Double eval = 0.0;
	            for (int i = 0; i < 6; i++)
	            {
	                eval += (7 - i) * (l3.get(i) + l3.get(i + 6));
	            }
	            return l3.get(12) == 11 - eval % 11;
	        }
		}
		else return false;
	}

    public static Boolean validirajAlpha(String t1) {
    	if (t1.length() > 30) return false;
		String[] niz = t1.split(" ");
		
		for (int i = 0; i<niz.length; i++) {
			String dio = niz[i];
			String[] patt = dio.split("-");
			for (int j= 0; j<patt.length; j++) {
				if (!patt[j].equals("di") && !patt[j].equals("I") &&
						!patt[j].equals("II") && !patt[j].equals("III") &&
						!patt[j].equals("IV") && !patt[j].equals("V")) {
					Pattern pattern = Pattern.compile("^[A-Z|È|Æ|Ž|Š|Ð]{1}[a-z|è|æ|ž|š|ð]{2,}$");
					Matcher matcher = pattern.matcher(patt[j]);
					Boolean istina =  matcher.matches();
					if (!istina) return false;
				}
			}
		}
		return true;
    }
    
    public static Boolean validirajAlphaNum(String t1) {
    	if (t1.length() > 30) return false;
		String[] niz = t1.split(" ");
		
		for (int i = 0; i<niz.length; i++) {
			String dio = niz[i];
			String[] patt = dio.split("-");
			for (int j= 0; j<patt.length; j++) {
				if (!patt[j].equals("di") && !patt[j].equals("I") &&
						!patt[j].equals("II") && !patt[j].equals("III") &&
						!patt[j].equals("IV") && !patt[j].equals("V")) {
					Pattern pattern = Pattern.compile("^[A-Z0-9|È|Æ|Ž|Š|Ð]{1}[a-z0-9|è|æ|ž|š|ð]{2,}$");
					Matcher matcher = pattern.matcher(patt[j]);
					Boolean istina =  matcher.matches();
					if (!istina) return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * Create the frame.
	 */
	public DodavanjeTakmicara(JFrame pf, GlavniProzor gp) {
		parentFrame = pf;
		gpf = gp;
		final Logger logger = Logger.getLogger(DodavanjeTakmicara.class);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeTakmicara.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBounds(100, 100, 331, 533);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		spinner = new JSpinner();
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o takmi\u010Daru", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		JButton btnPotvrdi = new JButton("Potvrdi");
		comboBox_1 = new JComboBox();
		comboBox = new JComboBox();
		JTableUtil jtutil = new JTableUtil();
		List<Klub> klubovi = jtutil.populateComboBoxKlubovi();
		textPane_3 = new JTextPane();
		for(int i=0; i<klubovi.size(); i++)
		{
			comboBox_1.addItem(klubovi.get(i).getNaziv());
		}
		
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPane_1.setText("");
				
				boolean flag = false;
				
				if(validirajPrazno(textField.getText()))
				{
					textPane_3.setText("");
				}
				if(!validirajPrazno(textField.getText()))
				{
					textPane_3.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if(validirajPrazno(textField.getText()))
				{
					if(validirajAlpha(textField.getText()))
					{
						textPane_3.setText("");
					}
				}
				if (validirajPrazno(textField.getText()))
				{
					if(!validirajAlpha(textField.getText()))
					{
						textPane_3.setText("Neispravni karakteri");
						flag = true;
					}
				}// ODAVDE POPRAVI
				if(validirajPrazno(textField_2.getText()))
				{
					textPane_4.setText("");
				}
				if(!validirajPrazno(textField_2.getText()))
				{
					textPane_4.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(validirajAlpha(textField_2.getText()))
					{
						textPane_4.setText("");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(!validirajAlpha(textField_2.getText()))
					{
						textPane_4.setText("Neispravni karakteri");
						flag = true;
					}
				}
//popravi
				if(validirajJmbg(textField_1.getText()))
				{
					textPane_1.setText("");	
				}
				else
				{
					textPane_1.setText("JMBG ne odgovara traženom formatu");	
					flag = true;
				}
				if(!flag)
				{
					final Logger logger = Logger.getLogger(DodavanjeTakmicara.class);
					Takmicar t = new Takmicar();
					TakmicarDAO tdao = new TakmicarDAO();
					
					t.setIme(textField.getText());
					t.setPrezime(textField_2.getText());
					t.setJmbg(textField_1.getText());
					t.setDatumRodjenja((Date)spinner.getValue());

					String datum = t.getJmbg().substring(0, 2);
					String mjesec = t.getJmbg().substring(2, 4);
					String godina = "1"+ t.getJmbg().substring(4, 7);

					String sredi = datum + "-" + mjesec + "-" + godina;
					
					String poredi = spinner.getValue().toString();
			        SimpleDateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			        DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
			        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
			        boolean flax = false;
			        try {
						Date jmbgDatum = targetFormat.parse(sredi);
						System.out.println(jmbgDatum);
						System.out.println(sredi);
						if (jmbgDatum.equals(t.getDatumRodjenja()))
							flax = true;
					} 
			        catch (ParseException e1) {
			        	logger.error("Belaj", e1);
					}
					
					spinner.getValue().toString();
					t.setKategorija(comboBox.getSelectedItem().toString());
					long tit = 0;
					t.setBrojTitula(tit);
					t.setBrojacPoraza(0);
					
  			         int[] omjer =  tdao.getMatchSummary(t.getId());
					 int brojPobjeda = omjer[0];
					 int brojNerijesenih = omjer[1];
					 int brojPoraza = omjer[2];
					 double bodovi = brojPobjeda*1.0d + brojNerijesenih*0.5d;
					 
					t.setBrojBodova(bodovi);
					List<Klub> klubovi = new ArrayList<Klub>();
					KlubDAO kdao = new KlubDAO();
					klubovi = kdao.getAll(Klub.class);
					for(int i=0; i<klubovi.size(); i++)
					{
						if(comboBox_1.getSelectedItem().toString().equals(klubovi.get(i).getNaziv()))
						{
							t.setKlub(klubovi.get(i));
							break;
						}
					}
					
					List<Takmicar> takmicari1 = new ArrayList<Takmicar>();
					takmicari1 = tdao.getAll(Takmicar.class);
					boolean flek = false;
					for(int i = 0; i< takmicari1.size(); i++)
					{
						if (t.getJmbg().equals(takmicari1.get(i).getJmbg()))
							flek = true;
					}
					if (flek)
					{
						JOptionPane.showMessageDialog(null, "Postoji veæ korisnik s tim matiènim brojem!", "Greška", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(flax)
						{
							tdao.create(t);
							JOptionPane.showMessageDialog(null, "Uspješno ste dodali takmièara!", "OK", JOptionPane.INFORMATION_MESSAGE);										
							JFrame thisFrame = (JFrame) SwingUtilities
									.getRoot(textField_1);
							thisFrame.dispose();
							parentFrame.setEnabled(true);
							gpf.RefreshTables();
						}
						else JOptionPane.showMessageDialog(null, "Matièni broj i datum roðenja nisu usklaðeni!", "Greška", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPotvrdi)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPotvrdi)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		
		txtpnDatumRoenja = new JTextPane();
		txtpnDatumRoenja.setEditable(false);
		txtpnDatumRoenja.setText("Datum ro\u0111enja: *");
		
		spinner.setModel(new SpinnerDateModel(new Date(-2197242000000L), null, null, Calendar.DAY_OF_YEAR));
		
		txtpnJmbg = new JTextPane();
		txtpnJmbg.setEditable(false);
		txtpnJmbg.setText("JMBG: *");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		txtpnKategorija = new JTextPane();
		txtpnKategorija.setEditable(false);
		txtpnKategorija.setText("Kategorija:");
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Majstor", "Majstorski kandidat", "I kategorija", "II kategorija", "III kategorija", "IV kategorija", "Bez kategorije"}));
		
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.red);
		
		JTextPane txtpnKlub = new JTextPane();
		txtpnKlub.setText("Klub: *");
		txtpnKlub.setEditable(false);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Ime: *");
		textPane.setEditable(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Prezime: *");
		textPane_2.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textPane_3.setForeground(Color.RED);
		
		textPane_3.setEditable(false);
		
		textPane_4 = new JTextPane();
		textPane_4.setForeground(Color.RED);
		textPane_4.setEditable(false);
		
	
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textPane_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textPane_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textPane_3, Alignment.LEADING)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnDatumRoenja, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnKategorija, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, 0, 238, Short.MAX_VALUE)
								.addComponent(txtpnKlub, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, 0, 238, Short.MAX_VALUE))))
					.addGap(34))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(txtpnDatumRoenja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnKategorija, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnKlub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public DodavanjeTakmicara(Takmicar t1, JFrame pf, GlavniProzor gp) {
		parentFrame = pf;
		gpf = gp;
		final Logger logger = Logger.getLogger(DodavanjeTakmicara.class);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		t=t1;
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeTakmicara.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBounds(100, 100, 321, 542);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		spinner = new JSpinner();
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o takmi\u010Daru", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		JButton btnPotvrdi = new JButton("Potvrdi");
		
		
		
		
		comboBox_1 = new JComboBox();
		comboBox = new JComboBox();
		JTableUtil jtutil = new JTableUtil();
		List<Klub> klubovi = jtutil.populateComboBoxKlubovi();
		textPane_3 = new JTextPane();
		for(int i=0; i<klubovi.size(); i++)
		{
			comboBox_1.addItem(klubovi.get(i).getNaziv());
		}
		
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPane_1.setText("");
				
				boolean flag = false;
				
				if(validirajPrazno(textField.getText()))
				{
					textPane_3.setText("");
				}
				if(!validirajPrazno(textField.getText()))
				{
					textPane_3.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if(validirajPrazno(textField.getText()))
				{
					if(validirajAlpha(textField.getText()))
					{
						textPane_3.setText("");
					}
				}
				if (validirajPrazno(textField.getText()))
				{
					if(!validirajAlpha(textField.getText()))
					{
						textPane_3.setText("Neispravni karakteri");
						flag = true;
					}
				}// ODAVDE POPRAVI
				if(validirajPrazno(textField_2.getText()))
				{
					textPane_4.setText("");
				}
				if(!validirajPrazno(textField_2.getText()))
				{
					textPane_4.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(validirajAlpha(textField_2.getText()))
					{
						textPane_4.setText("");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(!validirajAlpha(textField_2.getText()))
					{
						textPane_4.setText("Neispravni karakteri");
						flag = true;
					}
				}
//popravi
				if(validirajJmbg(textField_1.getText()))
				{
					textPane_1.setText("");	
				}
				else
				{
					textPane_1.setText("JMBG ne odgovara traženom formatu");	
					flag = true;
				}
				if(!flag)
				{
					Takmicar tak =	GenericDAO.loadById(Takmicar.class, t.getId());
					
					TakmicarDAO takdao = new TakmicarDAO();
					
					tak.setIme(textField.getText());
					tak.setPrezime(textField_2.getText());
					tak.setJmbg(textField_1.getText());
					tak.setDatumRodjenja((Date)spinner.getValue());
					tak.setKategorija(comboBox.getSelectedItem().toString());
					
					
					String datum = t.getJmbg().substring(0, 2);
					String mjesec = t.getJmbg().substring(2, 4);
					String godina = "1"+ t.getJmbg().substring(4, 7);

					String sredi = datum + "-" + mjesec + "-" + godina;
					
					String poredi = spinner.getValue().toString();
			        SimpleDateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			        DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
			        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
			        boolean flax = false;
			        try {
						Date jmbgDatum = targetFormat.parse(sredi);
						System.out.println(jmbgDatum);
						System.out.println(sredi);
						if (jmbgDatum.equals(t.getDatumRodjenja()))
							flax = true;
					} 
			        catch (ParseException e1) {
			        	logger.error("Belaj", e1);
					}
					
					
					List<Klub> klubovi = new ArrayList<Klub>();
					KlubDAO kdao = new KlubDAO();
					klubovi = kdao.getAll(Klub.class);
					for(int i=0; i<klubovi.size(); i++)
					{
						if(comboBox_1.getSelectedItem().toString().equals(klubovi.get(i).getNaziv()))
						{
							tak.setKlub(klubovi.get(i));
							break;
						}
					}			
					
					List<Takmicar> takmicari1 = new ArrayList<Takmicar>();
					takmicari1 = takdao.getAll(Takmicar.class);
					boolean flek = false;
					for(int i = 0; i< takmicari1.size(); i++)
					{
						if (tak.getJmbg().equals(takmicari1.get(i).getJmbg()) && tak.getId() != takmicari1.get(i).getId())
							flek = true;
					}
					if (flek)
					{
						JOptionPane.showMessageDialog(null, "Postoji veæ korisnik s tim matiènim brojem!", "Greška", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(flax)
						{
							takdao.update(tak);
							JOptionPane.showMessageDialog(null, "Uspješno ste modifikovali takmièara!", "OK", JOptionPane.INFORMATION_MESSAGE);										
							JFrame thisFrame = (JFrame) SwingUtilities
									.getRoot(textField_1);
							thisFrame.dispose();
							parentFrame.setEnabled(true);
							gpf.RefreshTables();
						}
						else JOptionPane.showMessageDialog(null, "Matièni broj i datum roðenja nisu usklaðeni!", "Greška", JOptionPane.ERROR_MESSAGE);

					

					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(228, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPotvrdi)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		
		txtpnDatumRoenja = new JTextPane();
		txtpnDatumRoenja.setEditable(false);
		txtpnDatumRoenja.setText("Datum ro\u0111enja: *");
		
		spinner.setModel(new SpinnerDateModel(new Date(-2197242000000L), null, null, Calendar.DAY_OF_YEAR));
		
		txtpnJmbg = new JTextPane();
		txtpnJmbg.setEditable(false);
		txtpnJmbg.setText("JMBG: *");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		txtpnKategorija = new JTextPane();
		txtpnKategorija.setEditable(false);
		txtpnKategorija.setText("Kategorija:");
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Majstor", "Majstorski kandidat", "I kategorija", "II kategorija", "III kategorija", "IV kategorija", "Bez kategorije"}));
		
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.red);
		
		JTextPane txtpnKlub = new JTextPane();
		txtpnKlub.setText("Klub: *");
		txtpnKlub.setEditable(false);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Ime: *");
		textPane.setEditable(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Prezime: *");
		textPane_2.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textPane_3.setForeground(Color.RED);
		
		textPane_3.setEditable(false);
		
		textPane_4 = new JTextPane();
		textPane_4.setForeground(Color.RED);
		textPane_4.setEditable(false);
		
		textField.setText(t.getIme());
		textField_2.setText(t.getPrezime());
		textField_1.setText(t.getJmbg());
		if(t.getDatumRodjenja()!=null)spinner.setValue((Date)t.getDatumRodjenja());
		
		comboBox.setSelectedItem(t.getKategorija());
		comboBox_1.setSelectedItem(t.getKlub().getNaziv());
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textPane_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textPane_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtpnKategorija, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, 0, 235, Short.MAX_VALUE)
								.addComponent(txtpnKlub, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtpnDatumRoenja, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1)
								.addComponent(spinner)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									))))
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(txtpnDatumRoenja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGap(11)
					.addComponent(txtpnKategorija, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnKlub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
