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
import java.awt.Font;
import java.awt.Component;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtpnahovskiKlubPijun;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/gui/Screenshot_2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/Screenshot_2.png")));
		
		txtpnahovskiKlubPijun = new JTextPane();
		txtpnahovskiKlubPijun.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnahovskiKlubPijun.setText("\u0160AHOVSKI KLUB PIJUN");
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel label_5 = new JLabel("");
		label_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_5.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/odjava1.jpg")));
		
		JLabel label_6 = new JLabel("");
		label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_6.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/postavke.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(txtpnahovskiKlubPijun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_6)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_5)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 657, Short.MAX_VALUE)
					.addGap(68))
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
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(23)
									.addComponent(txtpnahovskiKlubPijun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_6)
									.addGap(11)
									.addComponent(label)))))
					.addGap(43)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addContainerGap())
		);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{295, 63, 0};
		gbl_panel.rowHeights = new int[]{22, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.anchor = GridBagConstraints.NORTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Poèetna", null, panel_2, null);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/headerDefault.jpg")));
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Korisnici", null, panel_3, null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/plusic.jpg")));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(615, Short.MAX_VALUE)
					.addComponent(label_2)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Takmièari", null, panel_1, null);
		
		JTextPane txtpnKriterijZaPretraivanje = new JTextPane();
		txtpnKriterijZaPretraivanje.setBackground(UIManager.getColor("Button.background"));
		txtpnKriterijZaPretraivanje.setText("Kriterij za pretra\u017Eivanje:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ime i prezime", "Datum ro\u0111enja", "Klub", "Broj bodova", "Kategorija"}));
		comboBox.setToolTipText("");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnPretrai = new JButton("Pretra\u017Ei");
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/plusic.jpg")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnPretrai))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtpnKriterijZaPretraivanje, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 475, Short.MAX_VALUE)
							.addComponent(label_3)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtpnKriterijZaPretraivanje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPretrai))))
					.addContainerGap(203, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Klubovi", null, panel_4, null);
		
		JTextPane txtpnKriterijZaPretraivanje_1 = new JTextPane();
		txtpnKriterijZaPretraivanje_1.setBackground(UIManager.getColor("Button.background"));
		txtpnKriterijZaPretraivanje_1.setText("Kriterij za pretra\u017Eivanje:");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Naziv kluba", "Sjedi\u0161te kluba"}));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnPretrai_1 = new JButton("Pretra\u017Ei");
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/plusic.jpg")));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnPretrai_1))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(txtpnKriterijZaPretraivanje_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
							.addComponent(label_7)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(txtpnKriterijZaPretraivanje_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPretrai_1))))
					.addContainerGap(217, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Turniri", null, panel_5, null);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(GlavniProzor.class.getResource("/gui/plusic.jpg")));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap(594, Short.MAX_VALUE)
					.addComponent(label_8)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Izvještaji", null, panel_6, null);
		
		JButton btnNewButton = new JButton("Izvje\u0161taj o podacima takmi\u010Dara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		
		JButton btnIzvjetajOPodacima = new JButton("Izvje\u0161taj o podacima klubova");
		btnIzvjetajOPodacima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnIzvjetajZaJedan = new JButton("Izvje\u0161taj za jedan takmi\u010Darski dan");
		
		JButton btnIzvjetajORasporedu = new JButton("Izvje\u0161taj o rasporedu i satnici turnira\r\n");
		
		JButton btnIzvjetajORang = new JButton("Izvje\u0161taj o rang listi takmi\u010Dara");
		
		JButton btnIzvjetajORang_1 = new JButton("Izvje\u0161taj o rang listi klubova");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnIzvjetajORasporedu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(btnIzvjetajOPodacima, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnIzvjetajZaJedan))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(btnIzvjetajORang, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnIzvjetajORang_1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIzvjetajOPodacima, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIzvjetajZaJedan, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIzvjetajORang, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIzvjetajORasporedu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(35)
							.addComponent(btnIzvjetajORang_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
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
