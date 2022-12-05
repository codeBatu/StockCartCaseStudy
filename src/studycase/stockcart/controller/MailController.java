package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JTable;

import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.view.MailUi;

public class MailController implements ActionListener {
	private MailUi mailUi;

	public MailController(MailUi mailUi) {
		this.mailUi = mailUi;
	}

	public MailUi initMailUi(JTable table) {
		mailUi.getBtnNewButton().addActionListener(this);
		mailUi.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputStream stringPath = getClass().getResourceAsStream("/jasper/report6.jasper");
				Collection<Map<String, ?>> parameters = new ArrayList<>();
				Map<String, Object> maps = new HashMap<String, Object>();
				int selectedRow = table.getSelectedRow();
				maps.put("StockCode", table.getModel().getValueAt(selectedRow, 0).toString());
				maps.put("StockName", table.getModel().getValueAt(selectedRow, 1).toString());
				maps.put("StockType", table.getModel().getValueAt(selectedRow, 2).toString());
				maps.put("Unit", table.getModel().getValueAt(selectedRow, 3).toString());
				maps.put("Barcode", table.getModel().getValueAt(selectedRow, 4).toString());
				maps.put("KdvType", table.getModel().getValueAt(selectedRow, 5).toString());
				maps.put("Description", table.getModel().getValueAt(selectedRow, 6).toString());
				maps.put("CreatedDate", table.getModel().getValueAt(selectedRow, 7).toString());
				maps.put("KdvTypeId", table.getModel().getValueAt(selectedRow, 8).toString());
				maps.put("KdvTypeName", table.getModel().getValueAt(selectedRow, 9).toString());
				maps.put("KdvTypeCode", table.getModel().getValueAt(selectedRow, 10).toString());
				maps.put("KdvTypeRatio", table.getModel().getValueAt(selectedRow, 11).toString());
				maps.put("StockId", table.getModel().getValueAt(selectedRow, 12).toString());
				maps.put("StockTypeName", table.getModel().getValueAt(selectedRow, 13).toString());
				maps.put("StockTypeCode", table.getModel().getValueAt(selectedRow, 14).toString());
				maps.put("StockTypeDescription", table.getModel().getValueAt(selectedRow, 15).toString());

				parameters.add(maps);

				JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);

				try {
					JasperPrint jp = JasperFillManager.fillReport(stringPath, maps, beanColDataSource);
					String from = "erkenbatuh@yandex.com";
					String pass = "123Batu123*";

					String host = "smtp.yandex.com";
					Integer port = 465;
					Properties properties = new Properties();
					properties.put("mail.smtp.host", host);
					properties.put("mail.smtp.ssl.enable", true);
					properties.put("mail.smtp.port", port);
					properties.put("mail.smtp.auth", "true");

					Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {

							return new PasswordAuthentication(from, pass);

						}

					});

					session.setDebug(true);

					try {

						MimeMessage message = new MimeMessage(session);

						message.setFrom(new InternetAddress(from));

						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(mailUi.getTextField_2().getText()));

						message.setSubject("deneme");

						message.setText("deneme");
//						byte[] pdfBytes = JasperExportManager.exportReportToPdf(jp);
//						System.out.println(pdfBytes);
						// Send message
						Transport.send(message);
						System.out.println("deneme message is successfully....");
					} catch (MessagingException mex) {
						mex.printStackTrace();

					}

				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		return mailUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
