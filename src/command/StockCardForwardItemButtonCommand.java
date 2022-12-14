package command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.util.Constant;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.StockCardView;

public class StockCardForwardItemButtonCommand implements Command {

	private StockCardView cardView;
	private StockCardRepository cardRepository;

	public StockCardForwardItemButtonCommand(StockCardView stockCardView) {
		super();
		this.cardView = stockCardView;
	}

	@Override
	public void execute() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			String sql = "select * from stockcardtbl  where stock_code = (select MIN(stock_code) from stockcardtbl where stock_code >"
					+ "'"+cardView.getStock_code_textField().getText() +"'"+ " )";
			Query query = session.createNativeQuery(sql);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
		

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
