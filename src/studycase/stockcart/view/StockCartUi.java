package studycase.stockcart.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.model.CrudModel;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.StockCardModel;
import studycase.stockcart.util.Constant;



public class StockCartUi extends JFrame {
	
	private JPanel contentPane;
	private JTextField stock_code_textField;
	private JTextField stock_name_textField;
	private JTextField barcode_textField;
	private JTable table;
	private JTextArea description_textArea;
	private JFormattedTextField crated_date_formattedTextField ;
	private   StockCardController stockCardController ;


	  DefaultComboBoxModel<Double> kdvTypeModel = new DefaultComboBoxModel<>(Constant.KDV_TYPE_LIST);
	    DefaultComboBoxModel<Integer> stockTypeModel = new DefaultComboBoxModel<>(Constant.STOCK_TYPE_LIST);
	    DefaultComboBoxModel<String> unitTypeModel = new DefaultComboBoxModel<>(Constant.UNIT_TYPE_LIST);
	private  JComboBox<Double>  kdv_type_comboBox = new JComboBox<>(kdvTypeModel); ;
	private  JComboBox<Integer>  stock_type_comboBox  = new JComboBox<>(stockTypeModel); ; ;

private  JComboBox<String>  sunit_comboBox  = new JComboBox<>(unitTypeModel); ; ;
	Connection con ;
	PreparedStatement pst;
	ResultSet rs;
public StockCartUi(StockCardController stockCardControllers  ) {
	stockCardController =stockCardControllers;
			init();
			stockCardController.Connect() ;
			stockCardControllers.LoadData(table);
	}


private void Clear() {

	stock_code_textField.setText("");
	stock_code_textField.setText("");
	stock_name_textField.setText("");
	barcode_textField.setText("");
	description_textArea.setText("");
	//crated_date_formattedTextField.setText("");
}
private StockCardModel fill() { 
	StockCardModel stockCardModel = new StockCardModel();

stockCardModel.setStockCod(stock_code_textField.getText());
stockCardModel.setStockName(stock_name_textField.getText());
stockCardModel.setStockType((int)stock_type_comboBox.getSelectedItem());	
stockCardModel.setUnit(sunit_comboBox.getSelectedItem().toString());
stockCardModel.setBarcode(barcode_textField.getText());
stockCardModel.setKdvType((double)kdv_type_comboBox.getSelectedItem());
stockCardModel.setDescription(description_textArea.getText());
stockCardModel.setCratedDate(crated_date_formattedTextField.getText());
return stockCardModel;
}




 private void init() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 866);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel stock_code_lbl = new JLabel("Stok Kodu");
		stock_code_lbl.setBounds(10, 13, 86, 25);
		stock_code_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(stock_code_lbl);
		
		JLabel stock_name_lbl = new JLabel("Stok Adı");
		stock_name_lbl.setBounds(10, 55, 86, 25);
		stock_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(stock_name_lbl);
		
		stock_code_textField = new JTextField();
		stock_code_textField.setBounds(147, 15, 316, 20);
		stock_code_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(stock_code_textField);
		stock_code_textField.setColumns(10);
		
		stock_name_textField = new JTextField();
		stock_name_textField.setBounds(147, 57, 316, 20);
		stock_name_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stock_name_textField.setColumns(10);
		contentPane.add(stock_name_textField);
		
		JLabel stock_type_lbl = new JLabel("Stok Tipi");
		stock_type_lbl.setBounds(10, 105, 78, 25);
		stock_type_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(stock_type_lbl);

		stock_type_comboBox.setBounds(147, 106, 114, 22);
	
		stock_type_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(stock_type_comboBox);
		
		JLabel unit_lbl = new JLabel("Birimi");
		unit_lbl.setBounds(10, 141, 78, 25);
		unit_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(unit_lbl);
		

		sunit_comboBox.setBounds(147, 141, 114, 22);
	
		sunit_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(sunit_comboBox);
		
		JLabel barcode_lbl = new JLabel("Barkodu");
		barcode_lbl.setBounds(10, 177, 78, 25);
		barcode_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(barcode_lbl);
		
		barcode_textField = new JTextField();
		barcode_textField.setBounds(147, 179, 316, 20);
		barcode_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		barcode_textField.setColumns(10);
		contentPane.add(barcode_textField);
		
		JLabel kdv_type_lbl = new JLabel("Kdv Tipi");
		kdv_type_lbl.setBounds(10, 213, 78, 25);
		kdv_type_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(kdv_type_lbl);
		
		JLabel description_lbl = new JLabel("Açıklama");
		description_lbl.setBounds(10, 249, 78, 25);
		description_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(description_lbl);
		
		JLabel created_date_lbl = new JLabel("Oluşturma Tarihi");
		created_date_lbl.setBounds(10, 331, 124, 25);
		created_date_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(created_date_lbl);
		
	// kdv_type_comboBox = new JComboBox();
		kdv_type_comboBox.setBounds(147, 212, 114, 22);
	//	kdv_type_comboBox.addItem(.08d);
	//	kdv_type_comboBox.addItem(.18d);
		kdv_type_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(kdv_type_comboBox);
		
		description_textArea = new JTextArea();
		description_textArea.setBounds(147, 249, 316, 59);
		description_textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		
		contentPane.add(description_textArea);
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 crated_date_formattedTextField = new JFormattedTextField(dateFormat);
		crated_date_formattedTextField.setBounds(147, 333, 316, 20);
		crated_date_formattedTextField.setValue(new Date());
		crated_date_formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(crated_date_formattedTextField);
		
		
		//
		JButton delete_btnNewButton = new JButton("Sil");
		delete_btnNewButton.setBounds(479, 56, 190, 23);
		delete_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockCardController.deleteDb(stock_code_textField.getText());	
					stockCardController.LoadData(table);
					Clear();
					}	
				}
		);
	
		
		delete_btnNewButton.setBackground(Color.RED);
		delete_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(delete_btnNewButton);
		
		JButton update_btnNewButton = new JButton("Güncelle");
		update_btnNewButton.setBounds(479, 90, 190, 23);
		update_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				stockCardController.updateDb(fill()	);
				
					stockCardController.LoadData(table);
					
					Clear();
			
			}
		}	);
		update_btnNewButton.setForeground(Color.BLACK);
		update_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(update_btnNewButton);
		
		JButton search_btnNewButton = new JButton("Ara");
		search_btnNewButton.setBounds(479, 124, 190, 23);
		search_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
	
					table.setModel(DbUtils.resultSetToTableModel(stockCardController.getStockCartByStockCode(stock_code_textField.getText())));	
			}
		});
		search_btnNewButton.setForeground(Color.BLACK);
		search_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(search_btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 375, 816, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				TableModel tt = table.getModel();
				stock_code_textField.setText(tt.getValueAt(selectedRow, 0).toString());
				stock_name_textField.setText(tt.getValueAt(selectedRow, 1).toString());
				
				stock_type_comboBox.setSelectedItem(tt.getValueAt(selectedRow, 2));
				sunit_comboBox.setSelectedItem(tt.getValueAt(selectedRow, 3).toString());
				barcode_textField.setText(tt.getValueAt(selectedRow, 4).toString());
				description_textArea.setText(tt.getValueAt(selectedRow, 6).toString());
		//		kdv_type_comboBox.setSelectedItem();
				kdv_type_comboBox.setSelectedItem(tt.getValueAt(selectedRow, 5));
	//		kdv_type_comboBox.setSelectedItem(tt.getValueAt(selectedRow, 5).toString());
				crated_date_formattedTextField.setText(tt.getValueAt(selectedRow, 7).toString());		
			}		
		});

		scrollPane.setViewportView(table);
		JButton save_btnNewButton = new JButton("Kaydet");
		save_btnNewButton.setBounds(479, 12, 190, 23);
		save_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crated_date_formattedTextField.setValue(new Date());
				stockCardController.createDb(fill()	);
					Clear();
					stockCardController.LoadData(table);
					
					
 
			}
		});

		save_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(save_btnNewButton);
		
		JButton copy_btnNewButton = new JButton("Kopyala");
		copy_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCardModel stockCardModel = new StockCardModel();

				stockCardModel.setStockCod(stock_code_textField.getText()+"(2)");
				stockCardModel.setStockName(stock_name_textField.getText());
				stockCardModel.setStockType((int)stock_type_comboBox.getSelectedItem());	
				stockCardModel.setUnit(sunit_comboBox.getSelectedItem().toString());
				stockCardModel.setBarcode(barcode_textField.getText());
				stockCardModel.setKdvType((double)kdv_type_comboBox.getSelectedItem());
				stockCardModel.setDescription(description_textArea.getText());
				stockCardModel.setCratedDate(crated_date_formattedTextField.getText());
				
				
				stockCardController.createDb(stockCardModel);
					
			
					stockCardController.LoadData(table);
				//table.getTransferHandler().exportToClipboard(table, getToolkit().getSystemClipboard(), TransferHandler.COPY);
			}
		});
		copy_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		copy_btnNewButton.setBounds(479, 158, 190, 25);
		contentPane.add(copy_btnNewButton);
		
		JButton list_tbl_btnNewButton = new JButton("Listele");
		list_tbl_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
				stockCardController.LoadData(table);
			}
		});
		list_tbl_btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_tbl_btnNewButton.setBounds(479, 192, 190, 25);
		contentPane.add(list_tbl_btnNewButton);	
		
	}

}