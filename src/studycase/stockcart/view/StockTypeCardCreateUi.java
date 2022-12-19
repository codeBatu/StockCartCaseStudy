package studycase.stockcart.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import studycase.stockcart.controller.StockTypeCardControllerCommand;
import studycase.stockcart.util.Constant;

public class StockTypeCardCreateUi extends JInternalFrame {

	private JTextField stock_type_code_textField;

	public JTextField getStock_type_code_textField() {
		return stock_type_code_textField;
	}

	public void setStock_type_code_textField(JTextField stock_type_code_textField) {
		this.stock_type_code_textField = stock_type_code_textField;
	}



	public JTextArea getStock_type_description_textArea() {
		return stock_type_description_textArea;
	}

	public void setStock_type_description_textArea(JTextArea stock_type_description_textArea) {
		this.stock_type_description_textArea = stock_type_description_textArea;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	private JTextField stock_type_name_textField;
	private JTextArea stock_type_description_textArea;

	JButton btnNewButton = new JButton("Kaydet");
	private final JLabel lblNewLabel = new JLabel("id");

	public JLabel getLblNewLabel() {
		return lblNewLabel;

	}

	JButton delete_button = new JButton("Sil");
	private JButton firstItemButton = new JButton("İlk Kayıt");
	private JButton previusItemButton = new JButton("Geri");
	private final JButton forwardItemBtn = new JButton("İleri");
	private final JButton lastItemButton = new JButton("Son Kayıt");

	public JButton getPreviusItemButton() {
		return previusItemButton;
	}

	public void setPreviusItemButton(JButton previusItemButton) {
		this.previusItemButton = previusItemButton;
	}

	public JButton getFirstItemButton() {
		return firstItemButton;
	}

	public void setFirstItemButton(JButton firstItemButton) {
		this.firstItemButton = firstItemButton;
	}

	public JButton getDelete_button() {
		return delete_button;
	}

	public void setDelete_button(JButton delete_button) {
		this.delete_button = delete_button;
	}

	

	private void init() {

		// jInternalFrame. setBounds(100, 100, 450, 300);
		this.setClosable(true);
		this.setTitle("Yeni Stok Tip Kartı");

		// jInternalFrame().setLayout(null);
		this.setBounds(10, 11, 395, 388);

		this.getContentPane().setLayout(null);

		JLabel stock_type_code_lbl = new JLabel("Stok Tip Kodu");
		stock_type_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_code_lbl.setBounds(20, 11, 102, 19);
		this.getContentPane().add(stock_type_code_lbl);

		stock_type_code_textField = new JTextField();
		stock_type_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_code_textField.setColumns(10);
		stock_type_code_textField.setBounds(176, 11, 198, 19);
		this.getContentPane().add(stock_type_code_textField);

		setStock_type_name_textField(new JTextField());
		getStock_type_name_textField().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getStock_type_name_textField().setColumns(10);
		getStock_type_name_textField().setBounds(176, 41, 198, 19);
		this.getContentPane().add(getStock_type_name_textField());

		JLabel stock_type_name_lbl = new JLabel("Stok Tip Adı");
		stock_type_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_name_lbl.setBounds(20, 41, 102, 19);
		this.getContentPane().add(stock_type_name_lbl);

		JLabel stock_type_description_lbl = new JLabel("Stok Tip Açıklama");
		stock_type_description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_description_lbl.setBounds(20, 71, 165, 19);
		this.getContentPane().add(stock_type_description_lbl);

		stock_type_description_textArea = new JTextArea();
		stock_type_description_textArea.setBorder(UIManager.getBorder("TextField.border"));
		stock_type_description_textArea.setBackground(Color.WHITE);
		stock_type_description_textArea.setBounds(176, 71, 198, 55);
		this.getContentPane().add(stock_type_description_textArea);

		btnNewButton.setBounds(129, 136, 102, 29);
		this.getContentPane().add(btnNewButton);
		lblNewLabel.setBounds(491, 0, 46, 14);

		getContentPane().add(lblNewLabel);
		delete_button.setFocusTraversalPolicyProvider(true);
		delete_button.setFocusCycleRoot(true);

		delete_button.setBounds(241, 137, 119, 27);
		getContentPane().add(delete_button);
		
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		this.setJMenuBar(menuBar);
		firstItemButton.setBackground(Color.WHITE);
		firstItemButton.setBorderPainted(false);
		firstItemButton.setIcon(Constant.FIRST_ARROW_ICON);

		menuBar.add(firstItemButton);
		lblNewLabel.setVisible(false);
		previusItemButton.setBorderPainted(false);
		previusItemButton.setBackground(Color.WHITE);
		previusItemButton.setIcon(Constant.BACK_ARROW_ICON);

		menuBar.add(previusItemButton);
		getForwardItemBtn().setBorderPainted(false);
		getForwardItemBtn().setBackground(Color.WHITE);
		getForwardItemBtn().setIcon(Constant.FORWARD_ARROW_ICON);
		menuBar.add(getForwardItemBtn());
		lastItemButton.setBorderPainted(false);
		lastItemButton.setBackground(Color.WHITE);
		getLastItemButton().setIcon(Constant.LAST_ARROW_ICON);

		menuBar.add(getLastItemButton());

	}

	public StockTypeCardCreateUi() {
		setAutoscrolls(true);
		setFocusTraversalPolicyProvider(true);
		getContentPane().setEnabled(false);
		getContentPane().setBackground(Color.WHITE);

		init();

	}

	/**
	 * @return the forwardItemBtn
	 */
	public JButton getForwardItemBtn() {
		return forwardItemBtn;
	}

	/**
	 * @return the lastItemButton
	 */
	public JButton getLastItemButton() {
		return lastItemButton;
	}

	/**
	 * @return the stock_type_name_textField
	 */
	public JTextField getStock_type_name_textField() {
		return stock_type_name_textField;
	}

	/**
	 * @param stock_type_name_textField the stock_type_name_textField to set
	 */
	public void setStock_type_name_textField(JTextField stock_type_name_textField) {
		this.stock_type_name_textField = stock_type_name_textField;
	}
}
