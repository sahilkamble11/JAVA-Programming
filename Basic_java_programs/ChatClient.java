import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to chat server");

            new ReadThread(socket).start();
            new WriteThread(socket).start();
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }

    private static class ReadThread extends Thread {
        private BufferedReader in;

        public ReadThread(Socket socket) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Error getting input stream: " + e.getMessage());
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }
    }

    private static class WriteThread extends Thread {
        private PrintWriter out;
        private Scanner scanner;

        public WriteThread(Socket socket) {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                scanner = new Scanner(System.in);
            } catch (IOException e) {
                System.out.println("Error getting output stream: " + e.getMessage());
            }
        }

        public void run() {
            while (true) {
                String message = scanner.nextLine();
                out.println(message);
            }
        }
    }
}
