package studycase.stockcart.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockTypeCardModel;

public class StockTypeCardController {

	private StockTypeCardRepository stockTypeCardRepository;

	public StockTypeCardController(StockTypeCardRepository stockTypeCardRepository) {
		this.stockTypeCardRepository = stockTypeCardRepository;

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

}
