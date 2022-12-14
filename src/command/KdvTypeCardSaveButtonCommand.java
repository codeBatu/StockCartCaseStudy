package command;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.HibernateUtil;
import studycase.stockcart.view.KdvTypeCardCreateUi;

public class KdvTypeCardSaveButtonCommand implements Command {
	private KdvTypeCardCreateUi kdvTypeCardCreateUi;
	private KdvTypeCardRepository cardRepository;
	public KdvTypeCardSaveButtonCommand(KdvTypeCardCreateUi kdvTypeCardCreateUi) {
		super();
		this.kdvTypeCardCreateUi = kdvTypeCardCreateUi;
	}

	

	@Override
	public void execute() {
	
		KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
		
		
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
		
			kdvTypeCardModel.setRatio(Double.parseDouble(kdvTypeCardCreateUi.getKdv_type_ratio_textField().getText()));
			kdvTypeCardModel.setCode(kdvTypeCardCreateUi.getKdv_type_code_textField().getText());
			kdvTypeCardModel.setName(kdvTypeCardCreateUi.getKdv_type_name_textField().getText());
		

			session.save(kdvTypeCardModel);
			transaction.commit();
		session.close();
//		
//
//		if (kdvTypeCardModel.getCode().equals("") || kdvTypeCardModel.getName().equals("")
//				|| kdvTypeCardModel.getRatio().toString().equals("")) {
//
//			JOptionPane.showMessageDialog(null, "Field is not null");
//		} else {
//			if (kdvTypeCardModel.getCode().length() >= 15 || kdvTypeCardModel.getName().length() >= 50) {
//				JOptionPane.showMessageDialog(null, "Data is long");
//				return;
//
//			}
//
//			this.cardRepository.Create(kdvTypeCardModel);
//			// TODO Auto-generated method stub
//
//		}
	}

}
