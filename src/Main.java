import dao.JogadorDao;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        JogadorDao jogadorDao = null;
        try {
            jogadorDao = new JogadorDao();
        } catch (IOException e) {
            System.out.println("Falha ao conectar com o arquivo");
            System.exit(0);
        }
        System.out.println("BID - CBF");
        while(true){
            System.out.println("Escolha uma opção" +
                    "\n1 - Salvar Jogador" +
                    "\n2 - Listar Jogadores");
            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha){
                case 1 -> System.out.println("Escolheu salvar");
                case 2 -> System.out.println("Escolheu listar");
                default -> System.exit(0);
            }
        }


    }

}
