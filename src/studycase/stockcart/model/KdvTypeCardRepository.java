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

		try {
			Connect();
			pst = con.prepareStatement(Constant.CREATE_KDV_TYPE_CARD_TABLE_SQL_QUERY);

			pst.setString(1, kdvTypeCardModel.getCode());
			pst.setString(2, kdvTypeCardModel.getName());
			pst.setDouble(3, kdvTypeCardModel.getRatio());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public void deleteDb(Integer stockId) {
//		try {
//			Connect();
//			pst = con.prepareStatement(Constant.DELETE_KDV_TYPE_TABLE_BY_ID_SQL_QUERY);
//
//			pst.setInt(1, stockId);
//
//			pst.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JOptionPane.showMessageDialog(null, "Data update Success");
//	}

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

		//	pst.setInt(1, cardModel.getId());

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

	//		pst.setInt(1, cardModel.getId());

			return pst.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
