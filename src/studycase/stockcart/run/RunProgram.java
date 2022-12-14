package studycase.stockcart.run;


import studycase.stockcart.controller.MainFrameControllerCommand;
import studycase.stockcart.view.MainFrames;

public class RunProgram {
	public void start() {

		MainFrames frames = new MainFrames();

		MainFrameControllerCommand controllerCommand = new MainFrameControllerCommand(frames);

		controllerCommand.execute();

	}

}
