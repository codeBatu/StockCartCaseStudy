package command;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class StockTypeCardSaveButtonCommand implements Command {
	private StockTypeCardCreateUi stockTypeCardView;
	private StockTypeCardRepository stockTypeRepository;

	public StockTypeCardSaveButtonCommand(StockTypeCardCreateUi cardCreateUi) {
		this.stockTypeCardView = cardCreateUi;

	}

	@Override
	public void execute() {

		StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
		
			stockTypeCardModel.setName( this.stockTypeCardView.getStock_type_name_textField().getText());
			stockTypeCardModel.setCode( this.stockTypeCardView.getStock_type_code_textField().getText());
			stockTypeCardModel.setDescription( this.stockTypeCardView.getStock_type_description_textArea().getText());
		

			session.save(stockTypeCardModel);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
//		if (stockTypeCardModel.getCode().equals("") || stockTypeCardModel.getName().equals("")
//				|| stockTypeCardModel.getDescription().equals("")) {
//			JOptionPane.showMessageDialog(null, "Field is not null");
//			return ;
//		} else {
//			if (stockTypeCardModel.getCode().length() >= 15 || stockTypeCardModel.getName().length() >= 50) {
//				JOptionPane.showMessageDialog(null, "Data is long");
//				return;
//
//			}
//
//			this.stockTypeRepository.Create(stockTypeCardModel);

		// }

	}

}
