package studycase.stockcart.run;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import studycase.stockcart.controller.KdvTypeCardController;
import studycase.stockcart.controller.MainFrameController;
import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.controller.StockListController;
import studycase.stockcart.controller.StockTypeCardController;
import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.view.KdvTypeCardCreateUi;

import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockCardView;
import studycase.stockcart.view.StockListTableView;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class RunProgram {
	public void start() throws PropertyVetoException {
//		StockCardRepository cruModel = new StockCardRepository();
////		StockTypeCardRepository stockTypeCardRepository = new StockTypeCardRepository();
//		KdvTypeCardRepository kdvTypeCardRepository = new KdvTypeCardRepository();
//
//		// StockTypeCardController stockTypeCardController = new
//		// StockTypeCardController(stockTypeCardRepository);
//
////		KdvTypeCardController kdvTypeCardController = new KdvTypeCardController(kdvTypeCardRepository);
//		StockCardController stockCardController = new StockCardController(cruModel);
////		MainFrame mainFrame = new MainFrame(stockCardController, stockTypeCardController, kdvTypeCardController);
////
////		mainFrame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 50),
////				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50));
////		mainFrame.setMaximizedBounds(new Rectangle(0, 0, 500, 500));
////
////		mainFrame.setVisible(true);
		MainFrames frames = new MainFrames();
		StockListTableView stockListTableView = new StockListTableView();
		StockCardRepository cardRepository = new StockCardRepository();
		StockCardView stockCardView = new StockCardView();
		KdvTypeCardCreateUi cardCreateUi = new KdvTypeCardCreateUi();
		KdvTypeCardRepository kdvTypeCardRepository = new KdvTypeCardRepository();
		KdvTypeCardController kdvTypeCardController = new KdvTypeCardController(kdvTypeCardRepository, cardCreateUi);
		StockCardController cardController = new StockCardController(cardRepository, stockCardView);
		StockListController stockListController = new StockListController(stockListTableView, cardRepository,cardController);
		StockTypeCardCreateUi stockTypeCardCreateUi = new StockTypeCardCreateUi();
		StockTypeCardRepository stockTypeCardRepository = new StockTypeCardRepository();
		StockTypeCardController stockTypeCardController = new StockTypeCardController(stockTypeCardRepository,
				stockTypeCardCreateUi);
		MainFrameController controller = new MainFrameController(frames, stockListController, cardController,
				kdvTypeCardController, stockTypeCardController);

		controller.initController();

	}

}
 