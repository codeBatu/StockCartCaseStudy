package studycase.stockcart.model;

public class StockCardModel {
	private String stockCod;

	public String getStockCod() {
		return stockCod;
	}

	public void setStockCod(String stockCod) {
		this.stockCod = stockCod;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Double getKdvType() {
		return kdvType;
	}

	public void setKdvType(Double kdvType) {
		this.kdvType = kdvType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCratedDate() {
		return cratedDate;
	}

	public void setCratedDate(String cratedDate) {
		this.cratedDate = cratedDate;
	}

	private String stockName;
	private int stockType;
	private String unit;
	private String barcode;
	private Double kdvType;
	private String description;
	private String cratedDate;

}
