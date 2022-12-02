package studycase.stockcart.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

public class StockCardController {
	private static StockCardRepository crudModel;

	public StockCardController(StockCardRepository crudModel) {

		this.crudModel = crudModel;
	}

	public void updateDb( StockCardModel stockCardModel) {

		if (stockCardModel.getStockCod().equals("") ||stockCardModel.getStockName().equals("") || stockCardModel.getBarcode().equals("") || stockCardModel.getDescription().equals("")
				|| stockCardModel.getCratedDate().equals("")) {
			JOptionPane.showMessageDialog(null, "Field is not null");
		} else {
			if (stockCardModel.getStockCod().length() >= 50 || stockCardModel.getStockName().length() >= 100 || stockCardModel.getBarcode().length() >= 30) {
				JOptionPane.showMessageDialog(null, "Data is long");
				return;
 
			}

			this.crudModel.updateDb(stockCardModel);

		}
	}

	public void LoadData(JTable table) {

		this.crudModel.LoadData(table);
	}

	public void createDb( StockCardModel stockCardModel) {

		if (stockCardModel.getStockCod().equals("") ||stockCardModel.getStockName().equals("") || stockCardModel.getBarcode().equals("") || stockCardModel.getDescription().equals("")
				|| stockCardModel.getCratedDate().equals("")) {
			JOptionPane.showMessageDialog(null, "Field is not null");
		} else {
			if (stockCardModel.getStockCod().length() >= 50 || stockCardModel.getStockName().length() >= 100 || stockCardModel.getBarcode().length() >= 30) {
				JOptionPane.showMessageDialog(null, "Data is long");
				return;
 
			}

			this.crudModel.createDb(stockCardModel);

		}
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
	public ResultSet getStockTypeByKdvTypeId() {
		
		return this.crudModel.getStockTypeByKdvTypeId();
	}
	public ResultSet getKdvTypeTable() {
		
		return this.crudModel.getKdvTypeTable();
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
	public void getFirstItemFromStockListWithKdvListWithStockType(JTable j)  {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

	this.crudModel.getFirstItemFromStockListWithKdvListWithStockType(j);

	}

	public void getAfterItemFromStockListWithKdvListWithStockType(StockCardModel stockCardModel,JTable j) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		 this.crudModel.getAfterItemFromStockListWithKdvListWithStockType(stockCardModel, j);

	}

	public void getBeforeItemFromStockListWithKdvListWithStockType(StockCardModel stockCardModel,JTable j) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		 this.crudModel.getBeforeItemFromStockListWithKdvListWithStockType(stockCardModel, j);

	}
	
	
	public void getLastItemFromStockListWithKdvListWithStockType(JTable j) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		 this.crudModel.getLastItemFromStockListWithKdvListWithStockType(j);

	}

}
