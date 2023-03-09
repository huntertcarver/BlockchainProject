package blockchainprojectpackage;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String host;
    private int port;
    private List<String> peers;
    private Blockchain blockchain;

    public Node(String host, int port, Blockchain blockchain) {
    	this.host = host;
        this.port = port;
        this.peers = new ArrayList<String>();
        this.blockchain = blockchain;
    }

    public void addPeer(String host, int port) {
        String peer = host + ":" + port;
        this.peers.add(peer);
    }

    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    public void start() {
        // Start listening for incoming connections
        new Thread(new Server(port, blockchain)).start();

        // Periodically connect to peers and update blockchain
        new Thread(new Peer(port, peers, blockchain)).start();
    }
}
