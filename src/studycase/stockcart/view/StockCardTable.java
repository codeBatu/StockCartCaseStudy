package studycase.stockcart.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;

import studycase.stockcart.util.Constant;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class StockCardTable extends javax.swing.JFrame {

	private JInternalFrame jInternalFrame;
	private JTable table;
	private StockCardController stockCardController;

	public StockCardTable(JPanel jpanel, StockCardController stockCardController) {

		this.stockCardController = stockCardController;
		this.stockCardController.Connect();
		init(jpanel);

	}

	public void init(JPanel jpanel) {
		jInternalFrame = new JInternalFrame();

		// jInternalFrame. setBounds(100, 100, 450, 300);
		jInternalFrame.setClosable(true);
		jInternalFrame.setTitle(" Stok Kartı Listesi");
		try {
			jInternalFrame.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		jInternalFrame.setBounds(10, 11, 1325, 826);
		jpanel.add(jInternalFrame);
		jInternalFrame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 555, 1013, -553);
		jInternalFrame.getContentPane().add(scrollPane, BorderLayout.NORTH);

		table = new JTable();
		table.setBounds(0, 0, 1309, 770);
		jInternalFrame.getContentPane().add(table);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Export Excel");
		popupMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ekrana Getir");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				List<StockCardModel> list = new ArrayList<>();

				StockCardModel cardModel = new StockCardModel();

				InputStream İ = getClass().getResourceAsStream("/jasper/report6.jasper");
				try {

					Collection<Map<String, ?>> parameters = new ArrayList<>();
					Map<String, Object> maps = new HashMap<String, Object>();
					parameters.add(maps);

					JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);
					JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, beanColDataSource);

					// JasperReport jasperReport = JasperCompileManager.compileReport(İ);
					JasperPrint jp = JasperFillManager.fillReport(İ, null, new JREmptyDataSource());
					JFrame frame = new JFrame("Report");
					frame.getContentPane().add(new JRViewer(jp));
					frame.pack();
					frame.setVisible(true);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

////				
//				 List<StockTypeCardModel> dmmuy = new ArrayList<>();
//				 StockTypeCardModel d = new StockTypeCardModel();
//				 d.setId(1);
//				 d.setName("dasd");
//				String pathName="D:\\workspace\\java\\StudyCase\\src\\jasper\\report1.jrxml";
//				JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(dmmuy);
//				Map<String ,Object> parm = new HashMap<String,Object>();
//				parm.put("Paramatre1",jrBeanCollectionDataSource );
//		
//				JasperDesign jasperDesign;
//				try {
//					InputStream input = new FileInputStream(new File(pathName));
//					jasperDesign = JRXmlLoader.load(input);
//					JasperReport report = JasperCompileManager.compileReport(jasperDesign);
//					JasperPrint filledReport =  JasperFillManager.fillReport(report,parm,new JREmptyDataSource());
//					JasperViewer.viewReport(filledReport);
//				} catch (JRException | FileNotFoundException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
			}
		});
		popupMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Mail At");
		popupMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Stok Kartı ");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockCardUi cardUi = new StockCardUi(stockCardController, jpanel);

				System.out.println(table.getModel().getValueAt(0, 5).toString());
				cardUi.stock_code_textField.setText(table.getModel().getValueAt(0, 0).toString());

				cardUi.stock_name_textField.setText(table.getModel().getValueAt(0, 1).toString());
				;
				cardUi.stock_type_comboBox.setSelectedItem(table.getModel().getValueAt(0, 2).toString());
				;
				cardUi.unit_comboBox.setSelectedItem(table.getModel().getValueAt(0, 3).toString());
				cardUi.barcode_textField.setText(table.getModel().getValueAt(0, 4).toString());
				cardUi.kdv_type_comboBox2.setToolTipText(table.getModel().getValueAt(0, 5).toString());

				cardUi.description_textArea.setText(table.getModel().getValueAt(0, 6).toString());
				cardUi.crated_date_formattedTextField.setText(table.getModel().getValueAt(0, 7).toString());

			}
		});
		popupMenu.add(mntmNewMenuItem_3);

		JMenuBar menuBar = new JMenuBar();
		jInternalFrame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("İlk Kayıt");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				stockCardController.getFirstItemFromStockListWithKdvListWithStockType(table);
			}
		});
		mnNewMenu.setIcon(Constant.FIRST_ARROW_ICON);
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Geri");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockCardModel stockCardModel = new StockCardModel();
				stockCardModel.setStockCod(table.getModel().getValueAt(0, 0).toString());

				stockCardController.getBeforeItemFromStockListWithKdvListWithStockType(stockCardModel, table);
			}
		});
		mnNewMenu_1.setIcon(Constant.BACK_ARROW_ICON);
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("İleri");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockCardModel stockCardModel = new StockCardModel();
				stockCardModel.setStockCod(table.getModel().getValueAt(0, 0).toString());
				stockCardController.getAfterItemFromStockListWithKdvListWithStockType(stockCardModel, table);
			}
		});
		mnNewMenu_2.setIcon(Constant.FORWARD_ARROW_ICON);
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("Son Kayıt");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				stockCardController.getLastItemFromStockListWithKdvListWithStockType(table);
			}
		});
		mnNewMenu_3.setIcon(Constant.LAST_ARROW_ICON);
		menuBar.add(mnNewMenu_3);
		jInternalFrame.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
