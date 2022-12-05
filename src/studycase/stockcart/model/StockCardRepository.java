package studycase.stockcart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

public class StockCardRepository {

	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;

	public void LoadData(JTable table) {

		try {
			pst = con.prepareStatement(
					Constant.GET_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_SQL_QUERY);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Connection Connect() {
		try {
			Class.forName(Constant.DRIVER_NAME);
			String url = Constant.JDBC_URL;

			String username = Constant.DB_CONNECTİON_NAME;
			String password = Constant.DB_PASSWORD;

			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return con;

	}

	public ResultSet getStockCard() {
		try {
			pst = con.prepareStatement(
					Constant.GET_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_SQL_QUERY);

			return pst.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void updateDb(StockCardModel sotckCardModel) {
		try {
			pst = con.prepareStatement(Constant.UPDATE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY);

			pst.setString(8, sotckCardModel.getStockCod());
			pst.setString(1, sotckCardModel.getStockName());
			pst.setInt(2, sotckCardModel.getStockType());
			pst.setString(3, sotckCardModel.getUnit());
			pst.setString(4, sotckCardModel.getBarcode());
			pst.setDouble(5, sotckCardModel.getKdvType());
			pst.setString(6, sotckCardModel.getDescription());
			pst.setString(7, sotckCardModel.getCratedDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Data update Success");

	}

	public void createDb(StockCardModel sotckCardModel) {
		try {
			pst = con.prepareStatement(Constant.CREATE_STOCK_CARD_TABLE_SQL_QUERY);
			pst.setString(1, sotckCardModel.getStockCod());
			pst.setString(2, sotckCardModel.getStockName());
			pst.setInt(3, sotckCardModel.getStockType());
			pst.setString(4, sotckCardModel.getUnit());
			pst.setString(5, sotckCardModel.getBarcode());
			pst.setDouble(6, sotckCardModel.getKdvType());
			pst.setString(7, sotckCardModel.getDescription());
			pst.setString(8, sotckCardModel.getCratedDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Data update Success");
	}

	public void deleteDb(String stockCod) {
		try {
			pst = con.prepareStatement(Constant.DELETE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY);

			pst.setString(1, stockCod);

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Data update Success");
	}

	public ResultSet getStockCartByStockCode(String stockCod) {
		try {
			pst = con.prepareStatement(Constant.GET_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY);

			pst.setString(1, stockCod);

			JOptionPane.showMessageDialog(null, "Data update Success");

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	public ResultSet getKdvTypeTable() {
		try {
			pst = con.prepareStatement(Constant.GET_KDV_TYPE_TABLE_SQL_QUERY);

			rs = pst.executeQuery();

			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getStockTypeByKdvTypeId() {
		try {
			pst = con.prepareStatement(Constant.GET_STOCK_TYPE_TABLE_SQL_QUERY);

			rs = pst.executeQuery();

			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getFirstItemFromStockTable() {

		try {
			pst = con.prepareStatement(Constant.GET_FIRST_ITEM_FROM_STOCK_CARD_TABLE);

			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getLastItemFromStockTable() {

		try {
			pst = con.prepareStatement(Constant.GET_LAST_ITEM_FROM_STOCK_CARD_TABLE);

			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getAfterItemFromStockTable(StockCardModel cardModel) {

		try {
			pst = con.prepareStatement(Constant.GET_NEXT_ITEM_FROM_STOCK_CARD_TABLE_BYKDVTYPENAME);

			pst.setString(1, cardModel.getStockCod());

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getBeforeItemFromStockTable(StockCardModel cardModel) {

		try {
			pst = con.prepareStatement(Constant.GET_BACK_ITEM_FROM_STOCK_CARD_TABLE_BYSTOCKCODE);

			pst.setString(1, cardModel.getStockCod());

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}


}
