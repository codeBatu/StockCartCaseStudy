package command;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class StockTypeCardDeleteButtonCommand implements Command {
	private StockTypeCardCreateUi cardCreateUi;
	private StockTypeCardRepository cardRepository;

	public StockTypeCardDeleteButtonCommand(StockTypeCardCreateUi cardCreateUi) {
		this.cardCreateUi = cardCreateUi;
	}

	@Override
	public void execute() {

		StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			stockTypeCardModel.setId(Integer.parseInt(cardCreateUi.getLblNewLabel().getText()));
			session.delete(stockTypeCardModel);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				// transaction.rollback();
			
			}
			e.printStackTrace();

		}
	}
}
