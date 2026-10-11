package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        //1. Créer la socket d'écoute sur le port 1234
        ServerSocket socketServer = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");
        // 2. Attendre et accepter la connexion d'un client
        Socket socket = socketServer.accept();
        System.out.println("un client est connecté");
        // 3. Fermer les sockets
        socket.close();
        socketServer.close();
    }
}