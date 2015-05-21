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
import java.util.Vector;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import utils.JTableUtil;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private JTextField textField_2;
	private JComboBox comboBox_2;
	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);		
			}
		});
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
				for(int i=0; i< win.length; i++) { 
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
				JFrame parentFrame = (JFrame) SwingUtilities.getRoot(e.getComponent());
				DodavanjeKorisnika frame = new DodavanjeKorisnika(parentFrame);
				frame.setVisible(true);
				parentFrame.setEnabled(false);
			}
		});
		label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_6.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/settings.png")));
		label_6.setToolTipText("Postavke korisnièkog raèuna");
		JTable sss = new JTable();
		
		sss.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		
		JTableUtil jtutil = new JTableUtil();
		table.setModel(jtutil.populateJTableKlubovi());
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
			
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer = ((DefaultTableCellRenderer) sss.getDefaultRenderer(Object.class));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.setEnabled(false);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col == table.getColumnCount() - 1) {
		            table.setValueAt(table.getModel().getValueAt(row, 0), row, col);
		        }
		    }
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Korisnici", null, panel_3, null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));

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
				.getResource("/gui/add.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnKriterijZaPretraivanje, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnPretrai)
							.addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
							.addComponent(label_3)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3)
							.addGap(13))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPretrai)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnKriterijZaPretraivanje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Klubovi", null, panel_4, null);
				
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		comboBox_2 = new JComboBox();
		comboBox_2.addItem("Naziv");
		comboBox_2.addItem("Sjedište");
		comboBox_2.addItem("Predsjednik");
		JButton button = new JButton("Pretra\u017Ei");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTableUtil jtutil2 = new JTableUtil();
					table.setModel(jtutil2.searchKlubovi(comboBox_2.getSelectedIndex(), textField_2.getText()));
					table.removeColumn(table.getColumnModel().getColumn(0));
			}
		});
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Kriterij za pretra\u017Eivanje:");
		textPane.setBackground(SystemColor.menu);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		this.getRootPane().setDefaultButton(button);
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Turniri", null, panel_5, null);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(GlavniProzor.class
				.getResource("/gui/add.png")));

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
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addComponent(btnIzvjetajORasporedu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnIzvjetajOPodacima, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
						.addComponent(btnIzvjetajORang, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(btnIzvjetajORang_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnIzvjetajZaJedan, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
					.addGap(27))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
						.addComponent(btnIzvjetajOPodacima, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
						.addComponent(btnIzvjetajZaJedan, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
					.addGap(50)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIzvjetajORang, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
						.addComponent(btnIzvjetajORang_1, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
						.addComponent(btnIzvjetajORasporedu, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
					.addGap(56))
		);
		panel_6.setLayout(gl_panel_6);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnahovskiKlubPijun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(label_6))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_5)))
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(47)
									.addComponent(label_1))
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_6)
									.addGap(11)
									.addComponent(label))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(txtpnahovskiKlubPijun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
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
