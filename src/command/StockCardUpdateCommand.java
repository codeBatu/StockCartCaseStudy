package command;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockCardView;

public class StockCardUpdateCommand implements Command {

	private StockCardView _stockCardView;
	private StockCardRepository cardRepository;

	public StockCardUpdateCommand(StockCardView stockCardView) {
		super();
		_stockCardView = stockCardView;
	}

	@Override
	public void execute() {
		Transaction transaction = null;
		StockCardModel stockCardModel = new StockCardModel();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			StockTypeCardModel stockTypeCardModel = new StockTypeCardModel();
			stockTypeCardModel.setId((Integer) _stockCardView.getStock_type_comboBox().getSelectedItem());
			KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
			kdvTypeCardModel.setId((Integer) _stockCardView.getKdv_type_comboBox2().getSelectedItem());

			

			transaction = session.beginTransaction();
			stockCardModel.setStockCod(_stockCardView.getStock_code_textField().getText());
			stockCardModel.setStockName(_stockCardView.getStock_name_textField().getText());
			stockCardModel.setStockTypeId(stockTypeCardModel);
			stockCardModel.setUnit(_stockCardView.getUnit_comboBox().getSelectedItem().toString());
			stockCardModel.setBarcode(_stockCardView.getBarcode_textField().getText());
			stockCardModel.setKdvTypeId(kdvTypeCardModel);
			stockCardModel.setDescription(_stockCardView.getDescription_textArea().getText());
			stockCardModel.setCratedDate(_stockCardView.getCrated_date_formattedTextField().getText());

			session.saveOrUpdate(stockCardModel);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				// transaction.rollback();
			}
			e.printStackTrace();

		}

	}

}
