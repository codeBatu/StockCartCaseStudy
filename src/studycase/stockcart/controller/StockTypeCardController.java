package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class StockTypeCardController implements ActionListener {

	private StockTypeCardRepository stockTypeCardRepository;
	private StockTypeCardCreateUi stockTypeCardCreateUi;

	public StockTypeCardController(StockTypeCardRepository stockTypeCardRepository,
			StockTypeCardCreateUi stockTypeCardCreateUi) {
		this.stockTypeCardRepository = stockTypeCardRepository;
		this.stockTypeCardRepository.Connect();
		this.stockTypeCardCreateUi = stockTypeCardCreateUi;

	}

	public StockTypeCardCreateUi init() {
		stockTypeCardCreateUi.getBtnNewButton().addActionListener(this);

		stockTypeCardCreateUi.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create(fill());

			}
		});

		stockTypeCardCreateUi.getMnNewMenu_2().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				ResultSet result = getFirstItemFromStockType();

				try {

				
					if(result.next()) {
						stockTypeCardCreateUi.getLblNewLabel().setText(result.getString("StockId"));
						stockTypeCardCreateUi.getStock_type_code_textField().setText(result.getString("StockTypeCode"));
						stockTypeCardCreateUi.getStock_type_name_textField().setText(result.getString("StockTypeName"));
						stockTypeCardCreateUi.getStock_type_description_textArea().setText(result.getString("StockTypeDescription"));
					}
				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		stockTypeCardCreateUi.getMnNewMenu_1().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
				stockTypeCardModel.setName(stockTypeCardCreateUi.getStock_type_name_textField().getText());
				
				
				stockTypeCardModel.setId(Integer.parseInt(stockTypeCardCreateUi.getLblNewLabel().getText()));
				ResultSet result = getBeforeItemFromStockTypeTable(stockTypeCardModel);
				try {

					while (result.next()) {
						stockTypeCardCreateUi.getLblNewLabel().setText(result.getString("StockId"));
						stockTypeCardCreateUi.getStock_type_code_textField().setText(result.getString("StockTypeCode"));
						stockTypeCardCreateUi.getStock_type_name_textField().setText(result.getString("StockTypeName"));
						stockTypeCardCreateUi.getStock_type_description_textArea().setText(result.getString("StockTypeDescription"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		stockTypeCardCreateUi.getMnNewMenu().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
				stockTypeCardModel.setName(stockTypeCardCreateUi.getStock_type_name_textField().getText());
				
				
				stockTypeCardModel.setId(Integer.parseInt(stockTypeCardCreateUi.getLblNewLabel().getText()));
				ResultSet result = getAfterItemFromStockTypeTable(stockTypeCardModel);

				try {

					while (result.next()) {
						stockTypeCardCreateUi.getLblNewLabel().setText(result.getString("StockId"));
						stockTypeCardCreateUi.getStock_type_code_textField().setText(result.getString("StockTypeCode"));
						stockTypeCardCreateUi.getStock_type_name_textField().setText(result.getString("StockTypeName"));
						stockTypeCardCreateUi.getStock_type_description_textArea().setText(result.getString("StockTypeDescription"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		stockTypeCardCreateUi.getMnNewMenu_3().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
				stockTypeCardModel.setName(stockTypeCardCreateUi.getStock_type_name_textField().getText());
				ResultSet result = getLastItemFromStockTypeTable();

				try {

					if (result.next()) {
						stockTypeCardCreateUi.getLblNewLabel().setText(result.getString("StockId"));
						stockTypeCardCreateUi.getStock_type_code_textField().setText(result.getString("StockTypeCode"));
						stockTypeCardCreateUi.getStock_type_name_textField().setText(result.getString("StockTypeName"));
						stockTypeCardCreateUi.getStock_type_description_textArea().setText(result.getString("StockTypeDescription"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return this.stockTypeCardCreateUi;
	}

	public void Create(StockTypeCardModel stockTypeCardModel) {
		if (stockTypeCardModel.getCode().equals("") || stockTypeCardModel.getName().equals("")
				|| stockTypeCardModel.getDescription().equals("")) {
			JOptionPane.showMessageDialog(null, "Field is not null");
		} else {
			if (stockTypeCardModel.getCode().length() >= 15 || stockTypeCardModel.getName().length() >= 50) {
				JOptionPane.showMessageDialog(null, "Data is long");
				return;

			}

			this.stockTypeCardRepository.Create(stockTypeCardModel);

		}

	}

	public Connection Connect() {

		return this.stockTypeCardRepository.Connect();

	}

	public ResultSet getFirstItemFromStockType() {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

	}

	public ResultSet getAfterItemFromStockTypeTable(StockTypeCardModel stockTypeCardModel) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.stockTypeCardRepository.getAfterItemFromStockTypeTable(stockTypeCardModel);

	}

	public ResultSet getBeforeItemFromStockTypeTable(StockTypeCardModel stockTypeCardModel) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.stockTypeCardRepository.getBeforeItemFromStockTypeTable(stockTypeCardModel);

	}

	public ResultSet getLastItemFromStockTypeTable() {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.stockTypeCardRepository.getLastItemFromStockTypeTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private StockTypeCardModel fill() {
		StockTypeCardModel stockCardModel = new StockTypeCardModel();

		stockCardModel.setCode(stockTypeCardCreateUi.getStock_type_code_textField().getText());
		stockCardModel.setName(stockTypeCardCreateUi.getStock_type_name_textField().getText());
		// stockCardModel.setStockType((int) stock_type_comboBox.getSelectedItem());
		stockCardModel.setDescription(stockTypeCardCreateUi.getStock_type_description_textArea().getText());
		return stockCardModel;
	}

}
