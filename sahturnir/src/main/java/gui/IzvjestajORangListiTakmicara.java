package gui;

import java.awt.EventQueue;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;

import org.apache.log4j.Logger;

import dal.KlubDAO;
import dal.MecDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;
import utils.JTableUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterJob;

import klase.Klub;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

public class IzvjestajORangListiTakmicara extends JFrame {

	private static final long serialVersionUID = 1L;
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

	public IzvjestajORangListiTakmicara(JFrame pf) {
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
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajORangListiTakmicara.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		
		JTextPane txtpnDatumIVrijeme = new JTextPane();
		txtpnDatumIVrijeme.setEditable(false);
		txtpnDatumIVrijeme.setText("Datum i vrijeme generisanja izvje\u0161taja: ");
		
		JComboBox comboBox = new JComboBox();
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		///////////////////
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { "Pozicija", "Ime i prezime", "Datum roðenja",
					"Klub", "Broj turnira", "Broj titula", "Bodovi na turniru", "Ukupno bodova" }
		));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
		table.getColumnModel().getColumn(5).setPreferredWidth(25);
		table.getColumnModel().getColumn(6).setPreferredWidth(25);
		scrollPane.setViewportView(table);
		////////////////////////////
		
		
		
		
		
		jtutil = new JTableUtil();
		final List<Klub> klubovi = jtutil.populateComboBoxKlubovi();
	
		turniri = new ArrayList<Turnir>();
		turnirdao = new TurnirDAO();
		turniri = turnirdao.getAll(Turnir.class);
	       textField.setText(LocalDateTime.now().toString());
	       textField.setEditable(false);
		for(int i=0; i<turniri.size(); i++)
		{
			comboBox.addItem(turniri.get(i).getNaziv());
		}
		mecevi = new ArrayList<Mec>();
		mecdao = new MecDAO();
		mecevi = mecdao.getAll(Mec.class);
		
		klubdao = new KlubDAO();
		
		
		
		
		
		
	    JTextPane txtpnIzvjetajORang = new JTextPane();
		txtpnIzvjetajORang.setEditable(false);
		txtpnIzvjetajORang.setText("Izvje\u0161taj o rang listi takmi\u010Dara");
		txtpnIzvjetajORang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnIzvjetajORang.setBackground(Color.WHITE);
		
		
		
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        String selectedTurnir = (String) combo.getSelectedItem();
		        //List<Double> pozicije = new ArrayList<Double>(takmicari.size());
		        textField.setText(LocalDateTime.now().toString());
		        
		        //////////////////////////////////////////
		        ////////////////////////////////////////////
		        List<Takmicar> takmicari = new ArrayList<Takmicar>();
				Set<Takmicar> hs = new HashSet<Takmicar>();
				List<Takmicar> takmicari1 = new ArrayList<Takmicar>();
				List<Klub> klubovi = new ArrayList<Klub>();
				List<Mec> mecevi = new ArrayList<Mec>();
				List<Mec> mecevi1 = new ArrayList<Mec>();
				
				takmicari = TakmicarDAO.getAll(Takmicar.class);
				

				klubovi = KlubDAO.getAll(Klub.class);
				Turnir tx = new Turnir();
				
				mecevi = MecDAO.getAll(Mec.class);
				for(int i=0;i<mecevi.size();i++)
				{
					if(mecevi.get(i).getTurnir().getNaziv().equals(selectedTurnir))
					{
						mecevi1.add(mecevi.get(i));
						tx = mecevi.get(i).getTurnir();
					}
				}
			
				for(int i=0;i<mecevi1.size();i++)
				{
					for(int j=0;j<takmicari.size();j++)
					{
						if(mecevi1.get(i).getTakmicar1().getId()==takmicari.get(j).getId())
							takmicari1.add(takmicari.get(j));
						if(mecevi1.get(i).getTakmicar2().getId()==takmicari.get(j).getId())
							takmicari1.add(takmicari.get(j));
					}
					
				}
				hs.addAll(takmicari1);
				takmicari1.clear();
				takmicari1.addAll(hs);
				
				
				
				
				Collections.sort(takmicari1);
				Collections.reverse(takmicari1);
				
				
				((DefaultTableModel) table.getModel()).setRowCount(0);
		        PrepareTableDesign(table);
		        
		        TakmicarDAO trdao = new TakmicarDAO();
		        for(int i=0;i<takmicari1.size();i++)
		        {
   			         int[] omjer =  trdao.getMatchSummary(takmicari1.get(i).getId());
					 int brojPobjeda = omjer[0];
					 int brojNerijesenih = omjer[1];
					 double bodovi = brojPobjeda*1.0d + brojNerijesenih*0.5d;
					 takmicari1.get(i).setBrojBodova(bodovi);
					 int ucesce = 0;
					 ucesce = trdao.getParticipationCount(takmicari1.get(i).getId());
					 ((DefaultTableModel) table.getModel()).addRow(new Object[] {i+1, 
		        			takmicari1.get(i).getIme() + " " + takmicari1.get(i).getPrezime(), 
		        			String.valueOf(takmicari1.get(i).getDatumRodjenja()),
		        			takmicari1.get(i).getKlub().getNaziv(),
		        			ucesce, "0", trdao.getTournamentPoints(takmicari1.get(i).getId(), tx.getId()), takmicari1.get(i).getBrojBodova()});
		        }
		        
		        
		        
		        ///////////////////////////////////////////
		        /////////////////////////////////////////
		        
		        
		        
		    }
		    
		    
		});
		
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnIzvjetajORang, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
							.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnIzvjetajORang, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnPrint))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
}