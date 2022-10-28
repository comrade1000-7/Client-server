import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 33228;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String response = in.readLine();
            System.out.println(response);

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);

            String message1 = in.readLine();
            System.out.println(message1);

            String isChild = scanner.nextLine();
            out.println(isChild);

            String answer = in.readLine();
            System.out.println(answer);
        }
    }
}
