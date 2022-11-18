package studycase.stockcart.util;

public class Constant {
public static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/casestudydb";
public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
public static String DB_CONNECTİON_NAME = "root";
public static String DB_PASSWORD = "root123";
public static String GET_ALL_STOCK_CARD_TABLE_SQL_QUERY = "Select * from stock_card_tbl";
public static String DELETE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY = "delete from stock_card_tbl where StockCode=?";
public static String UPDATE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY = "update  "
		+ " stock_card_tbl set"
		+ " StockName=?,StockType=?,"
		+ "Unit=?,Barcode=?,KdvType=?,"
		+ "Description=?,"
		+ "CreatedDate=? "
		+ "where StockCode=?";
public static String GET_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY = "Select * from stock_card_tbl"
		+ " where StockCode=?";

public static String CREATE_STOCK_CARD_TABLE_SQL_QUERY = "insert into stock_card_tbl "
		+ "(StockCode,"
		+ "StockName,"
		+ "StockType,"
		+ "Unit,"
		+ "Barcode,"
		+ "KdvType,"
		+ "Description,"
		+ "CreatedDate)"
		+ "values (?,?,?,?,?,?,?,?)"
	;}
