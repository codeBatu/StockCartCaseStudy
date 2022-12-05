package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;
import studycase.stockcart.view.StockCardUi;
import studycase.stockcart.view.StockCardView;

public class StockCardController implements ActionListener {
	private StockCardRepository crudModel;
	StockCardUi stockCardUi = new StockCardUi();
	private StockCardView cardView;
	private StockCardModel stockCardModel = new StockCardModel();

	public StockCardController(StockCardRepository crudModel, StockCardView cardView) {
		this.crudModel = crudModel;
		this.crudModel.Connect();
		this.cardView = cardView;

	}

	public StockCardView init() {
		getKdvTypeTable();
		getStockTypeByKdvTypeId();

		cardView.getSave_btnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCardModel stockCardModel = new StockCardModel();

				stockCardModel.setStockCod(cardView.getStock_code_textField().getText());
				stockCardModel.setStockName(cardView.getStock_name_textField().getText());
				stockCardModel.setStockType((int) cardView.getStock_type_comboBox().getSelectedItem());
				stockCardModel.setUnit(cardView.getUnit_comboBox().getSelectedItem().toString());
				stockCardModel.setBarcode(cardView.getBarcode_textField().getText());
				// System.out.println((int) cardView.getKdv_type_comboBox2().getSelectedItem());
				stockCardModel.setKdvType((int) cardView.getKdv_type_comboBox2().getSelectedItem());
				stockCardModel.setDescription(cardView.getDescription_textArea().getText());
				stockCardModel.setCratedDate(cardView.getCrated_date_formattedTextField().getText());
				System.out.println(cardView.getKdv_type_comboBox().getSelectedItem());
				crudModel.createDb(stockCardModel);

			}
		});
		cardView.getSave_btnNewButton().addActionListener(this);
		cardView.getMnNewMenu_2().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ResultSet result = getFirstItemFromStockCard();

				try {
					result.first();
					cardView.getStock_code_textField().setText(result.getString("StockCode"));
					cardView.getStock_name_textField().setText(result.getString("StockName"));
					cardView.getStock_type_comboBox().setToolTipText(result.getString("StockType"));
					cardView.getUnit_comboBox().setToolTipText(result.getString("Unit"));
					cardView.getBarcode_textField().setText(result.getString("Barcode"));
					cardView.getKdv_type_comboBox2().setToolTipText(result.getString("KdvType"));
					cardView.getDescription_textArea().setText(result.getString("Description"));
					cardView.getCrated_date_formattedTextField().setText(result.getString("CreatedDate"));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cardView.getMnNewMenu_1().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					StockCardModel stockCardModel = new StockCardModel();
					stockCardModel.setStockCod(cardView.getStock_code_textField().getText());

					ResultSet result = getBeforeItemFromStockCard(stockCardModel);
					while (result.next()) {
						cardView.getStock_code_textField().setText(result.getString("StockCode"));
						cardView.getStock_name_textField().setText(result.getString("StockName"));
						cardView.getStock_type_comboBox().setToolTipText(result.getString("StockType"));
						cardView.getUnit_comboBox().setToolTipText(result.getString("Unit"));
						cardView.getBarcode_textField().setText(result.getString("Barcode"));
						cardView.getKdv_type_comboBox2().setToolTipText(result.getString("KdvType"));
						cardView.getDescription_textArea().setText(result.getString("Description"));
						cardView.getCrated_date_formattedTextField().setText(result.getString("CreatedDate"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cardView.getMnNewMenu_3().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {

					ResultSet result = getLastItemFromStockCard();
					result.last();
					cardView.getStock_code_textField().setText(result.getString("StockCode"));
					cardView.getStock_name_textField().setText(result.getString("StockName"));
					cardView.getStock_type_comboBox().setToolTipText(result.getString("StockType"));
					cardView.getUnit_comboBox().setToolTipText(result.getString("Unit"));
					cardView.getBarcode_textField().setText(result.getString("Barcode"));
					cardView.getKdv_type_comboBox2().setToolTipText(result.getString("KdvType"));
					cardView.getDescription_textArea().setText(result.getString("Description"));
					cardView.getCrated_date_formattedTextField().setText(result.getString("CreatedDate"));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cardView.getMnNewMenu().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					StockCardModel stockCardModel = new StockCardModel();
					stockCardModel.setStockCod(cardView.getStock_code_textField().getText());

					ResultSet result = getAfterItemFromStockCard(stockCardModel);
					while (result.next()) {
						cardView.getStock_code_textField().setText(result.getString("StockCode"));
						cardView.getStock_name_textField().setText(result.getString("StockName"));
						cardView.getStock_type_comboBox().setToolTipText(result.getString("StockType"));
						cardView.getUnit_comboBox().setToolTipText(result.getString("Unit"));
						cardView.getBarcode_textField().setText(result.getString("Barcode"));
						cardView.getKdv_type_comboBox2().setToolTipText(result.getString("KdvType"));
						cardView.getDescription_textArea().setText(result.getString("Description"));
						cardView.getCrated_date_formattedTextField().setText(result.getString("CreatedDate"));

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cardView.getUpdate_btnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (stockCardModel.getStockCod().equals("") || stockCardModel.getStockName().equals("")
						|| stockCardModel.getBarcode().equals("") || stockCardModel.getDescription().equals("")
						|| stockCardModel.getCratedDate().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is not null");
				} else {
					if (stockCardModel.getStockCod().length() >= 50 || stockCardModel.getStockName().length() >= 100
							|| stockCardModel.getBarcode().length() >= 30) {
						JOptionPane.showMessageDialog(null, "Data is long");
						return;

					}
					crudModel.updateDb(stockCardModel);
				}
			}
		});

		cardView.getDelete_btnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (stockCardModel.getStockCod().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is not null");
				} else {
					if (stockCardModel.getStockCod().length() >= 50) {
						JOptionPane.showMessageDialog(null, "Data is long");
						return;

					}
					crudModel.deleteDb(stockCardModel.getStockCod());

				}
			}
		});

		cardView.setVisible(true);

		return cardView;

	}

	private StockCardModel fill() {
		StockCardModel stockCardModel = new StockCardModel();

		stockCardModel.setStockCod(cardView.getStock_code_textField().getText());
		stockCardModel.setStockName(cardView.getStock_name_textField().getText());
		stockCardModel.setStockType((int) cardView.getStock_type_comboBox().getSelectedItem());
		stockCardModel.setUnit(cardView.getUnit_comboBox().getSelectedItem().toString());
		stockCardModel.setBarcode(cardView.getBarcode_textField().getText());
		stockCardModel.setKdvType((int) cardView.getKdv_type_comboBox().getSelectedItem());
		stockCardModel.setDescription(cardView.getDescription_textArea().getText());
		stockCardModel.setCratedDate(cardView.getCrated_date_formattedTextField().getText());
		return stockCardModel;
	}

	public void LoadData(JTable table) {

		this.crudModel.LoadData(table);
	}

	public void deleteDb(String stockCod) {

		if (stockCod.equals("")) {
			JOptionPane.showMessageDialog(null, "Field is not null");
		} else {
			if (stockCod.length() >= 50) {
				JOptionPane.showMessageDialog(null, "Data is long");
				return;

			}
			this.crudModel.deleteDb(stockCod);
		}
	}

	public ResultSet getStockCartByStockCode(String stockCod) {

		if (stockCod.equals("")) {
			JOptionPane.showMessageDialog(null, "Field is not null");
			ResultSet rs = null;
			return rs;
		} else {
			if (stockCod.length() >= 50) {
				JOptionPane.showMessageDialog(null, "Data is long");

			}
			return this.crudModel.getStockCartByStockCode(stockCod);

		}
	}

	public ResultSet getStockCart() {

		return getStockCart();

	}

	public Connection Connect() {

		return this.crudModel.Connect();

	}

	public void getStockTypeByKdvTypeId() {
		ResultSet result = this.crudModel.getStockTypeByKdvTypeId();
		;
		try {
			while (result.next()) {
				cardView.getStock_type_comboBox().addItem(result.getInt("StockId"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void getKdvTypeTable() {
		ResultSet result = this.crudModel.getKdvTypeTable();
		;
		try {
			while (result.next()) {
				cardView.getKdv_type_comboBox2().addItem(result.getInt("KdvTypeId"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public ResultSet getFirstItemFromStockCard() {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.crudModel.getFirstItemFromStockTable();

	}

	public ResultSet getAfterItemFromStockCard(StockCardModel stockCardModel) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.crudModel.getAfterItemFromStockTable(stockCardModel);

	}

	public ResultSet getBeforeItemFromStockCard(StockCardModel stockCardModel) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.crudModel.getBeforeItemFromStockTable(stockCardModel);

	}

	public ResultSet getLastItemFromStockCard() {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.crudModel.getLastItemFromStockTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
