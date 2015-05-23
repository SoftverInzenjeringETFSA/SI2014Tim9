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
import javax.swing.SpinnerDateModel;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import klase.Takmicar;
import klase.Turnir;
import dal.TurnirDAO;
import dal.TakmicarDAO;
import formatiturnira.JednostrukaEliminacija;


public class DodavanjeNovogIAzuriranjePostojecegTurnira extends JFrame {
	private JTextField textField;
	protected final JTextPane textPane;
	private JComboBox comboBox = new JComboBox();
	private JSpinner spinner = new JSpinner();
	private JSpinner spinner_1 = new JSpinner();
	private	JSpinner spinner_2 = new JSpinner();
	private JList<String> list_2 ;	
	private JList<String>  list ;
	DefaultListModel<String> prvaLista = new DefaultListModel<String>();
	DefaultListModel<String> drugaLista = new DefaultListModel<String>();
	List<Takmicar> t1=new ArrayList<Takmicar>();
	List<Takmicar> t2=new ArrayList<Takmicar>();
	//private JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(DodavanjeNovogIAzuriranjePostojecegTurnira.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					DodavanjeNovogIAzuriranjePostojecegTurnira frame = new DodavanjeNovogIAzuriranjePostojecegTurnira();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					logger.error("Sorry, something wrong!", e);
				}
			}
		});
	}
	
	public static Boolean validirajPrazno(String t1) {
		Boolean izlaz = false;
		
		if(t1.isEmpty()|| t1.trim().length() == 0) 
			izlaz = false;
		else
			izlaz = true;
		
		return izlaz;
	}
	
	public static Boolean validirajJmbg(String t1) {
		Boolean izlaz = false;
		if (!(t1.length() == 13))
		{
			izlaz = false;
		}
		else
			izlaz = true;
		return izlaz;
    }
	
    public static Boolean validirajImePrezime(String t1) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]* +[A-Z][a-z]*)";
		Pattern p = Pattern.compile(pattern);
		java.util.regex.Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;
		}
		else
			izlaz = true;
		
		return izlaz;
    }

    public static Boolean validirajAlpha(String t1) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]*)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;
		}
		else
			izlaz = true;
		
		return izlaz;
    }
    
    public static Boolean validirajAlphaNum(String t1) {
		Boolean izlaz = false;
		String pattern = "^[a-zA-Z0-9 ]*";
		Pattern p = Pattern.compile(pattern);
		java.util.regex.Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;
		}
		else
			izlaz = true;
		
		return izlaz;
    }
	
	public static Boolean validirajBrojTakmicara(int spinner){
		int i = 1;
		boolean flag = false;
		while(i < spinner){
			i = i*2;
			if(spinner == i){
				flag = true;
			}					
		}
		if (!flag)
		{
			flag = false;
		}
		//	TO DO:	if(list_2.size() == spinner.value) zabrani dodavanje novih na turnir
		return flag;
	}

	/**
	 * Create the frame.
	 */
	public DodavanjeNovogIAzuriranjePostojecegTurnira() {
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeNovogIAzuriranjePostojecegTurnira.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 484);
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
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jednostruki eliminacioni", "Dvostruki eliminacioni", "Round Robin", "Swiss"}));
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.RED);
		textPane.setBackground(Color.WHITE);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setForeground(Color.RED);
		textPane_1.setBackground(Color.WHITE);
		
		spinner.setModel(new SpinnerNumberModel(4, 4, 32, 4));
		
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		
		spinner_2.setModel(new SpinnerDateModel(new Date(1432245600000L), new Date(1432245600000L), null, Calendar.DAY_OF_YEAR));
		
		JTextPane txtpnDatumPoetkaTurnira = new JTextPane();
		txtpnDatumPoetkaTurnira.setText("Datum po\u010Detka turnira:*");
		txtpnDatumPoetkaTurnira.setEditable(false);
		txtpnDatumPoetkaTurnira.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(150, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
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
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnTrajanjeuDanima, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(txtpnDatumPoetkaTurnira, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(spinner_2, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
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
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "U\u010Desnici turnira", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		List<Takmicar> t = new ArrayList<Takmicar>();
		TakmicarDAO tdao = new TakmicarDAO();
		
		
		t = tdao.getAll(Takmicar.class);
		t1= tdao.getAll(Takmicar.class);
		
		String[] red = new String[t.size()];
		for(int i=0;i<t.size();i++)
		{
			//red[i]=t.get(i).getIme()+" "+t.get(i).getPrezime(); 
			prvaLista.addElement(t.get(i).getIme()+" "+t.get(i).getPrezime());
		}
		
		list = new JList<String>(prvaLista);
		list_2=new JList<String>(drugaLista);
		
//			list.setModel((ListModel) t);
//			list.add(t.get(i).getIme() + " " + t.get(i).getPrezime(), t.get(i));
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				boolean flag = false;
				
				if(validirajPrazno(textField.getText()))
				{
					textPane.setText("");
				}
				else 
				{
					textPane.setText("Polje ne smije biti prazno");
					flag = true;
				}
				if(validirajPrazno(textField.getText()))
				{	
					if(validirajAlphaNum(textField.getText()))
					{
						textPane.setText("");
					}
				}
				if(validirajPrazno(textField.getText()))
				{	
					if(!validirajAlphaNum(textField.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajBrojTakmicara((Integer)spinner.getValue()))
				{
					textPane_1.setText("");
				}
				else
				{
					flag = true;
					textPane_1.setText("Broj takmièara nije OK");
				}
				
				if(!flag)
				{
					Turnir t = new Turnir();
					TurnirDAO tdao = new TurnirDAO();
					
					t.setNaziv(textField.getText());
					t.setFormatTakmicenja(comboBox.getSelectedItem().toString());
					t.setTrajanje((Integer)spinner_1.getValue());
					t.setDatumPocetka((Date)spinner_2.getValue());
					textField.setText("");
					textPane.setText("");
					if(comboBox.getSelectedItem().toString().equals("Jednostruki eliminacioni"))
					{
						JednostrukaEliminacija j=new JednostrukaEliminacija();
						try{
							j.GenerisiRundu(t2, t,true);
						}
						catch(Exception ex)
						{
							
						}
					}
					else if(comboBox.getSelectedItem().toString().equals("Dvostruki eliminacioni"))
					{
						DvostrukaEliminacija j=new DvostrukaEliminacija();
						try{
							j.GenerisiPrvuRundu(t2, t,true);
						}
						catch(Exception ex)
						{
							
						}
					}
					else if(comboBox.getSelectedItem().toString().equals("Round Robin"))
					{
						RoundRobin j=new RoundRobin();
						try{
							j.RoundRobinGenerator(t2, t);
						}
						catch(Exception ex)
						{
							
						}
					}
					else
					{
						Swiss j=new Swiss();
						try{
							j.GenerisiMeceve(t2, t);
						}
						catch(Exception ex)
						{
							
						}
					}
					tdao.create(t);
			        JOptionPane.showMessageDialog(null, "Uspješno ste kreirali turnir!", "OK", JOptionPane.INFORMATION_MESSAGE);										
				}
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
							.addContainerGap(742, Short.MAX_VALUE)
							.addComponent(btnPotvrdi)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		JButton button = new JButton(">");
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				drugaLista.addElement(list.getSelectedValue().toString());
				prvaLista.removeElement(list.getSelectedValue());
				int broj=0;
				for(int i=0;i<t1.size();i++)
				{
					if(list.getSelectedValue().toString().equals(t1.get(i).getIme()+" "+t1.get(i).getPrezime()))
					{
						broj=i;
					}
				}
				t2.add(t1.get(broj));
				t1.remove(broj);
				
			}
		});
		
	
		JButton button_1 = new JButton("<");
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				prvaLista.addElement(list_2.getSelectedValue().toString());
				drugaLista.removeElement(list_2.getSelectedValue());
				int broj=0;
				for(int i=0;i<t2.size();i++)
				{
					if(list_2.getSelectedValue().toString().equals(t2.get(i).getIme()+" "+t2.get(i).getPrezime()))
					{
						broj=i;
					}
				}
				t1.add(t2.get(broj));
				t2.remove(broj);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		list_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Takmi\u010Dari u\u010Desnici", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		list_2.setBackground(SystemColor.control);

		list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Svi takmi\u010Dari", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		list.setBackground(SystemColor.control);
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
						.addComponent(button_1)
						.addComponent(lblNewLabel_1)
						.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel_1)
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(list_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
