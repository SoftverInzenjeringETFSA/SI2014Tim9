package gui;

import formatiturnira.Swiss;
import formatiturnira.RoundRobin;
import formatiturnira.DvostrukaEliminacija;
import formatiturnira.JednostrukaEliminacija;
import klase.Takmicar;

import java.awt.BorderLayout;
import java.awt.Component;
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

import javax.swing.DefaultListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import klase.Klub;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;
import dal.GenericDAO;
import dal.KlubDAO;
import dal.MecDAO;
import dal.TurnirDAO;
import dal.TakmicarDAO;
import formatiturnira.JednostrukaEliminacija;

public class DodavanjeNovogIAzuriranjePostojecegTurnira extends JFrame {
	private JTextField textField;
	protected final JTextPane textPane;
	private JComboBox comboBox = new JComboBox();
	private JSpinner spinner_1 = new JSpinner();
	private JSpinner spinner_2 = new JSpinner();
	private JList<String> list_2;
	private JList<String> list;
	DefaultListModel<String> prvaLista = new DefaultListModel<String>();
	DefaultListModel<String> drugaLista = new DefaultListModel<String>();
	transient List<Takmicar> t1 = new ArrayList<Takmicar>();
	transient List<Takmicar> t2 = new ArrayList<Takmicar>();
	Turnir turnir = new Turnir();
	private JTextField textField_1;
	private JFrame parentFrame;
	private GlavniProzor gpf;
	private JTextField textField_2;

	// private JList list;
	/**
	 * Launch the application.
	 */

	public static Boolean validirajPrazno(String t1) {
		Boolean izlaz = false;

		if (t1.isEmpty() || t1.trim().length() == 0)
			izlaz = false;
		else
			izlaz = true;

		return izlaz;
	}

	public static Boolean validirajAlpha(String t1) {
    	if (t1.length() > 50) return false;
		String[] niz = t1.split(" ");
		
		for (int i = 0; i<niz.length; i++) {
			String dio = niz[i];
			String[] patt = dio.split("-");
			for (int j= 0; j<patt.length; j++) {
				if (!patt[j].equals("di") && !patt[j].equals("I") &&
						!patt[j].equals("II") && !patt[j].equals("III") &&
						!patt[j].equals("IV") && !patt[j].equals("V")) {
					Pattern pattern = Pattern.compile("^[A-Z|�|�|�|�|�]{1}[a-z|�|�|�|�|�]{2,}$");
					Matcher matcher = pattern.matcher(patt[j]);
					Boolean istina =  matcher.matches();
					if (!istina) return false;
				}
			}
		}
		return true;
	}

	public static Boolean validirajAlphaNum(String t1) {
    	if (t1.length() > 50) return false;
		String[] niz = t1.split(" ");
		
		for (int i = 0; i<niz.length; i++) {
			String dio = niz[i];
			String[] patt = dio.split("-");
			for (int j= 0; j<patt.length; j++) {
				if (!patt[j].equals("di") && !patt[j].equals("I") &&
						!patt[j].equals("II") && !patt[j].equals("III") &&
						!patt[j].equals("IV") && !patt[j].equals("V")) {
					Pattern pattern = Pattern.compile("^[A-Z0-9|�|�|�|�|�]{1}[a-z0-9|�|�|�|�|�]{2,}$");
					Matcher matcher = pattern.matcher(patt[j]);
					Boolean istina =  matcher.matches();
					if (!istina) return false;
				}
			}
		}
		return true;
	}

	public static Boolean validirajBrojTakmicara(String tip, int spinner) {
		if (tip == "Jednostruki eliminacioni" || tip == "Dvostruki eliminacioni")
			if (spinner != 4 && spinner != 8 && spinner != 16 && spinner != 32)
				return false;
		if (spinner < 4)
			return false;
		return true;
	}

	/**
	 * Create the frame.
	 */
	public DodavanjeNovogIAzuriranjePostojecegTurnira(JFrame pf, GlavniProzor gp) {
		parentFrame = pf;
		gpf = gp;
		final Logger logger = Logger.getLogger(DodavanjeNovogIAzuriranjePostojecegTurnira.class);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		setResizable(false);
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DodavanjeNovogIAzuriranjePostojecegTurnira.class
						.getResource("/gui/logo.png")));
		setBounds(100, 100, 860, 463);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o turniru",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(turnir.getNaziv());

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

		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Jednostruki eliminacioni", "Dvostruki eliminacioni",
				"Round Robin", "Swiss" }));

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.RED);
		textPane.setBackground(Color.WHITE);

		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.RED);
		textPane_1.setBackground(Color.WHITE);

		spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));

		spinner_2.setModel(new SpinnerDateModel(new Date(1432504800000L), new Date(1432504800000L), null, Calendar.DAY_OF_YEAR));

		JTextPane txtpnDatumPoetkaTurnira = new JTextPane();
		txtpnDatumPoetkaTurnira.setText("Datum po\u010Detka turnira:*");
		txtpnDatumPoetkaTurnira.setEditable(false);
		txtpnDatumPoetkaTurnira.setBackground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("0");
		textField_1.setColumns(10);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(182, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(104, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox, 0, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnTrajanjeuDanima, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(txtpnDatumPoetkaTurnira, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(spinner_2, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
								.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addGap(21))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnDatumPoetkaTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnTrajanjeuDanima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "U\u010Desnici turnira",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List<Takmicar> t = new ArrayList<Takmicar>();
		TakmicarDAO tdao = new TakmicarDAO();

		t = tdao.getAll(Takmicar.class);
		t1 = tdao.getAll(Takmicar.class);

		String[] red = new String[t.size()];
		for (int i = 0; i < t.size(); i++) {
			// red[i]=t.get(i).getIme()+" "+t.get(i).getPrezime();
			prvaLista.addElement(t.get(i).getIme() + " "
					+ t.get(i).getPrezime());
		}

		list = new JList<String>(prvaLista);
		list_2 = new JList<String>(drugaLista);

		// list.setModel((ListModel) t);
		// list.add(t.get(i).getIme() + " " + t.get(i).getPrezime(), t.get(i));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Logger logger = Logger
						.getLogger(DodavanjeNovogIAzuriranjePostojecegTurnira.class);
				List<Mec> m = new ArrayList<Mec>();

				textPane.setText("");
				boolean flag = false;

				if (validirajPrazno(textField.getText())) {
					textPane.setText("");
				} else {
					textPane.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if (validirajPrazno(textField.getText())) {
					if (validirajAlphaNum(textField.getText())) {
						textPane.setText("");
					}
				}
				if (validirajPrazno(textField.getText())) {
					if (!validirajAlphaNum(textField.getText())) {
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if (validirajBrojTakmicara((String) comboBox.getSelectedItem(), Integer.parseInt(textField_1.getText()))) {
					textPane_1.setText("");
				} else {
					flag = true;
					textPane_1.setText("Broj takmi�ara nije ispravan");
				}

				if (!flag) {
					Turnir t = new Turnir();
					TurnirDAO tdao = new TurnirDAO();
					t.setNaziv(textField.getText());
					t.setFormatTakmicenja(comboBox.getSelectedItem().toString());
					t.setTrajanje((Integer) spinner_1.getValue());
					t.setDatumPocetka((Date) spinner_2.getValue());
					tdao.create(t);

					textField.setText("");
					textPane.setText("");
					if (comboBox.getSelectedItem().toString()
							.equals("Jednostruki eliminacioni")) {
						JednostrukaEliminacija j = new JednostrukaEliminacija();
						try {
							m = j.GenerisiRundu(t2, t, true);
						} catch (Exception ex) {
							logger.error("Do�lo je do gre�ke!", ex);
						}
					} else if (comboBox.getSelectedItem().toString()
							.equals("Dvostruki eliminacioni")) {
						DvostrukaEliminacija j = new DvostrukaEliminacija();
						try {
							m = j.GenerisiPrvuRundu(t2, t, true);
						} catch (Exception ex) {
							logger.error("Do�lo je do gre�ke!", ex);
						}
					} else if (comboBox.getSelectedItem().toString()
							.equals("Round Robin")) {
						RoundRobin j = new RoundRobin();
						try {
							m = j.RoundRobinGenerator(t2, t);
						} catch (Exception ex) {
							logger.error("Do�lo je do gre�ke!", ex);
						}
					} else {
						Swiss j = new Swiss();
						try {
							m = j.GenerisiMeceve(t2, t);
						} catch (Exception ex) {
							logger.error("Do�lo je do gre�ke!", ex);
						}
					}
					MecDAO mdao = new MecDAO();
					for (int i = 0; i < m.size(); i++) {
						mdao.create(m.get(i));
					}
					for (int i = 0; i < t2.size(); i++)
						tdao.prepareContestants(t.getId(), t2.get(i).getId());
					JOptionPane.showMessageDialog(null,
							"Uspje�no ste kreirali turnir!", "OK",
							JOptionPane.INFORMATION_MESSAGE);
					JFrame thisFrame = (JFrame) SwingUtilities
							.getRoot(textField_1);
					thisFrame.dispose();
					parentFrame.setEnabled(true);
					gpf.RefreshTables();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPotvrdi))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPotvrdi)
					.addGap(8))
		);
		JButton button = new JButton(">");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() != null) {
					int broj = 0;
					for (int i = 0; i < t1.size(); i++) {
						if (list.getSelectedValue()
								.toString()
								.equals(t1.get(i).getIme() + " "
										+ t1.get(i).getPrezime())) {
							broj = i;
						}
					}
					t2.add(t1.get(broj));
					t1.remove(broj);
					textField_1.setText(String.valueOf(t2.size()));
					drugaLista.addElement(list.getSelectedValue().toString());
					prvaLista.removeElement(list.getSelectedValue());
				}
			}
		});

		JButton button_1 = new JButton("<");

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list_2.getSelectedValue() != null) {
					int broj = 0;
					for (int i = 0; i < t2.size(); i++) {
						if (list_2
								.getSelectedValue()
								.toString()
								.equals(t2.get(i).getIme() + " "
										+ t2.get(i).getPrezime())) {
							broj = i;
						}
					}
					t1.add(t2.get(broj));
					t2.remove(broj);
					textField_1.setText(String.valueOf(t2.size()));
					prvaLista.addElement(list_2.getSelectedValue().toString());
					drugaLista.removeElement(list_2.getSelectedValue());
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");

		list_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Takmi\u010Dari u\u010Desnici", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		list_2.setBackground(SystemColor.control);

		list.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Svi takmi\u010Dari",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		list.setBackground(SystemColor.control);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(list_2, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public DodavanjeNovogIAzuriranjePostojecegTurnira(Turnir turn, JFrame pf, GlavniProzor gp) {
		parentFrame = pf;
		gpf = gp;
		final Logger logger = Logger.getLogger(DodavanjeNovogIAzuriranjePostojecegTurnira.class);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent arg0) {
					parentFrame.setEnabled(true);
			}
		});
		turnir = turn;
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DodavanjeNovogIAzuriranjePostojecegTurnira.class
						.getResource("/gui/logo.png")));
		setBounds(100, 100, 845, 484);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Podaci o turniru",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(turnir.getNaziv());

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

		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Jednostruki eliminacioni", "Dvostruki eliminacioni",
				"Round Robin", "Swiss" }));
		if (turnir.getFormatTakmicenja() == "Jednostruki eliminacioni")
			comboBox.setSelectedIndex(0);
		else if (turnir.getFormatTakmicenja() == "Dvostruki eliminacioni")
			comboBox.setSelectedIndex(1);
		else if (turnir.getFormatTakmicenja() == "Round Robin")
			comboBox.setSelectedIndex(2);
		else
			comboBox.setSelectedIndex(3);

		comboBox.setEditable(false);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.RED);
		textPane.setBackground(Color.WHITE);

		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.RED);
		textPane_1.setBackground(Color.WHITE);

		// spinner.setValue("0");

		spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_2.setModel(new SpinnerDateModel(new Date(1432245600000L),
				new Date(1432245600000L), null, Calendar.DAY_OF_YEAR));

		if (turnir.getDatumPocetka() != null) {
			spinner_2.setValue(turnir.getDatumPocetka());
		}

		spinner_1.setValue(turnir.getTrajanje());

		JTextPane txtpnDatumPoetkaTurnira = new JTextPane();
		txtpnDatumPoetkaTurnira.setText("Datum po\u010Detka turnira:*");
		txtpnDatumPoetkaTurnira.setEditable(false);
		txtpnDatumPoetkaTurnira.setBackground(Color.WHITE);
		TurnirDAO tdao = new TurnirDAO();
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(String.valueOf(tdao.getNumberOfContestants(turn.getId())));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(turn.getTrajanje()));
		textField_2.setColumns(10);
		
		comboBox.setSelectedItem(turn.getFormatTakmicenja());
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(182, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(104, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox, 0, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnTrajanjeuDanima, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(txtpnDatumPoetkaTurnira, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(spinner_2, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
								.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addGap(21))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnFormatTakmienja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnBrojTakmiara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnDatumPoetkaTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnTrajanjeuDanima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		comboBox.setEnabled(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "U\u010Desnici turnira",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		List<Takmicar> t = new ArrayList<Takmicar>();

		t = tdao.getAll(Takmicar.class);
		t1 = tdao.getAllContestants(turn.getId());

		for (int i = 0; i < t.size(); i++) {
			prvaLista.addElement(t.get(i).getIme() + " "
					+ t.get(i).getPrezime());
		}
		
		for (int i = 0; i < t1.size(); i++) {
			drugaLista.addElement(t1.get(i).getIme() + " "
					+ t1.get(i).getPrezime());
		}

		list = new JList<String>(prvaLista);
		list_2 = new JList<String>(drugaLista);

		// list.setModel((ListModel) t);
		// list.add(t.get(i).getIme() + " " + t.get(i).getPrezime(), t.get(i));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				boolean flag = false;

				if (validirajPrazno(textField.getText())) {
					textPane.setText("");
				} else {
					textPane.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if (validirajPrazno(textField.getText())) {
					if (validirajAlphaNum(textField.getText())) {
						textPane.setText("");
					}
				}
				if (validirajPrazno(textField.getText())) {
					if (!validirajAlphaNum(textField.getText())) {
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if (validirajBrojTakmicara((String) comboBox.getSelectedItem(), Integer.parseInt(textField_1.getText()))) {
					textPane_1.setText("");
				} else {
					flag = true;
					textPane_1.setText("Broj takmi�ara nije ispravan");
				}

				if (!flag) {
					Turnir turn = GenericDAO.loadById(Turnir.class,
							turnir.getId());
					TurnirDAO tdao = new TurnirDAO();

					turn.setNaziv(textField.getText());
					// turn.setFormatTakmicenja(comboBox.getSelectedItem().toString());
					turn.setTrajanje((Integer) spinner_1.getValue());
					turn.setDatumPocetka((Date) spinner_2.getValue());
					textField.setText("");
					textPane.setText("");
					
					tdao.update(turn);
					JOptionPane.showMessageDialog(null,
							"Uspje�no ste izmijenili turnir!", "OK",
							JOptionPane.INFORMATION_MESSAGE);
					JFrame thisFrame = (JFrame) SwingUtilities
							.getRoot(textField_1);
					thisFrame.dispose();
					parentFrame.setEnabled(true);
					gpf.RefreshTables();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
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
																		.addGap(26)
																		.addComponent(
																				panel,
																				GroupLayout.DEFAULT_SIZE,
																				214,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				panel_1,
																				GroupLayout.PREFERRED_SIZE,
																				537,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap(
																				742,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnPotvrdi)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																panel_1,
																GroupLayout.DEFAULT_SIZE,
																364,
																Short.MAX_VALUE)
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																372,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18).addComponent(btnPotvrdi)
										.addContainerGap()));
		JButton button = new JButton(">");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/*
		 * button.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent arg0){
		 * 
		 * drugaLista.addElement(list.getSelectedValue().toString());
		 * prvaLista.removeElement(list.getSelectedValue()); int broj=0; for(int
		 * i=0;i<t1.size();i++) {
		 * if(list.getSelectedValue().toString().equals(t1
		 * .get(i).getIme()+" "+t1.get(i).getPrezime())) { broj=i; } }
		 * t2.add(t1.get(broj)); t1.remove(broj);
		 * 
		 * } });
		 */

		JButton button_1 = new JButton("<");
		button_1.setEnabled(false);
		/*
		 * button_1.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent arg0){
		 * 
		 * prvaLista.addElement(list_2.getSelectedValue().toString());
		 * drugaLista.removeElement(list_2.getSelectedValue()); int broj=0;
		 * for(int i=0;i<t2.size();i++) {
		 * if(list_2.getSelectedValue().toString()
		 * .equals(t2.get(i).getIme()+" "+t2.get(i).getPrezime())) { broj=i; } }
		 * t1.add(t2.get(broj)); t2.remove(broj); } });
		 */

		JLabel lblNewLabel_1 = new JLabel("");

		list_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Takmi\u010Dari u\u010Desnici", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		list_2.setBackground(SystemColor.control);

		list.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Svi takmi\u010Dari",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		list.setBackground(SystemColor.control);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1))))
					.addGap(34))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel_1)
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
						.addComponent(list_2, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
