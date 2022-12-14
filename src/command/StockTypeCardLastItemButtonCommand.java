package command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class StockTypeCardLastItemButtonCommand  implements Command {
	private StockTypeCardCreateUi cardCreateUi;
	private StockTypeCardRepository cardRepository;

	public StockTypeCardLastItemButtonCommand(StockTypeCardCreateUi cardCreateUi) {
		this.cardCreateUi = cardCreateUi;

	}	 
	
	@Override
	public void execute() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			StockTypeCardModel kdvtypCardModel = new StockTypeCardModel();

			Query query = session.createNativeQuery(Constant.GET_LAST_ITEM_FROM_STOCK_TYPE_TABLE);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
				cardCreateUi.getLblNewLabel().setText(((Integer) row[0]).toString());
				cardCreateUi.getStock_type_code_textField().setText((String) row[1]);
				cardCreateUi.getStock_type_name_textField().setText((String) row[2]);
				cardCreateUi.getStock_type_description_textArea().setText(((String) row[3]));

			}

		} catch (Exception e) {
			System.out.println(e);

		}

		
	}

}
