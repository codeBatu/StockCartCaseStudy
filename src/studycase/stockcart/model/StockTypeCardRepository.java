package studycase.stockcart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

public class StockTypeCardRepository implements ICrudRepository<StockTypeCardModel> {
	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;

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

	public ResultSet getFirstItemFromStockTypeTable() {

		try {
			pst = con.prepareStatement(Constant.GET_FIRST_ITEM_FROM_KDV_TYPE_TABLE);

			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getLastItemFromStockTypeTable() {

		try {
			pst = con.prepareStatement(Constant.GET_LAST_ITEM_FROM_STOCK_TYPE_TABLE);

			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getAfterItemFromStockTypeTable(StockTypeCardModel stockTypeCardModel) {

		try {
			pst = con.prepareStatement(Constant.GET_NEXT_ITEM_FROM_STOCK_TYPE_TABLE_BYSTOCKTYPENAME);

			pst.setString(1, stockTypeCardModel.getName());

			var result = pst.executeQuery();
			String r = "";
			while (result.next()) {
				r = result.getString("kdvTypeName");
			}
			pst = con.prepareStatement(Constant.GET_STOCK_TYPE_TABLE_BYSTOCKTYPENAME);

			pst.setString(1, r);

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getBeforeItemFromStockTypeTable(StockTypeCardModel stockTypeCardModel) {

		try {
			pst = con.prepareStatement(Constant.GET_BACK_ITEM_FROM_STOCK_TYPE_TABLE_BYSTOCKTYPENAME);

			pst.setString(1, stockTypeCardModel.getName());

			var result = pst.executeQuery();
			String r = "";
			while (result.next()) {
				r = result.getString("kdvTypeName");
			}
			pst = con.prepareStatement(Constant.GET_STOCK_TYPE_TABLE_BYSTOCKTYPENAME);

			pst.setString(1, r);

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void Create(StockTypeCardModel stockTypeCardModel) {
		var lastId = getLastId();
		try {

			pst = con.prepareStatement(Constant.CREATE_STOCK_TYPE_CARD_TABLE_SQL_QUERY);

			pst.setLong(1, lastId);
			pst.setString(2, stockTypeCardModel.getCode());
			pst.setString(3, stockTypeCardModel.getName());
			pst.setString(4, stockTypeCardModel.getDescription());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int getLastId() {

		int lastId = 0;

		try {
			pst = con.prepareStatement(Constant.GET_LAST_ID_FROM_STOCK_TYPE_CARD_TABLE_SQL_QUERY);
			rs = pst.executeQuery();
			while (rs.next()) {
				lastId = rs.getInt(1);
				lastId++;
				return lastId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, Integer.toString(lastId));

		return 1;

	}

	@Override
	public void Delete() {

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet Get() {
		try {
			pst = con.prepareStatement(Constant.GET_STOCK_TYPE_TABLE_SQL_QUERY);

			return pst.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;

	}

}
