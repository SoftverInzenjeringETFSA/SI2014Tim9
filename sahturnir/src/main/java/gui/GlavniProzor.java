package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTabbedPane;

import java.awt.Insets;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import utils.JTableUtil;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import org.apache.log4j.Logger;

import dal.GenericDAO;
import dal.KlubDAO;
import dal.KorisnikDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;

import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import klase.Klub;
import klase.Korisnik;
import klase.Takmicar;
import klase.Turnir;

public class GlavniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnahovskiKlubPijun;
	private JTextField textField_1;
	private JPanel panel_3 = new JPanel(); 
	private JPanel panel_1 = new JPanel(); 
	private JPanel panel_9 = new JPanel();
	private JPanel panel_7 = new JPanel();
	JTable tableKorisnici = new JTable();
	JTable tableTakmicari = new JTable();
	JTable tableKlubovi = new JTable();
	JTable tableTurniri = new JTable();
	private transient JTableUtil jtutil = new JTableUtil();
	private JTextField textField_2;
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_2;
	private JTextField textField;
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JButton button_1 = new JButton("Pretra\u017Ei");
	private JButton button = new JButton("Pretra\u017Ei");
	private Korisnik korisnik;
	List<Takmicar> takmicari1 = TakmicarDAO.getAll(Takmicar.class);
	List<Turnir> turniri1 = TurnirDAO.getAll(Turnir.class);
	//takmicari1 = 
	/**
	 * Launch the application.
	 */

	public class ImageRendererDelete extends DefaultTableCellRenderer {
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
			tableLabel.setToolTipText("Ure�ivanje");
			tableLabel.setOpaque(true);
			Color c1 = new Color(0x67FD9A);
			Color c2 = new Color(0xC0C0C0);
			tableLabel.setBackground(row % 2 == 0 ? c1 : c2);
			tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return tableLabel;
		}
	}
	
	class ImageRendererMatch extends DefaultTableCellRenderer {
		JLabel tableLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/main/java/gui/match.png");
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			tableLabel.setText((String) value);
			tableLabel.setIcon(icon);
			tableLabel.setToolTipText("Upravljanje rezultatima me�eva");
			tableLabel.setOpaque(true);
			Color c1 = new Color(0x67FD9A);
			Color c2 = new Color(0xC0C0C0);
			tableLabel.setBackground(row % 2 == 0 ? c1 : c2);
			tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return tableLabel;
		}
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
		if(table.getName() == "tableTurniri")
			table.getColumnModel().getColumn(table.getColumnCount() - 3)
			.setCellRenderer(new ImageRendererMatch());	
		table.setEnabled(false);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.getColumnModel().getColumn(table.getColumnCount() - 1).setMaxWidth(40);
		table.getColumnModel().getColumn(table.getColumnCount() - 2).setMaxWidth(40);
		if(table.getName() == "tableTurniri")
			table.getColumnModel().getColumn(table.getColumnCount() - 3).setMaxWidth(40);	
	}

	/**
	 * Create the frame.
	 */
	public void RefreshTables()
	{
		tableKorisnici.setModel(jtutil.populateJTableKorisnici(korisnik));
		PrepareTableDesign(tableKorisnici);
		
		tableTakmicari.setModel(jtutil.populateJTableTakmicari());
		PrepareTableDesign(tableTakmicari);
		
		tableKlubovi.setModel(jtutil.populateJTableKlubovi());
		PrepareTableDesign(tableKlubovi);
		
		tableTurniri.setModel(jtutil.populateJTableTurniri());
		PrepareTableDesign(tableTurniri);
	}
	
	public GlavniProzor(Korisnik k) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		korisnik = k;
		setBackground(Color.WHITE);
		setTitle("\u0160ahovski klub Pijun - Glavni prozor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				GlavniProzor.class.getResource("/gui/logo.png")));
		setBounds(100, 100, 827, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/logo.png")));

		txtpnahovskiKlubPijun = new JTextPane();
		txtpnahovskiKlubPijun.setEditable(false);
		txtpnahovskiKlubPijun.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnahovskiKlubPijun.setText("\u0160AHOVSKI KLUB PIJUN");

		JLabel label = new JLabel("");

		JLabel label_1 = new JLabel("");

		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				java.awt.Window win[] = java.awt.Window.getWindows();
				for (int i = 0; i < win.length; i++) {
					win[i].dispose();
				}
				Prijava frame = new Prijava();
				frame.setVisible(true);
			}
		});
		label_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_5.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/sign_out.png")));
		label_5.setToolTipText("Odjava");
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				DodavanjeKorisnika dk = new DodavanjeKorisnika(korisnik, parentFrame, (GlavniProzor) parentFrame);
				dk.setVisible(true);
			}
		});
		label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_6.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/settings.png")));
		label_6.setToolTipText("Postavke korisni�kog ra�una");
		
		
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(tabbedPane.getSelectedIndex() == 1)
					getRootPane().setDefaultButton(button_1);
				else if(tabbedPane.getSelectedIndex() == 2)
					getRootPane().setDefaultButton(button);
				else
					getRootPane().setDefaultButton(null);
			}
		});

		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Korisnici", null, panel_2, null);
		
		JLabel label_2 = new JLabel("");
		label_2.setToolTipText("Dodavanje novog korisnika");
		label_2.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(arg0.getComponent());
				parentFrame.setEnabled(false);
				DodavanjeKorisnika dk = new DodavanjeKorisnika(parentFrame, (GlavniProzor) parentFrame);
				dk.setVisible(true);

				
			}
		});
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addComponent(label_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Takmi�ari", null, panel, null);
		
		comboBox.addItem("Ime i prezime");
		comboBox.addItem("JMBG");
		comboBox.addItem("Kategorija");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("Kriterij za pretra\u017Eivanje:");
		textPane_1.setBackground(SystemColor.menu);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));
		label_3.setToolTipText("Dodavanje novog takmi�ara");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				List<Klub> klubovi=GenericDAO.getAll(Klub.class);
				if(!klubovi.isEmpty()){
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				DodavanjeTakmicara dt = new DodavanjeTakmicara(parentFrame, (GlavniProzor) parentFrame);
				dt.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,
							"Nemogu�e dodati takmicara bez klubova u sistemu!", "Potvrda",
							JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 776, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableTakmicari.setModel(jtutil.searchTakmicari(
						comboBox.getSelectedIndex(), textField.getText()));
				PrepareTableDesign(tableTakmicari);
			}
		});
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 284, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Klubovi", null, panel_4, null);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		comboBox_2 = new JComboBox();
		comboBox_2.addItem("Naziv");
		comboBox_2.addItem("Sjedi�te");
		comboBox_2.addItem("Predsjednik");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableKlubovi.setModel(jtutil.searchKlubovi(
						comboBox_2.getSelectedIndex(), textField_2.getText()));
				PrepareTableDesign(tableKlubovi);
			}
		});

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Kriterij za pretra\u017Eivanje:");
		textPane.setBackground(SystemColor.menu);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));
		label_4.setToolTipText("Dodavanje novog kluba");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				DodavanjeKluba dk = new DodavanjeKluba(parentFrame, (GlavniProzor) parentFrame);
				dk.setVisible(true);
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button)))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Turniri", null, panel_5, null);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));
		label_8.setToolTipText("Dodavanje novog turnira");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				List<Takmicar> takmicari=GenericDAO.getAll(Takmicar.class);
				if(!takmicari.isEmpty()){
					JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
					parentFrame.setEnabled(false);
					DodavanjeNovogIAzuriranjePostojecegTurnira dt = new DodavanjeNovogIAzuriranjePostojecegTurnira(parentFrame, (GlavniProzor) parentFrame);
					dt.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,
							"Nemogu�e dodati turnir bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addComponent(label_8, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableKorisnici.setModel(jtutil.populateJTableKorisnici(korisnik));
		PrepareTableDesign(tableKorisnici);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(tableKorisnici.getTableHeader(), BorderLayout.NORTH);
		panel_3.add(new JScrollPane(tableKorisnici), BorderLayout.CENTER);
		tableKorisnici.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tableKorisnici.rowAtPoint(evt.getPoint());
				int col = tableKorisnici.columnAtPoint(evt.getPoint());
				if (row >= 0 && (col == tableKorisnici.getColumnCount() - 1 || col == tableKorisnici.getColumnCount() - 2)) {
					Korisnik k = new Korisnik();
					KorisnikDAO kdao = new KorisnikDAO();
					k = kdao.loadById(Korisnik.class, (Long) tableKorisnici.getModel().getValueAt(row, 0));
					if(col == tableKorisnici.getColumnCount() - 2)
					{
						JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
						parentFrame.setEnabled(false);
						DodavanjeKorisnika dk = new DodavanjeKorisnika(k, parentFrame, (GlavniProzor) parentFrame);
						dk.setVisible(true);
					}
					else if(col == tableKorisnici.getColumnCount() - 1)
					{
						String[] options = {"   Da!   ", "   Ne!   "};
						int confirmationResult = JOptionPane.showOptionDialog(null,
							    "Jeste li sigurni da �elite obrisati \"" + (String)tableKorisnici.getModel().getValueAt(row, 1) + "\"?",
							    "Potvrda brisanja",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE, null, options, null);
						if(confirmationResult == JOptionPane.YES_OPTION)
							{
								kdao.delete(k);
								((DefaultTableModel)tableKorisnici.getModel()).removeRow(row);
							}
					}
				}
			}
		});
		
		tableTakmicari.setModel(jtutil.populateJTableTakmicari());
		PrepareTableDesign(tableTakmicari);
		panel_1.setLayout(new BorderLayout());
		panel_1.add(tableTakmicari.getTableHeader(), BorderLayout.NORTH);
		panel_1.add(new JScrollPane(tableTakmicari), BorderLayout.CENTER);
		tableTakmicari.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tableTakmicari.rowAtPoint(evt.getPoint());
				int col = tableTakmicari.columnAtPoint(evt.getPoint());
				if (row >= 0 && (col == tableTakmicari.getColumnCount() - 1 || col == tableTakmicari.getColumnCount() - 2)) {
					Takmicar t = new Takmicar();
					TakmicarDAO tdao = new TakmicarDAO();
					t = tdao.loadById(Takmicar.class, (Long) tableTakmicari.getModel().getValueAt(row, 0));
					if(col == tableTakmicari.getColumnCount() - 2)
					{
						JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
						parentFrame.setEnabled(false);
						DodavanjeTakmicara dt = new DodavanjeTakmicara(t, parentFrame, (GlavniProzor) parentFrame);
						dt.setVisible(true);
					}
					else if(col == tableTakmicari.getColumnCount() - 1)
					{
						String[] options = {"   Da!   ", "   Ne!   "};
						int confirmationResult = JOptionPane.showOptionDialog(null,
							    "Jeste li sigurni da �elite obrisati \"" + (String)tableTakmicari.getModel().getValueAt(row, 1) + "\"?",
							    "Potvrda brisanja",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE, null, options, null);
						if(confirmationResult == JOptionPane.YES_OPTION)
							{
								tdao.delete(t);
								((DefaultTableModel)tableTakmicari.getModel()).removeRow(row);
							}
					}
				}
			}
		});
		
		tableKlubovi.setModel(jtutil.populateJTableKlubovi());
		PrepareTableDesign(tableKlubovi);
		panel_9.setLayout(new BorderLayout());
		panel_9.add(tableKlubovi.getTableHeader(), BorderLayout.NORTH);
		panel_9.add(new JScrollPane(tableKlubovi), BorderLayout.CENTER);
		tableKlubovi.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tableKlubovi.rowAtPoint(evt.getPoint());
				int col = tableKlubovi.columnAtPoint(evt.getPoint());
				if (row >= 0 && (col == tableKlubovi.getColumnCount() - 1 || col == tableKlubovi.getColumnCount() - 2)) {
					Klub k = new Klub();
					KlubDAO kdao = new KlubDAO();
					k = kdao.loadById(Klub.class, (Long) tableKlubovi.getModel().getValueAt(row, 0));
					if(col == tableKlubovi.getColumnCount() - 2)
					{
						JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
						parentFrame.setEnabled(false);
						DodavanjeKluba dk = new DodavanjeKluba(k, parentFrame, (GlavniProzor) parentFrame);
						dk.setVisible(true);
					}
					else if(col == tableKlubovi.getColumnCount() - 1)
					{
						String[] options = {"   Da!   ", "   Ne!   "};
						int confirmationResult = JOptionPane.showOptionDialog(null,
							    "Jeste li sigurni da �elite obrisati \"" + (String)tableKlubovi.getModel().getValueAt(row, 1) + "\"?",
							    "Potvrda brisanja",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE, null, options, null);
						if(confirmationResult == JOptionPane.YES_OPTION)
							{
								kdao.delete(k);
								((DefaultTableModel)tableKlubovi.getModel()).removeRow(row);
							}
					}
				}
			}
		});
		
		tableTurniri.setModel(jtutil.populateJTableTurniri());
		tableTurniri.setName("tableTurniri");
		PrepareTableDesign(tableTurniri);
		panel_7.setLayout(new BorderLayout());
		panel_7.add(tableTurniri.getTableHeader(), BorderLayout.NORTH);
		panel_7.add(new JScrollPane(tableTurniri), BorderLayout.CENTER);
		tableTurniri.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tableTurniri.rowAtPoint(evt.getPoint());
				int col = tableTurniri.columnAtPoint(evt.getPoint());
				if (row >= 0 && (col == tableTurniri.getColumnCount() - 1 || col == tableTurniri.getColumnCount() - 2 || col == tableTurniri.getColumnCount() - 3)) {
					Turnir t = new Turnir();
					TurnirDAO tdao = new TurnirDAO();
					t = tdao.loadById(Turnir.class, (Long) tableTurniri.getModel().getValueAt(row, 0));
					if(col == tableTurniri.getColumnCount() - 3)
					{
						JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
						parentFrame.setEnabled(false);
						RezultatiMecevaTabela rmt = new RezultatiMecevaTabela(t, parentFrame, (GlavniProzor) parentFrame);
						rmt.setVisible(true);
					}
					else if(col == tableTurniri.getColumnCount() - 2)
					{
						JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
						parentFrame.setEnabled(false);
						DodavanjeNovogIAzuriranjePostojecegTurnira dt = new DodavanjeNovogIAzuriranjePostojecegTurnira(t, parentFrame, (GlavniProzor) parentFrame);
						dt.setVisible(true);
					}
					else if(col == tableTurniri.getColumnCount() - 1)
					{
						String[] options = {"   Da!   ", "   Ne!   "};
						int confirmationResult = JOptionPane.showOptionDialog(null,
							    "Jeste li sigurni da �elite obrisati \"" + (String)tableTurniri.getModel().getValueAt(row, 1) + "\"?",
							    "Potvrda brisanja",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE, null, options, null);
						if(confirmationResult == JOptionPane.YES_OPTION)
							{
								tdao.delete(t);
								((DefaultTableModel)tableTurniri.getModel()).removeRow(row);
							}
					}
				}
			}
		});
		
		panel_5.setLayout(gl_panel_5);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Izvje�taji", null, panel_6, null);

		JButton btnNewButton = new JButton(
				"Izvje\u0161taj o podacima takmi\u010Dara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				////
				/*List<Takmicar> takmicari1 = new ArrayList<Takmicar>();
				takmicari1 = TakmicarDAO.getAll(Takmicar.class);*/
				if(takmicari1.isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Nemogu�e pokrenuti izvje�taj bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				IzvjestajOPodacimaTakmicara rep = new IzvjestajOPodacimaTakmicara(parentFrame);
				rep.setVisible(true);
				}
			}
		});

		JButton btnIzvjetajOPodacima = new JButton(
				"Izvje\u0161taj o podacima klubova");
		btnIzvjetajOPodacima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////
				List<Klub> klubovi = new ArrayList<Klub>();
				klubovi = TakmicarDAO.getAll(Klub.class);
				if(klubovi.isEmpty()||takmicari1.isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Nemogu�e pokrenuti izvje�taj bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				IzvjestajOPodacimaKlubova rep = new IzvjestajOPodacimaKlubova(parentFrame);
				rep.setVisible(true);
				}
			}
		});

		JButton btnIzvjetajZaJedan = new JButton(
				"Izvje\u0161taj za jedan takmi\u010Darski dan");
		btnIzvjetajZaJedan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(takmicari1.isEmpty()||turniri1.isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Nemogu�e pokrenuti izvje�taj bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				IzvjestajRezultataZaJedanTakmicarskiDan rep = new IzvjestajRezultataZaJedanTakmicarskiDan(parentFrame);
				rep.setVisible(true);}
			}
		});

		JButton btnIzvjetajORasporedu = new JButton(
				"Izvje\u0161taj o rasporedu i satnici turnira\r\n");
		btnIzvjetajORasporedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(takmicari1.isEmpty()||turniri1.isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Nemogu�e pokrenuti izvje�taj bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				IzvjestajORasporeduISatniciTurnira rep = new IzvjestajORasporeduISatniciTurnira(parentFrame);
				rep.setVisible(true);}
			}
		});

		JButton btnIzvjetajORang = new JButton(
				"Izvje\u0161taj o rang listi takmi\u010Dara");
		btnIzvjetajORang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(takmicari1.isEmpty()||turniri1.isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Nemogu�e pokrenuti izvje�taj bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				IzvjestajORangListiTakmicara rep = new IzvjestajORangListiTakmicara(parentFrame);
				rep.setVisible(true);}
			}
		});

		JButton btnIzvjetajORang_1 = new JButton(
				"Izvje\u0161taj o rang listi klubova");
		btnIzvjetajORang_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(takmicari1.isEmpty()||turniri1.isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Nemogu�e pokrenuti izvje�taj bez takmi�ara u sistemu!", "Gre�ka",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(textField_2);
				parentFrame.setEnabled(false);
				IzvjestajORangListiKlubova rep = new IzvjestajORangListiKlubova(parentFrame);
				rep.setVisible(true);}
			}
		});
		
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6
				.setHorizontalGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
										.addGap(31)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																btnNewButton,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																212,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajORasporedu,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																212,
																Short.MAX_VALUE))
										.addGap(26)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																btnIzvjetajOPodacima,
																GroupLayout.DEFAULT_SIZE,
																229,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajORang,
																GroupLayout.DEFAULT_SIZE,
																229,
																Short.MAX_VALUE))
										.addGap(26)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnIzvjetajORang_1,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajZaJedan,
																GroupLayout.DEFAULT_SIZE,
																225,
																Short.MAX_VALUE))
										.addGap(27)));
		gl_panel_6
				.setVerticalGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
										.addGap(51)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton,
																GroupLayout.DEFAULT_SIZE,
																63,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajOPodacima,
																GroupLayout.DEFAULT_SIZE,
																63,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajZaJedan,
																GroupLayout.DEFAULT_SIZE,
																63,
																Short.MAX_VALUE))
										.addGap(50)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnIzvjetajORang,
																GroupLayout.DEFAULT_SIZE,
																64,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajORang_1,
																GroupLayout.DEFAULT_SIZE,
																64,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajORasporedu,
																GroupLayout.DEFAULT_SIZE,
																64,
																Short.MAX_VALUE))
										.addGap(56)));
		panel_6.setLayout(gl_panel_6);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,
					    "Jeste li pro�itali uputstvo za kori�tenje? \n\n Za odjavu sa aplikacije pritinuti krajnje desno dugme! \n\n Za pode�avanje korisni�kog ra�una pritisnuti srednje dugme! \n\n Za sve ostale akcije u aplikaciji pratiti obavje�tenja dobivena od aplikacije.",
					    "Info",
					    JOptionPane.INFORMATION_MESSAGE, null); 
			}
		});
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/1433135200_info.png")));
		label_9.setToolTipText("Pomo�");
		label_9.setAlignmentX(0.5f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtpnahovskiKlubPijun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
									.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_6)
									.addGap(12))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap(754, Short.MAX_VALUE)
									.addComponent(label)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_5)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(47)
									.addComponent(label_1))
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(txtpnahovskiKlubPijun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addComponent(label_6)
								.addComponent(label_9, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(label)))
					.addGap(21)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addGap(6))
		);
		JTextPane txtpnKriterijZaPretraivanje_1 = new JTextPane();
		txtpnKriterijZaPretraivanje_1.setBackground(UIManager
				.getColor("Button.background"));
		txtpnKriterijZaPretraivanje_1
				.setText("Kriterij za pretra\u017Eivanje:");

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
				"Naziv kluba", "Sjedi\u0161te kluba" }));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnPretrai_1 = new JButton("Pretra\u017Ei");
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));
		contentPane.setLayout(gl_contentPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
