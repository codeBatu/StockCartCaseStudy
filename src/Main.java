
import java.awt.EventQueue;

import javax.swing.*;

import studycase.stockcart.run.RunProgram;
import studycase.stockcart.view.MainFrame;


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
