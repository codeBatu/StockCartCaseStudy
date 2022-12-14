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
	public static String DELETE_KDV_TYPE_TABLE_BY_ID_SQL_QUERY = "delete from kdv_type_card_tbl where KdvTypeId=?";
	public static String DELETE_STOCK_TYPE_TABLE_BY_ID_SQL_QUERY = "delete from stock_type_card_tbl where StockId=?";
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
	public static String CREATE_STOCK_TYPE_CARD_TABLE_SQL_QUERY = "insert into stock_type_card_tbl " + "("
			+ "StockTypeName," + "StockTypeCode," + "StockTypeDescription)" + "values (?,?,?)";
	public static String CREATE_KDV_TYPE_CARD_TABLE_SQL_QUERY = "insert into" + " kdv_type_card_tbl " + "("
			+ "kdvTypeName," + "KdvTypeCode," + "KdvTypeRatio)" + "values (?,?,?)";
	// -----------------------------------------------------------------------------------

	// Stock Card LİST Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_FİRST_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE = "SELECT (MIN(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId  ";
	public static String GET_LAST_ITEM_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE = "SELECT (MAX(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId";
	public static String GET_NEXT_ITEM_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_BYSTOCKCODE = "SELECT (MIN(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId where StockCode>?";
//	public static String GET_STOCK_CARD_TABLE_BYSTOCKCOD = "SELECT * FROM stock_card_tbl where StockCode=?";
	public static String GET_BACK_ITEM_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_BYSTOCKCODE = "SELECT (max(StockCode)) `StockCode`, `StockName`, `StockType`, `Unit`, `Barcode`, `KdvType`, `Description`, `CreatedDate` ,KdvTypeId , `kdvTypeName`,`KdvTypeCode`, `KdvTypeRatio`,`StockId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`  FROM stock_card_tbl JOIN  kdv_type_card_tbl  ON  stock_card_tbl.KdvType = kdv_type_card_tbl.KdvTypeId JOIN stock_type_card_tbl  ON stock_card_tbl.StockType = stock_type_card_tbl.StockId where StockCode<? ";
	/// ---JOİN
	public static String GET_KDV_TYPE_TABLE_WİTH_STOCK_TYPE_TABLE_WİTH_STOCK_CARD_TABLE_SQL_QUERY = "SELECT  `stock_code`,`stock_name`,`stocktype_id`, `unit`,`barcode`,`kdvtype_id`,`description`,`created_date`,KdvTypeId,`kdvTypeName`,`KdvTypeCode`,`KdvTypeRatio`,`StockTypeId`,`StockTypeName`,`StockTypeCode`,`StockTypeDescription`FROM stockcardtbl LEFT  JOIN  kdvtypetbl ON stockcardtbl.kdvtype_id = kdvtypetbl.KdvTypeId LEFT JOIN stocktypetbl ON stockcardtbl.stocktype_id = stocktypetbl.StockTypeId    ";

	// -----------------------------------------------------------------------------------

	// Stock Card Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_FIRST_ITEM_FROM_STOCK_CARD_TABLE = "SELECT * FROM stockcardtbl ORDER BY   stock_code    LIMIT 1  ";
	public static String GET_LAST_ITEM_FROM_STOCK_CARD_TABLE = "SELECT * FROM stockcardtbl ORDER BY   stock_code  DESC  LIMIT 1  ";
	public static String GET_NEXT_ITEM_FROM_STOCK_CARD_TABLE_BYKDVTYPENAME = "select * from stockcardtbl  where StockCode = (select MIN(StockCode) from stockcardtbl where StockCode > ?)";
	public static String GET_STOCK_CARD_TABLE_BYSTOCKCOD = "SELECT * FROM stockcardtbl where StockCode=?";
	public static String GET_BACK_ITEM_FROM_STOCK_CARD_TABLE_BYSTOCKCODE = "select * from stockcardtbl  where StockCode = (select max(StockCode) from stockcardtbl where StockCode < ?)";

	// -----------------------------------------------------------------------------------

	// Stock Type Sql Querys
	// --------İLERİ GERİ İLK SON

	public static String GET_FIRST_ITEM_FROM_STOCK_TYPE_TABLE = "SELECT * FROM stocktypetbl ORDER BY StockTypeId  LIMIT 1 ";

	public static String GET_LAST_ITEM_FROM_STOCK_TYPE_TABLE = "SELECT * FROM stocktypetbl ORDER BY StockTypeId DESC LIMIT 1 ";

	public static String GET_NEXT_ITEM_FROM_STOCK_TYPE_TABLE_BYSTOCKTYPENAME = "select * from casestudydb.stock_type_card_tbl  where StockId = (select MIN(StockId) from casestudydb.stock_type_card_tbl where StockId > ?)";
	public static String GET_STOCK_TYPE_TABLE_BYSTOCKTYPENAME = "SELECT * FROM stock_type_card_tbl where StockTypeName=?";
	public static String GET_BACK_ITEM_FROM_STOCK_TYPE_TABLE_BYSTOCKTYPENAME = "select * from casestudydb.stock_type_card_tbl  where StockId = (select max(StockId) from casestudydb.stock_type_card_tbl where StockId < ?)";
//-----------------------------------------------------------------------------------

	// Kdv Type Sql Querys
	// --------İLERİ GERİ İLK SON
	public static String GET_FIRST_ITEM_FROM_KDV_TYPE_TABLE = "SELECT * FROM kdvtypetbl ORDER BY KdvTypeId  LIMIT 1 ";
	public static String GET_LAST_ITEM_FROM_KDV_TYPE_TABLE = "SELECT * FROM kdvtypetbl ORDER BY KdvTypeId DESC LIMIT 1 ";
	public static String GET_NEXT_ITEM_FROM_KDV_TYPE_TABLE_BYKDVTYPENAME = "select * from casestudydb.kdv_type_card_tbl  where KdvTypeId = (select MIN(KdvTypeId) from casestudydb.kdv_type_card_tbl where KdvTypeId > ?)";
	public static String GET_KDV_TYPE_TABLE_BYKDVTYPENAME = "SELECT * FROM kdv_type_card_tbl where KdvTypeId=?";
	public static String GET_BACK_ITEM_FROM_kdv_TYPE_TABLE_BYKDVTYPENAME = "select * from casestudydb.kdv_type_card_tbl  where KdvTypeId = (select max(KdvTypeId) from casestudydb.kdv_type_card_tbl where KdvTypeId < ?)";
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

	// ---------------------------------------------------------
	// TABLE COLUMNS TİTLE
	public static String[] COLUMNS_TİTLE = { "StockCode", "StockName", "StockType", "Unit", "Barcode", "KdvType",
			"Description", "CreatedDate", "KdvTypeId", "kdvTypeName", "KdvTypeCode", "KdvTypeRatio", "StockId",
			"StockTypeName", "StockTypeCode", "StockTypeDescription" };

}