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
import dal.TakmicarDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import klase.Klub;
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
	private JTextPane txtpnBrojBodova;
	private JTextPane txtpnKategorija;
	private JSpinner spinner_1;
	protected final JTextPane textPane_1;
	private JSpinner timeSpinner;
	private JSpinner spinner;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextPane textPane_4;
	private JTextPane textPane_3;
	transient Takmicar t1 = new Takmicar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(DodavanjeTakmicara.class);
				EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					DodavanjeTakmicara frame = new DodavanjeTakmicara();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
//					e.printStackTrace();
					logger.error("Došlo je do greške!", e);
				}
			}
		});
	}
	public static Boolean validirajPrazno(String t1) {
		Boolean izlaz = false;
		
		if(t1.isEmpty() || t1.trim().length() == 0) 
			izlaz = false;
		else
			izlaz = true;
		
		return izlaz;
	}
	
	public static Boolean validirajJmbg(String t1) {
		Boolean izlaz = false;
		if (!(t1.length() == 13))
		{
			izlaz = false;
		}
		else
			izlaz = true;
		return izlaz;
    }
	
    public static Boolean validirajImePrezime(String t1) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]* +[A-Z][a-z]*)";
		Pattern p = Pattern.compile(pattern);
		java.util.regex.Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;
		}
		else
			izlaz = true;
		
		return izlaz;
    }

    public static Boolean validirajAlpha(String t1) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]*)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;
		}
		else
			izlaz = true;
		
		return izlaz;
    }
    
    public static Boolean validirajAlphaNum(String t1) {
		Boolean izlaz = false;
		String pattern = "^[a-zA-Z0-9 ]*";
		Pattern p = Pattern.compile(pattern);
		java.util.regex.Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;
		}
		else
			izlaz = true;
		
		return izlaz;
    }
	

	/**
	 * Create the frame.
	 */
	public DodavanjeTakmicara() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeTakmicara.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 650);
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
					Takmicar t = new Takmicar();
					TakmicarDAO tdao = new TakmicarDAO();
					
					t.setIme(textField.getText());
					t.setPrezime(textField_2.getText());
					t.setJmbg(textField_1.getText());
					t.setDatumRodjenja((Date)spinner.getValue());
					t.setBrojBodova((Double)spinner_1.getValue());
					t.setKategorija(comboBox.getSelectedItem().toString());
					
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
					
					tdao.create(t);
			        JOptionPane.showMessageDialog(null, "Uspješno ste dodali takmièara!", "OK", JOptionPane.INFORMATION_MESSAGE);										
					textPane_1.setText("");
					textPane_3.setText("");
					textPane_4.setText("");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(btnPotvrdi, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
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
		
		txtpnBrojBodova = new JTextPane();
		txtpnBrojBodova.setEditable(false);
		txtpnBrojBodova.setText("Broj bodova:");
		
		txtpnKategorija = new JTextPane();
		txtpnKategorija.setEditable(false);
		txtpnKategorija.setText("Kategorija:");
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Majstor", "Majstorski kandidat", "I kategorija", "II kategorija", "III kategorija", "IV kategorija", "Bez kategorije"}));
		
		spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(0.5d)));
		
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
									.addComponent(txtpnBrojBodova, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))))
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
					.addComponent(txtpnBrojBodova, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
	
	
	public DodavanjeTakmicara(Takmicar t) {
		t1 = t;
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeTakmicara.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 650);
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
		
		textField.setText(t1.getIme());
		textField_2.setText(t1.getPrezime());
		textField_1.setText(t1.getJmbg());
		
		
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
					Takmicar t = new Takmicar();
					TakmicarDAO tdao = new TakmicarDAO();
					
					t.setIme(textField.getText());
					t.setPrezime(textField_2.getText());
					t.setJmbg(textField_1.getText());
					t.setDatumRodjenja((Date)spinner.getValue());
					t.setBrojBodova((Double)spinner_1.getValue());
					t.setKategorija(comboBox.getSelectedItem().toString());
					
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
					
					tdao.create(t);
			        JOptionPane.showMessageDialog(null, "Uspješno ste dodali takmièara!", "OK", JOptionPane.INFORMATION_MESSAGE);										
					textPane_1.setText("");
					textPane_3.setText("");
					textPane_4.setText("");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(btnPotvrdi, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
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
		
		txtpnBrojBodova = new JTextPane();
		txtpnBrojBodova.setEditable(false);
		txtpnBrojBodova.setText("Broj bodova:");
		
		txtpnKategorija = new JTextPane();
		txtpnKategorija.setEditable(false);
		txtpnKategorija.setText("Kategorija:");
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Majstor", "Majstorski kandidat", "I kategorija", "II kategorija", "III kategorija", "IV kategorija", "Bez kategorije"}));
		
		spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(0.5d)));
		
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
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtpnBrojBodova, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))))
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
					.addComponent(txtpnBrojBodova, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
