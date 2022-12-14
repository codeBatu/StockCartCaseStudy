package command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.util.Constant;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.KdvTypeCardCreateUi;

public class KdvTypeCardLastItemButtonCommand implements Command {
	private KdvTypeCardCreateUi kdvTypeCardCreateUi;
	private KdvTypeCardRepository cardRepository;

	public KdvTypeCardLastItemButtonCommand(KdvTypeCardCreateUi kdvTypeCardCreateUi) {
		super();
		this.kdvTypeCardCreateUi = kdvTypeCardCreateUi;
	}

	@Override
	public void execute() {
		KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();

		// Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			String sql = "SELECT * FROM stocktypetbl";
			Query query = session.createNativeQuery(Constant.GET_LAST_ITEM_FROM_KDV_TYPE_TABLE);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
		kdvTypeCardCreateUi.getLblNewLabel().setText( ((Integer) row[0]).toString());
	kdvTypeCardCreateUi.getKdv_type_code_textField().setText((String) row[1]);
				kdvTypeCardCreateUi.getKdv_type_name_textField().setText((String) row[2]);
				kdvTypeCardCreateUi.getKdv_type_ratio_textField().setText(((Double) row[3]).toString());


			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
