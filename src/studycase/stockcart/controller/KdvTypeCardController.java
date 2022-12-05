package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



import studycase.stockcart.model.KdvTypeCardRepository;
import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;
import studycase.stockcart.view.KdvTypeCardCreateUi;

public class KdvTypeCardController implements ActionListener {

	private KdvTypeCardRepository kdvTypeCardRepository;
	private KdvTypeCardCreateUi kdvTypeCardCreateUi;
	private KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();

	public KdvTypeCardController(KdvTypeCardRepository kdvTypeCardRepository, KdvTypeCardCreateUi kdvTypeCardCreateUi) {

		this.kdvTypeCardRepository = kdvTypeCardRepository;
		this.kdvTypeCardRepository.Connect();
		this.kdvTypeCardCreateUi = kdvTypeCardCreateUi;

	}

	public KdvTypeCardCreateUi init() {
	//	kdvTypeCardCreateUi.getBtnNewButton_1().addActionListener(this);

		kdvTypeCardCreateUi.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kdvTypeCardModel
						.setRatio(Double.parseDouble(kdvTypeCardCreateUi.getKdv_type_ratio_textField().getText()));
				kdvTypeCardModel.setCode(kdvTypeCardCreateUi.getKdv_type_code_textField().getText());
				kdvTypeCardModel.setName(kdvTypeCardCreateUi.getKdv_type_name_textField().getText());

				if (kdvTypeCardModel.getCode().equals("") || kdvTypeCardModel.getName().equals("")
						|| kdvTypeCardModel.getRatio().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Field is not null");
				} else {
					if (kdvTypeCardModel.getCode().length() >= 15 || kdvTypeCardModel.getName().length() >= 50) {
						JOptionPane.showMessageDialog(null, "Data is long");
						return;

					}

					kdvTypeCardRepository.Create(kdvTypeCardModel);

				}
			}
		});
		kdvTypeCardCreateUi.getMnNewMenu().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ResultSet result = getFirstItemFromKdvType();
				try {

					if (result.next()) {
						kdvTypeCardCreateUi.getLblNewLabel().setText(result.getString("KdvTypeId"));
						kdvTypeCardCreateUi.getKdv_type_code_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_name_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_ratio_textField().setText(result.getString("KdvTypeRatio"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		kdvTypeCardCreateUi.getMnNewMenu_2().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
				kdvTypeCardModel.setId(Integer.parseInt(kdvTypeCardCreateUi.getLblNewLabel().getText()));

				ResultSet result = getAfterItemFromKdvTypeTable(kdvTypeCardModel);

				try {

					while (result.next()) {
						kdvTypeCardCreateUi.getLblNewLabel().setText(result.getString("KdvTypeId"));
						kdvTypeCardCreateUi.getKdv_type_code_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_name_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_ratio_textField().setText(result.getString("KdvTypeRatio"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		kdvTypeCardCreateUi.getMnNewMenu_3().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ResultSet result = getLastItemFromStockTypeTable();
				try {

					if (result.next()) {

						kdvTypeCardCreateUi.getLblNewLabel().setText(result.getString("KdvTypeId"));
						kdvTypeCardCreateUi.getKdv_type_code_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_name_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_ratio_textField().setText(result.getString("KdvTypeRatio"));

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		kdvTypeCardCreateUi.getMnNewMenu_1().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KdvTypeCardModel kdvTypeCardModel = new KdvTypeCardModel();
				kdvTypeCardModel.setId(Integer.parseInt(kdvTypeCardCreateUi.getLblNewLabel().getText()));

				ResultSet result = getBeforeItemFromKdvTypeTable(kdvTypeCardModel);

				try {

					while (result.next()) {
						kdvTypeCardCreateUi.getLblNewLabel().setText(result.getString("KdvTypeId"));
						kdvTypeCardCreateUi.getKdv_type_code_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_name_textField().setText(result.getString("KdvTypeCode"));
						kdvTypeCardCreateUi.getKdv_type_ratio_textField().setText(result.getString("KdvTypeRatio"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return this.kdvTypeCardCreateUi;
	}

	public Connection Connect() {

		return this.kdvTypeCardRepository.Connect();

	}

	public ResultSet getFirstItemFromKdvType() {

		return this.kdvTypeCardRepository.getFirstItemFromKdvTypeTable();

	}

	public ResultSet getAfterItemFromKdvTypeTable(KdvTypeCardModel cardModel) {

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
