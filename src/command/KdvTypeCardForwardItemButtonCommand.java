package command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.query.Query;

import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.util.Constant;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.KdvTypeCardCreateUi;

public class KdvTypeCardForwardItemButtonCommand implements Command {
	private KdvTypeCardCreateUi kdvTypeCardCreateUi;
	private KdvTypeCardRepository cardRepository;

	public KdvTypeCardForwardItemButtonCommand(KdvTypeCardCreateUi kdvTypeCardCreateUi) {
		super();
		this.kdvTypeCardCreateUi = kdvTypeCardCreateUi;
	}

	@Override
	public void execute() {
		KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();

		// Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			if (kdvTypeCardCreateUi.getLblNewLabel().getText().equals("id")) {
				JOptionPane.showInternalConfirmDialog(null, "hh");
				return;
			}
			String sql = "select * from kdvtypetbl  where KdvTypeId = (select MIN(KdvTypeId) from kdvtypetbl where KdvTypeId >"
					+ kdvTypeCardCreateUi.getLblNewLabel().getText() + " )";
			Query query = session.createNativeQuery(sql);
			List<Object[]> results = query.getResultList();
			for (Object[] row : results) {
				kdvTypeCardCreateUi.getLblNewLabel().setText(((Integer) row[0]).toString());
				kdvTypeCardCreateUi.getKdv_type_code_textField().setText((String) row[1]);
				kdvTypeCardCreateUi.getKdv_type_name_textField().setText((String) row[2]);
				kdvTypeCardCreateUi.getKdv_type_ratio_textField().setText(((Double) row[3]).toString());
	

			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
