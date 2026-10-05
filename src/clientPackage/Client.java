package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Je suis un client pas encore connecté ");
        // 2. Se connecter au serveur : adresse + port
        Socket socket = new Socket("localhost", 1234);
        System.out.println("je suis un client connecté");

        // Fermer la socket
        socket.close();
    }
}