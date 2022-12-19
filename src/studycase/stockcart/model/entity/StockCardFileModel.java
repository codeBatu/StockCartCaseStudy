package studycase.stockcart.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "stockcardfilestbl")

public class StockCardFileModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fileid")
	private Integer id;

	@Column(name = "filedescription")
	private String sendFileDescription;

	@Column(name = "filename")
	private String fileName;

	@ManyToOne
	@JoinColumn(name = "stock_card_id")
	private StockCardModel stockcards;

	/**
	 * @return the sendFileDescription
	 */
	public String getSendFileDescription() {
		return sendFileDescription;
	}

	/**
	 * @param sendFileDescription the sendFileDescription to set
	 */
	public void setSendFileDescription(String sendFileDescription) {
		this.sendFileDescription = sendFileDescription;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public StockCardModel getStockcards() {
		return stockcards;
	}

	public void setStockcards(StockCardModel stockcards) {
		this.stockcards = stockcards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
