import java.io.*;
import java.net.*;

public class EchoClientHandler implements Runnable{

    Socket clientSocket;
    int clientNo;

    public EchoClientHandler(Socket clientSocket, int clientNo) {
        this.clientSocket = clientSocket;
        this.clientNo = clientNo;
    }

    public void run(){

        try {

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String clientMessage;

            while (! (clientMessage = inFromClient.readLine()).equals("exit") ){
                outToClient.println(clientMessage);
            }

            System.out.println("Client " + this.clientNo + " has disconnected");
            outToClient.println("Connection closed \n Goodbye!");

            inFromClient.close();
            outToClient.close();
            this.clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
