package studycase.stockcart.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import studycase.stockcart.controller.KdvTypeCardController;
import studycase.stockcart.controller.StockTypeCardController;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KdvTypeCardCreateUi extends JInternalFrame {
	KdvTypeCardController kdvTypeCardController;

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

	JButton btnNewButton_1 = new JButton("Kaydet");

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JMenu getMnNewMenu() {
		return mnNewMenu;
	}

	public void setMnNewMenu(JMenu mnNewMenu) {
		this.mnNewMenu = mnNewMenu;
	}

	public JMenu getMnNewMenu_1() {
		return mnNewMenu_1;
	}

	public void setMnNewMenu_1(JMenu mnNewMenu_1) {
		this.mnNewMenu_1 = mnNewMenu_1;
	}

	public JMenu getMnNewMenu_2() {
		return mnNewMenu_2;
	}

	public void setMnNewMenu_2(JMenu mnNewMenu_2) {
		this.mnNewMenu_2 = mnNewMenu_2;
	}

	public JMenu getMnNewMenu_3() {
		return mnNewMenu_3;
	}

	public void setMnNewMenu_3(JMenu mnNewMenu_3) {
		this.mnNewMenu_3 = mnNewMenu_3;
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
	JMenu mnNewMenu = new JMenu("İlk Kayıt");
	JMenu mnNewMenu_1 = new JMenu("Geri");
	JMenu mnNewMenu_2 = new JMenu("İleri");
	JMenu mnNewMenu_3 = new JMenu("Son Kayıt");

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
		this.setBounds(10, 11, 424, 225);

		this.getContentPane().setLayout(null);

		JLabel kdv_type_code_lbl = new JLabel("Kdv Tip Kodu");
		kdv_type_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_code_lbl.setBounds(20, 23, 102, 19);
		this.getContentPane().add(kdv_type_code_lbl);

		kdv_type_code_textField = new JTextField();
		kdv_type_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_code_textField.setColumns(10);
		kdv_type_code_textField.setBounds(132, 20, 228, 25);
		this.getContentPane().add(kdv_type_code_textField);

		kdv_type_name_textField = new JTextField();
		kdv_type_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_name_textField.setColumns(10);
		kdv_type_name_textField.setBounds(132, 50, 228, 25);
		this.getContentPane().add(kdv_type_name_textField);

		JLabel kdv_type_name_lbl = new JLabel("Kdv Tip Adı");
		kdv_type_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_name_lbl.setBounds(20, 53, 102, 19);
		this.getContentPane().add(kdv_type_name_lbl);

		JLabel kdv_type_description_lbl = new JLabel("Kdv Oranı");
		kdv_type_description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_description_lbl.setBounds(20, 83, 165, 19);
		this.getContentPane().add(kdv_type_description_lbl);

		kdv_type_ratio_textField = new JTextField();
		kdv_type_ratio_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_ratio_textField.setColumns(10);
		kdv_type_ratio_textField.setBounds(132, 80, 228, 25);
		this.getContentPane().add(kdv_type_ratio_textField);

		btnNewButton_1.setBounds(271, 116, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		
		lblNewLabel.setBounds(360, 0, 38, 14);
		getContentPane().add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		mnNewMenu.setIcon(Constant.FIRST_ARROW_ICON);
		menuBar.add(mnNewMenu);

		mnNewMenu_1.setIcon(Constant.BACK_ARROW_ICON);
		menuBar.add(mnNewMenu_1);

		mnNewMenu_2.setIcon(Constant.FORWARD_ARROW_ICON);
		menuBar.add(mnNewMenu_2);

	
		mnNewMenu_3.setIcon(Constant.LAST_ARROW_ICON);
		menuBar.add(mnNewMenu_3);

		this.setVisible(true);
	}

	public KdvTypeCardCreateUi() {
		init();
	}

	private KdvTypeCardModel fill() {
		KdvTypeCardModel kdvCardModel = new KdvTypeCardModel();

		kdvCardModel.setCode(kdv_type_code_textField.getText());
		kdvCardModel.setName(kdv_type_name_textField.getText());

		kdvCardModel.setRatio(Double.parseDouble(kdv_type_ratio_textField.getText()));
		return kdvCardModel;
	}
}
