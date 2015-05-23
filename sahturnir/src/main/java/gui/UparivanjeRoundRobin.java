package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.Color;
import java.util.ArrayList;

public class UparivanjeRoundRobin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UparivanjeRoundRobin frame = new UparivanjeRoundRobin();
					frame.setVisible(true);
					//frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int izracunajStepen(int n)
	{
		int brojac=0;
		if(n==1) return brojac;
		n=n/2; 
		brojac++;
		return izracunajStepen(n);
	}

	/**
	 * Create the frame.
	 */
	//@SuppressWarnings("static-access")
	public UparivanjeRoundRobin() {
		setTitle("\u0160AHOVSKI KLUB PIJUN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UparivanjeRoundRobin.class.getResource("/gui/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		
		JLabel lblTurnir = new JLabel("Turnir:");
		lblTurnir.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JTextPane textPane_1 = new JTextPane();
		
		JLabel lblSistem = new JLabel("Sistem:");
		lblSistem.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTurnir)
							.addGap(56))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSistem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(31)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
						.addComponent(textPane_1))
					.addContainerGap(422, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTurnir)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSistem)
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(417, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	
        contentPane.updateUI();
    }

	}

