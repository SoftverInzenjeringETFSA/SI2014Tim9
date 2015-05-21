package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKluba frame = new DodavanjeKluba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Boolean validirajPrazno(JTextField t1, JTextPane t2) {
		Boolean izlaz = false;
		String a = t1.getText();
		
		if(a.isEmpty()) 
			t2.setText("Polje ne smije biti prazno");
		else
			izlaz = true;
		
		return izlaz;
	}
	
    public static Boolean validirajImePrezime(JTextField t1, JTextPane t2) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]* +[A-Z][a-z]*)";
		String a = t1.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(a);
		
		if(!(m.matches())) {
			t2.setText("Neispravni karakteri");
		}
		else
			izlaz = true;
		
		return izlaz;
    }
    
    public static Boolean validirajAlphaNum(JTextField t1, JTextPane t2) {
		Boolean izlaz = false;
		String pattern = "^[a-zA-Z0-9 ]*";
		String a = t1.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(a);
		
		if(!(m.matches())) {
			t2.setText("Neispravni karakteri");
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
		setBounds(100, 100, 324, 506);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o klubu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.WHITE);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				if(validirajPrazno(textField, textPane))
					textPane.setText("");
				if(validirajPrazno(textField, textPane))
					if(validirajAlphaNum(textField, textPane))
						textPane.setText("");
				if(validirajPrazno(textField_1, textPane_1))
					textPane_1.setText("");
				if(validirajPrazno(textField_1, textPane_1))
					if(validirajAlphaNum(textField_1, textPane_1))
						textPane_1.setText("");
				if(validirajPrazno(textField_2, textPane_2))
					textPane_2.setText("");
				if(validirajPrazno(textField_2, textPane_2))
					if(validirajImePrezime(textField_2, textPane_2))
						textPane_2.setText("");
			}
	});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(199, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(-2197242000000L), null, null, Calendar.DAY_OF_YEAR));
		
		JTextPane txtpnBrojBodova = new JTextPane();
		txtpnBrojBodova.setEditable(false);
		txtpnBrojBodova.setText("Broj bodova:");
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(0.5d)));
		
		textPane = new JTextPane();
		textPane.setForeground(Color.red);
		
		textPane_1 = new JTextPane();
		textPane_1.setForeground(Color.red);
		
		textPane_2 = new JTextPane();
		textPane_2.setForeground(Color.red);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(txtpnBrojBodova, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnDatumOsnivanja, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(txtpnPredsjednik, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnSjedite, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnSjedite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(txtpnPredsjednik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtpnDatumOsnivanja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnBrojBodova, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
