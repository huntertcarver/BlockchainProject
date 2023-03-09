package blockchainprojectpackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Blockchain blockchain;

    public ClientHandler(Socket clientSocket, Blockchain blockchain) {
        this.clientSocket = clientSocket;
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            String request = (String) in.readObject();

            if (request.equals("get_latest_block")) {
                Block latestBlock = blockchain.getLatestBlock();
                out.writeObject(latestBlock);
            } else if (request.equals("add_block")) {
                Block newBlock = (Block) in.readObject();
                blockchain.addBlock(newBlock);
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
