package studycase.stockcart.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrames extends JFrame {

	public JMenuItem mntmNewMenuItem = new JMenuItem("Stok Listesi");
	private JDesktopPane desktopPane;
private	JMenuItem mntmNewMenuItem_1 = new JMenuItem("Yeni Stok Kartı");
private JMenuItem mntmNewMenuItem_3 = new JMenuItem("Kdv Tip Kartı");
JMenuItem mntmNewMenuItem_2 = new JMenuItem("Yeni Stok Tip Kartı");
	public JMenuItem getMntmNewMenuItem_2() {
	return mntmNewMenuItem_2;
}

public void setMntmNewMenuItem_2(JMenuItem mntmNewMenuItem_2) {
	this.mntmNewMenuItem_2 = mntmNewMenuItem_2;
}

	public JMenuItem getMntmNewMenuItem_3() {
	return mntmNewMenuItem_3;
}

public void setMntmNewMenuItem_3(JMenuItem mntmNewMenuItem_3) {
	this.mntmNewMenuItem_3 = mntmNewMenuItem_3;
	
}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public JMenuItem getMntmNewMenuItem() {
		return mntmNewMenuItem;
	}

	public void setMntmNewMenuItem(JMenuItem mntmNewMenuItem) {
		this.mntmNewMenuItem = mntmNewMenuItem;
	}

	public JMenuItem getmntmNewMenuItem_1() {
		return mntmNewMenuItem_1;
	}

	public void setmntmNewMenuItem_1(JMenuItem mntmNewMenuItem) {
		this.mntmNewMenuItem = mntmNewMenuItem;
	}

	/**
	 * Create the frame.
	 */
	public MainFrames() {
		desktopPane = new JDesktopPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1926, 1057);
		getContentPane().add(panel);
		panel.setLayout(null);

		desktopPane.setBounds(0, 0, 1926, 1057);
		panel.add(desktopPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1926, 22);
		desktopPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Stok Kartı");
		menuBar.add(mnNewMenu);

		mnNewMenu.add(mntmNewMenuItem);

	

		
		mnNewMenu.add(mntmNewMenuItem_1);
		
	

		
	
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Kdv Kartı");
		menuBar.add(mnNewMenu_1);

		
	
		mnNewMenu_1.add(mntmNewMenuItem_3);
		// contentPane.add(desktopPane);

	}
}
