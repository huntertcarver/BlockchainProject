package blockchainprojectpackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Peer implements Runnable {
    private int port;
    private List<String> peers;
    private Blockchain blockchain;

    public Peer(int port, List<String> peers, Blockchain blockchain) {
        this.port = port;
        this.peers = peers;
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        while (true) {
            for (String peer : peers) {
                String[] parts = peer.split(":");
                String host = parts[0];
                int port = Integer.parseInt(parts[1]);

                try {
                    Socket socket = new Socket(host, port);

                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject("get_latest_block");

                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    Block latestBlock = (Block) in.readObject();

                    if (latestBlock.getIndex() > blockchain.getLatestBlock().getIndex()) {
                        out.writeObject("add_block");
                        out.writeObject(latestBlock);
                    }

                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
