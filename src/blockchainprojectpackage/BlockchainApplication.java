package blockchainprojectpackage;

import javax.swing.JFrame;

public class BlockchainApplication {

	public static void main(String[] args) {
		BlockchainFrame blockchainFrame = new BlockchainFrame();
		blockchainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blockchainFrame.setSize(450,450);
		blockchainFrame.setVisible(true);
	}

}