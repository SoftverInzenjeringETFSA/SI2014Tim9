package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.transaction.Transaction;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import dal.MecDAO;
import utils.HibernateUtil;
import klase.Mec;
import klase.Turnir;

import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RezultatiMecevaUnos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JSpinner spinner = new JSpinner();		
	private JSpinner spinner_1 = new JSpinner();
	transient Mec m1;
	transient Turnir t1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(RezultatiMecevaUnos.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					RezultatiMecevaUnos frame = new RezultatiMecevaUnos();
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

	/**
	 * Create the frame.
	 */
	public RezultatiMecevaUnos() {
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RezultatiMecevaUnos.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 420);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o me\u010Du", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("");
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// UNESI U BAZU UPDATE TO DO !!!
				Mec m = new Mec();
				m.setRezultat1((Double)spinner.getValue());
				m.setRezultat2((Double)spinner_1.getValue());
				MecDAO mdao = new MecDAO();
				mdao.update(m);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnPotvrdi)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		
		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setEditable(false);
		txtpnNazivTurnira.setText("Naziv turnira:");
		
		textField = new JTextField();
		textField.setColumns(10);
		JTextPane txtpnKategorija = new JTextPane();
		txtpnKategorija.setEditable(false);
		txtpnKategorija.setText("Kategorija:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnTakmiar = new JTextPane();
		txtpnTakmiar.setEditable(false);
		txtpnTakmiar.setText("Takmi\u010Dar 1:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextPane txtpnTakmiar_1 = new JTextPane();
		txtpnTakmiar_1.setEditable(false);
		txtpnTakmiar_1.setText("Takmi\u010Dar 2:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if((Double)spinner.getValue() == 0.0d)
				{
					spinner_1.setValue(1.0d);
				}
				if((Double)spinner.getValue() == 0.5d)
				{
					spinner_1.setValue(0.5d);					
				}
				if((Double)spinner.getValue() == 1.0d)
				{
					spinner_1.setValue(0.0d);					
				}
			}
		});
		
		spinner.setModel(new SpinnerNumberModel(0, 0, 1, 0.5d));
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if((Double)spinner_1.getValue() == 0.0d)
				{
					spinner.setValue(1.0d);
				}
				if((Double)spinner_1.getValue() == 0.5d)
				{
					spinner.setValue(0.5d);					
				}
				if((Double)spinner_1.getValue() == 1.0d)
				{
					spinner.setValue(0.0d);					
				}			
			}
		});
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 1, 0.5d));
		spinner_1.setValue(1.0d);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtpnTakmiar_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(textField_1, Alignment.LEADING)
						.addComponent(txtpnNazivTurnira, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(txtpnTakmiar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnKategorija, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnKategorija, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnTakmiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtpnTakmiar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public RezultatiMecevaUnos(Turnir t, Mec m) {
		m1 = m;
		t1 = t;
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RezultatiMecevaUnos.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 420);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o me\u010Du", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("");
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// UNESI U BAZU UPDATE TO DO !!!
				m1.setRezultat1((Double)spinner.getValue());
				m1.setRezultat2((Double)spinner_1.getValue());
				MecDAO mdao = new MecDAO();
				mdao.update(m1);
				RezultatiMecevaTabela frame = new RezultatiMecevaTabela(t1);
				frame.setVisible(true);
		        JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili korisnika!", "OK", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnPotvrdi)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		
		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setEditable(false);
		txtpnNazivTurnira.setText("Naziv turnira:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField.setText(t.getNaziv());
		textField.setEditable(false);
		JTextPane txtpnKategorija = new JTextPane();
		txtpnKategorija.setEditable(false);
		txtpnKategorija.setText("Kategorija:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(t.getFormatTakmicenja());
		textField_1.setEditable(false);
		JTextPane txtpnTakmiar = new JTextPane();
		txtpnTakmiar.setEditable(false);
		txtpnTakmiar.setText("Takmi\u010Dar 1:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(m.getTakmicar1().getIme() + " " + m.getTakmicar1().getPrezime());
		textField_2.setEditable(false);
		JTextPane txtpnTakmiar_1 = new JTextPane();
		txtpnTakmiar_1.setEditable(false);
		txtpnTakmiar_1.setText("Takmi\u010Dar 2:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText(m.getTakmicar2().getIme() + " " + m.getTakmicar2().getPrezime());		
		textField_3.setEditable(false);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if((Double)spinner.getValue() == 0.0d)
				{
					spinner_1.setValue(1.0d);
				}
				if((Double)spinner.getValue() == 0.5d)
				{
					spinner_1.setValue(0.5d);					
				}
				if((Double)spinner.getValue() == 1.0d)
				{
					spinner_1.setValue(0.0d);					
				}
			}
		});
		
		spinner.setModel(new SpinnerNumberModel(0, 0, 1, 0.5d));
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if((Double)spinner_1.getValue() == 0.0d)
				{
					spinner.setValue(1.0d);
				}
				if((Double)spinner_1.getValue() == 0.5d)
				{
					spinner.setValue(0.5d);					
				}
				if((Double)spinner_1.getValue() == 1.0d)
				{
					spinner.setValue(0.0d);					
				}			
			}
		});
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 1, 0.5d));
		spinner_1.setValue(1.0d);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtpnTakmiar_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(textField_1, Alignment.LEADING)
						.addComponent(txtpnNazivTurnira, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(txtpnTakmiar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnKategorija, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnKategorija, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnTakmiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtpnTakmiar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
