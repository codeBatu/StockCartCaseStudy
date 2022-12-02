package studycase.stockcart.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;

import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;

public class KdvTypeCardController {

	private KdvTypeCardRepository kdvTypeCardRepository;

	public KdvTypeCardController(KdvTypeCardRepository kdvTypeCardRepository) {

		this.kdvTypeCardRepository = kdvTypeCardRepository;

	}

	// TODO Double check
	public void Create(KdvTypeCardModel kdvTypeCardModel) {
		if (kdvTypeCardModel.getCode().equals("") || kdvTypeCardModel.getName().equals("")
				|| kdvTypeCardModel.getRatio().toString().equals("")) {

			JOptionPane.showMessageDialog(null, "Field is not null");
		} else {
			if (kdvTypeCardModel.getCode().length() >= 15 || kdvTypeCardModel.getName().length() >= 50) {
				JOptionPane.showMessageDialog(null, "Data is long");
				return;

			}

			this.kdvTypeCardRepository.Create(kdvTypeCardModel);

		}

	}

	public Connection Connect() {

		return this.kdvTypeCardRepository.Connect();

	}

	public ResultSet getFirstItemFromKdvType() {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.kdvTypeCardRepository.getFirstItemFromKdvTypeTable();

	}

	public ResultSet getAfterItemFromKdvTypeTable(KdvTypeCardModel cardModel) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.kdvTypeCardRepository.getAfterItemFromKdvTypeTable(cardModel);

	}

	public ResultSet getBeforeItemFromKdvTypeTable(KdvTypeCardModel cardModel) {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.kdvTypeCardRepository.getBeforeItemFromKdvTypeTable(cardModel);

	}

	public ResultSet getLastItemFromStockTypeTable() {

		// var list = this.stockTypeCardRepository.getFirstItemFromStockTypeTable();

		return this.kdvTypeCardRepository.getLastItemFromKdvTypeTable();

	}

}
