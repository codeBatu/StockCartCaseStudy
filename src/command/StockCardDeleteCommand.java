package command;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockCardView;

public class StockCardDeleteCommand implements Command {

	private StockCardView cardView;
	private StockCardRepository cardRepository = new StockCardRepository();

	public StockCardDeleteCommand(StockCardView stockCardView) {
		super();
		this.cardView = stockCardView;
	}

	@Override

	public void execute() {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			StockCardModel stockCardModel = new StockCardModel();
			stockCardModel.setStockCod(cardView.getStock_code_textField().getText());

			session.delete(stockCardModel);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				// transaction.rollback();
			}
			e.printStackTrace();

		}

	}

}