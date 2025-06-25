package messenger;

import messenger.client.Client;
import messenger.server.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o modo:");
        System.out.println("[1] Servidor");
        System.out.println("[2] Cliente");
        System.out.print("Digite 1 ou 2: ");

        String input = scanner.nextLine().trim();

        switch (input) {
            case "1":
                Server.main(new String[0]);
                break;
            case "2":
                Client.main(new String[0]);
                break;
            default:
                System.out.println("Opção inválida. Encerrando programa.");
        }

        scanner.close();
    }
}
