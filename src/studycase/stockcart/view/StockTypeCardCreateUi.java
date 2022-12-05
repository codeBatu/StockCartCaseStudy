package studycase.stockcart.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import studycase.stockcart.controller.StockTypeCardController;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StockTypeCardCreateUi extends JInternalFrame {

	private JTextField stock_type_code_textField;

	public JTextField getStock_type_code_textField() {
		return stock_type_code_textField;
	}

	public void setStock_type_code_textField(JTextField stock_type_code_textField) {
		this.stock_type_code_textField = stock_type_code_textField;
	}

	public JTextField getStock_type_name_textField() {
		return stock_type_name_textField;
	}

	public void setStock_type_name_textField(JTextField stock_type_name_textField) {
		this.stock_type_name_textField = stock_type_name_textField;
	}

	public JTextArea getStock_type_description_textArea() {
		return stock_type_description_textArea;
	}

	public void setStock_type_description_textArea(JTextArea stock_type_description_textArea) {
		this.stock_type_description_textArea = stock_type_description_textArea;
	}

	public JMenu getMnNewMenu_2() {
		return mnNewMenu_2;
	}

	public void setMnNewMenu_2(JMenu mnNewMenu_2) {
		this.mnNewMenu_2 = mnNewMenu_2;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JMenu getMnNewMenu_1() {
		return mnNewMenu_1;
	}

	public void setMnNewMenu_1(JMenu mnNewMenu_1) {
		this.mnNewMenu_1 = mnNewMenu_1;
	}

	public JMenu getMnNewMenu() {
		return mnNewMenu;
	}

	public void setMnNewMenu(JMenu mnNewMenu) {
		this.mnNewMenu = mnNewMenu;
	}
	

	public JMenu getMnNewMenu_3() {
		return mnNewMenu_3;
	}

	public void setMnNewMenu_3(JMenu mnNewMenu_3) {
		this.mnNewMenu_3 = mnNewMenu_3;
	}

	private JTextField stock_type_name_textField;
	private JTextArea stock_type_description_textArea;
	private StockTypeCardController stockTypeCardController;
	JMenu mnNewMenu_2 = new JMenu("İlk Kayıt");
	JButton btnNewButton = new JButton("Kaydet");
	JMenu mnNewMenu_1 = new JMenu("Geri");
	JMenu mnNewMenu = new JMenu("İleri");
	JMenu mnNewMenu_3 = new JMenu("Son Kayıt");
	private final JLabel lblNewLabel = new JLabel("id");

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	private void Clear() {

		stock_type_code_textField.setText("");
		stock_type_name_textField.setText("");
		stock_type_description_textArea.setText("");

		// crated_date_formattedTextField.setText("");

	}

	private void init() {

		// jInternalFrame. setBounds(100, 100, 450, 300);
		this.setClosable(true);
		this.setTitle("Yeni Stok Tip Kartı");
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		this.setBounds(10, 11, 602, 458);

		this.getContentPane().setLayout(null);

		JLabel stock_type_code_lbl = new JLabel("Stok Tip Kodu");
		stock_type_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_code_lbl.setBounds(20, 36, 102, 19);
		this.getContentPane().add(stock_type_code_lbl);

		stock_type_code_textField = new JTextField();
		stock_type_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_code_textField.setColumns(10);
		stock_type_code_textField.setBounds(233, 20, 247, 52);
		this.getContentPane().add(stock_type_code_textField);

		stock_type_name_textField = new JTextField();
		stock_type_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_name_textField.setColumns(10);
		stock_type_name_textField.setBounds(233, 83, 247, 52);
		this.getContentPane().add(stock_type_name_textField);

		JLabel stock_type_name_lbl = new JLabel("Stok Tip Adı");
		stock_type_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_name_lbl.setBounds(20, 99, 102, 19);
		this.getContentPane().add(stock_type_name_lbl);

		JLabel stock_type_description_lbl = new JLabel("Stok Tip Açıklama");
		stock_type_description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_description_lbl.setBounds(20, 155, 165, 19);
		this.getContentPane().add(stock_type_description_lbl);

		stock_type_description_textArea = new JTextArea();
		stock_type_description_textArea.setBounds(233, 146, 247, 150);
		this.getContentPane().add(stock_type_description_textArea);

		btnNewButton.setBounds(91, 307, 428, 88);
		this.getContentPane().add(btnNewButton);
		lblNewLabel.setBounds(491, 0, 46, 14);
		
		getContentPane().add(lblNewLabel);
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		mnNewMenu_2.setIconTextGap(1);

		mnNewMenu_2.setIcon(Constant.FIRST_ARROW_ICON);

		menuBar.add(mnNewMenu_2);

		mnNewMenu_1.setIcon(Constant.BACK_ARROW_ICON);

		menuBar.add(mnNewMenu_1);

		mnNewMenu.setIcon(Constant.FORWARD_ARROW_ICON);

		menuBar.add(mnNewMenu);

		mnNewMenu_3.setIcon(Constant.LAST_ARROW_ICON);

		menuBar.add(mnNewMenu_3);

		this.setVisible(true);
	}

	public StockTypeCardCreateUi() {

		init();

	}

}
