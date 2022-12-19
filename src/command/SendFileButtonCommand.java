package command;

import studycase.stockcart.view.SendFileView;

public class SendFileButtonCommand implements Command {
	private SendFileView fileView;

	public SendFileButtonCommand(SendFileView fileView) {
		super();
		this.fileView = fileView;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
