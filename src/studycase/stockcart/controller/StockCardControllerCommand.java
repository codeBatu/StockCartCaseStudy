package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import command.GeneralAction;
import command.StockCardDeleteCommand;
import command.StockCardFirstItemButtonCommand;
import command.StockCardForwardItemButtonCommand;
import command.StockCardLastItemButtonCommand;
import command.StockCardPreviusItemButtonCommand;
import command.StockCardSaveCommand;
import command.StockCardSendFtpButtonCommand;
import command.StockCardUpdateCommand;
import studycase.stockcart.model.StockCardRepository;
import studycase.stockcart.model.DbUtils;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.util.Constant;
import studycase.stockcart.view.MainFrames;
import studycase.stockcart.view.StockCardView;

public class StockCardControllerCommand {
	private StockCardRepository crudModel = new StockCardRepository();

	private StockCardView cardView;
	private StockCardModel stockCardModel = new StockCardModel();

	private MainFrames mainFrames;

	public StockCardControllerCommand(MainFrames mainFrames) {
		this.mainFrames = mainFrames;

	}

	public void execute() {
		cardView = new StockCardView();

		getKdvTypeTable();
		getStockTypeByKdvTypeId();

		setListeners();

		cardView.setVisible(true);
		mainFrames.getDesktopPane().add(cardView);
		// return cardView;

	}

	private void setListeners() {
		cardView.getSave_btnNewButton().addActionListener(new GeneralAction(new StockCardSaveCommand(cardView)));
		cardView.getDelete_btnNewButton().addActionListener(new GeneralAction(new StockCardDeleteCommand(cardView)));
		cardView.getUpdate_btnNewButton().addActionListener(new GeneralAction(new StockCardUpdateCommand(cardView)));
		cardView.getFirstItemButton()
				.addActionListener(new GeneralAction(new StockCardFirstItemButtonCommand(cardView)));
		cardView.getLastItemButton().addActionListener(new GeneralAction(new StockCardLastItemButtonCommand(cardView)));
		cardView.getForwardItemBtn()
				.addActionListener(new GeneralAction(new StockCardForwardItemButtonCommand(cardView)));
		cardView.getPreviusItemButton()
				.addActionListener(new GeneralAction(new StockCardPreviusItemButtonCommand(cardView)));
		cardView.getSendFtpButton().addActionListener(new GeneralAction(new StockCardSendFtpButtonCommand(cardView)));
	}

	private void getStockTypeByKdvTypeId() {
		
		List<StockTypeCardModel> result = this.crudModel.getStockTypeByStockIdList();
	
		
		    result.stream().forEach(z->cardView.getStock_type_comboBox().addItem(z.getId()));
		  

	}

	private void getKdvTypeTable() {
		
		List<KdvTypeCardModel> result = this.crudModel.getKdvTypeTable();
		
		
	    result.stream().forEach(z->cardView.getKdv_type_comboBox2().addItem(z.getId()));
	

	}

}
