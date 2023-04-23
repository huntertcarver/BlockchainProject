package blockchainprojectpackage;

import javax.swing.JFrame;

public class BlockchainApplication {

	public static void main(String[] args) {
		Blockchain block1 = new Blockchain(2);
		BlockchainFrame blockchainFrame = new BlockchainFrame(block1);
		blockchainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blockchainFrame.setSize(450,450);
		blockchainFrame.setVisible(true);
	}

}