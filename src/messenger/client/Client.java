package messenger.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Conectado ao servidor em " + SERVER_HOST + ":" + SERVER_PORT);
            System.out.println("Digite mensagens para enviar ao servidor (digite 'sair' para encerrar):");

            String message;
            while (true) {
                System.out.print("Você: ");
                message = scanner.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("sair")) {
                    break;
                }

                String response = in.readLine();
                System.out.println("Servidor: " + response);
            }

            System.out.println("Conexão encerrada.");
        } catch (IOException e) {
            System.err.println("Erro ao se conectar ao servidor: " + e.getMessage());
        }
    }
}
