package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

import utils.HibernateUtil;
import klase.Mec;

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
					e.printStackTrace();
					logger.error("Sorry, something wrong!", e);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 473);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPotvrdi)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPotvrdi)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setText("Naziv turnira:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnKategorija = new JTextPane();
		txtpnKategorija.setText("Kategorija:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnTakmiar = new JTextPane();
		txtpnTakmiar.setText("Takmi\u010Dar 1:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextPane txtpnTakmiar_1 = new JTextPane();
		txtpnTakmiar_1.setText("Takmi\u010Dar 2:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JTextPane txtpnRezultatMea = new JTextPane();
		txtpnRezultatMea.setText("Rezultat me\u010Da: *");
		
		JSpinner spinner = new JSpinner();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(spinner, Alignment.LEADING)
						.addComponent(txtpnRezultatMea, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnTakmiar_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(textField_1, Alignment.LEADING)
						.addComponent(txtpnNazivTurnira, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(txtpnTakmiar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnKategorija, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, Alignment.LEADING))
					.addContainerGap(23, Short.MAX_VALUE))
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
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnTakmiar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnRezultatMea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
