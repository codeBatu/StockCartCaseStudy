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

	private JTextField textField_2 = new JTextField();;

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public MailUi() {
		init();

	}

	private JButton btnNewButton = new JButton("Send");

	private void init() {

		// jInternalFrame. setBounds(100, 100, 450, 300);
		this.setClosable(true);
		this.setTitle("Yeni Kdv Tip Kartı");
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// jInternalFrame().setLayout(null);
		this.setBounds(10, 11, 316, 86);

		this.getContentPane().setLayout(null);

		textField_2.setBounds(76, 8, 86, 20);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Alıcı");
		lblNewLabel_2.setBounds(10, 11, 46, 14);
		this.getContentPane().add(lblNewLabel_2);
//		

	
		btnNewButton.setBounds(177, 7, 89, 23);
		this.getContentPane().add(btnNewButton);
		this.setVisible(true);
	}
}
