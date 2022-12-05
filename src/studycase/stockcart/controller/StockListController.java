package studycase.stockcart.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.util.Constant;
import studycase.stockcart.view.MailUi;
import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockCardUi;
import studycase.stockcart.view.StockCardView;
import studycase.stockcart.view.StockListTableView;

public class StockListController implements ActionListener {

	private StockListTableView listTableView;
	private StockCardRepository cardRepository;
	private DefaultTableModel columnModel = new DefaultTableModel();
	private StockCardController cardController;

	public StockListController(StockListTableView listTableView, StockCardRepository cardRepository,
			StockCardController cardController) {

		this.cardRepository = cardRepository;
		cardRepository.Connect();
		this.listTableView = listTableView;
		this.cardController = cardController;

	}

	public StockListTableView init() {
		listTableView.getMnNewMenu().addActionListener(this);

		columnModel.setColumnIdentifiers(Constant.COLUMNS_TİTLE);

		listTableView.getMnNewMenu().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				fillTable();

			}

		});

		listTableView.getMenuItemSendMail().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MailUi mailUi = new MailUi();
				MailController controller = new MailController(mailUi);
				JFrame frame = new JFrame("Report");
				frame.getContentPane().add(controller.initMailUi(listTableView.getTable()));
				frame.setBounds(500, 500, 1500, 1500);
				frame.pack();
				frame.setVisible(true);
				 
			}

		});
		listTableView.getTable().setModel(columnModel);
		listTableView.setVisible(true);
		listTableView.getMenuItemExportExcel().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fchoose = new JFileChooser();
				int option = fchoose.showSaveDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					String name = fchoose.getSelectedFile().getName();
					String path = fchoose.getSelectedFile().getParentFile().getPath();
					String file = path + "\\" + name + ".xls";
					export(listTableView.getTable(), new File(file));
					try {
						Desktop.getDesktop().open(new File(file));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
		listTableView.getMenuItemScreen().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				InputStream stringPath = getClass().getResourceAsStream("/jasper/report6.jasper");
				try {

					Collection<Map<String, ?>> parameters = new ArrayList<>();
					Map<String, Object> maps = new HashMap<String, Object>();
					int selectedRow = listTableView.getTable().getSelectedRow();
					maps.put("StockCode", listTableView.getTable().getModel().getValueAt(selectedRow, 0).toString());
					maps.put("StockName", listTableView.getTable().getModel().getValueAt(selectedRow, 1).toString());
					maps.put("StockType", listTableView.getTable().getModel().getValueAt(selectedRow, 2).toString());
					maps.put("Unit", listTableView.getTable().getModel().getValueAt(selectedRow, 3).toString());
					maps.put("Barcode", listTableView.getTable().getModel().getValueAt(selectedRow, 4).toString());
					maps.put("KdvType", listTableView.getTable().getModel().getValueAt(selectedRow, 5).toString());
					maps.put("Description", listTableView.getTable().getModel().getValueAt(selectedRow, 6).toString());
					maps.put("CreatedDate", listTableView.getTable().getModel().getValueAt(selectedRow, 7).toString());
					maps.put("KdvTypeId", listTableView.getTable().getModel().getValueAt(selectedRow, 8).toString());
					maps.put("KdvTypeName", listTableView.getTable().getModel().getValueAt(selectedRow, 9).toString());
					maps.put("KdvTypeCode", listTableView.getTable().getModel().getValueAt(selectedRow, 10).toString());
					maps.put("KdvTypeRatio",
							listTableView.getTable().getModel().getValueAt(selectedRow, 11).toString());
					maps.put("StockId", listTableView.getTable().getModel().getValueAt(selectedRow, 12).toString());
					maps.put("StockTypeName",
							listTableView.getTable().getModel().getValueAt(selectedRow, 13).toString());
					maps.put("StockTypeCode",
							listTableView.getTable().getModel().getValueAt(selectedRow, 14).toString());
					maps.put("StockTypeDescription",
							listTableView.getTable().getModel().getValueAt(selectedRow, 15).toString());

					parameters.add(maps);

					JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);

					JasperPrint jp = JasperFillManager.fillReport(stringPath, maps, beanColDataSource);
					// JasperExportManager.exportReportToPdfFile(jp, "./productsReport.pdf");
					JFrame frame = new JFrame("Report");
					frame.getContentPane().add(new JRViewer(jp));
					frame.setBounds(500, 500, 1500, 1500);
					frame.pack();
					frame.setVisible(true);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		listTableView.getMenuItemGetStockCard().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				cardController.Connect();

				JFrame frame = new JFrame("Stok Kart");
				StockCardView cardView = null;
				try {
					cardView = new StockCardView();
					cardView.getStock_code_textField()
							.setText(listTableView.getTable().getModel().getValueAt(0, 0).toString());

					cardView.getStock_name_textField()
							.setText(listTableView.getTable().getModel().getValueAt(0, 1).toString());
					;
					cardView.getStock_type_comboBox()
							.setSelectedItem(listTableView.getTable().getModel().getValueAt(0, 2).toString());
					;
					cardView.getUnit_comboBox()
							.setSelectedItem(listTableView.getTable().getModel().getValueAt(0, 3).toString());
					cardView.getBarcode_textField()
							.setText(listTableView.getTable().getModel().getValueAt(0, 4).toString());
					cardView.getKdv_type_comboBox2()
							.setToolTipText(listTableView.getTable().getModel().getValueAt(0, 5).toString());

					cardView.getDescription_textArea()
							.setText(listTableView.getTable().getModel().getValueAt(0, 6).toString());
					cardView.getCrated_date_formattedTextField()
							.setText(listTableView.getTable().getModel().getValueAt(0, 7).toString());
					frame.getContentPane().add(cardView);

					frame.setBounds(100, 100, 1083, 798);
					frame.pack();
					frame.setVisible(true);

				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		return listTableView;

	}

	public void fillTable() {
		ResultSet result = cardRepository.getStockCard();
		listTableView.getTable().setModel(DbUtils.resultSetToTableModel(result));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void export(JTable table, File file) {

		try {
			TableModel m = table.getModel();
			System.out.println(m.getValueAt(0, 0).toString());
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
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
