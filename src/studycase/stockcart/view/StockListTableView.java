package studycase.stockcart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Component;

public class StockListTableView extends JInternalFrame {
	private JTable table;

	public JMenuItem getMenuItemExportExcel() {
		return menuItemExportExcel;
	}

	public void setMenuItemExportExcel(JMenuItem menuItemExportExcel) {
		this.menuItemExportExcel = menuItemExportExcel;
	}

	public JMenuItem getMenuItemScreen() {
		return menuItemScreen;
	}

	public void setMenuItemScreen(JMenuItem menuItemScreen) {
		this.menuItemScreen = menuItemScreen;
	}

	public JMenuItem getMenuItemSendMail() {
		return menuItemSendMail;
	}

	public void setMenuItemSendMail(JMenuItem menuItemSendMail) {
		this.menuItemSendMail = menuItemSendMail;
	}

	public JMenuItem getMenuItemGetStockCard() {
		return menuItemGetStockCard;
	}

	public void setMenuItemGetStockCard(JMenuItem menuItemGetStockCard) {
		this.menuItemGetStockCard = menuItemGetStockCard;
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

	JMenuItem menuItemExportExcel = new JMenuItem("Export Excel");
	JMenuItem menuItemScreen = new JMenuItem("Ekrana Getir");
	JMenuItem menuItemSendMail = new JMenuItem("Mail At");
	JMenuItem menuItemGetStockCard = new JMenuItem("Stok Kartı ");

	public JTable getTable() {
		return table;
	}

	JPopupMenu popupMenu = new JPopupMenu();

	public void setTable(JTable table) {
		this.table = table;
	}

	private JMenuItem mnNewMenu = new JMenu("Listele");

	public JMenuItem getMnNewMenu() {
		return mnNewMenu;
	}

	public void setMnNewMenu(JMenuItem mnNewMenu) {
		this.mnNewMenu = mnNewMenu;
	}

	public StockListTableView() throws PropertyVetoException {
		setClosable(true);
		setClosed(true);
		setBounds(100, 100, 1083, 798);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1067, 768);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1067, 768);
		panel.add(scrollPane);

		addPopup(scrollPane, popupMenu);

		table = new JTable();

		scrollPane.setViewportView(table);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuItemExportExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		popupMenu.add(menuItemExportExcel);
	
		popupMenu.add(menuItemScreen);
		popupMenu.add(menuItemSendMail);
		popupMenu.add(menuItemGetStockCard);
		table.setComponentPopupMenu(popupMenu);
		menuBar.add(mnNewMenu);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
