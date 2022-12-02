package studycase.stockcart.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import studycase.stockcart.controller.KdvTypeCardController;
import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.controller.StockTypeCardController;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {
	private JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItemAdd = new JMenuItem("Export Excel");
	private JPanel contentPane;
	private JTextField stock_code_textField;
	private JTextField stock_name_textField;
	private JTextField barcode_textField;
	private JTextArea description_textArea;
	private JFormattedTextField crated_date_formattedTextField;
	private StockCardController stockCardController;
	private StockTypeCardController stockTypeCardController;;
	private JComboBox<Integer> stock_type_comboBox = new JComboBox<>();;;
	private KdvTypeCardController kdvTypeCardController;
	JComboBox<Integer> kdv_type_comboBox2;

	private JTable table_1;

	public void export(JTable table, File file) throws IOException {

		TableModel m = table.getModel();
		FileWriter fw = new FileWriter(file);
		for (int i = 0; i < m.getColumnCount(); i++) {
			fw.write(m.getColumnName(i) + "\t");
		}
		fw.write("\n");
		for (int i = 0; i < m.getRowCount(); i++) {
			for (int j = 0; j < m.getColumnCount(); j++) {
				fw.write(m.getValueAt(i, j).toString() + "\t");
			}
			fw.write("\n");
		}
		fw.close();

	}

	static void exportToExcel(JTable table, String filePath) throws Exception {
		TableModel model = table.getModel();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row;
		Cell cell;

		// write the column headers
		row = sheet.createRow(0);
		for (int c = 0; c < model.getColumnCount(); c++) {
			cell = row.createCell(c);
			cell.setCellValue(model.getColumnName(c));
		}

		// write the data rows
		for (int r = 0; r < model.getRowCount(); r++) {
			row = sheet.createRow(r + 1);
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c);
				Object value = model.getValueAt(r, c);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Double) {
					cell.setCellValue((Double) value);
				}
			}
		}

		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);
		out.close();
		workbook.close();
	}

	public MainFrame(StockCardController stockCardControllers, StockTypeCardController stockTypeCardController,
			KdvTypeCardController kdvTypeCardController) throws PropertyVetoException {
		setTitle("Stok Kartı Case Study2");

		init();
		stockCardController = stockCardControllers;
		this.stockTypeCardController = stockTypeCardController;
		this.kdvTypeCardController = kdvTypeCardController;
		stockCardController.Connect();

	}

	private void Clear() {

		stock_code_textField.setText("");
		stock_code_textField.setText("");
		stock_name_textField.setText("");
		barcode_textField.setText("");
		description_textArea.setText("");
		// crated_date_formattedTextField.setText("");
	}

	private StockCardModel fill() {
		StockCardModel stockCardModel = new StockCardModel();

		stockCardModel.setStockCod(stock_code_textField.getText());
		stockCardModel.setStockName(stock_name_textField.getText());
		stockCardModel.setStockType((int) stock_type_comboBox.getSelectedItem());
		stockCardModel.setUnit("metre");
		stockCardModel.setBarcode(barcode_textField.getText());
		stockCardModel.setKdvType((int) kdv_type_comboBox2.getSelectedItem());
		stockCardModel.setDescription(description_textArea.getText());
		stockCardModel.setCratedDate(crated_date_formattedTextField.getText());
		return stockCardModel;
	}

	private void init() throws PropertyVetoException {

		popupMenu.add(menuItemAdd);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 866);

		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		JMenu mnNewMenu_1 = new JMenu("Yeni Stok Kartı ");
		menuBar_1.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Stok Kart");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				StockCardUi stockCardUi = new StockCardUi(stockCardController, contentPane);
			}
		});

		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Stok Kart Listesi");
		mntmNewMenuItem_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockCardTable stockCardTable = new StockCardTable(contentPane, stockCardController);
				stockCardTable.setVisible(false);
				if (stockCardTable.isActive()) {
					stockCardTable.setVisible(true);
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Yeni Stok Kart Tipi");
		mntmNewMenuItem_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardCreateUi frame = new StockTypeCardCreateUi(contentPane, stockTypeCardController);

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenu mnNewMenu = new JMenu("Kdv");
		menuBar_1.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Yeni Kdv Tip Kartı");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KdvTypeCardCreateUi cardCreateUi = new KdvTypeCardCreateUi(contentPane, kdvTypeCardController);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}