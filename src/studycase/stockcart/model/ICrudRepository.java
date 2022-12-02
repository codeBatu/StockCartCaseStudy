package studycase.stockcart.model;

import java.sql.ResultSet;

public interface ICrudRepository<T> {
	
	void Create(T t);
	void Delete();
	void Update();
	ResultSet Get();
	

}
