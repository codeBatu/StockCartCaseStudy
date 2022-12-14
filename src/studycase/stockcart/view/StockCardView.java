
package studycase.stockcart.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import studycase.stockcart.util.Constant;

public class StockCardView extends JInternalFrame {

	public JTextField getStock_code_textField() {
		return stock_code_textField;

	}

	public void setStock_code_textField(JTextField stock_code_textField) {

		this.stock_code_textField = stock_code_textField;
	}

	public JTextField getBarcode_textField() {
		return barcode_textField;
	}

	public void setBarcode_textField(JTextField barcode_textField) {
		this.barcode_textField = barcode_textField;
	}

	public JButton getSave_btnNewButton() {
		return save_Button;
	}

	public void setSave_btnNewButton(JButton save_btnNewButton) {
		this.save_Button = save_btnNewButton;
	}

	public JTextField getStock_name_textField() {
		return stock_name_textField;
	}

	public void setStock_name_textField(JTextField stock_name_textField) {
		this.stock_name_textField = stock_name_textField;
	}

	public JFormattedTextField getCrated_date_formattedTextField() {
		return crated_date_formattedTextField;
	}

	public void setCrated_date_formattedTextField(JFormattedTextField crated_date_formattedTextField) {
		this.crated_date_formattedTextField = crated_date_formattedTextField;
	}

	public JComboBox getStock_type_comboBox() {
		return stock_type_comboBox;
	}

	public void setStock_type_comboBox(JComboBox<Integer> stock_type_comboBox) {
		this.stock_type_comboBox = stock_type_comboBox;
	}

	public JComboBox<Integer> getKdv_type_comboBox2() {
		return kdv_type_comboBox2;
	}

	public void setKdv_type_comboBox2(JComboBox<Integer> kdv_type_comboBox2) {
		this.kdv_type_comboBox2 = kdv_type_comboBox2;
	}

	public JComboBox<String> getUnit_comboBox() {
		return unit_comboBox;
	}

	public void setUnit_comboBox(JComboBox<String> unit_comboBox) {
		this.unit_comboBox = unit_comboBox;
	}

	public JTextArea getDescription_textArea() {
		return description_textArea;
	}

	public void setDescription_textArea(JTextArea description_textArea) {
		this.description_textArea = description_textArea;
	}

	private JButton firstItemButton = new JButton("İlk Kayıt");

	public JButton getFirstItemButton() {
		return firstItemButton;
	}

	public void setFirstItemButton(JButton firstItemButton) {
		this.firstItemButton = firstItemButton;
	}

	public JButton getPreviusItemButton() {
		return previusItemButton;
	}

	public JButton getForwardItemBtn() {
		return forwardItemBtn;
	}

	public JButton getLastItemButton() {
		return lastItemButton;
	}

	private final JButton previusItemButton = new JButton("Geri");
	private final JButton forwardItemBtn = new JButton("İleri");
	private final JButton lastItemButton = new JButton("Son Kayıt");

	private JTextField stock_code_textField = new JTextField();;

	private JTextField barcode_textField = new JTextField();

	private JButton save_Button = new JButton("Kaydet");

	private JTextField stock_name_textField = new JTextField();;

	private JFormattedTextField crated_date_formattedTextField;

	private JComboBox<Integer> stock_type_comboBox = new JComboBox<>();;;

	private JComboBox<Integer> kdv_type_comboBox2 = new JComboBox<>();;
	private JComboBox<String> unit_comboBox = new JComboBox();

	private JTextArea description_textArea;
	private JMenu mnNewMenu_2 = new JMenu("İlk Kayıt");

	public JMenu getMnNewMenu_2() {

		return mnNewMenu_2;
	}

	public void setMnNewMenu_2(JMenu mnNewMenu_2) {
		this.mnNewMenu_2 = mnNewMenu_2;
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

	private JMenu mnNewMenu_1 = new JMenu("Geri");
	private JMenu mnNewMenu = new JMenu("İleri");
	private JMenu mnNewMenu_3 = new JMenu("Son Kayıt");

	public JButton getUpdate_btnNewButton() {
		return update_btnNewButton;
	}

	public void setUpdate_btnNewButton(JButton update_btnNewButton) {
		this.update_btnNewButton = update_btnNewButton;
	}

	public JButton getDelete_btnNewButton() {
		return delete_btnNewButton;
	}

	public void setDelete_btnNewButton(JButton delete_btnNewButton) {
		this.delete_btnNewButton = delete_btnNewButton;
	}

	private JButton update_btnNewButton = new JButton("Güncelle");
	private JButton delete_btnNewButton = new JButton("Sil");

	public StockCardView() {
		setClosable(true);

		setBounds(100, 100, 1083, 798);
		getContentPane().setLayout(null);
		init();

	}

	public void init() {
		kdv_type_comboBox2.setEditable(true);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// jInternalFrame. setBounds(100, 100, 450, 300);
		this.setClosable(true);
		this.setTitle(" Stok  Kartı");

		// jInternalFrame().setLayout(null);
		this.setBounds(10, 11, 994, 352);

		this.getContentPane().setLayout(null);

		JLabel stock_code_lbl = new JLabel("Stok Kodu");
		stock_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_code_lbl.setBounds(14, 11, 102, 19);
		this.getContentPane().add(stock_code_lbl);

		stock_code_textField = new JTextField();
		stock_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_code_textField.setColumns(10);
		stock_code_textField.setBounds(142, 11, 248, 19);
		this.getContentPane().add(stock_code_textField);

		stock_name_textField = new JTextField();
		stock_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_name_textField.setColumns(10);
		stock_name_textField.setBounds(233, 83, 247, 52);
		this.getContentPane().add(stock_code_textField);
		JLabel stock_name_lbl = new JLabel("Stok Adı");
		stock_name_lbl.setBounds(14, 41, 86, 25);

		stock_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.getContentPane().add(stock_name_lbl);
		stock_name_textField = new JTextField();
		stock_name_textField.setBounds(142, 41, 248, 19);

		stock_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_name_textField.setColumns(10);
		this.getContentPane().add(stock_name_textField);
		JLabel stock_type_lbl = new JLabel("Stok Tipi");
		stock_type_lbl.setBounds(14, 70, 78, 25);
		this.getContentPane().add(stock_type_lbl);
		stock_type_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel barcode_lbl = new JLabel("Barkodu");
		barcode_lbl.setBounds(14, 103, 78, 25);
		this.getContentPane().add(barcode_lbl);
		barcode_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		barcode_textField.setBounds(143, 105, 247, 20);
		this.getContentPane().add(barcode_textField);
		barcode_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		barcode_textField.setColumns(10);

		JLabel description_lbl = new JLabel("Açıklama");
		description_lbl.setBounds(14, 139, 78, 25);
		this.getContentPane().add(description_lbl);
		description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		description_textArea = new JTextArea();
		description_textArea.setBounds(142, 139, 247, 59);
		this.getContentPane().add(description_textArea);
		description_textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

		JLabel created_date_lbl = new JLabel("Oluşturma Tarihi");
		created_date_lbl.setBounds(441, 88, 124, 25);
		this.getContentPane().add(created_date_lbl);
		created_date_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		crated_date_formattedTextField = new JFormattedTextField(dateFormat);
		crated_date_formattedTextField.setBounds(575, 88, 248, 25);
		this.getContentPane().add(crated_date_formattedTextField);
		crated_date_formattedTextField.setValue(new Date());
		crated_date_formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel kdv_type_lbl = new JLabel("Kdv Tipi");
		kdv_type_lbl.setBounds(441, 11, 78, 25);
		this.getContentPane().add(kdv_type_lbl);
		kdv_type_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel unit_lbl = new JLabel("Birimi");
		unit_lbl.setBounds(441, 47, 78, 25);
		this.getContentPane().add(unit_lbl);
		unit_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		save_Button.setBounds(198, 223, 190, 46);
		this.getContentPane().add(save_Button);

		save_Button.setFont(new Font("Tahoma", Font.PLAIN, 15));

		update_btnNewButton.setBounds(397, 225, 190, 43);
		this.getContentPane().add(update_btnNewButton);

		update_btnNewButton.setForeground(Color.BLACK);
		update_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		delete_btnNewButton.setBounds(597, 226, 190, 40);
		this.getContentPane().add(delete_btnNewButton);

		delete_btnNewButton.setBackground(Color.RED);
		delete_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		stock_type_comboBox.setBounds(142, 71, 247, 22);
		this.getContentPane().add(stock_type_comboBox);

		kdv_type_comboBox2 = new JComboBox<>();

		kdv_type_comboBox2.setBounds(575, 11, 247, 22);
		this.getContentPane().add(kdv_type_comboBox2);

		unit_comboBox.addItem("metre");
		unit_comboBox.setBounds(575, 44, 247, 22);
		this.getContentPane().add(unit_comboBox);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
//
//		mnNewMenu_2.setIcon(Constant.FIRST_ARROW_ICON);
//
//		menuBar.add(mnNewMenu_2);
//
//		mnNewMenu_1.setIcon(Constant.BACK_ARROW_ICON);
//
//		menuBar.add(mnNewMenu_1);
//
//		mnNewMenu.setIcon(Constant.FORWARD_ARROW_ICON);
//
//		menuBar.add(mnNewMenu);
//
//		mnNewMenu_3.setIcon(Constant.LAST_ARROW_ICON);
////		
//		menuBar.add(mnNewMenu_3);
		menuBar.setBackground(Color.WHITE);
		this.setJMenuBar(menuBar);
		firstItemButton.setBackground(Color.WHITE);
		firstItemButton.setBorderPainted(false);
		firstItemButton.setIcon(Constant.FIRST_ARROW_ICON);

		menuBar.add(firstItemButton);

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

		this.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {

	}

}
