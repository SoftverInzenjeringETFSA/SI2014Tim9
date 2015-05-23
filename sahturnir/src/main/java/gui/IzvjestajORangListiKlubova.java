package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTextPane;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JButton;

import utils.JTableUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;

public class IzvjestajORangListiKlubova extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajORangListiKlubova frame = new IzvjestajORangListiKlubova();
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
	public IzvjestajORangListiKlubova() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvjestajORangListiKlubova.class.getResource("/gui/logo.png")));
		setTitle("\u0160ahovski klub Pijun");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setEditable(false);
		txtpnNazivTurnira.setText("Naziv turnira:");
		
		JComboBox comboBox = new JComboBox();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextPane txtpnDatumIVrijeme = new JTextPane();
		txtpnDatumIVrijeme.setEditable(false);
		txtpnDatumIVrijeme.setText("Datum i vrijeme generisanja izvje\u0161taja:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnIzvjetajORang_1 = new JTextPane();
		txtpnIzvjetajORang_1.setEditable(false);
		txtpnIzvjetajORang_1.setText("Izvje\u0161taj o rang listi klubova");
		txtpnIzvjetajORang_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnIzvjetajORang_1.setBackground(Color.WHITE);
		
		JButton btnPrint = new JButton("Print");
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
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtpnIzvjetajORang_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
							.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnIzvjetajORang_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnPrint))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnDatumIVrijeme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		/*table = new JTable();
		JTableUtil jtutil = new JTableUtil();
		table.setModel(jtutil.populateJTableRangListaKlubovi());
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);*/
	}


}
