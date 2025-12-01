import dao.JogadorDao;
import model.Jogador;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try {
            JogadorDao dao = new JogadorDao();
            System.out.println(dao.getJogadores());
//            dao.salvar(new Jogador("111.111.111-01",
//                "Danilo",
//                    LocalDate.of(1990,2,3),
//                    "Flamengo", "Zagueiro",
//                    10000000));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
