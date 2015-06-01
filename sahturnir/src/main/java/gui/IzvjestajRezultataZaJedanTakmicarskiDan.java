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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.Font;

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

public class IzvjestajRezultataZaJedanTakmicarskiDan extends JFrame {

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
	private JSpinner spinner = new JSpinner();
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
	public IzvjestajRezultataZaJedanTakmicarskiDan(JFrame pf) {
		parentFrame = pf;
		final Logger logger = Logger.getLogger(IzvjestajORangListiTakmicara.class);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajRezultataZaJedanTakmicarskiDan.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		JTextPane txtpnDatum = new JTextPane();
		txtpnDatum.setEditable(false);
		txtpnDatum.setText("Datum:");
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextPane txtpnDatum_1 = new JTextPane();
		txtpnDatum_1.setEditable(false);
		txtpnDatum_1.setText("Datum i vrijeme generisanja izvje\u0161taja:");
		
		textField = new JTextField();
		textField.setColumns(10);
		spinner.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), new Date(1433109600000L), Calendar.DAY_OF_YEAR));
		
		JTextPane txtpnIzvjetajRezultataZa_1 = new JTextPane();
		txtpnIzvjetajRezultataZa_1.setEditable(false);
		txtpnIzvjetajRezultataZa_1.setText("Izvje\u0161taj rezultata za jedan takmi\u010Darski dan");
		txtpnIzvjetajRezultataZa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnIzvjetajRezultataZa_1.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Broj me\u010Da", "Takmi\u010Dar 1", "Takmi\u010Dar 2", "Rezultat"
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
		//////////////////////////
		
		
		
		//////////
		
		klubdao = new KlubDAO();
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        /*String selectedTurnir = (String) combo.getSelectedItem();
		        Date d = (Date)spinner.getValue();
		        textField.setText(LocalDateTime.now().toString());
				table.setModel(jtutil.populateJTableRezultatiDan(selectedTurnir, d));
				PrepareTableDesign(table);*/
		        
		        
		        //btnPrint.setEnabled(true);
		        String selectedTurnir = (String) combo.getSelectedItem();
		        textField.setText(LocalDateTime.now().toString());
		        long t=-1;
		        for(int i=0; i<turniri.size(); i++)
				{
					if (turniri.get(i).getNaziv().equals(selectedTurnir)) 
					{
						t=turniri.get(i).getId();
				        long plusDani = turniri.get(i).getTrajanje()*1000*60*60*24;				        
						
						long l = turniri.get(i).getDatumPocetka().getTime();

						long maxDate = l + plusDani;
						spinner.setModel(new SpinnerDateModel(new Date(l), new Date(l), new Date(maxDate), Calendar.DAY_OF_YEAR));
					}		
				}

		        
		        ((DefaultTableModel) table.getModel()).setRowCount(0);
		        PrepareTableDesign(table);
		        
		       String datum=spinner.getValue().toString();
		       
		       SimpleDateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		       DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
		       SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		      
		      
		       
               try{ 
            	   Date date = originalFormat.parse(datum);
			       String spinnerDate = targetFormat.format(date);
			       date = targetFormat.parse(spinnerDate);
			      // System.out.println(targetFormat.format(date));
	            	   
		        for(int i=0; i<mecevi.size(); i++)
		        {
		        	
		        	try{
		        		 
		        		
							Date datemec = format1.parse(mecevi.get(i).getDatumPocetka().toString());
							   String datemec1 = targetFormat.format(datemec);
							   datemec = targetFormat.parse(datemec1);
							   //System.out.println(targetFormat.format(datemec));
							   
		        	if(mecevi.get(i).getTurnir().getId()==t && date.compareTo(datemec)==0) 
		        	{
		        		int jedan=-1;
		        		if(mecevi.get(i).getRezultat1()!=0.5)
		        		{
		        			jedan = (int) Math.round(mecevi.get(i).getRezultat1());
		        		}
		        		int dva=-1;
		        		if(mecevi.get(i).getRezultat2()!=0.5)
		        		{
		        			dva = (int) Math.round(mecevi.get(i).getRezultat2());
		        		}
		        		if(jedan!=-1 && dva!=-1)
		        		{
		        			((DefaultTableModel) table.getModel()).addRow(new Object[] {i+1, 
			    					mecevi.get(i).getTakmicar1().getIme() + " " + mecevi.get(i).getTakmicar1().getPrezime(), 
			    					mecevi.get(i).getTakmicar2().getIme() + " " + mecevi.get(i).getTakmicar2().getPrezime(), 
			    					jedan + " : "+ dva });
		        		}
		        		else if(jedan!=-1)
		        		{
		        			((DefaultTableModel) table.getModel()).addRow(new Object[] {i+1, 
			    					mecevi.get(i).getTakmicar1().getIme() + " " + mecevi.get(i).getTakmicar1().getPrezime(), 
			    					mecevi.get(i).getTakmicar2().getIme() + " " + mecevi.get(i).getTakmicar2().getPrezime(), 
			    					jedan + " : "+ mecevi.get(i).getRezultat2() });
		        		}
		        		else if(dva!=-1)
		        		{
		        			((DefaultTableModel) table.getModel()).addRow(new Object[] {i+1, 
			    					mecevi.get(i).getTakmicar1().getIme() + " " + mecevi.get(i).getTakmicar1().getPrezime(), 
			    					mecevi.get(i).getTakmicar2().getIme() + " " + mecevi.get(i).getTakmicar2().getPrezime(), 
			    					mecevi.get(i).getRezultat1() + " : "+ dva });
		        		}
		        		else{
		        			((DefaultTableModel) table.getModel()).addRow(new Object[] {i+1, 
		    					mecevi.get(i).getTakmicar1().getIme() + " " + mecevi.get(i).getTakmicar1().getPrezime(), 
		    					mecevi.get(i).getTakmicar2().getIme() + " " + mecevi.get(i).getTakmicar2().getPrezime(), 
		    					mecevi.get(i).getRezultat1() + " : "+ mecevi.get(i).getRezultat2() });
		        		}
		        		
		        		
		    			

		        	}
		        	}catch(Exception e){
		        		
		        	}
		        }
               	}catch(Exception e){}
		       
               	
		    }

			
		});
			
			
		
		
	
		
		
		
		
		

		
		
		
		
		
		JButton button = new JButton("Print");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		        attributes.add(DialogTypeSelection.COMMON);
		        PrinterJob printJob = PrinterJob.getPrinterJob();
		        printJob.printDialog(attributes);
			}
		});
	
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtpnIzvjetajRezultataZa_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtpnDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(46)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(87)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnDatum_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnIzvjetajRezultataZa_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnDatum_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
