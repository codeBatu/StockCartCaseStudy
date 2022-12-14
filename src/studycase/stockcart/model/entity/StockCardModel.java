package studycase.stockcart.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "stockcardtbl")
@Audited

public class StockCardModel {
	@Id
	@Column(name = "stock_code")
	private String stockCod;

	@Column(name = "stock_name")
	private String stockName;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stocktype_id")
	private StockTypeCardModel stockTypeId;
	@Column(name = "unit")
	private String unit;
	@Column(name = "barcode")
	private String barcode;

	@OneToOne
	@JoinColumn(name = "kdvtype_id")
	private KdvTypeCardModel kdvTypeId;

	@Column(name = "description")
	private String description;
	@Column(name = "created_date")
	private String cratedDate;

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

	public KdvTypeCardModel getKdvTypeId() {
		return kdvTypeId;
	}

	/**
	 * @param kdvTypeId the kdvTypeId to set
	 */
	public void setKdvTypeId(KdvTypeCardModel kdvTypeId) {
		this.kdvTypeId = kdvTypeId;
	}

	/**
	 * @return the stockTypeId
	 */
	public StockTypeCardModel getStockTypeId() {
		return stockTypeId;
	}

	/**
	 * @param stockTypeId the stockTypeId to set
	 */
	public void setStockTypeId(StockTypeCardModel stockTypeId) {
		this.stockTypeId = stockTypeId;
	}

}
