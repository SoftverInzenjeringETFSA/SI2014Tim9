package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import klase.Mec;
import dal.MecDAO;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

class MyDrawing extends JPanel {
    public void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
    }
}

public class UparivanjeJednostrukaEliminacija extends JFrame {

	private JPanel contentPane;
	private gui.MyDrawing myDrawing;
	private gui.MyDrawing myDrawing_1;
	private JTextField textField_8;
	private JTextField textField_9;
	private JSeparator separator_2;
	private gui.MyDrawing myDrawing_2;
	private gui.MyDrawing myDrawing_3;
	private JTextField textField;
	private JTextField textField_1;
	private JSeparator separator;
	private gui.MyDrawing myDrawing_4;
	private JTextField textField_4;
	private JTextField textField_5;
	private JSeparator separator_4;
	private gui.MyDrawing myDrawing_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UparivanjeJednostrukaEliminacija frame = new UparivanjeJednostrukaEliminacija();
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
	public UparivanjeJednostrukaEliminacija() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		
		List<Mec> mecevi = new ArrayList<Mec>();
		MecDAO mdao = new MecDAO();
		mecevi = mdao.getAll(Mec.class);
		
		myDrawing = new gui.MyDrawing();
		contentPane.add(myDrawing, "cell 0 1,grow");
		
		myDrawing_2 = new gui.MyDrawing();
		myDrawing_2.setLayout(new GridLayout(0, 6, 0, 0));
		
		myDrawing_3 = new gui.MyDrawing();
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(20);
		textField.setBackground(Color.WHITE);
		myDrawing_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(2);
		myDrawing_3.add(textField_1);
		
		separator = new JSeparator();
		myDrawing_3.add(separator);
		
		myDrawing_1 = new gui.MyDrawing();
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setColumns(20);
		textField_8.setBackground(Color.WHITE);
		myDrawing_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(2);
		myDrawing_1.add(textField_9);
		
		separator_2 = new JSeparator();
		myDrawing_1.add(separator_2);
		
		myDrawing_4 = new gui.MyDrawing();
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(20);
		textField_4.setBackground(Color.WHITE);
		myDrawing_4.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(2);
		myDrawing_4.add(textField_5);
		
		separator_4 = new JSeparator();
		myDrawing_4.add(separator_4);
		
		gui.MyDrawing myDrawing_6 = new gui.MyDrawing();
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(20);
		textField_2.setBackground(Color.WHITE);
		myDrawing_6.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(2);
		myDrawing_6.add(textField_3);
		
		JSeparator separator_1 = new JSeparator();
		myDrawing_6.add(separator_1);
		
		gui.MyDrawing myDrawing_7 = new gui.MyDrawing();
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setColumns(20);
		textField_6.setBackground(Color.WHITE);
		myDrawing_7.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(2);
		myDrawing_7.add(textField_7);
		
		JSeparator separator_3 = new JSeparator();
		myDrawing_7.add(separator_3);
		
		gui.MyDrawing myDrawing_8 = new gui.MyDrawing();
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.LEFT);
		textField_10.setColumns(20);
		textField_10.setBackground(Color.WHITE);
		myDrawing_8.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(2);
		myDrawing_8.add(textField_11);
		
		JSeparator separator_5 = new JSeparator();
		myDrawing_8.add(separator_5);
		
		gui.MyDrawing myDrawing_9 = new gui.MyDrawing();
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.LEFT);
		textField_12.setColumns(20);
		textField_12.setBackground(Color.WHITE);
		myDrawing_9.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(2);
		myDrawing_9.add(textField_13);
		
		JSeparator separator_6 = new JSeparator();
		myDrawing_9.add(separator_6);
		
		gui.MyDrawing myDrawing_10 = new gui.MyDrawing();
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.LEFT);
		textField_14.setColumns(20);
		textField_14.setBackground(Color.WHITE);
		myDrawing_10.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(2);
		myDrawing_10.add(textField_15);
		
		JSeparator separator_7 = new JSeparator();
		myDrawing_10.add(separator_7);
		
		gui.MyDrawing myDrawing_11 = new gui.MyDrawing();
		
		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.LEFT);
		textField_16.setColumns(20);
		textField_16.setBackground(Color.WHITE);
		myDrawing_11.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(2);
		myDrawing_11.add(textField_17);
		
		JSeparator separator_8 = new JSeparator();
		myDrawing_11.add(separator_8);
		
		gui.MyDrawing myDrawing_12 = new gui.MyDrawing();
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.LEFT);
		textField_18.setColumns(20);
		textField_18.setBackground(Color.WHITE);
		myDrawing_12.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(2);
		myDrawing_12.add(textField_19);
		
		JSeparator separator_9 = new JSeparator();
		myDrawing_12.add(separator_9);
		
		gui.MyDrawing myDrawing_13 = new gui.MyDrawing();
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.LEFT);
		textField_20.setColumns(20);
		textField_20.setBackground(Color.WHITE);
		myDrawing_13.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(2);
		myDrawing_13.add(textField_21);
		
		JSeparator separator_10 = new JSeparator();
		myDrawing_13.add(separator_10);
		
		gui.MyDrawing myDrawing_14 = new gui.MyDrawing();
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.LEFT);
		textField_22.setColumns(20);
		textField_22.setBackground(Color.WHITE);
		myDrawing_14.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(2);
		myDrawing_14.add(textField_23);
		
		JSeparator separator_11 = new JSeparator();
		myDrawing_14.add(separator_11);
		
		gui.MyDrawing myDrawing_15 = new gui.MyDrawing();
		
		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.LEFT);
		textField_24.setColumns(20);
		textField_24.setBackground(Color.WHITE);
		myDrawing_15.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(2);
		myDrawing_15.add(textField_25);
		
		JSeparator separator_12 = new JSeparator();
		myDrawing_15.add(separator_12);
		
		gui.MyDrawing myDrawing_16 = new gui.MyDrawing();
		
		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.LEFT);
		textField_26.setColumns(20);
		textField_26.setBackground(Color.WHITE);
		myDrawing_16.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(2);
		myDrawing_16.add(textField_27);
		
		JSeparator separator_13 = new JSeparator();
		myDrawing_16.add(separator_13);
		GroupLayout gl_myDrawing = new GroupLayout(myDrawing);
		gl_myDrawing.setHorizontalGroup(
			gl_myDrawing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_myDrawing.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_myDrawing.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_myDrawing.createSequentialGroup()
							.addComponent(myDrawing_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(myDrawing_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(myDrawing_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(myDrawing_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(myDrawing_6, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(myDrawing_7, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(myDrawing_8, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(myDrawing_9, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(myDrawing_10, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_myDrawing.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_myDrawing.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
							.addGroup(gl_myDrawing.createParallelGroup(Alignment.LEADING)
								.addComponent(myDrawing_15, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addComponent(myDrawing_16, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_myDrawing.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_myDrawing.createParallelGroup(Alignment.TRAILING)
								.addComponent(myDrawing_12, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addComponent(myDrawing_11, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addComponent(myDrawing_13, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addComponent(myDrawing_14, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		gl_myDrawing.setVerticalGroup(
			gl_myDrawing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_myDrawing.createSequentialGroup()
					.addGroup(gl_myDrawing.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_myDrawing.createSequentialGroup()
							.addGap(20)
							.addComponent(myDrawing_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_myDrawing.createSequentialGroup()
							.addContainerGap()
							.addComponent(myDrawing_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myDrawing_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(myDrawing_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myDrawing_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(myDrawing_7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myDrawing_8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(myDrawing_9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myDrawing_10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_myDrawing.createSequentialGroup()
					.addGap(61)
					.addComponent(myDrawing_11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myDrawing_12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(myDrawing_15, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(myDrawing_16, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(myDrawing_13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myDrawing_14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
		);
		myDrawing.setLayout(gl_myDrawing);
		
		myDrawing_5 = new gui.MyDrawing();
	}

}
