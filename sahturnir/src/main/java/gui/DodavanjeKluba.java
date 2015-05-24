package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import org.apache.log4j.Logger;

import dal.GenericDAO;
import dal.KlubDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import klase.Klub;

import java.util.Date;
public class DodavanjeKluba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	protected final JTextPane textPane;
	protected final JTextPane textPane_1;
	protected final JTextPane textPane_2;
	private JSpinner spinner = new JSpinner();		
	private JSpinner spinner_1 = new JSpinner();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(DodavanjeKluba.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					DodavanjeKluba frame = new DodavanjeKluba();
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
		//String a = t1.getText();
		
		if(t1.isEmpty()|| t1.trim().length() == 0) 
			izlaz = false;//t2textPane.setText("Polje ne smije biti prazno");
		else
			izlaz = true;
		
		return izlaz;
	}
	
    public static Boolean validirajImePrezime(String t1) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]* +[A-Z][a-z]*)";
		//String a = t1.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;//t2textPane.setText("Neispravni karakteri");
		}
		else
			izlaz = true;
		
		return izlaz;
    }
    
    public static Boolean validirajAlphaNum(String t1) {
		Boolean izlaz = false;
		String pattern = "^[a-zA-Z0-9 ]*";
		//String a = t1.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;//t2textPane.setText("Neispravni karakteri");
		}
		else
			izlaz = true;
		
		return izlaz;
    }
	

	/**
	 * Create the frame.
	 * @return 
	 */
	public DodavanjeKluba() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeKluba.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o klubu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		spinner.setModel(new SpinnerDateModel(new Date(-2197242000000L), null, null, Calendar.DAY_OF_YEAR));

		spinner_1.setEnabled(false);
		spinner_1.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(0.5d)));

		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.WHITE);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				boolean flag = false;
				if(validirajPrazno(textField.getText()))
				{
					textPane.setText("");
				}
				else
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField.getText()))
				{
					if(validirajAlphaNum(textField.getText()))
					{
						textPane.setText("");
					}
				}
				if(validirajPrazno(textField.getText()))
				{
					if(!validirajAlphaNum(textField.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajPrazno(textField_1.getText()))
				{
					textPane_1.setText("");
				}
				else
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_1.getText()))
				{
					if(validirajAlphaNum(textField_1.getText()))
					{
						textPane_1.setText("");
					}
				}
				if(validirajPrazno(textField_1.getText()))
				{
					if(!validirajAlphaNum(textField_1.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					textPane_2.setText("");
				}
				else
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_2.getText()))
				{	
					if(validirajImePrezime(textField_2.getText()))
					{
						textPane_2.setText("");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{	
					if(!validirajImePrezime(textField_2.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if (!flag)
				{
					Klub k = new Klub();
					KlubDAO kdao = new KlubDAO();
					
					k.setNaziv(textField.getText());
					k.setSjediste(textField_1.getText());
					k.setPredsjednik(textField_2.getText());
					k.setDatumOsnivanja((Date)spinner.getValue());

					kdao.create(k);
			        JOptionPane.showMessageDialog(null, "Uspješno ste dodali klub!", "OK", JOptionPane.INFORMATION_MESSAGE);
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
					textPane.setText("");
					textPane_1.setText("");
					textPane_2.setText("");
				}
			}
	});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(221, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		
		JTextPane txtpnNaziv = new JTextPane();
		txtpnNaziv.setEditable(false);
		txtpnNaziv.setBackground(Color.WHITE);
		txtpnNaziv.setText("Naziv: *");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnSjedite = new JTextPane();
		txtpnSjedite.setEditable(false);
		txtpnSjedite.setText("Sjedi\u0161te: *");
		txtpnSjedite.setBackground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnPredsjednik = new JTextPane();
		txtpnPredsjednik.setEditable(false);
		txtpnPredsjednik.setText("Predsjednik: *");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextPane txtpnDatumOsnivanja = new JTextPane();
		txtpnDatumOsnivanja.setEditable(false);
		txtpnDatumOsnivanja.setText("Datum osnivanja: *");
		
		JTextPane txtpnBrojBodova = new JTextPane();
		txtpnBrojBodova.setEditable(false);
		txtpnBrojBodova.setText("Broj bodova:");
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.red);
		
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.red);
		
		textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setForeground(Color.red);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnDatumOsnivanja, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnPredsjednik, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnSjedite, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(spinner, Alignment.LEADING)
							.addComponent(textField_1, Alignment.LEADING)
							.addComponent(textPane, Alignment.LEADING)
							.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(textPane_2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(txtpnBrojBodova, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtpnSjedite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnPredsjednik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(txtpnDatumOsnivanja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnBrojBodova, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
