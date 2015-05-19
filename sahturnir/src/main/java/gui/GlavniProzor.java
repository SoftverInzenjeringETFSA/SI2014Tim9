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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import utils.JTableUtil;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GlavniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnahovskiKlubPijun;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel = new JPanel();
	private JPanel panel_7 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_8 = new JPanel();
	JTable table = new JTable();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setBackground(Color.WHITE);
		setTitle("\u0160ahovski klub Pijun - Glavni prozor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				GlavniProzor.class.getResource("/gui/Screenshot_2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/Screenshot_2.png")));

		txtpnahovskiKlubPijun = new JTextPane();
		txtpnahovskiKlubPijun.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnahovskiKlubPijun.setText("\u0160AHOVSKI KLUB PIJUN");

		JLabel label = new JLabel("");

		JLabel label_1 = new JLabel("");

		JLabel label_5 = new JLabel("");
		label_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_5.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/odjava1.jpg")));

		JLabel label_6 = new JLabel("");
		label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_6.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/postavke.png")));
		
		JTableUtil jtutil = new JTableUtil();
		table = jtutil.populateJTableKlubovi();
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
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
		TableColumn sportColumn = table.getColumnModel().getColumn(5);
		JComboBox comboBoxs = new JComboBox();
		comboBoxs.addItem("Snowboarding");
		comboBoxs.addItem("Rowing");
		comboBoxs.addItem("Chasing toddlers");
		comboBoxs.addItem("Speed reading");
		comboBoxs.addItem("Teaching high school");
		comboBoxs.addItem("None");
		comboBoxs.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String petName = (String)cb.getSelectedItem();
		        table.setValueAt("loooooooooool", 5, 5);
		    }
		});
		sportColumn.setCellEditor(new DefaultCellEditor(comboBoxs));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Korisnici", null, panel_3, null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/plusic.jpg")));

		panel_2.setLayout(new BorderLayout());
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel_3.createSequentialGroup()
								.addContainerGap(741, Short.MAX_VALUE)
								.addComponent(label_2).addContainerGap())
				.addGroup(
						Alignment.LEADING,
						gl_panel_3
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_2,
										GroupLayout.DEFAULT_SIZE, 756,
										Short.MAX_VALUE).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_2)
						.addGap(35)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 222,
								Short.MAX_VALUE).addContainerGap()));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Takmièari", null, panel_1, null);

		JTextPane txtpnKriterijZaPretraivanje = new JTextPane();
		txtpnKriterijZaPretraivanje.setBackground(UIManager
				.getColor("Button.background"));
		txtpnKriterijZaPretraivanje.setText("Kriterij za pretra\u017Eivanje:");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Ime i prezime", "Datum ro\u0111enja", "Klub", "Broj bodova",
				"Kategorija" }));
		comboBox.setToolTipText("");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnPretrai = new JButton("Pretra\u017Ei");

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/plusic.jpg")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panel_7,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																756,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.LEADING,
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				comboBox,
																				GroupLayout.PREFERRED_SIZE,
																				146,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				textField,
																				GroupLayout.PREFERRED_SIZE,
																				133,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnPretrai))
														.addGroup(
																Alignment.LEADING,
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				txtpnKriterijZaPretraivanje,
																				GroupLayout.PREFERRED_SIZE,
																				130,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				601,
																				Short.MAX_VALUE)
																		.addComponent(
																				label_3)))
										.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(label_3)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				txtpnKriterijZaPretraivanje,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								comboBox,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnPretrai))))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(panel_7,
												GroupLayout.DEFAULT_SIZE, 222,
												Short.MAX_VALUE)
										.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Klubovi", null, panel_4, null);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_4
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 756,
								Short.MAX_VALUE).addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_panel_4
						.createSequentialGroup()
						.addGap(71)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 222,
								Short.MAX_VALUE).addContainerGap()));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Turniri", null, panel_5, null);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/plusic.jpg")));

		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(741, Short.MAX_VALUE)
					.addComponent(label_8)
					.addContainerGap())
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8)
					.addGap(35)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Izvještaji", null, panel_6, null);

		JButton btnNewButton = new JButton(
				"Izvje\u0161taj o podacima takmi\u010Dara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnIzvjetajOPodacima = new JButton(
				"Izvje\u0161taj o podacima klubova");
		btnIzvjetajOPodacima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnIzvjetajZaJedan = new JButton(
				"Izvje\u0161taj za jedan takmi\u010Darski dan");

		JButton btnIzvjetajORasporedu = new JButton(
				"Izvje\u0161taj o rasporedu i satnici turnira\r\n");

		JButton btnIzvjetajORang = new JButton(
				"Izvje\u0161taj o rang listi takmi\u010Dara");

		JButton btnIzvjetajORang_1 = new JButton(
				"Izvje\u0161taj o rang listi klubova");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6
				.setHorizontalGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
										.addGap(18)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																btnNewButton,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																btnIzvjetajORasporedu,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(18)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				btnIzvjetajOPodacima,
																				GroupLayout.PREFERRED_SIZE,
																				181,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnIzvjetajZaJedan))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				btnIzvjetajORang,
																				GroupLayout.PREFERRED_SIZE,
																				181,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnIzvjetajORang_1,
																				GroupLayout.DEFAULT_SIZE,
																				196,
																				Short.MAX_VALUE)))
										.addContainerGap()));
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
																GroupLayout.PREFERRED_SIZE,
																50,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnIzvjetajOPodacima,
																GroupLayout.PREFERRED_SIZE,
																50,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnIzvjetajZaJedan,
																GroupLayout.PREFERRED_SIZE,
																50,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(36)
																		.addGroup(
																				gl_panel_6
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnIzvjetajORang,
																								GroupLayout.PREFERRED_SIZE,
																								50,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnIzvjetajORasporedu,
																								GroupLayout.PREFERRED_SIZE,
																								52,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(35)
																		.addComponent(
																				btnIzvjetajORang_1,
																				GroupLayout.PREFERRED_SIZE,
																				50,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(74, Short.MAX_VALUE)));
		panel_6.setLayout(gl_panel_6);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(10)
										.addComponent(lblNewLabel)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				txtpnahovskiKlubPijun,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				399,
																				Short.MAX_VALUE)
																		.addComponent(
																				label))
														.addComponent(label_6))
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(13)
																		.addComponent(
																				label_1))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				label_5)))
										.addGap(5))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(tabbedPane,
												GroupLayout.DEFAULT_SIZE, 781,
												Short.MAX_VALUE)
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(11)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(47)
																										.addComponent(
																												label_1))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(23)
																										.addComponent(
																												txtpnahovskiKlubPijun,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								lblNewLabel)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(8)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								label_5)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												label_6)
																										.addGap(11)
																										.addComponent(
																												label)))))
										.addGap(18).addComponent(tabbedPane)
										.addContainerGap()));
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
				.getResource("/gui/plusic.jpg")));
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
