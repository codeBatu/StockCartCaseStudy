package studycase.stockcart.controller;

import command.GeneralAction;
import command.KdvTypeCardDeleteButtonCommand;
import command.KdvTypeCardFirstItemButtonCommand;
import command.KdvTypeCardForwardItemButtonCommand;
import command.KdvTypeCardLastItemButtonCommand;
import command.KdvTypeCardPreviusItemButtonCommand;
import command.KdvTypeCardSaveButtonCommand;
import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.view.KdvTypeCardCreateUi;
import studycase.stockcart.view.MainFrames;

public class KdvTypeCardControllerCommand {

	private KdvTypeCardRepository kdvTypeCardRepository = new KdvTypeCardRepository();

	private KdvTypeCardCreateUi kdvTypeCardCreateUi;
	private MainFrames mainFrames;

	public KdvTypeCardControllerCommand(MainFrames mainFrames) {
		super();
		this.mainFrames = mainFrames;
		this.kdvTypeCardRepository.Connect();
	}

	public void Execute() {

		this.kdvTypeCardCreateUi = new KdvTypeCardCreateUi();

		setListener();

		this.kdvTypeCardCreateUi.setVisible(true);
		mainFrames.getDesktopPane().add(kdvTypeCardCreateUi);
	}

	private void setListener() {
		kdvTypeCardCreateUi.getSaveButton()
				.addActionListener(new GeneralAction(new KdvTypeCardSaveButtonCommand(kdvTypeCardCreateUi)));
		kdvTypeCardCreateUi.getDelete_button()
				.addActionListener(new GeneralAction(new KdvTypeCardDeleteButtonCommand(kdvTypeCardCreateUi)));
		kdvTypeCardCreateUi.getFirstItemButton()
				.addActionListener(new GeneralAction(new KdvTypeCardFirstItemButtonCommand(kdvTypeCardCreateUi)));
		kdvTypeCardCreateUi.getLastItemButton()
				.addActionListener(new GeneralAction(new KdvTypeCardLastItemButtonCommand(kdvTypeCardCreateUi)));
		kdvTypeCardCreateUi.getPreviusItemButton()
				.addActionListener(new GeneralAction(new KdvTypeCardPreviusItemButtonCommand(kdvTypeCardCreateUi)));
		kdvTypeCardCreateUi.getForwardItemBtn()
				.addActionListener(new GeneralAction(new KdvTypeCardForwardItemButtonCommand(kdvTypeCardCreateUi)));
	}

}
