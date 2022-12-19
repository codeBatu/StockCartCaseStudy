package studycase.stockcart.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import studycase.stockcart.model.entity.StockCardFileModel;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.util.HibernateUtil;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class SendFileView extends JInternalFrame {
	;
	private JTextField fileNameTextField2;
	private JTextField fileDescriptionTextField2;
	private JTextField fileStockCodeTextField2;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public SendFileView(StockCardView cardView) {
		setClosable(true);
		setBounds(100, 100, 1482, 625);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();

		FTPClient ftp = new FTPClient();
		JScrollPane scrollPane = new JScrollPane(panel);

		scrollPane.setBounds(24, 444, 1326, 140);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton openFileButton = new JButton("Aç");
		openFileButton.setBounds(0, 0, 0, 0);
		panel.add(openFileButton);
		JButton btnNewButton_1 = new JButton("Yükle");

		getLastItem(cardView, panel);
		panel.setLayout(null);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				uploadButton(cardView);

//				

			}
		});
		openFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ftp.connect("192.168.2.235");
					ftp.login("guru", "chocolateforguru");
					ftp.changeWorkingDirectory("/dosya");
					//
//					if (fileNameTextField.getText().isEmpty()) {
//
//					} else {
//						InputStream name = ftp.retrieveFileStream(fileNameTextField.getText());
//						if (name == null) {
//
//						} else {
//							FileOutputStream outputStream = new FileOutputStream(
//									"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp" + fileNameTextField.getText());
//
//							IOUtils.copy(name, outputStream);
//
//							outputStream.close();
//							name.close();
//							Desktop.getDesktop().open(new File(
//									"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp" + fileNameTextField.getText()));
//							ftp.disconnect();
//						}
//
//					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(1310, 11, 150, 27);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		getTable(cardView);

		// Create a GridBagConstraints object to specify the layout for each cell

//		btnNewButton_1.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//
//				
//				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//				jfc.setDialogTitle("Multiple file and directory selection:");
//				jfc.setMultiSelectionEnabled(true);
//				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//
//				int returnValue = jfc.showOpenDialog(null);
//				if (returnValue == JFileChooser.APPROVE_OPTION) {
//					File[] files = jfc.getSelectedFiles();
//					for (int i = 0; i < files.length; i++) {
//
//						try {
//
//							Transaction transaction;
//							Session session = HibernateUtil.getSessionFactory().openSession();
//							// start a transaction
//							transaction = session.beginTransaction();
//							FileInputStream fis = new FileInputStream(files[i]);
//
//							StockCardFileModel stockCardFileModel = new StockCardFileModel();
//							stockCardFileModel.setFileName(files[0].getName());
//							stockCardFileModel.setSendFileDescription(sendFileDescription);
//							stockCardFileModel.setStockcards(1);
//							fileNameTextField.setText(files[0].getName());
//							fileDescriptionTextField.setText(sendFileDescription);
//							fileStockCodeTextField.setText(stockCardFileModel.getStockcards().toString());
//							JButton openFileButton = new JButton("Aç");
//							openFileButton.addActionListener(new ActionListener() {
//								public void actionPerformed(ActionEvent e) {
//									try {
//								System.out.println("tıık");
//										Desktop.getDesktop().open(new File(files[0].toString()));
//									} catch (IOException e1) {
//										// TODO Auto-generated catch block
//										e1.printStackTrace();
//									}
//								}
//							});
//							openFileButton.setBounds(1308, 6, 89, 23);
//							panel.add(openFileButton);
////							ftp.connect("192.168.2.235");
////							ftp.login("guru", "chocolateforguru");
////							ftp.changeWorkingDirectory("/dosya");
////							ftp.storeFile(files[i].getName(), fis);
////							ftp.disconnect();
//							session.save(stockCardFileModel);
//
//							transaction.commit();
//							session.close();
//
//							getTextField_1().setColumns(10);
//							getTextField_1().setBounds(122, 0, 267, 27);
//							getTextField_1().setVisible(true);
//							panel.setLayout(null);
//							panel.add(getTextField_1());
//							getTextField_3().setBounds(614, 0, 200, 27);
//							panel.add(getTextField_3());
//							getTextField_3().setColumns(10);
//
//							getTextField_4().setBounds(1047, 0, 166, 27);
//							panel.add(getTextField_4());
//							getTextField_4().setColumns(10);
//
//							if (files.length != 1) {
//								openFileButton2.setVisible(true);
//								fileNameTextField2 = new JTextField();
//
//								fileDescriptionTextField2 = new JTextField();
//
//								fileStockCodeTextField2 = new JTextField();
//
//								getFileNameTextField2().setColumns(10);
//								getFileNameTextField2().setBounds(122, 40, 267, 27);
//								getFileNameTextField2().setVisible(true);
//								panel.setLayout(null);
//								panel.add(getFileNameTextField2());
//								getFileDescriptionTextField2().setBounds(614, 40, 200, 27);
//								panel.add(getFileDescriptionTextField2());
//								getFileDescriptionTextField2().setColumns(10);
//
//								getFileStockCodeTextField2().setBounds(1047, 40, 166, 27);
//								panel.add(getFileStockCodeTextField2());
//								getFileStockCodeTextField2().setColumns(10);
//
//								fileNameTextField2.setText(files[1].getName());
//								fileDescriptionTextField2.setText(sendFileDescription);
//								fileStockCodeTextField2.setText(stockCardFileModel.getStockcards().toString());
//
//							}
//
//						}
//
//						catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//
//					}
//
//				}
//			}
//
//		});
//		btnNewButton_1.setBounds(1276, 11, 184, 43);
//		getContentPane().add(btnNewButton_1);

	}

	/**
	 * @return the textField_4
	 */

	/**
	 * @param textField_4 the textField_4 to set
	 */

	public JTextField getFileNameTextField2() {
		return fileNameTextField2;
	}

	public void setFileNameTextField2(JTextField fileNameTextField2) {
		this.fileNameTextField2 = fileNameTextField2;
	}

	public JTextField getFileDescriptionTextField2() {
		return fileDescriptionTextField2;
	}

	public void setFileDescriptionTextField2(JTextField fileDescriptionTextField2) {
		this.fileDescriptionTextField2 = fileDescriptionTextField2;
	}

	public JTextField getFileStockCodeTextField2() {
		return fileStockCodeTextField2;
	}

	public void setFileStockCodeTextField2(JTextField fileStockCodeTextField2) {
		this.fileStockCodeTextField2 = fileStockCodeTextField2;
	}

	int count = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;

	private List<StockCardFileModel> getLastItem(StockCardView cardView, JPanel panel) {

		List<StockCardFileModel> files = new ArrayList<>();
		if (cardView.getStock_code_textField().getText().isEmpty()) {
			String stockCode = JOptionPane.showInputDialog("Stok Kod Giriniz");
			cardView.getStock_code_textField().setText(stockCode);

		}
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

//			Query query = session.createSQLQuery("		 SELECT fileıd, filename,stock_card_id"
//					+ "FROM stockcardfilestbl " + "LEFT JOIN stockcardtbl ON stock_card_id = stock_code"
//					+ "WHERE stock_code = " + "'" + cardView.getStock_code_textField().getText() + "'"
//					+ "  ORDER BY fileıd DESC" + "LIMIT 1");

			Query query = session.createNativeQuery(
					"  SELECT  filename, filedescription, stock_card_id , fileid    FROM stockcardfilestbl"
							+ "  WHERE stock_card_id  =" + "'" + cardView.getStock_code_textField().getText() + "'");
			List<Object[]> results = query.getResultList();
			JLabel fileNamejLabel[] = new JLabel[results.size()];
			JLabel fileIdjLabel[] = new JLabel[results.size()];
			JTextField fileNamejTextField[] = new JTextField[results.size()];
			JLabel fileDescriptionjLabel[] = new JLabel[results.size()];
			JTextField fileDescriptionjTextField[] = new JTextField[results.size()];
			JLabel fileStockCodjLabel[] = new JLabel[results.size()];
			JTextField fileStockCodjTextField[] = new JTextField[results.size()];
			JButton openfileButton[] = new JButton[results.size()];
			JButton deletefileButton[] = new JButton[results.size()];

			for (int i = 0; i < results.size(); i++) {
				Integer ct = i;
				Object[] row = results.get(i);

				fileIdjLabel[i] = new JLabel(row[3].toString());
				fileIdjLabel[i].setBounds(0, i * 30, 80, 20);
				fileNamejLabel[i] = new JLabel("Dosya Adı");
				fileNamejLabel[i].setBounds(40, i * 30, 80, 20);
				fileNamejTextField[i] = new JTextField(row[0].toString());
				fileNamejTextField[i].setBounds(122, i * 30, 267, 27);

				fileDescriptionjLabel[i] = new JLabel("Dosya Açıklama");
				fileDescriptionjLabel[i].setBounds(450, i * 30, 80, 20);
				fileDescriptionjTextField[i] = new JTextField(row[1].toString());
				fileDescriptionjTextField[i].setBounds(614, i * 30, 200, 27);
				fileStockCodjLabel[i] = new JLabel("Stok Kodu");
				fileStockCodjLabel[i].setBounds(907, i * 30, 80, 20);
				fileStockCodjTextField[i] = new JTextField(row[2].toString());
				fileStockCodjTextField[i].setBounds(1047, i * 30, 200, 27);
				openfileButton[i] = new JButton("Aç");
				openfileButton[i].setBounds(1275, i * 30, 59, 23);
				deletefileButton[i] = new JButton("Sil");
				deletefileButton[i].setBounds(1330, i * 30, 59, 23);
				;
				openfileButton[i].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						FTPClient ftp = new FTPClient();

						try {

							ftp.connect("192.168.2.235");
							ftp.login("guru", "chocolateforguru");
							ftp.changeWorkingDirectory("/dosya");
							InputStream name = ftp.retrieveFileStream(fileNamejTextField[ct].getText());

							FileOutputStream outputStream = new FileOutputStream(
									"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp" + fileNamejTextField[ct].getText());

							IOUtils.copy(name, outputStream);

							outputStream.close();
							name.close();
							Desktop.getDesktop().open(new File(
									"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp" + fileNamejTextField[ct].getText()));
							ftp.disconnect();
						} catch (SocketException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});

				deletefileButton[i].addActionListener(new ActionListener() {
					int counter = count;

					public void actionPerformed(ActionEvent e) {
						System.out.println(counter);
						// FTPClient ftp = new FTPClient();

						// ftp.connect("192.168.2.235");
						// ftp.login("guru", "chocolateforguru");
						// ftp.changeWorkingDirectory("/dosya");
						// ftp.deleteFile(fileNamejTextField[counter].getText());
						Transaction transaction = null;
						Session session = HibernateUtil.getSessionFactory().openSession();

						// start a transaction
						transaction = session.beginTransaction();
						StockCardFileModel stockCardFileModel = new StockCardFileModel();

						stockCardFileModel.setId(Integer.parseInt(fileIdjLabel[ct].getText()));
						session.delete(stockCardFileModel);

						transaction.commit();
						session.close();
						// transaction = session.beginTransaction();
						// ftp.disconnect();

					}

				});
//				
				panel.add(fileIdjLabel[i]);
				panel.add(fileNamejLabel[i]);
				panel.add(fileNamejTextField[i]);
				panel.add(fileDescriptionjLabel[i]);
				panel.add(fileDescriptionjTextField[i]);
				panel.add(fileStockCodjLabel[i]);
				panel.add(fileStockCodjTextField[i]);
				panel.add(deletefileButton[i]);
				panel.add(openfileButton[i]);

			}
//			for (Object[] row : results) {
//
//				++count;
//				fileIdjLabel[count] = new JLabel(row[3].toString());
//				fileIdjLabel[count].setBounds(0, count * 30, 80, 20);
//				fileNamejLabel[count] = new JLabel("Dosya Adı");
//				fileNamejLabel[count].setBounds(40, count * 30, 80, 20);
//				fileNamejTextField[count] = new JTextField(row[0].toString());
//				fileNamejTextField[count].setBounds(122, count * 30, 267, 27);
//
//				fileDescriptionjLabel[count] = new JLabel("Dosya Açıklama");
//				fileDescriptionjLabel[count].setBounds(450, count * 30, 80, 20);
//				fileDescriptionjTextField[count] = new JTextField(row[1].toString());
//				fileDescriptionjTextField[count].setBounds(614, count * 30, 200, 27);
//				fileStockCodjLabel[count] = new JLabel("Stok Kodu");
//				fileStockCodjLabel[count].setBounds(907, count * 30, 80, 20);
//				fileStockCodjTextField[count] = new JTextField(row[2].toString());
//				fileStockCodjTextField[count].setBounds(1047, count * 30, 200, 27);
//				openfileButton[count] = new JButton("Aç");
//				openfileButton[count].setBounds(1275, count * 30, 59, 23);
//				deletefileButton[count] = new JButton("Sil");
//				deletefileButton[count].setBounds(1330, count * 30, 59, 23);
//				;
//				openfileButton[count].addActionListener(new ActionListener() {
//					int counter = count;
//
//					public void actionPerformed(ActionEvent e) {
//						FTPClient ftp = new FTPClient();
//
//						try {
//
//							ftp.connect("192.168.2.235");
//							ftp.login("guru", "chocolateforguru");
//							ftp.changeWorkingDirectory("/dosya");
//							InputStream name = ftp.retrieveFileStream(fileNamejTextField[counter].getText());
//
//							FileOutputStream outputStream = new FileOutputStream(
//									"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp"
//											+ fileNamejTextField[counter].getText());
//
//							IOUtils.copy(name, outputStream);
//
//							outputStream.close();
//							name.close();
//							Desktop.getDesktop().open(new File("C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp"
//									+ fileNamejTextField[counter].getText()));
//							ftp.disconnect();
//						} catch (SocketException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//
//					}
//
//				});
//
//				deletefileButton[count].addActionListener(new ActionListener() {
//					int counter = count;
//
//					public void actionPerformed(ActionEvent e) {
//						System.out.println(counter);
//						// FTPClient ftp = new FTPClient();
//
//						// ftp.connect("192.168.2.235");
//						// ftp.login("guru", "chocolateforguru");
//						// ftp.changeWorkingDirectory("/dosya");
//						// ftp.deleteFile(fileNamejTextField[counter].getText());
//						Transaction transaction = null;
//						Session session = HibernateUtil.getSessionFactory().openSession();
//						StockCardFileModel stockCardFileModel = new StockCardFileModel();
//
//						stockCardFileModel.setId(counter);
//						session.delete(stockCardFileModel);
//
//						transaction.commit();
//						session.close();
//						// transaction = session.beginTransaction();
//						// ftp.disconnect();
//
//					}
//
//				});
//				
//
//			}
//			for (int i = 0; i < results.size(); i++) {
//				
//				
//				System.out.println(results.get(1));
//				System.out.println(results.get(2));
////				 fileDescriptionTextField.setText(row[0].toString());
////				  fileNameTextField.setText(row[1].toString());
////               fileStockCodeTextField.setText(row[2].toString());
//				
//			}

		} catch (

		Exception e) {
			System.out.println(e);

		}

		return files;

	}

	void getTable(StockCardView cardView) {
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 11, 1192, 308);
		getContentPane().add(scrollPane_1);

		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 65, 116, 109, 112, 123, 134, 153, 191, 168, 0 };
		gbl_panel_1.rowHeights = new int[] { 37, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		// start a transaction
		transaction = session.beginTransaction();
		StockCardFileModel stockCardFileModel = new StockCardFileModel();

		Query<Object[]> query = session.createNativeQuery(
				"  SELECT  filename, filedescription, stock_card_id , fileid    FROM stockcardfilestbl"
						+ "  WHERE stock_card_id  =" + "'" + cardView.getStock_code_textField().getText() + "'");

		List<Object[]> results = query.getResultList();
		JButton openfileButton[] = new JButton[results.size()];
		for (int i = 0; i < results.size(); i++) {
			Integer ct = i;
			Object[] row = results.get(i);

			JLabel lblNewLabel = new JLabel(row[3].toString());
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = i;
			panel_1.add(lblNewLabel, gbc_lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Dosya Adı");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = i;
			panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

			textField_1 = new JTextField(row[0].toString());
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.BOTH;
			gbc_textField_1.insets = new Insets(0, 0, 0, 5);
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = i;
			panel_1.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
			JLabel lblNewLabel_2 = new JLabel("Dosya Açıklaması");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 3;
			gbc_lblNewLabel_2.gridy = i;
			panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

			textField_2 = new JTextField(row[1].toString());
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.fill = GridBagConstraints.BOTH;
			gbc_textField_2.insets = new Insets(0, 0, 0, 5);
			gbc_textField_2.gridx = 4;
			gbc_textField_2.gridy = i;
			panel_1.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
			JLabel lblNewLabel_3 = new JLabel("Stok Kodu");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 5;
			gbc_lblNewLabel_3.gridy = i;
			panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

			textField = new JTextField(row[2].toString());
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.gridx = 6;
			gbc_textField.gridy = i;
			panel_1.add(textField, gbc_textField);
			textField.setColumns(10);
			btnNewButton = new JButton(row[3].toString() + "Aç");

			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 7;
			gbc_btnNewButton.gridy = i;
			btnNewButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					openButton(cardView, row[0].toString());

					// transaction = session.beginTransaction();
					// ftp.disconnect();

				}

			});
			panel_1.add(btnNewButton, gbc_btnNewButton);

			JButton btnNewButton_2 = new JButton("Sil");
			GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
			gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton_2.gridx = 8;
			gbc_btnNewButton_2.gridy = i;
			btnNewButton_2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					deleteButton(lblNewLabel, cardView);
					// transaction = session.beginTransaction();
					// ftp.disconnect();

				}

			});
			panel_1.add(btnNewButton_2, gbc_btnNewButton_2);

		}

		transaction.commit();
		session.close();

	}

	private void openButton(StockCardView cardView, String fileName) {
		FTPClient ftp = new FTPClient();

		try {

			ftp.connect("192.168.2.235");
			ftp.login("guru", "chocolateforguru");
			ftp.changeWorkingDirectory("/dosya");
			InputStream name = ftp.retrieveFileStream(fileName);

			FileOutputStream outputStream = new FileOutputStream(
					"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp" + fileName);

			IOUtils.copy(name, outputStream);

			outputStream.close();
			name.close();
			Desktop.getDesktop().open(new File("C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\ftp" + fileName));
			ftp.disconnect();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		getTable(cardView);

	}

//		

	private void deleteButton(JLabel lblNewLabel, StockCardView cardView) {

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		// start a transaction
		transaction = session.beginTransaction();
		StockCardFileModel stockCardFileModel = new StockCardFileModel();

		stockCardFileModel.setId(Integer.parseInt(lblNewLabel.getText()));
		session.delete(stockCardFileModel);

		transaction.commit();
		session.close();

		getTable(cardView);
		FTPClient ftp = new FTPClient();

		try {
			ftp.connect("192.168.2.235");
			ftp.login("guru", "chocolateforguru");
			ftp.changeWorkingDirectory("/dosya");
			ftp.deleteFile(lblNewLabel.getText());
		
			ftp.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void uploadButton(StockCardView cardView) {

		String sendFileDescription = JOptionPane.showInputDialog("Açıklama");
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("File", "pdf", "txt", ".");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			Transaction transaction;
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			try {
				FileInputStream fis = new FileInputStream(file);
				StockCardFileModel stockCardFileModel = new StockCardFileModel();
				stockCardFileModel.setFileName(file.getName());
				stockCardFileModel.setSendFileDescription(sendFileDescription);
				StockCardModel cardModel = new StockCardModel();
				cardModel.setStockCod(cardView.getStock_code_textField().getText());
				;
				if (cardModel.getStockCod().isEmpty()) {
					String stockCode = JOptionPane.showInputDialog("Stok Kodu Giriniz");
					cardModel.setStockCod(stockCode);

				}
				stockCardFileModel.setStockcards(cardModel);

				session.save(stockCardFileModel);

				transaction.commit();
				session.close();
				FTPClient ftp = new FTPClient();
				try {
					ftp.connect("192.168.2.235");
					ftp.login("guru", "chocolateforguru");
					ftp.changeWorkingDirectory("/dosya");
					ftp.storeFile(file.getName(), fis);
					ftp.disconnect();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

//		

		}

		getTable(cardView);
		// transaction = session.beginTransaction();
		// ftp.disconnect();

	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}
}
