package command;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.KdvTypeCardCreateUi;

public class KdvTypeCardDeleteButtonCommand implements Command {

	private KdvTypeCardRepository cardRepository;
	private KdvTypeCardCreateUi kdvTypeCardCreateUi;

	public KdvTypeCardDeleteButtonCommand(KdvTypeCardCreateUi kdvTypeCardCreateUi) {
		super();
		this.kdvTypeCardCreateUi = kdvTypeCardCreateUi;
	}

	@Override
	public void execute() {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();

			kdvTypeCardModel.setId(Integer.parseInt(kdvTypeCardCreateUi.getLblNewLabel().getText()));
			session.delete(kdvTypeCardModel);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				// transaction.rollback();
				System.out.println("burda");
			}
			e.printStackTrace();

		}

		// this.cardRepository.deleteDb(Integer.parseInt(kdvTypeCardCreateUi.getLblNewLabel().getText()));

	}

}
