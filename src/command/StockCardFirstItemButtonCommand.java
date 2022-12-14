package command;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.util.Constant;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockCardView;
import org.hibernate.query.Query;

public class StockCardFirstItemButtonCommand implements Command {

	private StockCardView cardView;
	private StockCardRepository cardRepository = new StockCardRepository();

	public StockCardFirstItemButtonCommand(StockCardView stockCardView) {
		super();
		this.cardView = stockCardView;
	}

	@Override
	public void execute() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Query query = session.createNativeQuery(Constant.GET_FIRST_ITEM_FROM_STOCK_CARD_TABLE);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
//				System.out.println(row[0]);
//				System.out.println(row[1]);
//				System.out.println(row[2]);
//				System.out.println(row[3]);
//				System.out.println(row[4]);
//				System.out.println(row[5]);
//				System.out.println(row[6]);
//				System.out.println(row[7]);

				cardView.getStock_code_textField().setText((String) row[0]);
				cardView.getStock_name_textField().setText((String) row[4]);
				cardView.getStock_type_comboBox().setSelectedItem(row[7]);
				cardView.getUnit_comboBox().setSelectedItem(row[5]);
				cardView.getBarcode_textField().setText((String) row[1]);
				cardView.getKdv_type_comboBox2().setSelectedItem(row[6]);
				cardView.getDescription_textArea().setText((String) row[3]);
				cardView.getCrated_date_formattedTextField().setText((String) row[2]);

			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
