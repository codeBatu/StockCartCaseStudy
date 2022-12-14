package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralAction  implements ActionListener{
private	Command command ;

	public GeneralAction(Command command) {
		super();
		// TODO Auto-generated constructor stub
		this.command = command;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		command.execute();
		
	}
	

}
