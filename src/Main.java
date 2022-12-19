
import java.awt.EventQueue;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.run.RunProgram;
import studycase.stockcart.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {

					RunProgram frame = new RunProgram();
					frame.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
