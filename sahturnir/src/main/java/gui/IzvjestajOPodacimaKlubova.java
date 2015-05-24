package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import org.apache.log4j.Logger;

import dal.KlubDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;
import klase.Klub;
import klase.Takmicar;
import klase.Turnir;
import utils.JTableUtil;

public class IzvjestajOPodacimaKlubova extends JFrame {

	private JPanel contentPane;
	private JButton btnPrint;
	private JPanel panel;
	private JLabel lblUkupniBrojTitula;
	private JTextField textField_1;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JComboBox comboBox;
	private JSpinner spinner_3;
	private JLabel lblBrojTitulaTakmiara;
	private JLabel lblBrojTurnira;
	private JLabel lblUkupniBrojBodova;
	private JLabel lblBrojTakmiara;
	private JLabel lblImeKluba;
	private JLabel lblIzaberiKlub;
	private JSpinner spinner_4;
	private transient JTableUtil jtutil;
	private transient List<Takmicar> takmicari;
	private transient TakmicarDAO tdao;
	private transient List<Turnir> turniri;
	private transient TurnirDAO turnirdao;
	private JSpinner spinner_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(IzvjestajOPodacimaKlubova.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					IzvjestajOPodacimaKlubova frame = new IzvjestajOPodacimaKlubova();
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
	public IzvjestajOPodacimaKlubova() {
		setResizable(false);
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajOPodacimaKlubova.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 494);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnIzvjetajOPodacima = new JTextPane();
		txtpnIzvjetajOPodacima.setBackground(Color.WHITE);
		txtpnIzvjetajOPodacima.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnIzvjetajOPodacima.setText("Izvje\u0161taj o podacima kluba");
		
		JTextPane txtpnDatumIVrijeme = new JTextPane();
		txtpnDatumIVrijeme.setBackground(Color.WHITE);
		txtpnDatumIVrijeme.setText("Datum i vrijeme generisanja izvje\u0161taja:");
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		        attributes.add(DialogTypeSelection.COMMON);
		        PrinterJob printJob = PrinterJob.getPrinterJob();
		        printJob.printDialog(attributes);
			}
		});
		
		panel = new JPanel();
		
		lblUkupniBrojTitula = new JLabel("Ukupni broj titula:");
		lblUkupniBrojTitula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setEnabled(false);
		
		spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		
		spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		
		comboBox = new JComboBox();
		
		spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		
		lblBrojTitulaTakmiara = new JLabel("Broj titula takmi\u010Dara:");
		lblBrojTitulaTakmiara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblBrojTurnira = new JLabel("Broj turnira:");
		lblBrojTurnira.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblUkupniBrojBodova = new JLabel("Ukupni broj bodova:");
		lblUkupniBrojBodova.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblBrojTakmiara = new JLabel("Broj takmi\u010Dara:");
		lblBrojTakmiara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblImeKluba = new JLabel("Ime kluba:");
		lblImeKluba.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblIzaberiKlub = new JLabel("Izaberi klub:");
		lblIzaberiKlub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		spinner_4 = new JSpinner();
		spinner_4.setEnabled(false);
		
		jtutil = new JTableUtil();
		final List<Klub> klubovi = jtutil.populateComboBoxKlubovi();
		
		takmicari = new ArrayList<Takmicar>();
		tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);
		
		turniri = new ArrayList<Turnir>();
		turnirdao = new TurnirDAO();
		turniri = turnirdao.getAll(Turnir.class);
		
		for(int i=0; i<klubovi.size(); i++)
		{
			comboBox.addItem(klubovi.get(i).getNaziv());
		}
		
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        String selectedKlub = (String) combo.getSelectedItem();
		 
		        for (int i=0; i<klubovi.size(); i++)
		        {
		        	if (selectedKlub.equals(klubovi.get(i).getNaziv()))
		        	 {
		        		 textField_1.setText(selectedKlub);
		        		 
		        		 int brojacTakmicaraKluba=0;
		        		 double brojBodovaSvihTakmicaraKluba=0;
		        		// int brojTitulaTakmicara=0;
		        		 int brojTurnira=0, ukupanBrojTitula=0;
		        		 
		        		 for (int j=0; j<takmicari.size(); j++)
		        		 {
		        			 Klub k = takmicari.get(j).getKlub();
		        			 if (k.getNaziv()==selectedKlub) brojacTakmicaraKluba++;
		        			 Takmicar t=takmicari.get(j);
		        			 double a=t.getBrojBodova();
		        			 brojBodovaSvihTakmicaraKluba+=a;	    
		        		 }
		        		 spinner_3.setValue(brojacTakmicaraKluba);
		        		 spinner.setValue(brojBodovaSvihTakmicaraKluba);
		        		 spinner_2.setValue(brojTurnira);	
		        		 spinner_1.setValue(ukupanBrojTitula);
		        	 }
		        } 
		        spinner_5.setValue(LocalDateTime.now());
		    }
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImeKluba, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIzaberiKlub, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojTakmiara, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUkupniBrojTitula, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojTurnira, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUkupniBrojBodova, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojTitulaTakmiara, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(spinner_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(spinner_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(spinner_3)
							.addComponent(spinner)))
					.addGap(89))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIzaberiKlub, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblImeKluba, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrojTakmiara, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUkupniBrojBodova, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrojTurnira, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrojTitulaTakmiara, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(17)
									.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblUkupniBrojTitula, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		spinner_5 = new JSpinner();
		spinner_5.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtpnIzvjetajOPodacima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnIzvjetajOPodacima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrint))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
