import java.io.IOException;
import java.io.*;
import java.net.*;

public class EchoMultiServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(80);
        System.out.println("Server is running");
        int counter = 0;

        while(true) {

            Socket clientSocket = serverSocket.accept();
            counter ++;
            System.out.println("Client " + counter + " connected with IP "
                                + clientSocket.getInetAddress().getHostAddress());

            EchoClientHandler clientHandler = new EchoClientHandler(clientSocket, counter);

            new Thread(clientHandler).start();

        }

    }

}
