package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;

import javax.swing.JTextPane;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import klase.Klub;
import klase.Korisnik;
import dal.GenericDAO;
import dal.KlubDAO;
import dal.KorisnikDAO;
public class DodavanjeKorisnika extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;	
	private JFrame parentFrame;
	protected final JTextPane textPane;
	protected final JTextPane textPane_1;
	protected final JTextPane textPane_2;
	protected final JTextPane textPane_3;
	protected final JTextPane textPane_4;
	Korisnik k=new Korisnik();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(DodavanjeKorisnika.class);
				EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					Korisnik k=new Korisnik();
					DodavanjeKorisnika frame = new DodavanjeKorisnika(k);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
//					e.printStackTrace();
					logger.error("Došlo je do greške!", e);
				}
			}
		});
	}
   
	public static Boolean validirajPrazno(String t1) {
		Boolean izlaz = false;
		//String a = t1.getText();
		
		if(t1.isEmpty()|| t1.trim().length() == 0)
			izlaz = false;//t2textPane.setText("Polje ne smije biti prazno");
		else
			izlaz = true;
		
		return izlaz;
	}
	
	
	public static Boolean validirajPraznoPass(char[] t1) {
		Boolean izlaz = false;
		//char[] a = t1.getPassword();
		
		if(t1.length==0) 
			izlaz = false;//t2textPane.setText("Polje ne smije biti prazno");
		else
			izlaz = true;
		
		return izlaz;
	}
	
    public static Boolean validirajAlpha(String t1) {
		Boolean izlaz = false;
		String pattern = "^([A-Z][a-z]*)";
		//String a = t1.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz = false;//t2textPane.setText("Neispravni karakteri");
		}
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
    public static Boolean validirajJmbg(JTextField t1, JTextPane t2) {
		Boolean izlaz = false;
//		String pattern = "/^[0-9]+.{13}$";
		String a = t1.getText();
//		Pattern p = Pattern.compile(pattern);
//		Matcher m = p.matcher(a);
		if (!(a.length() == 13))
		{
			t2.setText("GreskaJMBG");
		}
		else
			izlaz = true;
		return izlaz;
    }
    
    public static Boolean validirajSifru(String t1) {
		Boolean izlaz = false;
		String pattern = "^(?=.*[0-9])(?=\\S+$).{6,}$"; //mora sadrzavati minimalno 6 karaktera od kojih je jedna cifra, nije dozvoljen whitespace
		//String a =  new String(t1.getPassword());
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t1);
		
		if(!(m.matches())) {
			izlaz=false;//t2.setText("Mozete unijeti samo brojeve");
		}
		else
			izlaz = true;
		
		return izlaz;
    }
	/**
	 * Create the frame.
	 */
	public DodavanjeKorisnika() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//addWindowListener(new WindowAdapter() {
			//@Override
			//public void windowClosing(WindowEvent arg0) {
				//parentFrame.setEnabled(true);
			//}
		//});
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeKorisnika.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBounds(100, 100, 330, 546);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Korisni\u010Dki podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				textPane_3.setText("");
				textPane_4.setText("");
				boolean flag = false;
				if(validirajPrazno(textField.getText()))
				{
					textPane.setText("");
				}
				if(!validirajPrazno(textField.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField.getText()))
					if(validirajAlphaNum(textField, textPane))
						textPane.setText("");
				if(validirajPrazno(textField.getText()))
				{
					if(!validirajAlphaNum(textField, textPane))
					{
						flag = true;
					}
				}
				if(validirajPraznoPass(passwordField.getPassword()))
				{
					textPane_1.setText("");
				}
				if(validirajPraznoPass(passwordField.getPassword()))
				{
					if(validirajSifru(new String(passwordField.getPassword())))
					{
						textPane_1.setText("");
					}
					else 
					{
						textPane_1.setText("Morate unijeti barem jedan broj i minimalno 6 karaktera");
					}
				}
				if(!validirajPraznoPass(passwordField.getPassword()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
					
				}
				if(validirajPrazno(textField_1.getText()))
				{
					textPane_2.setText("");
				}
				if(!validirajPrazno(textField_1.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_1.getText()))
				{
					if(validirajAlpha(textField_1.getText()))
					{
						textPane_2.setText("");
					}
				}
				if (validirajPrazno(textField_1.getText()))
				{
					if(!validirajAlpha(textField_1.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					textPane_3.setText("");
				}
				if(!validirajPrazno(textField_2.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(validirajAlpha(textField_2.getText()))
					{
						textPane_3.setText("");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(!validirajAlpha(textField_2.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajPrazno(textField_3.getText()))
				{
					textPane_4.setText("");
				}
				if(!validirajPrazno(textField_3.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_3.getText()))
				{
					if(validirajJmbg(textField_3, textPane_4))
					{
						textPane_4.setText("");
					}
				}
				if(validirajPrazno(textField_3.getText()))
				{
					if(!validirajJmbg(textField_3, textPane_4))
					{
						flag = true;
					}
				}
				if (!flag)
				{
					Korisnik k = new Korisnik();
					k.setKorisnickoIme(textField.getText());
					String s = new String(passwordField.getPassword());
					k.setSifra(s);
					k.setIme(textField_1.getText());
					k.setPrezime(textField_2.getText());
					k.setJmbg(textField_3.getText());
					KorisnikDAO kdao = new KorisnikDAO();
					kdao.create(k);
			        JOptionPane.showMessageDialog(null, "Uspješno ste dodali korisnika!", "OK", JOptionPane.INFORMATION_MESSAGE);
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        passwordField.setText("");
					textPane.setText("");
					textPane_1.setText("");
					textPane_2.setText("");
					textPane_3.setText("");
					textPane_4.setText("");

				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPotvrdi)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPotvrdi)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		JTextPane txtpnKorisnikoIme = new JTextPane();
		txtpnKorisnikoIme.setEditable(false);
		txtpnKorisnikoIme.setText("Korisni\u010Dko ime: *");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnifra = new JTextPane();
		txtpnifra.setEditable(false);
		txtpnifra.setText("\u0160ifra: *");
		
		passwordField = new JPasswordField();
		
		JTextPane txtpnIme = new JTextPane();
		txtpnIme.setEditable(false);
		txtpnIme.setText("Ime: *");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnPrezime = new JTextPane();
		txtpnPrezime.setEditable(false);
		txtpnPrezime.setText("Prezime: *");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextPane txtpnJmbg = new JTextPane();
		txtpnJmbg.setEditable(false);
		txtpnJmbg.setText("JMBG:*");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.red);
		
	    textPane_1 = new JTextPane();
	    textPane_1.setEditable(false);
	    textPane_1.setForeground(Color.red);
		
		textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setForeground(Color.red);
		
		textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setForeground(Color.red);
		
		textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setForeground(Color.red);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(passwordField, 233, 233, 233)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnifra, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(170, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnKorisnikoIme, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(109, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnIme, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(159, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnPrezime, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(182, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(191, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnKorisnikoIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtpnifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtpnIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
	
	public DodavanjeKorisnika(Korisnik k1) {
		//addWindowListener(new WindowAdapter() {
			//@Override
			//public void windowClosing(WindowEvent arg0) {
				//parentFrame.setEnabled(true);
			//}
		//});
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeKorisnika.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBounds(100, 100, 350, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Korisni\u010Dki podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		k=k1;
		
		
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				textPane_3.setText("");
				textPane_4.setText("");
				boolean flag = false;
				if(validirajPrazno(textField.getText()))
				{
					textPane.setText("");
				}
				if(!validirajPrazno(textField.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField.getText()))
					if(validirajAlphaNum(textField, textPane))
						textPane.setText("");
				if(validirajPrazno(textField.getText()))
				{
					if(!validirajAlphaNum(textField, textPane))
					{
						flag = true;
					}
				}
				if(validirajPraznoPass(passwordField.getPassword()))
				{
					textPane_1.setText("");
				}
				if(validirajPraznoPass(passwordField.getPassword()))
				{
					if(validirajSifru(new String(passwordField.getPassword())))
					{
						textPane_1.setText("");
					}
					else 
					{
						textPane_1.setText("Morate unijeti barem jedan broj i minimalno 6 karaktera");
					}
				}
				if(!validirajPraznoPass(passwordField.getPassword()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
					
				}
				if(validirajPrazno(textField_1.getText()))
				{
					textPane_2.setText("");
				}
				if(!validirajPrazno(textField_1.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_1.getText()))
				{
					if(validirajAlpha(textField_1.getText()))
					{
						textPane_2.setText("");
					}
				}
				if (validirajPrazno(textField_1.getText()))
				{
					if(!validirajAlpha(textField_1.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					textPane_3.setText("");
				}
				if(!validirajPrazno(textField_2.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(validirajAlpha(textField_2.getText()))
					{
						textPane_3.setText("");
					}
				}
				if(validirajPrazno(textField_2.getText()))
				{
					if(!validirajAlpha(textField_2.getText()))
					{
						flag = true;
						textPane.setText("Neispravni karakteri");
					}
				}
				if(validirajPrazno(textField_3.getText()))
				{
					textPane_4.setText("");
				}
				if(!validirajPrazno(textField_3.getText()))
				{
					flag = true;
					textPane.setText("Polje ne smije biti prazno");
				}
				if(validirajPrazno(textField_3.getText()))
				{
					if(validirajJmbg(textField_3, textPane_4))
					{
						textPane_4.setText("");
					}
				}
				if(validirajPrazno(textField_3.getText()))
				{
					if(!validirajJmbg(textField_3, textPane_4))
					{
						flag = true;
					}
				}
				if (!flag)
				{
					
					Korisnik kor =	GenericDAO.loadById(Korisnik.class, k.getId());
					
					KorisnikDAO kdao = new KorisnikDAO();
					
					kor.setKorisnickoIme(textField.getText());
					String s = new String(passwordField.getPassword());
					kor.setSifra(s);
					kor.setIme(textField_1.getText());
					kor.setPrezime(textField_2.getText());
					kor.setJmbg(textField_3.getText());
					
					kdao.update(kor);
			        JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili korisnika!", "OK", JOptionPane.INFORMATION_MESSAGE);
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        passwordField.setText("");
					textPane.setText("");
					textPane_1.setText("");
					textPane_2.setText("");
					textPane_3.setText("");
					textPane_4.setText("");

				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPotvrdi)))
					.addGap(28))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnPotvrdi)
					.addContainerGap())
		);
		
		JTextPane txtpnKorisnikoIme = new JTextPane();
		txtpnKorisnikoIme.setEditable(false);
		txtpnKorisnikoIme.setText("Korisni\u010Dko ime: *");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnifra = new JTextPane();
		txtpnifra.setEditable(false);
		txtpnifra.setText("\u0160ifra: *");
		
		passwordField = new JPasswordField();
		
		JTextPane txtpnIme = new JTextPane();
		txtpnIme.setEditable(false);
		txtpnIme.setText("Ime: *");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnPrezime = new JTextPane();
		txtpnPrezime.setEditable(false);
		txtpnPrezime.setText("Prezime: *");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextPane txtpnJmbg = new JTextPane();
		txtpnJmbg.setEditable(false);
		txtpnJmbg.setText("JMBG:*");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		
		textField.setText(k.getKorisnickoIme());
		passwordField.setText(k.getSifra());
		textField_1.setText(k.getIme());
		textField_2.setText(k.getPrezime());
		textField_3.setText(k.getJmbg());
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.red);
		
	    textPane_1 = new JTextPane();
	    textPane_1.setEditable(false);
	    textPane_1.setForeground(Color.red);
		
		textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setForeground(Color.red);
		
		textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setForeground(Color.red);
		
		textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setForeground(Color.red);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(passwordField, 233, 233, 233)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(txtpnifra, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(170, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnKorisnikoIme, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnIme, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(159, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(191, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtpnPrezime, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(182, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
							.addGap(19))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnKorisnikoIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtpnifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtpnIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnPrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(txtpnJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
