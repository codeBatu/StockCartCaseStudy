package studycase.stockcart.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "stocktypetbl")

//@AuditTable(value = "StockType_Audited")
public class StockTypeCardModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "StockTypeId")
	private Integer id;
	@Column(name = "StockTypeDescription")
	private String description;

	@Column(name = "StockTypeName")
	private String name;

	public String getName() {
		return name;
	}

	@Column(name = "StockTypeCode")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

//	@OneToOne(mappedBy = "stockTypeId")
//	private StockCardModel stockCardModel;

}
