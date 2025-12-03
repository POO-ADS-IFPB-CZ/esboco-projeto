package service;

import dao.GenericDao;
import exception.CpfExistenteException;
import exception.ValorInvalidoException;
import model.Jogador;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JogadorService {

    GenericDao<Jogador> jogadorDao;

    public JogadorService() throws IOException {
        jogadorDao = new GenericDao<>("jogadores.txt");
    }

    public boolean salvar(Jogador jogador)
            throws ValorInvalidoException, IOException,
            ClassNotFoundException, CpfExistenteException {
        if(jogador.getValor()<0){
            throw new ValorInvalidoException(
                    "O valor deve ser maior ou igual a zero");
        }
        if(jogadorDao.getObjetos().stream()
                .filter(j -> j.getCpf().equals(jogador.getCpf()))
                .count()>0){
            throw new CpfExistenteException(
                    "Já existe alguém com esse CPF");
        }
        return jogadorDao.salvar(jogador);
    }

    public List<Jogador> listar() throws IOException, ClassNotFoundException {
        return jogadorDao.getObjetos().stream()
                .sorted(Comparator.comparing(Jogador::getCpf))
                .collect(Collectors.toUnmodifiableList());
    }

}
