package messenger.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int PORT = 5000;
    private static final List<String> RESPONSES = Arrays.asList(
            "Interessante... continue.",
            "Essa é uma boa pergunta.",
            "Você sempre pensa assim?"
    );

    public static void main(String[] args) {
        System.out.println("Servidor iniciado na porta " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());

                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final Random random = new Random();

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String input;
                while ((input = in.readLine()) != null) {
                    if (input.equalsIgnoreCase("sair")) {
                        out.println("Conexão encerrada.");
                        break;
                    }

                    String response = RESPONSES.get(random.nextInt(RESPONSES.size()));
                    out.println(response);
                }
            } catch (IOException e) {
                System.err.println("Erro na comunicação com o cliente: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    System.out.println("Conexão com cliente encerrada.");
                } catch (IOException e) {
                    System.err.println("Erro ao fechar socket: " + e.getMessage());
                }
            }
        }
    }
}
