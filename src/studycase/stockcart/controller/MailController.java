package studycase.stockcart.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
		mailUi.getSendButton().addActionListener(this);
		mailUi.getSendButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputStream stringPath = getClass().getResourceAsStream("/jasper/report8.jasper");
				Collection<Map<String, ?>> parameters = new ArrayList<>();
				Map<String, Object> maps = new HashMap<String, Object>();

				for (int i = 0; i < table.getRowCount(); i++) {

					maps.put("StockCode", table.getModel().getValueAt(i, 0).toString());
					maps.put("StockName", table.getModel().getValueAt(i, 1).toString());
					maps.put("StockType", table.getModel().getValueAt(i, 2).toString());
					maps.put("Unit", table.getModel().getValueAt(i, 3).toString());
					maps.put("Barcode", table.getModel().getValueAt(i, 4).toString());
					maps.put("KdvType", table.getModel().getValueAt(i, 5).toString());
					maps.put("Description", table.getModel().getValueAt(i, 6).toString());
					maps.put("CreatedDate", table.getModel().getValueAt(i, 7).toString());
					maps.put("KdvTypeId", table.getModel().getValueAt(i, 8).toString());
					maps.put("KdvTypeName", table.getModel().getValueAt(i, 9).toString());
					maps.put("KdvTypeCode", table.getModel().getValueAt(i, 10).toString());
					maps.put("KdvTypeRatio", table.getModel().getValueAt(i, 11).toString()!=null?table.getModel().getValueAt(i, 11).toString():"");
				//	maps.put("StockId", table.getModel().getValueAt(i, 11).toString()!=null?table.getModel().getValueAt(i, 11).toString():"");
					maps.put("StockId", table.getModel().getValueAt(i, 11).toString());
					maps.put("StockTypeName", table.getModel().getValueAt(i, 13));

					maps.put("StockTypeDescription", table.getModel().getValueAt(i, 14));
					parameters.add(maps);

					parameters.add(maps);

				}

				JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);

				try {

					JasperPrint jp = JasperFillManager.fillReport(stringPath, maps, beanColDataSource);

					JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\report.pdf");
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

						message.addRecipient(Message.RecipientType.TO, new InternetAddress("mnf_41@hotmail.com"));

						message.setSubject("deneme");

						message.setText("deneme");
						Multipart multipart = new MimeMultipart();

						BodyPart bodyPart = new MimeBodyPart();
						bodyPart.setDataHandler(new DataHandler(new javax.activation.FileDataSource(
								"C:\\Users\\mnf_4\\OneDrive\\Masaüstü\\report.pdf")));
						bodyPart.setFileName("report.pdf");
						multipart.addBodyPart(bodyPart);
						message.setContent(multipart);

						Transport.send(message);

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
