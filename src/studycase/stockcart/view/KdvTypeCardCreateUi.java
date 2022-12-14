package studycase.stockcart.view;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import studycase.stockcart.controller.KdvTypeCardControllerCommand;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.util.Constant;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.Component;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class KdvTypeCardCreateUi extends JInternalFrame {
	public JButton getFirstItemButton() {
		return firstItemButton;
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

	private final JButton firstItemButton = new JButton("İlk Kayıt");
	private final JButton previusItemButton = new JButton("Geri");

	private final JButton forwardItemBtn = new JButton("İleri");
	private final JButton lastItemButton = new JButton("Son Kayıt");
	KdvTypeCardControllerCommand kdvTypeCardController;

	public JTextField getKdv_type_code_textField() {
		return kdv_type_code_textField;
	}

	public void setKdv_type_code_textField(JTextField kdv_type_code_textField) {
		this.kdv_type_code_textField = kdv_type_code_textField;
	}

	public JTextField getKdv_type_name_textField() {
		return kdv_type_name_textField;
	}

	public void setKdv_type_name_textField(JTextField kdv_type_name_textField) {
		this.kdv_type_name_textField = kdv_type_name_textField;
	}

	public JTextField getKdv_type_ratio_textField() {
		return kdv_type_ratio_textField;
	}

	public void setKdv_type_ratio_textField(JTextField kdv_type_ratio_textField) {
		this.kdv_type_ratio_textField = kdv_type_ratio_textField;
	}

	JButton save_Button = new JButton("Kaydet");

	public JButton getSaveButton() {
		return save_Button;
	}

	public void setSaveButton(JButton btnNewButton_1) {
		this.save_Button = btnNewButton_1;
	}

	public JMenu getMnNewMenu() {
		return firstRecordMenuItem;
	}

	public void setMnNewMenu(JMenu mnNewMenu) {
		this.firstRecordMenuItem = mnNewMenu;
	}

	public JMenu getMnNewMenu_1() {
		return previusRecordMenuItem;
	}

	public void setMnNewMenu_1(JMenu mnNewMenu_1) {
		this.previusRecordMenuItem = mnNewMenu_1;
	}

	public JMenu getMnNewMenu_2() {
		return forwardRecordMenuItem;
	}

	public void setMnNewMenu_2(JMenu mnNewMenu_2) {
		this.forwardRecordMenuItem = mnNewMenu_2;
	}

	public JMenu getMnNewMenu_3() {
		return lastRecordMenuItem;
	}

	public void setMnNewMenu_3(JMenu mnNewMenu_3) {
		this.lastRecordMenuItem = mnNewMenu_3;
	}

	JLabel lblNewLabel = new JLabel("id");

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	private JTextField kdv_type_code_textField;
	private JTextField kdv_type_name_textField;

	private JTextField kdv_type_ratio_textField;
	JMenu firstRecordMenuItem = new JMenu("İlk Kayıt");
	JMenu previusRecordMenuItem = new JMenu("Geri");
	JMenu forwardRecordMenuItem = new JMenu("İleri");
	JMenu lastRecordMenuItem = new JMenu("Son Kayıt");
	private final JButton delete_button = new JButton("Sil");

	public JButton getDelete_button() {
		return delete_button;
	}

	private void init() {

		// jInternalFrame. setBounds(100, 100, 450, 300);
		this.setClosable(true);
		this.setTitle("Yeni Kdv Tip Kartı");
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		this.setBounds(10, 11, 422, 238);
		lblNewLabel.setBounds(360, 0, 38, 14);
		lblNewLabel.setVisible(false);
		JLabel kdv_type_code_lbl = new JLabel("Kdv Tip Kodu");
		kdv_type_code_lbl.setBounds(20, 23, 102, 19);
		kdv_type_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		kdv_type_code_textField = new JTextField();
		kdv_type_code_textField.setBounds(132, 20, 228, 25);
		kdv_type_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_code_textField.setColumns(10);

		kdv_type_name_textField = new JTextField();
		kdv_type_name_textField.setBounds(132, 50, 228, 25);
		kdv_type_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_name_textField.setColumns(10);

		JLabel kdv_type_name_lbl = new JLabel("Kdv Tip Adı");
		kdv_type_name_lbl.setBounds(20, 53, 102, 19);
		kdv_type_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel kdv_type_description_lbl = new JLabel("Kdv Oranı");
		kdv_type_description_lbl.setBounds(20, 83, 165, 19);
		kdv_type_description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_ratio_textField = new JTextField();
		kdv_type_ratio_textField.setBounds(132, 80, 228, 25);
		kdv_type_ratio_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_ratio_textField.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(kdv_type_code_lbl);
		getContentPane().add(kdv_type_code_textField);
		getContentPane().add(kdv_type_name_lbl);
		getContentPane().add(kdv_type_name_textField);
		getContentPane().add(kdv_type_description_lbl);
		getContentPane().add(kdv_type_ratio_textField);
		save_Button.setBounds(178, 143, 89, 23);
		getContentPane().add(save_Button);
		delete_button.setBounds(271, 143, 89, 23);
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

	public KdvTypeCardCreateUi() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		init();
	}
}
