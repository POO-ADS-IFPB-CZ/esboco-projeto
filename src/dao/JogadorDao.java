package dao;

import model.Jogador;

import java.util.HashSet;
import java.util.Set;

public class JogadorDao {

    Set<Jogador> jogadores;

    public JogadorDao(){
        jogadores = new HashSet<>();
    }

    //CREATE
    public boolean salvar(Jogador jogador){
        return jogadores.add(jogador);
    }

    //READ
    public Set<Jogador> getJogadores(){
        return jogadores;
    }

    //UPDATE
    public boolean atualizar(Jogador jogador){
        return jogadores.remove(jogador) && jogadores.add(jogador);
    }

    //DELETE
    public boolean deletar(Jogador jogador){
        return jogadores.remove(jogador);
    }

}
