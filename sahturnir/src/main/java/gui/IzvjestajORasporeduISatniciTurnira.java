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
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;

import org.apache.log4j.Logger;

import utils.JTableUtil;
import dal.KlubDAO;
import dal.MecDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;

import klase.Klub;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;


public class IzvjestajORasporeduISatniciTurnira extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private transient JTableUtil jtutil;
	private transient List<Takmicar> takmicari;
	private transient TakmicarDAO tdao;
	private transient List<Turnir> turniri;
	private transient TurnirDAO turnirdao;
	private transient List<Mec> mecevi;
	private transient MecDAO mecdao;
	private transient KlubDAO klubdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(IzvjestajORasporeduISatniciTurnira.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					IzvjestajORasporeduISatniciTurnira frame = new IzvjestajORasporeduISatniciTurnira();
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
	public IzvjestajORasporeduISatniciTurnira() {
		setResizable(false);
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajORasporeduISatniciTurnira.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnIzvjetajORasporedu = new JTextPane();
		txtpnIzvjetajORasporedu.setEditable(false);
		txtpnIzvjetajORasporedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnIzvjetajORasporedu.setBackground(Color.WHITE);
		txtpnIzvjetajORasporedu.setText("Izvje\u0161taj o rasporedu i satnici turnira");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextPane txtpnDatumIVrijeme = new JTextPane();
		txtpnDatumIVrijeme.setEditable(false);
		txtpnDatumIVrijeme.setBackground(Color.WHITE);
		txtpnDatumIVrijeme.setText("Datum i vrijeme generisanja izvje\u0161taja:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Naziv turnira:");
		
		JComboBox comboBox = new JComboBox();
		
		JTextPane txtpnDatumPoetkaTurnira = new JTextPane();
		txtpnDatumPoetkaTurnira.setEditable(false);
		txtpnDatumPoetkaTurnira.setText("Datum po\u010Detka turnira:");
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1431986400000L), null, null, Calendar.DAY_OF_YEAR));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Broj me\u010Da","Takmi\u010Dar 1", "Takmi\u010Dar 2", "Termin me\u010Da"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		jtutil = new JTableUtil();
		final List<Klub> klubovi = jtutil.populateComboBoxKlubovi();
	
		turniri = new ArrayList<Turnir>();
		turnirdao = new TurnirDAO();
		turniri = turnirdao.getAll(Turnir.class);
		
		for(int i=0; i<turniri.size(); i++)
		{
			comboBox.addItem(turniri.get(i));
		}
		mecevi = new ArrayList<Mec>();
		mecdao = new MecDAO();
		mecevi = mecdao.getAll(Mec.class);
		
		klubdao = new KlubDAO();
		
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        String selectedTurnir = (String) combo.getSelectedItem();
		        textField.setText(LocalDateTime.now().toString());
		    }
		    
		    
		});
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		        attributes.add(DialogTypeSelection.COMMON);
		        PrinterJob printJob = PrinterJob.getPrinterJob();
		        printJob.printDialog(attributes);
			}
		});
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnIzvjetajORasporedu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
							.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnDatumPoetkaTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinner_1)
								.addComponent(comboBox, 0, 153, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnIzvjetajORasporedu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnDatumPoetkaTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnPrint))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
