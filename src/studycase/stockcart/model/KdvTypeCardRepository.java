package studycase.stockcart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;

public class KdvTypeCardRepository implements ICrudRepository<KdvTypeCardModel> {

	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public void Create(KdvTypeCardModel kdvTypeCardModel) {
		int lastId = getLastId();
		lastId++;
		try {

			pst = con.prepareStatement(Constant.CREATE_KDV_TYPE_CARD_TABLE_SQL_QUERY);
			pst.setLong(1, lastId);
			pst.setString(2, kdvTypeCardModel.getCode());
			pst.setString(3, kdvTypeCardModel.getName());
			pst.setDouble(4, kdvTypeCardModel.getRatio());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet Get() {
		return rs;

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

	private int getLastId() {

		int lastId = 1;

		try {
			pst = con.prepareStatement(Constant.GET_LAST_ID_FROM_KDV_TYPE_CARD_TABLE_SQL_QUERY);
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

	public ResultSet getFirstItemFromKdvTypeTable() {

		try {
			pst = con.prepareStatement(Constant.GET_FIRST_ITEM_FROM_KDV_TYPE_TABLE);

			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getLastItemFromKdvTypeTable() {

		try {
			pst = con.prepareStatement(Constant.GET_LAST_ITEM_FROM_KDV_TYPE_TABLE);

			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getAfterItemFromKdvTypeTable(KdvTypeCardModel cardModel) {

		try {
			pst = con.prepareStatement(Constant.GET_NEXT_ITEM_FROM_KDV_TYPE_TABLE_BYKDVTYPENAME);

			pst.setString(1, cardModel.getName());

			var result = pst.executeQuery();
			String r = "";
			while (result.next()) {
				r = result.getString("kdvTypeName");
				System.out.println(r);
			}
			pst = con.prepareStatement(Constant.GET_KDV_TYPE_TABLE_BYKDVTYPENAME);

			pst.setString(1, r);

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getBeforeItemFromKdvTypeTable(KdvTypeCardModel cardModel) {

		try {
			pst = con.prepareStatement(Constant.GET_BACK_ITEM_FROM_kdv_TYPE_TABLE_BYKDVTYPENAME);

			pst.setString(1, cardModel.getName());

			var result = pst.executeQuery();
			String r = "";
			while (result.next()) {
				r = result.getString("kdvTypeName");
			}
			pst = con.prepareStatement(Constant.GET_KDV_TYPE_TABLE_BYKDVTYPENAME);

			pst.setString(1, r);

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
