package blockchainprojectpackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private int port;
    private Blockchain blockchain;

    public Server(int port, Blockchain blockchain) {
        this.port = port;
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new ClientHandler(clientSocket, blockchain));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}