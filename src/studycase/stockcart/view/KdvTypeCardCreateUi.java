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
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KdvTypeCardCreateUi extends JInternalFrame {

	private JTextField kdv_type_code_textField;
	private JTextField kdv_type_name_textField;
	private KdvTypeCardController kdvTypeCardController;
	private JInternalFrame jInternalFrame;
	private JTextField kdv_type_ratio_textField;

	private void Clear() {

		kdv_type_code_textField.setText("");
		kdv_type_name_textField.setText("");
		kdv_type_ratio_textField.setText("");

		// crated_date_formattedTextField.setText("");
	}

	private void init(JPanel jpanel) {
		jInternalFrame = new JInternalFrame();

		// jInternalFrame. setBounds(100, 100, 450, 300);
		jInternalFrame.setClosable(true);
		jInternalFrame.setTitle("Yeni Kdv Tip Kartı");
		try {
			jInternalFrame.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		jInternalFrame.setBounds(10, 11, 424, 225);
		jpanel.add(jInternalFrame);
		jInternalFrame.getContentPane().setLayout(null);

		JLabel kdv_type_code_lbl = new JLabel("Kdv Tip Kodu");
		kdv_type_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_code_lbl.setBounds(20, 23, 102, 19);
		jInternalFrame.getContentPane().add(kdv_type_code_lbl);

		kdv_type_code_textField = new JTextField();
		kdv_type_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_code_textField.setColumns(10);
		kdv_type_code_textField.setBounds(132, 20, 228, 25);
		jInternalFrame.getContentPane().add(kdv_type_code_textField);

		kdv_type_name_textField = new JTextField();
		kdv_type_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_name_textField.setColumns(10);
		kdv_type_name_textField.setBounds(132, 50, 228, 25);
		jInternalFrame.getContentPane().add(kdv_type_name_textField);

		JLabel kdv_type_name_lbl = new JLabel("Kdv Tip Adı");
		kdv_type_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_name_lbl.setBounds(20, 53, 102, 19);
		jInternalFrame.getContentPane().add(kdv_type_name_lbl);

		JLabel kdv_type_description_lbl = new JLabel("Kdv Oranı");
		kdv_type_description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_description_lbl.setBounds(20, 83, 165, 19);
		jInternalFrame.getContentPane().add(kdv_type_description_lbl);

		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kdvTypeCardController.Create(fill());
				Clear();
			}
		});
		btnNewButton.setBounds(273, 116, 89, 23);
		jInternalFrame.getContentPane().add(btnNewButton);

		kdv_type_ratio_textField = new JTextField();
		kdv_type_ratio_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		kdv_type_ratio_textField.setColumns(10);
		kdv_type_ratio_textField.setBounds(132, 80, 228, 25);
		jInternalFrame.getContentPane().add(kdv_type_ratio_textField);

		JMenuBar menuBar = new JMenuBar();
		jInternalFrame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("İlk Kayıt");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				var result = kdvTypeCardController.getFirstItemFromKdvType();
				try {

					
				while(result.next()) {
					kdv_type_code_textField.setText(result.getString("KdvTypeCode"));
					kdv_type_name_textField.setText(result.getString("kdvTypeName"));
					kdv_type_ratio_textField.setText(result.getString("KdvTypeRatio"));

				}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		mnNewMenu.setIcon(Constant.FIRST_ARROW_ICON);
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Geri");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
				kdvTypeCardModel.setName(kdv_type_name_textField.getText());
				var result = kdvTypeCardController.getBeforeItemFromKdvTypeTable(kdvTypeCardModel);

				try {

					while (result.next()) {

						kdv_type_name_textField.setText(result.getString("kdvTypeName"));
						kdv_type_code_textField.setText(result.getString("KdvTypeCode"));
						kdv_type_ratio_textField.setText(result.getString("KdvTypeRatio"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.setIcon(Constant.BACK_ARROW_ICON);
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("İleri");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
				kdvTypeCardModel.setName(kdv_type_name_textField.getText());
				var result = kdvTypeCardController.getAfterItemFromKdvTypeTable(kdvTypeCardModel);

				try {

					while (result.next()) {

						kdv_type_name_textField.setText(result.getString("kdvTypeName"));
						kdv_type_code_textField.setText(result.getString("KdvTypeCode"));
						kdv_type_ratio_textField.setText(result.getString("KdvTypeRatio"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_2.setIcon(Constant.FORWARD_ARROW_ICON);
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("Son Kayıt");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				var result = kdvTypeCardController.getLastItemFromStockTypeTable();
				try {

					
				while(result.next()) {
					kdv_type_code_textField.setText(result.getString("KdvTypeCode"));
					kdv_type_name_textField.setText(result.getString("kdvTypeName"));
					kdv_type_ratio_textField.setText(result.getString("KdvTypeRatio"));

				}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_3.setIcon(Constant.LAST_ARROW_ICON);
		menuBar.add(mnNewMenu_3);

		jInternalFrame.setVisible(true);
	}

	public KdvTypeCardCreateUi(JPanel jpanel, KdvTypeCardController kdvTypeCardController) {
		init(jpanel);
		this.kdvTypeCardController = kdvTypeCardController;
		this.kdvTypeCardController.Connect();

	}

	private KdvTypeCardModel fill() {
		KdvTypeCardModel kdvCardModel = new KdvTypeCardModel();

		kdvCardModel.setCode(kdv_type_code_textField.getText());
		kdvCardModel.setName(kdv_type_name_textField.getText());

		kdvCardModel.setRatio(Double.parseDouble(kdv_type_ratio_textField.getText()));
		return kdvCardModel;
	}
}
