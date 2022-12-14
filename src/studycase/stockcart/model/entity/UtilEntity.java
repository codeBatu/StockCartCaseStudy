package studycase.stockcart.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UtilEntity {

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getKdvtype_id() {
		return kdvtype_id;
	}

	public void setKdvtype_id(Integer kdvtype_id) {
		this.kdvtype_id = kdvtype_id;
	}

	public Integer getStocktype_id() {
		return stocktype_id;
	}

	public void setStocktype_id(Integer stocktype_id) {
		this.stocktype_id = stocktype_id;
	}

	public Integer getKdvTypeId() {
		return kdvTypeId;
	}

	public void setKdvTypeId(Integer kdvTypeId) {
		this.kdvTypeId = kdvTypeId;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public String getKdvTypeCode() {
		return kdvTypeCode;
	}

	public void setKdvTypeCode(String kdvTypeCode) {
		this.kdvTypeCode = kdvTypeCode;
	}

	public String getKdvTypeName() {
		return kdvTypeName;
	}

	public void setKdvTypeName(String kdvTypeName) {
		this.kdvTypeName = kdvTypeName;
	}

	public Integer getStockTypeId() {
		return stockTypeId;
	}

	public void setStockTypeId(Integer stockTypeId) {
		this.stockTypeId = stockTypeId;
	}

	public String getStockTypeDescription() {
		return stockTypeDescription;
	}

	public void setStockTypeDescription(String stockTypeDescription) {
		this.stockTypeDescription = stockTypeDescription;
	}

	public String getStockTypeName() {
		return stockTypeName;
	}

	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}

	public String getStockTypeCode() {
		return stockTypeCode;
	}

	public void setStockTypeCode(String stockTypeCode) {
		this.stockTypeCode = stockTypeCode;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	private String barcode;
	private String stockCode;
	private String created_date;
	private String stockDescription;
	private String stock_name;
	private String unit;
	private Integer kdvtype_id;
	private Integer stocktype_id;

	private Integer kdvTypeId;
	private Double ratio;
	private String kdvTypeCode;
	private String kdvTypeName;

	private Integer stockTypeId;

	private String stockTypeDescription;

	private String stockTypeName;

	private String stockTypeCode;

}
