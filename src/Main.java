import dao.JogadorDao;
import model.Jogador;

import java.io.File;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        JogadorDao jogadorDao = new JogadorDao();

        //Após ler os dados do jogador (formulário)
        Jogador jogador = new Jogador("111.111.111-01",
                "Danilo",
                LocalDate.of(1983, 3,2),
                "Flamengo", "Zagueiro",
                10000000);

        if(jogadorDao.salvar(jogador)){
            System.out.println("Salvo com sucesso!");
        }
        System.out.println(jogadorDao.getJogadores());
        jogador.setNome("Danilo bi campeão");
        jogadorDao.atualizar(jogador);
        System.out.println(jogadorDao.getJogadores());
        jogadorDao.deletar(jogador);
        System.out.println(jogadorDao.getJogadores());
    }

}
