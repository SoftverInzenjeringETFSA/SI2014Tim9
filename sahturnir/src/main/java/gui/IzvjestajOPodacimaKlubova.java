package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;
import java.awt.Color;

public class IzvjestajOPodacimaKlubova extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOPodacimaKlubova frame = new IzvjestajOPodacimaKlubova();
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
	public IzvjestajOPodacimaKlubova() {
		setResizable(false);
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajOPodacimaKlubova.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnIzvjetajOPodacima = new JTextPane();
		txtpnIzvjetajOPodacima.setBackground(Color.WHITE);
		txtpnIzvjetajOPodacima.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnIzvjetajOPodacima.setText("Izvje\u0161taj o podacima klubova");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextPane txtpnDatumIVrijeme = new JTextPane();
		txtpnDatumIVrijeme.setBackground(Color.WHITE);
		txtpnDatumIVrijeme.setText("Datum i vrijeme generisanja izvje\u0161taja:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		        attributes.add(DialogTypeSelection.COMMON);
		        PrinterJob printJob = PrinterJob.getPrinterJob();
		        printJob.printDialog(attributes);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnIzvjetajOPodacima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 577, Short.MAX_VALUE)
							.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnIzvjetajOPodacima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrint))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ime kluba", "Broj takmi\u010Dara", "Ukupni broj bodova", "Broj turnira", "Broj titula takmi\u010Dara", "Ukupan broj titula"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
