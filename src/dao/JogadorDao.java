package dao;

import model.Jogador;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class JogadorDao {

    private File file;

    public JogadorDao() throws IOException {
        file = new File("jogadores.txt");
        if(!file.exists()) file.createNewFile();
    }

    //CREATE
    public boolean salvar(Jogador jogador){
        return jogadores.add(jogador);
    }

    //READ
    public Set<Jogador> getJogadores() throws IOException,
            ClassNotFoundException {
        if(file.length()==0) return new HashSet<>();
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))){
            return (Set<Jogador>) in.readObject();
        }
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
