package command;

import org.apache.commons.net.ftp.FTPClient;

import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.view.SendFileView;
import studycase.stockcart.view.StockCardView;

public class StockCardSendFtpButtonCommand implements Command {
	private StockCardView cardView;

	StockCardModel stockCardModel = new StockCardModel();

	public StockCardSendFtpButtonCommand(StockCardView stockCardView) {
		super();
		this.cardView = stockCardView;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		SendFileView sendFileView = new SendFileView(cardView);
		sendFileView.setVisible(true);
		cardView.getDesktopPane().add(sendFileView);

//		FTPClient ftp = new FTPClient();
//		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		jfc.setDialogTitle("Multiple file and directory selection:");
//		jfc.setMultiSelectionEnabled(true);
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//
//		int returnValue = jfc.showOpenDialog(null);
//		if (returnValue == JFileChooser.APPROVE_OPTION) {
//			File[] files = jfc.getSelectedFiles();
//
//			Arrays.asList(files).forEach(x -> {
//				if (x.isFile()) {
//					try {
//						FileInputStream fis = new FileInputStream(x);
//
//						ftp.connect("192.168.2.235");
//
//						// ftp.changeToParentDirectory();
//						// ftp.changeToParentDirectory();
//						// System.err.println(ftp.isConnected());
//
//						showServerReply(ftp);
//
//						FTPFile[] file = ftp.listDirectories();
//						for (FTPFile dic : file) {
//
//							System.out.println(dic.getName());
//
//						}
//
//						ftp.storeFile(x.getName(), fis);
//						ftp.disconnect();
//
//					} catch (SocketException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//			});
//		}

	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

}
