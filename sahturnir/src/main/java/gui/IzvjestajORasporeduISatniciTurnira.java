package gui;

import gui.GlavniProzor.ImageRendererDelete;
import gui.GlavniProzor.ImageRendererEdit;
import gui.GlavniProzor.ImageRendererMatch;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JLabel;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	private JFrame parentFrame;
	private JButton btnPrint = new JButton("Print");
	/**
	 * Launch the application.
	 */
	private void PrepareTableDesign(JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Color c1 = new Color(0x67FD9A);
				Color c2 = new Color(0xC0C0C0);
				Color c3 = new Color(0x343434);
				final Component c = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 0 ? c1 : c2);
				table.setRowHeight(row, 40);
				JTableHeader h = table.getTableHeader();
				h.setOpaque(false);
				h.setBackground(c3);
				h.setForeground(Color.white);
				return c;
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IzvjestajORasporeduISatniciTurnira(JFrame pf) {
		parentFrame = pf;
		final Logger logger = Logger.getLogger(IzvjestajORasporeduISatniciTurnira.class);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajORasporeduISatniciTurnira.class.getResource("/gui/logo.png")));
		setBounds(100, 100, 845, 539);
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
			comboBox.addItem(turniri.get(i).getNaziv());
		}
		mecevi = new ArrayList<Mec>();
		mecdao = new MecDAO();
		mecevi = mecdao.getAll(Mec.class);
		
		klubdao = new KlubDAO();
		
		
		
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        btnPrint.setEnabled(true);
		        String selectedTurnir = (String) combo.getSelectedItem();
		        textField.setText(LocalDateTime.now().toString());
		        long t=-1;
		        for(int i=0; i<turniri.size(); i++)
				{
					if (turniri.get(i).getNaziv().equals(selectedTurnir)) 
					{
						t=turniri.get(i).getId();
					}
						
				}
		        ((DefaultTableModel) table.getModel()).setRowCount(0);
		        PrepareTableDesign(table);

		        for(int i=0; i<mecevi.size(); i++)
		        {
		        	
		        	if(mecevi.get(i).getTurnir().getId()==t) 
		        	{
		    			((DefaultTableModel) table.getModel()).addRow(new Object[] {i+1, 
		    					mecevi.get(i).getTakmicar1().getIme() + " " + mecevi.get(i).getTakmicar1().getPrezime(), 
		    					mecevi.get(i).getTakmicar2().getIme() + " " + mecevi.get(i).getTakmicar2().getPrezime(), mecevi.get(i).getDatumPocetka()  });

		        	}
		        }
		    }
		    
		    
		});
		
		btnPrint.setEnabled(false);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		        attributes.add(DialogTypeSelection.COMMON);
		        PrinterJob printJob = PrinterJob.getPrinterJob();
		        printJob.printDialog(attributes);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtpnIzvjetajORasporedu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
									.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
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
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnPrint))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
