package studycase.stockcart.util;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import studycase.stockcart.view.StockTypeCardCreateUi;

public class Constant {
	// DB CONNECT
	public static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/casestudydb";
	public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static String DB_CONNECTİON_NAME = "root";
	public static String DB_PASSWORD = "root123";
	// -------------------------------------------------//
	// OTHER DUZELT BURAYI
	public static String GET_ALL_STOCK_CARD_TABLE_SQL_QUERY = "Select * from stock_card_tbl";
	public static String DELETE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY = "delete from stock_card_tbl where StockCode=?";
	public static String UPDATE_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY = "update  " + " stock_card_tbl set"
			+ " StockName=?,StockType=?," + "Unit=?,Barcode=?,KdvType=?," + "Description=?," + "CreatedDate=? "
			+ "where StockCode=?";
	public static String GET_STOCK_CARD_TABLE_BY_STOCKCARDNO_SQL_QUERY = "Select * from stock_card_tbl"
			+ " where StockCode=?";

	public static String CREATE_STOCK_CARD_TABLE_SQL_QUERY = "insert into stock_card_tbl " + "(StockCode,"
			+ "StockName," + "StockType," + "Unit," + "Barcode," + "KdvType," + "Description," + "CreatedDate)"
			+ "values (?,?,?,?,?,?,?,?)";

	public static String GET_STOCK_TYPE_TABLE_SQL_QUERY = "Select * from stock_type_card_tbl";
	public static String GET_KDV_TYPE_TABLE_SQL_QUERY = "Select * from kdv_type_card_tbl";
	public static String CREATE_STOCK_TYPE_CARD_TABLE_SQL_QUERY = "insert into stock_type_card_tbl " + "(StockId,"
			+ "StockTypeName," + "StockTypeCode," + "StockTypeDescription)" + "values (?,?,?,?)";
	public static String CREATE_KDV_TYPE_CARD_TABLE_SQL_QUERY = "insert into" + " kdv_type_card_tbl " + "(KdvTypeId,"
			+ "kdvTypeName," + "KdvTypeCode," + "KdvTypeRatio)" + "values (?,?,?,?)";
	// -----------------------------------------------------------------------------------

	// Stock Card LİST Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_FİRST_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE = "SELECT (MIN(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId  ";
	public static String GET_LAST_ITEM_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE = "SELECT (MAX(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId";
	public static String GET_NEXT_ITEM_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_BYSTOCKCODE = "SELECT (MIN(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId where StockCode>?";
//	public static String GET_STOCK_CARD_TABLE_BYSTOCKCOD = "SELECT * FROM stock_card_tbl where StockCode=?";
	public static String GET_BACK_ITEM_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_BYSTOCKCODE = "SELECT (max(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId where StockCode<? ";
	/// ---JOİN
	public static String GET_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_SQL_QUERY = "SELECT `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription` FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId  ";
	// -----------------------------------------------------------------------------------

	// Stock Card Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_FIRST_ITEM_FROM_STOCK_CARD_TABLE = "SELECT * FROM casestudydb.stock_card_tbl ORDER BY   StockCode asc   LIMIT 1  ";
	public static String GET_LAST_ITEM_FROM_STOCK_CARD_TABLE = "SELECT * FROM casestudydb.stock_card_tbl ORDER BY  StockCode  desc   LIMIT 1  ";
	public static String GET_NEXT_ITEM_FROM_STOCK_CARD_TABLE_BYKDVTYPENAME = "SELECT MIN(stock_card_tbl.StockCode) AS StockCode  FROM casestudydb.stock_card_tbl where StockCode>?";
	public static String GET_STOCK_CARD_TABLE_BYSTOCKCOD = "SELECT * FROM stock_card_tbl where StockCode=?";
	public static String GET_BACK_ITEM_FROM_STOCK_CARD_TABLE_BYSTOCKCODE = "SELECT MAX(StockCode) AS StockCode  FROM casestudydb.stock_card_tbl where StockCode<?";

	// -----------------------------------------------------------------------------------

	// Stock Type Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_LAST_ID_FROM_STOCK_TYPE_CARD_TABLE_SQL_QUERY = "	SELECT max(StockId) FROM casestudydb.stock_type_card_tbl";
	public static String GET_LAST_ID_FROM_KDV_TYPE_CARD_TABLE_SQL_QUERY = "	SELECT max(StockId) FROM casestudydb.stock_type_card_tbl";

	public static String GET_FIRST_ITEM_FROM_STOCK_TYPE_TABLE = "SELECT * FROM casestudydb.stock_type_card_tbl ORDER BY  StockId   LIMIT 1 ";

	public static String GET_LAST_ITEM_FROM_STOCK_TYPE_TABLE = "SELECT * FROM casestudydb.stock_type_card_tbl ORDER BY  StockId  desc   LIMIT 1 ";

	public static String GET_NEXT_ITEM_FROM_STOCK_TYPE_TABLE_BYSTOCKTYPENAME = "SELECT MIN(StockTypeName) AS StockTypeName  FROM casestudydb.stock_type_card_tbl where StockTypeName>?";
	public static String GET_STOCK_TYPE_TABLE_BYSTOCKTYPENAME = "SELECT * FROM stock_type_card_tbl where StockTypeName=?";
	public static String GET_BACK_ITEM_FROM_STOCK_TYPE_TABLE_BYSTOCKTYPENAME = "SELECT MAX(StockTypeName) AS StockTypeName  FROM casestudydb.stock_type_card_tbl where StockTypeName<?";
//-----------------------------------------------------------------------------------

	// Kdv Type Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_FIRST_ITEM_FROM_KDV_TYPE_TABLE = "SELECT * FROM casestudydb.kdv_type_card_tbl ORDER BY  KdvTypeId   LIMIT 1 ";
	public static String GET_LAST_ITEM_FROM_KDV_TYPE_TABLE = "SELECT * FROM casestudydb.kdv_type_card_tbl ORDER BY  KdvTypeId  desc   LIMIT 1  ";
	public static String GET_NEXT_ITEM_FROM_KDV_TYPE_TABLE_BYKDVTYPENAME = "SELECT MIN(kdv_type_card_tbl.kdvTypeName) AS kdvTypeName  FROM casestudydb.kdv_type_card_tbl where kdvTypeName>?";
	public static String GET_KDV_TYPE_TABLE_BYKDVTYPENAME = "SELECT * FROM kdv_type_card_tbl where kdvTypeName=?";
	public static String GET_BACK_ITEM_FROM_kdv_TYPE_TABLE_BYKDVTYPENAME = "SELECT MAX(kdvTypeName) AS kdvTypeName  FROM casestudydb.kdv_type_card_tbl where kdvTypeName<?";
	// ------------------------------------------------------------------------------------------------------
	// ICON
	public static Icon FIRST_ARROW_ICON = new ImageIcon(
			new ImageIcon(StockTypeCardCreateUi.class.getResource("/assets/First-icon.png")).getImage()
					.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	public static Icon BACK_ARROW_ICON = new ImageIcon(
			new ImageIcon(StockTypeCardCreateUi.class.getResource("/assets/back-icon.png")).getImage()
					.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	public static Icon FORWARD_ARROW_ICON = new ImageIcon(
			new ImageIcon(StockTypeCardCreateUi.class.getResource("/assets/forward-icon.png")).getImage()
					.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	public static Icon LAST_ARROW_ICON = new ImageIcon(
			new ImageIcon(StockTypeCardCreateUi.class.getResource("/assets/Last-icon.png")).getImage()
					.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
}