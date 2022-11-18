package studycase.stockcart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import studycase.stockcart.util.Constant;

public class CrudModel {
	

	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;


public void LoadData(JTable table) {
	
	try {
		pst = con.prepareStatement(Constant.GET_ALL_STOCK_CARD_TABLE_SQL_QUERY);
		rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception ex) {
		ex.printStackTrace();
	}
}
	public Connection  Connect() {
		try {
			Class.forName(Constant.DRIVER_NAME);
			String url = Constant.JDBC_URL;
		
			String username = Constant.DB_CONNECTİON_NAME;
			String password = Constant.DB_PASSWORD;

			con = DriverManager.getConnection(url, username, password);
		return con ;
		} catch (Exception ex) {
		
			ex.printStackTrace();
		}
		return con ;
	}
	public ResultSet getStockCard() {
		try {
			pst = con.prepareStatement(Constant.GET_ALL_STOCK_CARD_TABLE_SQL_QUERY);
		
			return pst.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}


	public void updateDb(
			String stockCod , 
			String stockName,
			int stockType,
			String unit, 
			String barcode, Double kdvType, 
			String description ,
			String cratedDate ) {
		try {
				pst = con.prepareStatement(Constant.UPDATE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY);

				pst.setString(8,stockCod);
				pst.setString(1,stockName);
				pst.setInt(2,stockType);
				pst.setString(3,unit);
				pst.setString(4,barcode);
				pst.setDouble(5,kdvType);
				pst.setString(6,description);
				pst.setString(7,cratedDate);
			
			pst.executeUpdate();
		stockCod = "";
		stockName = "";
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			JOptionPane.showMessageDialog(null, "Data update Success");
		

}
	public void createDb(String stockCod , 
			String stockName,
			int stockType,
			String unit, 
			String barcode, Double kdvType, 
			String description ,
			String cratedDate ) {
		try {
				pst = con.prepareStatement(Constant.CREATE_STOCK_CARD_TABLE_SQL_QUERY);

				pst.setString(1,stockCod);
				pst.setString(2,stockName);
				pst.setInt(3,stockType);
				pst.setString(4,unit);
				pst.setString(5,barcode);
				pst.setDouble(6,kdvType);
				pst.setString(7,description);
				pst.setString(8,cratedDate);
			
			pst.executeUpdate();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			JOptionPane.showMessageDialog(null, "Data update Success");
	}
	public void deleteDb(String stockCod  ) {
		try {
				pst = con.prepareStatement(Constant.DELETE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY);

				pst.setString(1,stockCod);
			
			
			pst.executeUpdate();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JOptionPane.showMessageDialog(null, "Data update Success");
	}
	public ResultSet getStockCartByStockCode(String stockCod  ) {
		try {
				pst = con.prepareStatement(Constant.GET_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY);

				pst.setString(1,stockCod);
			
				JOptionPane.showMessageDialog(null, "Data update Success");
			
		
				return		 pst.executeQuery();
			
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return  rs;
		
	
	
			
	}
	
		}
