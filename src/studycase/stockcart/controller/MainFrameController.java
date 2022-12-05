package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockListTableView;

public class MainFrameController implements ActionListener {

	private MainFrames frames;
	private StockListController controller;
	private StockCardController stockCardController;
	private StockTypeCardController stockTypeCardController;
private KdvTypeCardController kdvTypeCardController;
	public MainFrameController(MainFrames frame, StockListController controller,
			StockCardController stockCardController,
			KdvTypeCardController kdvTypeCardController,
			StockTypeCardController stockTypeCardController
			) {

		this.frames = frame;
		initView();
        this.stockCardController = stockCardController;
        this.kdvTypeCardController = kdvTypeCardController;
        this.stockTypeCardController = stockTypeCardController;
		this.controller = controller;

		frames.setVisible(true);

	}

	public void initController() {
		getButtons();
	}

	public void getButtons() {
		frames.getMntmNewMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frames.getDesktopPane().add(controller.init());
				
				

			}
		});
		frames.getmntmNewMenuItem_1().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frames.getDesktopPane().add(stockCardController.init());
			}
		});
		
		frames.getMntmNewMenuItem_3().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frames.getDesktopPane().add(kdvTypeCardController.init());
			}
		});
		frames.getMntmNewMenuItem_2().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frames.getDesktopPane().add(stockTypeCardController.init());
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
