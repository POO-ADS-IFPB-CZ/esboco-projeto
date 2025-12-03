import dao.GenericDao;
import exception.CpfExistenteException;
import exception.ValorInvalidoException;
import model.Jogador;
import service.JogadorService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        JogadorService jogadorService = null;
        try {
            jogadorService = new JogadorService();
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
                case 1 -> {
                    System.out.println("Informe o CPF:");
                    String cpf = scanner.nextLine();
                    System.out.println("Informe o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o nascimento (AAAA-MM-DD)");
                    LocalDate nascimento = LocalDate.parse(scanner.nextLine());
                    System.out.println("Informe o time:");
                    String time = scanner.nextLine();
                    System.out.println("Informe a posição:");
                    String posicao = scanner.nextLine();
                    System.out.println("Informe o valor:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    Jogador jogador = new Jogador(cpf, nome, nascimento, time,
                            posicao, valor);
                    try {
                        if(jogadorService.salvar(jogador)){
                            System.out.println("Salvo com sucesso");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Falha ao salvar jogador");
                    } catch (CpfExistenteException e) {
                        System.out.println(e.getMessage());
                    } catch (ValorInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.println(jogadorService.listar());
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Falha ao listar");
                        System.exit(0);
                    }
                }
                default -> System.exit(0);
            }
        }


    }

}
