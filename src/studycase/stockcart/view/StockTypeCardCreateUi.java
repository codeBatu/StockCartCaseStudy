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

public class StockTypeCardCreateUi {

	private JTextField stock_type_code_textField;
	private JTextField stock_type_name_textField;
	private JTextArea stock_type_description_textArea;
	private StockTypeCardController stockTypeCardController;
	private JInternalFrame jInternalFrame;

	private void Clear() {

		stock_type_code_textField.setText("");
		stock_type_name_textField.setText("");
		stock_type_description_textArea.setText("");

		// crated_date_formattedTextField.setText("");
	}

	private void init(JPanel jpanel) {
		jInternalFrame = new JInternalFrame();

		// jInternalFrame. setBounds(100, 100, 450, 300);
		jInternalFrame.setClosable(true);
		jInternalFrame.setTitle("Yeni Stok Tip Kartı");
		try {
			jInternalFrame.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		jInternalFrame.setBounds(10, 11, 602, 458);
		jpanel.add(jInternalFrame);
		jInternalFrame.getContentPane().setLayout(null);

		JLabel stock_type_code_lbl = new JLabel("Stok Tip Kodu");
		stock_type_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_code_lbl.setBounds(20, 36, 102, 19);
		jInternalFrame.getContentPane().add(stock_type_code_lbl);

		stock_type_code_textField = new JTextField();
		stock_type_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_code_textField.setColumns(10);
		stock_type_code_textField.setBounds(233, 20, 247, 52);
		jInternalFrame.getContentPane().add(stock_type_code_textField);

		stock_type_name_textField = new JTextField();
		stock_type_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_name_textField.setColumns(10);
		stock_type_name_textField.setBounds(233, 83, 247, 52);
		jInternalFrame.getContentPane().add(stock_type_name_textField);

		JLabel stock_type_name_lbl = new JLabel("Stok Tip Adı");
		stock_type_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_name_lbl.setBounds(20, 99, 102, 19);
		jInternalFrame.getContentPane().add(stock_type_name_lbl);

		JLabel stock_type_description_lbl = new JLabel("Stok Tip Açıklama");
		stock_type_description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_type_description_lbl.setBounds(20, 155, 165, 19);
		jInternalFrame.getContentPane().add(stock_type_description_lbl);

		stock_type_description_textArea = new JTextArea();
		stock_type_description_textArea.setBounds(233, 146, 247, 150);
		jInternalFrame.getContentPane().add(stock_type_description_textArea);

		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.setIcon(new ImageIcon("D:\\workspace\\java\\StudyCase\\Icons\\next.ico"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockTypeCardController.Create(fill());
				Clear();
			}
		});

		btnNewButton.setBounds(91, 307, 428, 88);
		jInternalFrame.getContentPane().add(btnNewButton);
		JMenuBar menuBar = new JMenuBar();
		jInternalFrame.setJMenuBar(menuBar);

		JMenu mnNewMenu_2 = new JMenu("İlk Kayıt");
		mnNewMenu_2.setIconTextGap(1);

		mnNewMenu_2.setIcon(Constant.FIRST_ARROW_ICON);
		mnNewMenu_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				var result = stockTypeCardController.getFirstItemFromStockType();

				try {

					result.first();
					// stock_type_code_textField.setText(result.getNString("StockTypeCode"));
					stock_type_code_textField.setText(result.getString("StockTypeCode"));
					stock_type_name_textField.setText(result.getString("StockTypeName"));
					stock_type_description_textArea.setText(result.getString("StockTypeDescription"));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_1 = new JMenu("Geri");

		mnNewMenu_1.setIcon(Constant.BACK_ARROW_ICON);
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
				stockTypeCardModel.setName(stock_type_name_textField.getText());
				var result = stockTypeCardController.getBeforeItemFromStockTypeTable(stockTypeCardModel);

				try {

					while (result.next()) {

						stock_type_name_textField.setText(result.getString("StockTypeName"));
						stock_type_code_textField.setText(result.getString("StockTypeCode"));
						stock_type_description_textArea.setText(result.getString("StockTypeDescription"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu = new JMenu("İleri");

		mnNewMenu.setIcon(Constant.FORWARD_ARROW_ICON);

		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
				stockTypeCardModel.setName(stock_type_name_textField.getText());
				var result = stockTypeCardController.getAfterItemFromStockTypeTable(stockTypeCardModel);

				try {

					while (result.next()) {
						stock_type_name_textField.setText(result.getString("StockTypeName"));
						stock_type_code_textField.setText(result.getString("StockTypeCode"));
						stock_type_description_textArea.setText(result.getString("StockTypeDescription"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_3 = new JMenu("Son Kayıt");
		

		mnNewMenu_3.setIcon(Constant.LAST_ARROW_ICON);
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				var result = stockTypeCardController.getLastItemFromStockTypeTable();

				try {

					while (result.next()) {
						stock_type_name_textField.setText(result.getString("StockTypeName"));
						stock_type_code_textField.setText(result.getString("StockTypeCode"));
						stock_type_description_textArea.setText(result.getString("StockTypeDescription"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mnNewMenu_3);

		jInternalFrame.setVisible(true);
	}

	public StockTypeCardCreateUi(JPanel jpanel, StockTypeCardController stockTypeCardController) {
		
		this.stockTypeCardController = stockTypeCardController;
		this.stockTypeCardController.Connect();
		init(jpanel);

	}

	private StockTypeCardModel fill() {
		StockTypeCardModel stockCardModel = new StockTypeCardModel();

		stockCardModel.setCode(stock_type_code_textField.getText());
		stockCardModel.setName(stock_type_name_textField.getText());
		// stockCardModel.setStockType((int) stock_type_comboBox.getSelectedItem());
		stockCardModel.setDescription(stock_type_description_textArea.getText());
		return stockCardModel;
	}
}
