package gui;

import formatiturnira.JednostrukaEliminacija;
import formatiturnira.Swiss;
import gui.GlavniProzor.ImageRendererDelete;
import gui.GlavniProzor.ImageRendererEdit;
import gui.GlavniProzor.ImageRendererMatch;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;

import klase.Klub;
import klase.Mec;
import klase.Turnir;
import klase.Takmicar;

import org.apache.log4j.Logger;

import dal.KlubDAO;
import dal.MecDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;
import utils.JTableUtil;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class RezultatiMecevaTabela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table = new JTable();
	private transient JTableUtil jtutil = new JTableUtil();
	private JFrame parentFrame;
	private GlavniProzor gpf;
	transient Turnir t1;
	private int swiss = 0;
	private JButton btnNovaRunda = new JButton("Nova runda");
	/**
	 * Launch the application.
	 */

	class ImageRendererDelete extends DefaultTableCellRenderer {
		JLabel tableLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/main/java/gui/delete.png");

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			tableLabel.setText((String) value);
			tableLabel.setIcon(icon);
			tableLabel.setToolTipText("Brisanje");
			tableLabel.setOpaque(true);
			Color c1 = new Color(0x67FD9A);
			Color c2 = new Color(0xC0C0C0);
			tableLabel.setBackground(row % 2 == 0 ? c1 : c2);
			tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return tableLabel;
		}
	}

	class ImageRendererEdit extends DefaultTableCellRenderer {
		JLabel tableLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/main/java/gui/edit.png");

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			tableLabel.setText((String) value);
			tableLabel.setIcon(icon);
			tableLabel.setToolTipText("Ureðivanje");
			tableLabel.setOpaque(true);
			Color c1 = new Color(0x67FD9A);
			Color c2 = new Color(0xC0C0C0);
			tableLabel.setBackground(row % 2 == 0 ? c1 : c2);
			tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return tableLabel;
		}
	}
	
	public void RefreshTables()
	{
		table.setModel(jtutil.populateJTableMecevi(t1));
		PrepareTableDesign(table);
	}

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
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setPreferredSize(new Dimension(0, 40));
		table.getColumnModel().getColumn(table.getColumnCount() - 1)
				.setCellRenderer(new ImageRendererDelete());
		table.getColumnModel().getColumn(table.getColumnCount() - 2)
				.setCellRenderer(new ImageRendererEdit());
		table.setEnabled(false);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.getColumnModel().getColumn(table.getColumnCount() - 1)
				.setMaxWidth(40);
		table.getColumnModel().getColumn(table.getColumnCount() - 2)
				.setMaxWidth(40);
	}

	/**
	 * Create the frame.
	 */
	public RezultatiMecevaTabela(Turnir t, JFrame pf, GlavniProzor gp) {
		parentFrame = pf;
		gpf = gp;
		final Logger logger = Logger.getLogger(RezultatiMecevaUnos.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		t1 = t;
		btnNovaRunda.setEnabled(false);		
		Mec m = new Mec();
		MecDAO mdao = new MecDAO();
		if (!t1.getFormatTakmicenja().equals("Round Robin"))
		{
			btnNovaRunda.setEnabled(true);
		}
		
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				RezultatiMecevaTabela.class.getResource("/gui/logo.png")));
		setBounds(100, 100, 763, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setEditable(false);
		txtpnNazivTurnira.setText("Naziv turnira:");

		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(t1.getNaziv());
		textField.setEditable(false);
		JTextPane txtpnMeeviZaKoje = new JTextPane();
		txtpnMeeviZaKoje.setEditable(false);
		txtpnMeeviZaKoje.setText("Me\u010Devi turnira:");
		JPanel panel = new JPanel();
		table.setModel(jtutil.populateJTableMecevi(t1));
		PrepareTableDesign(table);
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(new JScrollPane(table), BorderLayout.CENTER);

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int col = table.columnAtPoint(evt.getPoint());
				if (row >= 0 && (col == table.getColumnCount() - 1 || col == table.getColumnCount() - 2)) {
					Mec m = new Mec();
					MecDAO mdao = new MecDAO();
					m = mdao.loadById(Mec.class, (Long) table.getModel().getValueAt(row, 0));
					if(col == table.getColumnCount() - 2)
					{
						JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField);
						parentFrame.setEnabled(false);
						RezultatiMecevaUnos rmu = new RezultatiMecevaUnos(t1, m, parentFrame, (RezultatiMecevaTabela) parentFrame);
						rmu.setVisible(true);
					}
					else if(col == table.getColumnCount() - 1)
					{
						String[] options = {"   Da!   ", "   Ne!   "};
						int confirmationResult = JOptionPane.showOptionDialog(null,
							    "Jeste li sigurni da želite obrisati ovaj meè?",
							    "Potvrda brisanja",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE, null, options, null);
						if(confirmationResult == JOptionPane.YES_OPTION)
							{
								mdao.delete(m);
								((DefaultTableModel)table.getModel()).removeRow(row);
							}
					}
				}
			}
		});
		
		
		
		btnNovaRunda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					final Logger logger = Logger.getLogger(TurnirDAO.class);
					TurnirDAO tdao = new TurnirDAO();
					List <Takmicar> takmicari = new ArrayList<Takmicar>();
					takmicari = tdao.getAllContestants(t1.getId());
					TakmicarDAO takdao = new TakmicarDAO();
		 	 		if(t1.getFormatTakmicenja().equals("Jednostruki eliminacioni"))
					{
			 	 		System.out.println("UŠAO");
			 	 		System.out.println(takmicari.size());
						for (int i =0; i< takmicari.size(); i++)
						{
							if (takdao.throwOut(takmicari.get(i).getId(), t1.getId()))
							{
								takmicari.remove(i);
								i--;
							}
						}
						if(takmicari.size() == 1)
						{
							btnNovaRunda.setEnabled(false);
						}
						JednostrukaEliminacija je = new JednostrukaEliminacija();
						List<Mec> mecevi = new ArrayList<Mec>();
						MecDAO mdao = new MecDAO();
						try 
						{
							mecevi = je.GenerisiRundu( takmicari , t1, false);
							for (int i = 0; i < mecevi.size(); i++)
							{
					 	 		System.out.println("UŠAO");
								mdao.create(mecevi.get(i));
							}
						} 
						catch (Exception e1) 
						{
							logger.error("Došlo je do greške!", e1);
						}
					}
/*					else if(t1.getFormatTakmicenja().equals("Dvostruka eliminacija"))
					{
						
					}
*/					else if (t1.getFormatTakmicenja().equals("Swiss"))
					{
						System.out.println("UŠAO");
						swiss++;
						if(swiss == takmicari.size()-1)
						{
	//						btnNova
						}
						System.out.println(takmicari.size());
						Swiss s = new Swiss();
						List<Mec> mecevi = new ArrayList<Mec>();
						MecDAO mdao = new MecDAO();
						try 
						{
							mecevi = s.GenerisiMeceve(takmicari, t1);
							for (int i = 0; i < mecevi.size(); i++)
							{
					 	 		System.out.println("UŠAO");
								mdao.create(mecevi.get(i));
							}
							
						} 
						catch (Exception e1) 
						{
							logger.error("Došlo je do greške!", e1);
						}
					}
				}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
						.addComponent(txtpnMeeviZaKoje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
							.addComponent(btnNovaRunda)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(txtpnMeeviZaKoje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNovaRunda)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
					.addContainerGap())
		);

		// JTableUtil jtutil = new JTableUtil();
		// table.setModel(jtutil.populateJTableMecevi(t));
		// PrepareTableDesign(table);
		// panel_3.setLayout(new BorderLayout());
		// panel_3.add(table.getTableHeader(), BorderLayout.NORTH);
		// panel_3.add(new JScrollPane(table), BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
	}
}
