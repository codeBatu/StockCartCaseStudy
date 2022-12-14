package studycase.stockcart.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.UtilEntity;
import studycase.stockcart.util.Constant;
import studycase.stockcart.view.MailUi;
import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockCardView;
import studycase.stockcart.view.StockListTableView;

public class StockListControllerCommand implements ActionListener {

	private StockListTableView listTableView;
	private StockCardRepository cardRepository = new StockCardRepository();

	private MainFrames frames;

	public StockListControllerCommand(MainFrames frames) {
		this.frames = frames;

		cardRepository.Connect();

	}

	public void execute() {

		this.listTableView = new StockListTableView();

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
				controller.initMailUi(listTableView.getTable());

				frames.getDesktopPane().add(controller.initMailUi(listTableView.getTable()));
				// frames.getContentPane().add());

			}

		});

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

					for (int i = 0; i < listTableView.getTable().getRowCount(); i++) {

						maps.put("StockCode", listTableView.getTable().getModel().getValueAt(i, i).toString());
						maps.put("StockName", listTableView.getTable().getModel().getValueAt(i, 1).toString());
						maps.put("StockType", listTableView.getTable().getModel().getValueAt(i, 2).toString());
						maps.put("Unit", listTableView.getTable().getModel().getValueAt(i, 3).toString());
						maps.put("Barcode", listTableView.getTable().getModel().getValueAt(i, 4).toString());
						maps.put("KdvType", listTableView.getTable().getModel().getValueAt(i, 5).toString());
						maps.put("Description", listTableView.getTable().getModel().getValueAt(i, 6).toString());
						maps.put("CreatedDate", listTableView.getTable().getModel().getValueAt(i, 7).toString());
						maps.put("KdvTypeId", listTableView.getTable().getModel().getValueAt(i, 8).toString());
						maps.put("KdvTypeName", listTableView.getTable().getModel().getValueAt(i, 9).toString());
						maps.put("KdvTypeCode", listTableView.getTable().getModel().getValueAt(i, 10).toString());
						maps.put("KdvTypeRatio", listTableView.getTable().getModel().getValueAt(i, 11).toString());
						maps.put("StockId",
								listTableView.getTable().getModel().getValueAt(i, 12) != null ? "Stok Kartı Silinmiş"
										: listTableView.getTable().getModel().getValueAt(i, 12));
						maps.put("StockTypeName", listTableView.getTable().getModel().getValueAt(i, 13));

						maps.put("StockTypeDescription", listTableView.getTable().getModel().getValueAt(i, 14));

					}

					JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);

					JasperPrint jp = JasperFillManager.fillReport(stringPath, maps, beanColDataSource);

					JFrame exportJasperPrint = new JFrame();
					exportJasperPrint.getContentPane().add(new JRViewer(jp));
					exportJasperPrint.setBounds(500, 500, 1500, 1500);
					exportJasperPrint.pack();
					exportJasperPrint.setVisible(true);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
//		 model.addRow(new Object[] {entity.getID(), entity.getName(), entity.getSurname()});
		listTableView.getMenuItemGetStockCard().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				//

				StockCardView cardView = new StockCardView();
				cardView.setVisible(true);
				
				int selectedRow = listTableView.getTable().getSelectedRow();

				cardView.getStock_code_textField()

						.setText(listTableView.getTable().getModel().getValueAt(selectedRow, 0).toString());

				cardView.getStock_name_textField()
						.setText(listTableView.getTable().getModel().getValueAt(selectedRow, 1).toString());
				;
				cardView.getStock_type_comboBox()
						.setSelectedItem((Object) (listTableView.getTable().getModel().getValueAt(selectedRow, 2)));
				;

				cardView.getUnit_comboBox().setSelectedItem(
						(Object) listTableView.getTable().getModel().getValueAt(selectedRow, 3).toString());
				cardView.getBarcode_textField()
						.setText(listTableView.getTable().getModel().getValueAt(selectedRow, 4).toString());
				cardView.getKdv_type_comboBox2()
						.setSelectedItem((Object) listTableView.getTable().getModel().getValueAt(selectedRow, 5));

				cardView.getDescription_textArea()
						.setText(listTableView.getTable().getModel().getValueAt(selectedRow, 6).toString());
				cardView.getCrated_date_formattedTextField()
						.setText(listTableView.getTable().getModel().getValueAt(selectedRow, 7).toString());

				frames.getDesktopPane().add(cardView);
			}

		});
		listTableView.setVisible(true);
		frames.getDesktopPane().add(listTableView);

	}

	public void fillTable() {
		List<UtilEntity> listAll = cardRepository.getStockCard();

		DefaultTableModel model = new DefaultTableModel();

		// Create a couple of columns
		model.setColumnIdentifiers(Constant.COLUMNS_TİTLE);

		for (UtilEntity row : listAll) {

			model.addRow(new Object[] { row.getStockCode(), row.getStock_name(), row.getStocktype_id(), row.getUnit(),
					row.getBarcode(), row.getKdvtype_id(), row.getStockDescription(), row.getCreated_date(),
					row.getKdvTypeId(), row.getKdvTypeName(), row.getKdvTypeCode(), row.getRatio(),
					row.getStockTypeId(), row.getStockTypeName(), row.getStockTypeCode(), row.getStockDescription()

			});

		}
		listTableView.getTable().setModel(model);

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
