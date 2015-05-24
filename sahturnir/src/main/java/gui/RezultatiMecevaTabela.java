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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;

import klase.Klub;
import klase.Mec;
import klase.Turnir;

import org.apache.log4j.Logger;

import dal.KlubDAO;
import dal.MecDAO;
import dal.TurnirDAO;
import utils.JTableUtil;

public class RezultatiMecevaTabela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table = new JTable();
	private transient JTableUtil jtutil = new JTableUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(RezultatiMecevaTabela.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Turnir t = new Turnir();
					RezultatiMecevaTabela frame = new RezultatiMecevaTabela(t);
					frame.setVisible(true);
				} catch (Exception e) {
					// e.printStackTrace();
					logger.error("Do�lo je do gre�ke!", e);
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
			tableLabel.setToolTipText("Ure�ivanje");
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
		table.getColumnModel().getColumn(table.getColumnCount() - 1)
				.setMaxWidth(40);
		table.getColumnModel().getColumn(table.getColumnCount() - 2)
				.setMaxWidth(40);
	}

	/**
	 * Create the frame.
	 */
	public RezultatiMecevaTabela(Turnir t) {
		setTitle("\u0160ahovski klub Pijun");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				RezultatiMecevaTabela.class.getResource("/gui/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 763, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTextPane txtpnNazivTurnira = new JTextPane();
		txtpnNazivTurnira.setEditable(false);
		txtpnNazivTurnira.setText("Naziv turnira:");

		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(t.getNaziv());
		textField.setEditable(false);
		JTextPane txtpnMeeviZaKoje = new JTextPane();
		txtpnMeeviZaKoje.setEditable(false);
		txtpnMeeviZaKoje.setText("Me\u010Devi turnira:");
		JPanel panel = new JPanel();
		table.setModel(jtutil.populateJTableMecevi(t));
		PrepareTableDesign(table);
		panel.setLayout(new BorderLayout());
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int col = table.columnAtPoint(evt.getPoint());
				if (row >= 0 && (col == table.getColumnCount() - 1 || col == table.getColumnCount() - 2)) {
					Mec m = new Mec();
					MecDAO mdao = new MecDAO();
					m = mdao.loadById(Mec.class, (Long) table.getModel().getValueAt(row, 0));
					if(col == table.getColumnCount() - 2)
					{
						RezultatiMecevaUnos rmu = new RezultatiMecevaUnos();
						rmu.setVisible(true);
					}
					else if(col == table.getColumnCount() - 1)
					{
						String[] options = {"   Da!   ", "   Ne!   "};
						int confirmationResult = JOptionPane.showOptionDialog(null,
							    "Jeste li sigurni da �elite obrisati ovaj me�?",
							    "Potvrda brisanja",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE, null, options, null);
						if(confirmationResult == JOptionPane.YES_OPTION)
							{
								mdao.delete(m);
								((DefaultTableModel)table.getModel()).removeRow(row);
							}
					}
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel,
																GroupLayout.DEFAULT_SIZE,
																717,
																Short.MAX_VALUE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				txtpnNazivTurnira,
																				GroupLayout.PREFERRED_SIZE,
																				79,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				textField,
																				GroupLayout.PREFERRED_SIZE,
																				261,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																txtpnMeeviZaKoje,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
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
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				txtpnNazivTurnira,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(36)
																		.addComponent(
																				txtpnMeeviZaKoje,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 299,
												Short.MAX_VALUE)
										.addContainerGap()));

		// JTableUtil jtutil = new JTableUtil();
		// table.setModel(jtutil.populateJTableMecevi(t));
		// PrepareTableDesign(table);
		// panel_3.setLayout(new BorderLayout());
		// panel_3.add(table.getTableHeader(), BorderLayout.NORTH);
		// panel_3.add(new JScrollPane(table), BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
	}
}
