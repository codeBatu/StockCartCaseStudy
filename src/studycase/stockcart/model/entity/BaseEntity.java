package studycase.stockcart.model.entity;

public class BaseEntity {
	private KdvTypeCardModel id;
	public KdvTypeCardModel getId() {
		return id;
	}
	public void setId(KdvTypeCardModel id) {
		this.id = id;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	private String Code;
	private String  Name ;
}
