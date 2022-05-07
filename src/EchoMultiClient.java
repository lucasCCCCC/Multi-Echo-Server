import java.io.IOException;
import java.io.*;
import java.net.*;

public class EchoMultiClient {

    public static void main(String[] args) throws IOException {

        String message, serverMessage;

        Socket clientSocket = new Socket("127.0.0.1", 80);
        System.out.println("Client is running");

        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            System.out.println("CLIENT MESSAGE: ");
            message = inFromUser.readLine();
            outToServer.println(message);

            serverMessage = inFromServer.readLine();
            System.out.println("SERVER MESSAGE: " + serverMessage);

            if (message.equals("exit")){
                break;
            }

        }

        inFromServer.close();
        inFromUser.close();
        outToServer.close();
        clientSocket.close();

    }

}
