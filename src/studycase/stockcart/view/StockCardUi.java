package studycase.stockcart.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import studycase.stockcart.controller.KdvTypeCardController;
import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.controller.StockTypeCardController;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.TextArea;

public class StockCardUi extends javax.swing.JFrame {
	private StockTypeCardController stockTypeCardController;
	private JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItemAdd = new JMenuItem("Export Excel");
	public JPanel contentPane = new JPanel();
	public JTextField stock_code_textField = new JTextField();;

	public JTextField barcode_textField = new JTextField();

	public JButton save_btnNewButton = new JButton("Kaydet");

	public JTextField stock_name_textField = new JTextField();;

	public JFormattedTextField crated_date_formattedTextField;
	private StockCardController stockCardController;

//	private JComboBox<Double> kdv_type_comboBox = new JComboBox<>();;
	public JComboBox<Integer> stock_type_comboBox = new JComboBox<>();;;

	public JComboBox<Integer> kdv_type_comboBox2 = new JComboBox<>();;;
	public JComboBox<String> unit_comboBox = new JComboBox();
	private JInternalFrame jInternalFrame;
	public JTextArea description_textArea;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	private JTable table_3;

	public StockCardUi() {

		// this.stockCardController = stockCardController;
		// stockCardController.Connect();
		init(contentPane);

		try {
			stockTypecomboboxFill();
			kdvTypecomboboxFill();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private StockCardModel fill() {
		StockCardModel stockCardModel = new StockCardModel();

		stockCardModel.setStockCod(stock_code_textField.getText());
		stockCardModel.setStockName(stock_name_textField.getText());
		stockCardModel.setStockType((int) stock_type_comboBox.getSelectedItem());
		stockCardModel.setUnit(unit_comboBox.getSelectedItem().toString());
		stockCardModel.setBarcode(barcode_textField.getText());
		stockCardModel.setKdvType((int) kdv_type_comboBox2.getSelectedItem());
		stockCardModel.setDescription(description_textArea.getText());
		stockCardModel.setCratedDate(crated_date_formattedTextField.getText());
		return stockCardModel;
	}

	private void Clear() {

		stock_code_textField.setText("");
		stock_code_textField.setText("");
		stock_name_textField.setText("");
		barcode_textField.setText("");
		description_textArea.setText("");
		// crated_date_formattedTextField.setText("");
	}

	private void stockTypecomboboxFill() throws SQLException {

		// var rs = this.stockCardController.getStockTypeByKdvTypeId();
		// while (rs.next()) {
		// stock_type_comboBox.addItem(rs.getInt("StockId"));
//		}

	}

	private void kdvTypecomboboxFill() throws SQLException {

//		var rs = stockCardController.getKdvTypeTable();
//		try {
//			while (rs.next()) {
//				kdv_type_comboBox2.addItem(rs.getInt("KdvTypeId"));
//
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

	}

	private void init(JPanel jpanel) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		jInternalFrame = new JInternalFrame();

		// jInternalFrame. setBounds(100, 100, 450, 300);
		jInternalFrame.setClosable(true);
		jInternalFrame.setTitle(" Stok  Kartı");
		try {
			jInternalFrame.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		jInternalFrame.setBounds(10, 11, 994, 352);
		;
		jpanel.add(jInternalFrame);
		jInternalFrame.getContentPane().setLayout(null);

		JLabel stock_code_lbl = new JLabel("Stok Kodu");
		stock_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_code_lbl.setBounds(14, 11, 102, 19);
		jInternalFrame.getContentPane().add(stock_code_lbl);

		stock_code_textField = new JTextField();
		stock_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_code_textField.setColumns(10);
		stock_code_textField.setBounds(142, 11, 248, 19);
		jInternalFrame.getContentPane().add(stock_code_textField);

		stock_name_textField = new JTextField();
		stock_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_name_textField.setColumns(10);
		stock_name_textField.setBounds(233, 83, 247, 52);
		jInternalFrame.getContentPane().add(stock_code_textField);
		JLabel stock_name_lbl = new JLabel("Stok Adı");
		stock_name_lbl.setBounds(14, 41, 86, 25);

		stock_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jInternalFrame.getContentPane().add(stock_name_lbl);
		stock_name_textField = new JTextField();
		stock_name_textField.setBounds(142, 41, 248, 19);

		stock_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_name_textField.setColumns(10);
		jInternalFrame.getContentPane().add(stock_name_textField);
		JLabel stock_type_lbl = new JLabel("Stok Tipi");
		stock_type_lbl.setBounds(14, 70, 78, 25);
		jInternalFrame.getContentPane().add(stock_type_lbl);
		stock_type_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel barcode_lbl = new JLabel("Barkodu");
		barcode_lbl.setBounds(14, 103, 78, 25);
		jInternalFrame.getContentPane().add(barcode_lbl);
		barcode_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		barcode_textField.setBounds(143, 105, 247, 20);
		jInternalFrame.getContentPane().add(barcode_textField);
		barcode_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		barcode_textField.setColumns(10);

		JLabel description_lbl = new JLabel("Açıklama");
		description_lbl.setBounds(14, 139, 78, 25);
		jInternalFrame.getContentPane().add(description_lbl);
		description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		description_textArea = new JTextArea();
		description_textArea.setBounds(142, 139, 247, 59);
		jInternalFrame.getContentPane().add(description_textArea);
		description_textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

		JLabel created_date_lbl = new JLabel("Oluşturma Tarihi");
		created_date_lbl.setBounds(441, 88, 124, 25);
		jInternalFrame.getContentPane().add(created_date_lbl);
		created_date_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		crated_date_formattedTextField = new JFormattedTextField(dateFormat);
		crated_date_formattedTextField.setBounds(575, 88, 248, 25);
		jInternalFrame.getContentPane().add(crated_date_formattedTextField);
		crated_date_formattedTextField.setValue(new Date());
		crated_date_formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel kdv_type_lbl = new JLabel("Kdv Tipi");
		kdv_type_lbl.setBounds(441, 11, 78, 25);
		jInternalFrame.getContentPane().add(kdv_type_lbl);
		kdv_type_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel unit_lbl = new JLabel("Birimi");
		unit_lbl.setBounds(441, 47, 78, 25);
		jInternalFrame.getContentPane().add(unit_lbl);
		unit_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		save_btnNewButton.setBounds(397, 176, 190, 46);
		jInternalFrame.getContentPane().add(save_btnNewButton);

		save_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton search_btnNewButton = new JButton("Ara");
		search_btnNewButton.setBounds(771, 228, 176, 37);
		jInternalFrame.getContentPane().add(search_btnNewButton);
		search_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table_3.setModel(DbUtils.resultSetToTableModel(
						stockCardController.getStockCartByStockCode(stock_code_textField.getText())));
			}
		});
		search_btnNewButton.setForeground(Color.BLACK);
		search_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton update_btnNewButton = new JButton("Güncelle");
		update_btnNewButton.setBounds(397, 225, 190, 43);
		jInternalFrame.getContentPane().add(update_btnNewButton);
		update_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// stockCardController.updateDb(fill());

				// stockCardController.LoadData(table_3);

			}
		});
		update_btnNewButton.setForeground(Color.BLACK);
		update_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton copy_btnNewButton = new JButton("Kopyala");
		copy_btnNewButton.setBounds(608, 228, 140, 37);
		jInternalFrame.getContentPane().add(copy_btnNewButton);
		copy_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCardModel stockCardModel = new StockCardModel();

				stockCardModel.setStockCod(stock_code_textField.getText() + "(2)");
				stockCardModel.setStockName(stock_name_textField.getText());
				// stockCardModel.setStockType((int)stock_type_comboBox.getSelectedItem());
				stockCardModel.setUnit(unit_comboBox.getSelectedItem().toString());
				stockCardModel.setBarcode(barcode_textField.getText());
				stockCardModel.setKdvType((int) kdv_type_comboBox2.getSelectedItem());
				stockCardModel.setDescription(description_textArea.getText());
				stockCardModel.setCratedDate(crated_date_formattedTextField.getText());

				// stockCardController.createDb(stockCardModel);

				// stockCardController.LoadData(table_3);
				// table.getTransferHandler().exportToClipboard(table,
				// getToolkit().getSystemClipboard(), TransferHandler.COPY);
			}
		});
		copy_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton list_tbl_btnNewButton = new JButton("Listele");
		list_tbl_btnNewButton.setBounds(777, 176, 164, 46);
		jInternalFrame.getContentPane().add(list_tbl_btnNewButton);
		list_tbl_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
				stockCardController.LoadData(table_3);
				// stockCardController.LoadData(table_3);
			}
		});
		list_tbl_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		//
		JButton delete_btnNewButton = new JButton("Sil");
		delete_btnNewButton.setBounds(608, 176, 140, 40);
		jInternalFrame.getContentPane().add(delete_btnNewButton);
		delete_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockCardController.deleteDb(stock_code_textField.getText());
				stockCardController.LoadData(table_3);
				Clear();
			}
		});

		delete_btnNewButton.setBackground(Color.RED);
		delete_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		stock_type_comboBox.setBounds(142, 71, 247, 22);
		jInternalFrame.getContentPane().add(stock_type_comboBox);

		kdv_type_comboBox2 = new JComboBox<>();

		kdv_type_comboBox2.setBounds(575, 11, 247, 22);
		jInternalFrame.getContentPane().add(kdv_type_comboBox2);

		unit_comboBox.addItem("metre");
		unit_comboBox.setBounds(575, 44, 247, 22);
		jInternalFrame.getContentPane().add(unit_comboBox);

		JMenuBar menuBar = new JMenuBar();
		jInternalFrame.setJMenuBar(menuBar);

		JMenu mnNewMenu_2 = new JMenu("İlk Kayıt");

		mnNewMenu_2.setIcon(Constant.FIRST_ARROW_ICON);
		mnNewMenu_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				ResultSet result = stockCardController.getFirstItemFromStockCard();

				try {

					result.first();
					// stock_type_code_textField.setText(result.getNString("StockTypeCode"));

					stock_code_textField.setText(result.getString("StockCode"));
					stock_name_textField.setText(result.getString("StockName"));
					stock_type_comboBox.setToolTipText(result.getString("StockType"));
					unit_comboBox.setToolTipText(result.getString("Unit"));
					barcode_textField.setText(result.getString("Barcode"));
					kdv_type_comboBox2.setToolTipText(result.getString("KdvType"));
					description_textArea.setText(result.getString("Description"));
					crated_date_formattedTextField.setText(result.getString("CreatedDate"));

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
				StockCardModel cardModel = new StockCardModel();
				cardModel.setStockCod(stock_code_textField.getText());
				ResultSet result = stockCardController.getBeforeItemFromStockCard(cardModel);

				try {

					while (result.next()) {

						try {
							stock_code_textField.setText(result.getString("StockCode"));
							stock_name_textField.setText(result.getString("StockName"));
							stock_type_comboBox.setToolTipText(result.getString("StockType"));
							unit_comboBox.setToolTipText(result.getString("Unit"));
							barcode_textField.setText(result.getString("Barcode"));
							kdv_type_comboBox2.setToolTipText(result.getString("KdvType"));
							description_textArea.setText(result.getString("Description"));
							crated_date_formattedTextField.setText(result.getString("CreatedDate"));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

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
				StockCardModel cardModel = new StockCardModel();
				cardModel.setStockCod(stock_code_textField.getText());
				ResultSet result = stockCardController.getAfterItemFromStockCard(cardModel);

				try {

					while (result.next()) {

						try {
							stock_code_textField.setText(result.getString("StockCode"));
							stock_name_textField.setText(result.getString("StockName"));
							stock_type_comboBox.setToolTipText(result.getString("StockType"));
							unit_comboBox.setToolTipText(result.getString("Unit"));
							barcode_textField.setText(result.getString("Barcode"));
							kdv_type_comboBox2.setToolTipText(result.getString("KdvType"));
							description_textArea.setText(result.getString("Description"));
							crated_date_formattedTextField.setText(result.getString("CreatedDate"));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

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
				ResultSet result = stockCardController.getLastItemFromStockCard();

				try {

					result.last();
					// stock_type_code_textField.setText(result.getNString("StockTypeCode"));

					stock_code_textField.setText(result.getString("StockCode"));
					stock_name_textField.setText(result.getString("StockName"));
					stock_type_comboBox.setToolTipText(result.getString("StockType"));
					unit_comboBox.setToolTipText(result.getString("Unit"));
					barcode_textField.setText(result.getString("Barcode"));
					kdv_type_comboBox2.setToolTipText(result.getString("KdvType"));
					description_textArea.setText(result.getString("Description"));
					crated_date_formattedTextField.setText(result.getString("CreatedDate"));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mnNewMenu_3);

		jInternalFrame.setVisible(true);

	}
}
