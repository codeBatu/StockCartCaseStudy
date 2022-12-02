package studycase.stockcart.view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailUi extends JInternalFrame {

	/**
	 * Launch the application.
	 */

 private JInternalFrame jInternalFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public MailUi(JPanel jpanel) {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(97, 11, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 42, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 134, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(97, 164, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(97, 195, 173, 178);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(10, 14, 77, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 45, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setBounds(10, 137, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject");
		lblNewLabel_3.setBounds(10, 167, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Message");
		lblNewLabel_4.setBounds(10, 200, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Properties props = new Properties();
				final String username = "---------@mydomain.com";
		        final String password = "***********";
				 props.put("mail.smtp.auth", "true");
				 props.put("mail.smtp.starttls.enable", "true"); 
			        props.put("mail.smtp.host", "smtp.yandex.com");
			        props.put("mail.smtp.debug", "true");
			        props.put("mail.smtp.port", "465 ");
			        Session session = Session.getInstance(props,
			                new javax.mail.Authenticator() {
			                  protected PasswordAuthentication getPasswordAuthentication() {
			                      return new PasswordAuthentication(username, password);
			                  }
			                });
			              session.setDebug(true);

			              try {

			                  Message message = new MimeMessage(session);
			                  message.setFrom(new 
			                        InternetAddress("---------@mydomain.com"));
			                  message.setRecipients(Message.RecipientType.TO,
			                  InternetAddress.parse("---------@mydomain.com"));
			                  message.setSubject("Testing Subject");
			                  message.setText("Dear Mail Crawler,"
			                      + "\n\n No spam to my email, please!");

			                  Transport.send(message);

			                  System.out.println("Done");

			              } catch (MessagingException e1) {
			                  throw new RuntimeException(e1);
			              }
			}
		});
		btnNewButton.setBounds(181, 384, 89, 23);
		getContentPane().add(btnNewButton);
		init(jpanel);

	}
	private void init(JPanel jpanel) {
		jInternalFrame = new JInternalFrame();

		// jInternalFrame. setBounds(100, 100, 450, 300);
		jInternalFrame.setClosable(true);
		jInternalFrame.setTitle("Yeni Stok Tip Kartı");
		try {
			jInternalFrame.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		jInternalFrame.setBounds(10, 11, 602, 458);
		jpanel.add(jInternalFrame);
		jInternalFrame.getContentPane().setLayout(null);
		jInternalFrame.setVisible(true);
	}
}
