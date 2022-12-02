package studycase.stockcart.run;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import studycase.stockcart.controller.KdvTypeCardController;
import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.controller.StockTypeCardController;
import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.view.MainFrame;
import studycase.stockcart.view.MainFrame;

public class RunProgram {
	public void start() throws PropertyVetoException {
		StockCardRepository cruModel = new StockCardRepository();
		StockTypeCardRepository stockTypeCardRepository = new StockTypeCardRepository();
		KdvTypeCardRepository kdvTypeCardRepository = new KdvTypeCardRepository();
	
		StockTypeCardController stockTypeCardController = new StockTypeCardController(stockTypeCardRepository);

		KdvTypeCardController kdvTypeCardController = new KdvTypeCardController(kdvTypeCardRepository);
		StockCardController stockCardController = new StockCardController(cruModel);
		MainFrame mainFrame = new MainFrame(stockCardController, stockTypeCardController, kdvTypeCardController);

		mainFrame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 50),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50));
		mainFrame.setMaximizedBounds(new Rectangle(0, 0, 500, 500));

		mainFrame.setVisible(true);
	}

}
