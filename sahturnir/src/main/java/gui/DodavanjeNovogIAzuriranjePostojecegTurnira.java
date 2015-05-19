package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.CardLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeNovogIAzuriranjePostojecegTurnira extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeNovogIAzuriranjePostojecegTurnira frame = new DodavanjeNovogIAzuriranjePostojecegTurnira();
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
	public DodavanjeNovogIAzuriranjePostojecegTurnira() {
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeNovogIAzuriranjePostojecegTurnira.class.getResource("/gui/Screenshot_2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o turniru", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnNaziv = new JTextPane();
		txtpnNaziv.setBackground(UIManager.getColor("Button.background"));
		txtpnNaziv.setText("Naziv:*");
		
		JTextPane txtpnFormatTakmienja = new JTextPane();
		txtpnFormatTakmienja.setText("Format takmi\u010Denja:*");
		txtpnFormatTakmienja.setBackground(SystemColor.menu);
		
		JTextPane txtpnBrojTakmiara = new JTextPane();
		txtpnBrojTakmiara.setText("Broj takmi\u010Dara:*");
		txtpnBrojTakmiara.setBackground(SystemColor.menu);
		
		JTextPane txtpnTrajanjeuDanima = new JTextPane();
		txtpnTrajanjeuDanima.setText("Trajanje (u danima):*");
		txtpnTrajanjeuDanima.setBackground(SystemColor.menu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jednostruki eliminacioni", "Dvostruki eliminacioni", "Round Robin", "Swiss"}));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		final JTextPane textPane = new JTextPane();
		textPane.setForeground(Color.RED);
		textPane.setBackground(UIManager.getColor("Button.background"));
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setForeground(Color.RED);
		textPane_1.setBackground(UIManager.getColor("Button.background"));
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setForeground(Color.RED);
		textPane_2.setBackground(UIManager.getColor("Button.background"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(150, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(77, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(comboBox, 0, 182, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(72, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnTrajanjeuDanima, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_2, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnTrajanjeuDanima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "U\u010Desnici turnira", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				String a = textField.getText();
				if (a.isEmpty()) textPane.setText("Morate unijeti naziv");
				
				String b = textField_1.getText();
				if (b.isEmpty()) textPane_1.setText("Morate unijeti broj");
				else {		
				
				for (int i=0; i<b.length(); i++)
				{
					char c = b.charAt(i);
					if (!((c >= '0') && (c <= '9') ))   
					         { textPane_1.setText("Mozete unijeti samo broj");}
				}
					}
				
				String d = textField_2.getText();
				if (d.isEmpty()) textPane_2.setText("Morate unijeti broj");
				else {		
				
				for (int i=0; i<d.length(); i++)
				{
					char c = d.charAt(i);
					if (!((c >= '0') && (c <= '9') ))   
					         { textPane_1.setText("Mozete unijeti samo broj");}
				}
					}
				
				
				
		}}
			);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(681, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addGap(49))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPotvrdi)
					.addGap(14))
		);
		
		JButton button = new JButton(">");
		
		JButton button_1 = new JButton("<");
		
		JLabel lblNewLabel = new JLabel("Svi takmi\u010Dari");
		
		JLabel lblNewLabel_1 = new JLabel("Takmi\u010Dari u\u010Desnici");
		
		JList list_1 = new JList<Object>();
		
		JList<?> list_2 = new JList();
		
		JList list = new JList<Object>();
		
		JCheckBox chckbxAutomatskiGeneriiParove = new JCheckBox("Automatski generi\u0161i parove");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addGap(37))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxAutomatskiGeneriiParove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(217))
						.addComponent(lblNewLabel_1))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(66)
							.addComponent(list_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(list_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button)
						.addComponent(chckbxAutomatskiGeneriiParove))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
