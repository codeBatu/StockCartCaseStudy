package studycase.stockcart.view;

import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailUi extends JInternalFrame {

	private JTextField mailTextField = new JTextField();;

	public JTextField getMailTextField() {
		return mailTextField;
	}

	public JButton getSendButton() {
		return sendButton;
	}

	public MailUi() {
		init();

	}

	private JButton sendButton = new JButton("Send");

	private void init() {

		this.setClosable(true);
		this.setTitle("Send Mail");

		this.setBounds(10, 11, 316, 86);

		this.getContentPane().setLayout(null);

		mailTextField.setBounds(76, 8, 86, 20);
		this.getContentPane().add(mailTextField);
		mailTextField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Alıcı");
		lblNewLabel_2.setBounds(10, 11, 46, 14);
		this.getContentPane().add(lblNewLabel_2);
//		

		sendButton.setBounds(177, 7, 89, 23);
		this.getContentPane().add(sendButton);
		this.setVisible(true);
	}
}
