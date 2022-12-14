package studycase.stockcart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.hibernate.Session;
import org.hibernate.query.Query;

import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.model.entity.UtilEntity;
import studycase.stockcart.util.Constant;
import studycase.stockcart.util.HibernateUtil;

public class StockCardRepository {

	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;

	public StockCardRepository() {
		Connect();

	}

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

	public List<UtilEntity> getStockCard() {

		List<UtilEntity> stocktype = new ArrayList<>();

		// Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

//			Query<UtilEntity> query = session.createNativeQuery(
//					Constant.GET_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_SQL_QUERY);
//			stocktype = query.getResultList();
//			
//			stocktype.stream().map
			Query query = session.createNativeQuery(
					Constant.GET_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_SQL_QUERY);
			List<Object[]> results = query.getResultList();

			for (Object[] row : results) {
				UtilEntity model = new UtilEntity();
				model.setStockCode(row[0].toString());
				model.setStock_name(row[1].toString());
				model.setStocktype_id((Integer) row[2]);
				model.setUnit(row[3].toString());
				model.setBarcode(row[4].toString());

				model.setKdvtype_id((Integer) row[5]);
				model.setStockDescription(row[6].toString());
				model.setCreated_date(row[7].toString());

				model.setKdvTypeId((Integer) row[8]);
				model.setKdvTypeName(row[9].toString());
				model.setKdvTypeCode(row[10].toString());
				model.setRatio((Double) row[11]);
				model.setStockTypeId((Integer) row[12]);
				model.setStockTypeName(row[13].toString());
				model.setStockTypeCode(row[14].toString());
				model.setStockDescription(row[15].toString());

				stocktype.add(model);

			}

		} catch (Exception e) {
			System.out.println(e);

		}

		return stocktype;
	}

	public List<KdvTypeCardModel> getKdvTypeTable() {
		List<KdvTypeCardModel> kdvType = new ArrayList<>();

		// Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			String sql = "SELECT * FROM kdvtypetbl";
			Query query = session.createNativeQuery(sql);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
				KdvTypeCardModel model = new KdvTypeCardModel();
				model.setId((Integer) row[0]);

				kdvType.add(model);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		if (kdvType.isEmpty()) {

			return new ArrayList<>();
		}
		return kdvType;
	}

	public List<StockTypeCardModel> getStockTypeByStockIdList() {

		List<StockTypeCardModel> stocktype = new ArrayList<>();

		// Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			String sql = "SELECT * FROM stocktypetbl";
			Query query = session.createNativeQuery(sql);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
				StockTypeCardModel model = new StockTypeCardModel();
				model.setId((Integer) row[0]);

				stocktype.add(model);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		if (stocktype.isEmpty()) {

			return new ArrayList<>();
		}
		return stocktype;

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
