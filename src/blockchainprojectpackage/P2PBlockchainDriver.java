package blockchainprojectpackage;

public class P2PBlockchainDriver {
    public static void main(String[] args) {
        // create a blockchain with difficulty of 3
        Blockchain blockchain = new Blockchain(3);

        // create a node with ID "localhost:5000"
        //Node node = new Node("localhost", 5000, blockchain);

        // start the node server
        //node.start();

        // connect to other nodes
        //node.addPeer("localhost", 5001);
        //node.addPeer("localhost", 5002);

        // create and add some blocks to the blockchain
        for(int i = 0; i < 50; i++) {
        	blockchain.addBlock(new Block(blockchain.getLatestBlock().getIndex() + 1, Integer.toString(i), blockchain.getLatestBlock().getHash()));
        }
        // print out the blockchain and its validity
        System.out.println("P2P Blockchain:");
        System.out.println(blockchain.getLatestBlock().getData());
        System.out.println("Is valid: " + blockchain.isValid());
    }
}
