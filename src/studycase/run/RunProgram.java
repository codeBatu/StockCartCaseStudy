package studycase.run;

import studycase.stockcart.controller.StockCardController;
import studycase.stockcart.model.CrudModel;
import studycase.stockcart.view.StockCartUi;

public class RunProgram {
	   public void start() {
	       CrudModel cruModel = new CrudModel();
	       StockCardController stockCardController = new StockCardController(cruModel);
		    StockCartUi stockCardUi = new StockCartUi(stockCardController);
		    stockCardUi.setVisible(true);
	
	   

	    }

}
