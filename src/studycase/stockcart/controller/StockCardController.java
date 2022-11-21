package studycase.stockcart.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import studycase.stockcart.model.CrudModel;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.StockCardModel;
import studycase.stockcart.util.Constant;

public class StockCardController {
	private static CrudModel crudModel;

	public StockCardController(CrudModel crudModel) {

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

}
