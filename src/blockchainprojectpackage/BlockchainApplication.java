package blockchainprojectpackage;

import javax.swing.JFrame;

public class BlockchainApplication {

	public static void main(String[] args) {
		Blockchain block1 = new Blockchain(2);
		//BlockchainFrame blockchainFrame = new BlockchainFrame(block1);
		StartFrame firstFrame = new StartFrame();
		firstFrame.setVisible(true);
	}

}