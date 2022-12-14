package command;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class StockTypeCardForwardItemButtonCommand implements Command {
	private StockTypeCardCreateUi cardCreateUi;
	private StockTypeCardRepository cardRepository;

	public StockTypeCardForwardItemButtonCommand(StockTypeCardCreateUi cardCreateUi) {
		this.cardCreateUi = cardCreateUi;

	}

	@Override
	public void execute() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			StockTypeCardModel kdvtypCardModel = new StockTypeCardModel();

			String sql = "select * from stocktypetbl  where StockTypeId = (select MIN(StockTypeId) from stocktypetbl where StockTypeId >"
					+ cardCreateUi.getLblNewLabel().getText() + " )";
			Query query = session.createNativeQuery(sql);
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