package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import command.GeneralAction;
import command.StockTypeCardDeleteButtonCommand;
import command.StockTypeCardFirstItemButtonCommand;
import command.StockTypeCardForwardItemButtonCommand;
import command.StockTypeCardLastItemButtonCommand;
import command.StockTypeCardPreviusItemButtonCommand;
import command.StockTypeCardSaveButtonCommand;
import studycase.stockcart.model.StockTypeCardRepository;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockTypeCardCreateUi;

public class StockTypeCardControllerCommand {

	private StockTypeCardRepository stockTypeCardRepository = new StockTypeCardRepository();
	private StockTypeCardCreateUi stockTypeCardCreateUi;

	private MainFrames mainFrames;

	public StockTypeCardControllerCommand(MainFrames mainFrames) {
		this.mainFrames = mainFrames;

		this.stockTypeCardRepository.Connect();

	}

	public void execute() {
		this.stockTypeCardCreateUi = new StockTypeCardCreateUi();

		setListener();

		this.stockTypeCardCreateUi.setVisible(true);
		this.mainFrames.getDesktopPane().add(stockTypeCardCreateUi);
	}

	private void setListener() {
		stockTypeCardCreateUi.getBtnNewButton()
				.addActionListener(new GeneralAction(new StockTypeCardSaveButtonCommand(stockTypeCardCreateUi)));
		stockTypeCardCreateUi.getDelete_button()
				.addActionListener(new GeneralAction(new StockTypeCardDeleteButtonCommand(stockTypeCardCreateUi)));
		stockTypeCardCreateUi.getFirstItemButton()
				.addActionListener(new GeneralAction(new StockTypeCardFirstItemButtonCommand(stockTypeCardCreateUi)));
		stockTypeCardCreateUi.getPreviusItemButton()
				.addActionListener(new GeneralAction(new StockTypeCardPreviusItemButtonCommand(stockTypeCardCreateUi)));
		stockTypeCardCreateUi.getForwardItemBtn()
				.addActionListener(new GeneralAction(new StockTypeCardForwardItemButtonCommand(stockTypeCardCreateUi)));
		stockTypeCardCreateUi.getLastItemButton()
				.addActionListener(new GeneralAction(new StockTypeCardLastItemButtonCommand(stockTypeCardCreateUi)));

	}

	public Connection Connect() {

		return this.stockTypeCardRepository.Connect();

	}

}
