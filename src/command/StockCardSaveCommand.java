package command;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockCardView;

public class StockCardSaveCommand implements Command {

	private StockCardView cardView;

	StockCardModel stockCardModel = new StockCardModel();

	public StockCardSaveCommand(StockCardView stockCardView) {
		super();
		this.cardView = stockCardView;
	}

	@Override
	public void execute() {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
			stockTypeCardModel.setId((Integer) cardView.getStock_type_comboBox().getSelectedItem());
			KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
			kdvTypeCardModel.setId((Integer) cardView.getKdv_type_comboBox2().getSelectedItem());

			// kdvTypeCardModel.setId((Integer)
			// cardView.getKdv_type_comboBox2().getSelectedItem());

			transaction = session.beginTransaction();
			stockCardModel.setStockCod(cardView.getStock_code_textField().getText());
			stockCardModel.setStockName(cardView.getStock_name_textField().getText());
		stockCardModel.setStockTypeId(stockTypeCardModel);
			stockCardModel.setUnit(cardView.getUnit_comboBox().getSelectedItem().toString());
			stockCardModel.setBarcode(cardView.getBarcode_textField().getText());
			stockCardModel.setKdvTypeId(kdvTypeCardModel);
			stockCardModel.setDescription(cardView.getDescription_textArea().getText());
			stockCardModel.setCratedDate(cardView.getCrated_date_formattedTextField().getText());

			session.save(stockCardModel);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				// transaction.rollback();
			}
			e.printStackTrace();

		}

	}

}
