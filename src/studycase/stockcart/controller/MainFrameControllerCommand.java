package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import studycase.stockcart.view.KdvTypeCardCreateUi;
import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockListTableView;

public class MainFrameControllerCommand implements ActionListener {

	private MainFrames frames;



	public MainFrameControllerCommand(MainFrames frame) {

		this.frames = frame;
		initView();

	

		frames.setVisible(true);

	}

	public void execute() {
		getButtons();
	}

	public void getButtons() {
		frames.getMntmNewMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StockListControllerCommand controller = new StockListControllerCommand(frames);
				     
				controller.execute();
			}
		});
		frames.getmntmNewMenuItem_1().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockCardControllerCommand stockCardController = new StockCardControllerCommand(frames);
				stockCardController.execute();

			}
		});

		frames.getMntmNewMenuItem_3().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KdvTypeCardControllerCommand kdvTypeCardController = new KdvTypeCardControllerCommand(frames);
				kdvTypeCardController.Execute();
			}
		});
		frames.getMntmNewMenuItem_2().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StockTypeCardControllerCommand stockCardController = new StockTypeCardControllerCommand(frames);
				stockCardController.execute();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void initView() {
		frames.getMntmNewMenuItem().addActionListener(this);

	}

}
