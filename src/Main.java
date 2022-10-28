import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 33228;
        System.out.println("Server started");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("New connection accepted");
                    out.println("What is your name?");

                    String username = in.readLine();

                    out.println("Are you child? yes/no");

                    String isChild = in.readLine();
                    if (isChild.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s! " +
                                "Have a good rest, or a good working day!", username));
                    }

                }
            }
        }
    }
}
