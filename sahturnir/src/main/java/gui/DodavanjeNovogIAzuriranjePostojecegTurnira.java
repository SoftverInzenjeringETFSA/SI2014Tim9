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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DodavanjeNovogIAzuriranjePostojecegTurnira extends JFrame {
	private JTextField textField;
	protected final JTextPane textPane;

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
	
	public static Boolean validirajPrazno(JTextField t1, JTextPane t2) {
		Boolean izlaz = false;
		String a = t1.getText();
		
		if(a.isEmpty()) 
			t2.setText("Polje ne smije biti prazno");
		else
			izlaz = true;
		
		return izlaz;
	}
	
	public static Boolean validirajAlphaNum(JTextField t1, JTextPane t2) {
		Boolean izlaz = false;
		String pattern = "^[a-zA-Z0-9 ]*";
		String a = t1.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(a);
		
		if(!(m.matches())) {
			t2.setText("Neispravni karakteri");
		}
		else
			izlaz = true;
		
		return izlaz;
    }

	/**
	 * Create the frame.
	 */
	public DodavanjeNovogIAzuriranjePostojecegTurnira() {
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeNovogIAzuriranjePostojecegTurnira.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 484);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o turniru", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnNaziv = new JTextPane();
		txtpnNaziv.setEditable(false);
		txtpnNaziv.setBackground(Color.WHITE);
		txtpnNaziv.setText("Naziv:*");
		
		JTextPane txtpnFormatTakmienja = new JTextPane();
		txtpnFormatTakmienja.setEditable(false);
		txtpnFormatTakmienja.setText("Format takmi\u010Denja:*");
		txtpnFormatTakmienja.setBackground(Color.WHITE);
		
		JTextPane txtpnBrojTakmiara = new JTextPane();
		txtpnBrojTakmiara.setEditable(false);
		txtpnBrojTakmiara.setText("Broj takmi\u010Dara:*");
		txtpnBrojTakmiara.setBackground(Color.WHITE);
		
		JTextPane txtpnTrajanjeuDanima = new JTextPane();
		txtpnTrajanjeuDanima.setEditable(false);
		txtpnTrajanjeuDanima.setText("Trajanje (u danima):*");
		txtpnTrajanjeuDanima.setBackground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jednostruki eliminacioni", "Dvostruki eliminacioni", "Round Robin", "Swiss"}));
		
		textPane = new JTextPane();
		textPane.setForeground(Color.RED);
		textPane.setBackground(Color.WHITE);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.RED);
		textPane_1.setBackground(Color.WHITE);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setForeground(Color.RED);
		textPane_2.setBackground(Color.WHITE);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(4, 4, 32, 4));
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
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
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textPane_2, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addGap(21))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnTrajanjeuDanima, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addGap(64))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(72, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox, 0, 171, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(77, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addGap(21))))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtpnTrajanjeuDanima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "U\u010Desnici turnira", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				if(validirajPrazno(textField, textPane))
					textPane.setText("");
				if(validirajPrazno(textField, textPane))
					if(validirajAlphaNum(textField, textPane))
						textPane.setText("");
			}			
		}
			);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(720, Short.MAX_VALUE)
							.addComponent(btnPotvrdi)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPotvrdi)
					.addGap(14))
		);
		
		JButton button = new JButton(">");
		
		JButton button_1 = new JButton("<");
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JList list_1 = new JList<Object>();
		
		JList<?> list_2 = new JList();
		list_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Takmi\u010Dari u\u010Desnici", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		list_2.setBackground(SystemColor.control);
		
		JList list = new JList<Object>();
		list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Svi takmi\u010Dari", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		list.setBackground(SystemColor.control);
		
		JCheckBox chckbxAutomatskiGeneriiParove = new JCheckBox("Automatski generi\u0161i parove");
		chckbxAutomatskiGeneriiParove.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxAutomatskiGeneriiParove, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
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
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(66)
							.addComponent(list_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(list_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
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
