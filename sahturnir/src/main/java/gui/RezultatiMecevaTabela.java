package gui;

import gui.GlavniProzor.ImageRendererDelete;
import gui.GlavniProzor.ImageRendererEdit;
import gui.GlavniProzor.ImageRendererMatch;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;

import utils.JTableUtil;

public class RezultatiMecevaTabela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezultatiMecevaTabela frame = new RezultatiMecevaTabela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class ImageRendererDelete extends DefaultTableCellRenderer {
		JLabel tableLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/main/java/gui/delete.png");
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			tableLabel.setText((String) value);
			tableLabel.setIcon(icon);
			tableLabel.setToolTipText("Brisanje");
			tableLabel.setOpaque(true);
			Color c1 = new Color(0x67FD9A);
			Color c2 = new Color(0xC0C0C0);
			tableLabel.setBackground(row % 2 == 0 ? c1 : c2);
			tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return tableLabel;
		}
	}
	
	class ImageRendererEdit extends DefaultTableCellRenderer {
		JLabel tableLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/main/java/gui/edit.png");
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			tableLabel.setText((String) value);
			tableLabel.setIcon(icon);
			tableLabel.setToolTipText("Ureðivanje");
			tableLabel.setOpaque(true);
			Color c1 = new Color(0x67FD9A);
			Color c2 = new Color(0xC0C0C0);
			tableLabel.setBackground(row % 2 == 0 ? c1 : c2);
			tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return tableLabel;
		}
	}
	
	private void PrepareTableDesign(JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Color c1 = new Color(0x67FD9A);
				Color c2 = new Color(0xC0C0C0);
				Color c3 = new Color(0x343434);
				final Component c = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 0 ? c1 : c2);
				table.setRowHeight(row, 40);
				JTableHeader h = table.getTableHeader();
				h.setOpaque(false);
				h.setBackground(c3);
				h.setForeground(Color.white);
				return c;
			}
		});
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setPreferredSize(new Dimension(0, 40));
		table.getColumnModel().getColumn(table.getColumnCount() - 1)
				.setCellRenderer(new ImageRendererDelete());
		table.getColumnModel().getColumn(table.getColumnCount() - 2)
		.setCellRenderer(new ImageRendererEdit());	
		table.setEnabled(false);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.getColumnModel().getColumn(table.getColumnCount() - 1).setMaxWidth(40);
		table.getColumnModel().getColumn(table.getColumnCount() - 2).setMaxWidth(40);
		if(table.getName() == "tableTurniri")
			table.getColumnModel().getColumn(table.getColumnCount() - 3).setMaxWidth(40);	
	}

	/**
	 * Create the frame.
	 */
	public RezultatiMecevaTabela() {
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RezultatiMecevaTabela.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setText("Naziv turnira:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane txtpnMeeviZaKoje = new JTextPane();
		txtpnMeeviZaKoje.setText("Me\u010Devi za koje nije unijet rezultat:");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtpnMeeviZaKoje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnNazivTurnira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(txtpnMeeviZaKoje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		JTableUtil jtutil = new JTableUtil();
		table.setModel(jtutil.populateJTableMecevi());
		PrepareTableDesign(table);
		//panel_3.setLayout(new BorderLayout());
		//panel_3.add(table.getTableHeader(), BorderLayout.NORTH);
		//panel_3.add(new JScrollPane(table), BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
