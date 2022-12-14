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
@Table(name = "kdvtypetbl")
@Audited
//@AuditTable(value = "KdvType_Audited")
public class KdvTypeCardModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KdvTypeId")
	private Integer id;
	@Column(name = "KdvTypeCode")
	private String code;

	@Column(name = "KdvTypeRatio")
	private Double ratio;
	@Column(name = "KdvTypeName")
	private String name;

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the id
	 */
	

	@OneToOne(mappedBy = "kdvTypeId")
	private StockCardModel stockCardModel;

}
