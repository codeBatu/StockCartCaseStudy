package command;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session;
		session = sessionFactory.openSession();
		session.beginTransaction();
		KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();

		kdvTypeCardModel.setId(1);
		session.delete(kdvTypeCardModel);
		session.getTransaction().commit();
		session.close();

//		Transaction transaction = null;
//
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//
//			transaction = session.beginTransaction();
//
//			KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
//
//			kdvTypeCardModel.setId(Integer.parseInt(kdvTypeCardCreateUi.getLblNewLabel().getText()));
//			session.delete(kdvTypeCardModel);
//
//			transaction.commit();

//		} catch (Exception e) {
//			if (transaction != null) {
//				// transaction.rollback();
//				System.out.println("burda");
//			}
//			e.printStackTrace();
//
//		}

		// this.cardRepository.deleteDb(Integer.parseInt(kdvTypeCardCreateUi.getLblNewLabel().getText()));

	}

}
