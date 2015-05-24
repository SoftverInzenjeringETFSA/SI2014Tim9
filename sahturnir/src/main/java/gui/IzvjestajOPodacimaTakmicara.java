package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Toolkit;

import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.DropMode;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerDateModel;

import org.apache.log4j.Logger;

import utils.JTableUtil;
import dal.TakmicarDAO;
import dal.TurnirDAO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import klase.Klub;
import klase.Takmicar;
import klase.Turnir;
import javax.swing.SpinnerNumberModel;

public class IzvjestajOPodacimaTakmicara extends JFrame {

	private JPanel contentPane;
	private JButton btnPrint;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	transient JTableUtil jtutil;
	private transient List<Takmicar> takmicari;
	private transient TakmicarDAO tdao;
	private JTextField textField_4;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(IzvjestajOPodacimaTakmicara.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					IzvjestajOPodacimaTakmicara frame = new IzvjestajOPodacimaTakmicara();
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
	public IzvjestajOPodacimaTakmicara() {
		setResizable(false);
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajOPodacimaTakmicara.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 615);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnPodaciOTakmiarima = new JTextPane();
		txtpnPodaciOTakmiarima.setEditable(false);
		txtpnPodaciOTakmiarima.setBackground(Color.WHITE);
		txtpnPodaciOTakmiarima.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnPodaciOTakmiarima.setText("Izvje\u0161taj o podacima takmi\u010Dara");
		
		JTextPane txtpnDatumIzvjetaja = new JTextPane();
		txtpnDatumIzvjetaja.setEditable(false);
		txtpnDatumIzvjetaja.setBackground(Color.WHITE);
		txtpnDatumIzvjetaja.setText("Datum i vrijeme generisanja izvje\u0161taja:");
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		        attributes.add(DialogTypeSelection.COMMON);
		        PrinterJob printJob = PrinterJob.getPrinterJob();
		        printJob.printDialog(attributes);
			}
		});
		
		JPanel panel = new JPanel();
		
		textField = new JTextField();
		textField.setEditable(false);
		String datum = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss").format(new Date());
		textField.setText(datum);
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(txtpnDatumIzvjetaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtpnPodaciOTakmiarima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnPodaciOTakmiarima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrint))
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnDatumIzvjetaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblIzaberiTakmiara = new JLabel("Izaberite takmi\u010Dara:");
		lblIzaberiTakmiara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblImeIPrezime = new JLabel("Ime i prezime:");
		lblImeIPrezime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDatumRoenja = new JLabel("Datum ro\u0111enja:");
		lblDatumRoenja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblBrojBodova = new JLabel("Broj bodova:");
		lblBrojBodova.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblRang = new JLabel("Rang:");
		lblRang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblKlub = new JLabel("Klub:");
		lblKlub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblBrojUea = new JLabel("Broj u\u010De\u0161\u0107a:");
		lblBrojUea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblBrojTitula = new JLabel("Broj titula:");
		lblBrojTitula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblOmjerPobjedaI = new JLabel("Omjer pobjeda i poraza:");
		lblOmjerPobjedaI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinner.setEnabled(false);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		
		final JSpinner spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		
		JComboBox comboBox = new JComboBox();
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		final JTextField spinner_3 = new JTextField();
		spinner_3.setEnabled(false);
		
		jtutil = new JTableUtil();
		
		takmicari = new ArrayList<Takmicar>();
		tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);
		
		final List<String> imenaPrezimena = new ArrayList<String>();
		
		for(int i=0; i<takmicari.size(); i++)
		{
			String ime = takmicari.get(i).getIme();
			String prezime = takmicari.get(i).getPrezime();
			String s= ime + " " + prezime;
			imenaPrezimena.add(s);
			comboBox.addItem(s);
		}
		
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        String selectedTakmicar = (String) combo.getSelectedItem();
		 
		        for (int i=0; i<takmicari.size(); i++)
		        {
		        	 if (selectedTakmicar.equals(imenaPrezimena.get(i)))
		        	 {
		        		 int brojUcesca=0, brojTitula=0, brojPobjeda=0, brojPoraza=0;
		        	     Takmicar takmicar = takmicari.get(i);
		        		 textField_1.setText(selectedTakmicar);
		        		 spinner.setValue(takmicar.getBrojBodova());
		        		 textField_4.setText(takmicar.getKategorija());
		        		 if(takmicar.getKlub() != null)
		        			 textField_2.setText(takmicar.getKlub().getNaziv());
		        		 else
		        			 textField_2.setText("");
		        		 spinner_1.setValue(brojUcesca);
		        		 spinner_2.setValue(brojTitula);
		        		 textField_3.setText(Integer.toString(brojPobjeda)+" : " + Integer.toString(brojPoraza));
		        		 spinner_3.setText(takmicar.getDatumRodjenja().toString());       		 
		        	 }
		        }
		        textField.setText(LocalDateTime.now().toString());
		        //spinner_4.setValue(LocalDateTime.now());
		    }
		    
		    
		});
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKlub, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojBodova, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojUea, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojTitula, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIzaberiTakmiara, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRang, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOmjerPobjedaI, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDatumRoenja, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblImeIPrezime, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinner_2, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_3)
						.addComponent(textField_4)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_3))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIzaberiTakmiara, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblImeIPrezime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDatumRoenja, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrojBodova, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRang, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKlub, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrojUea, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrojTitula, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOmjerPobjedaI, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
