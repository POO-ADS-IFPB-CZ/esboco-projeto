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
    public boolean salvar(Jogador jogador) throws IOException, ClassNotFoundException {
        Set<Jogador> jogadores = getJogadores();
        if(jogadores.add(jogador)){
            atualizarArquivo(jogadores);
            return true;
        }
        return false;
    }

    private void atualizarArquivo(Set<Jogador> jogadores)
            throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(jogadores);
        }
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
        return false;
//        return jogadores.remove(jogador) && jogadores.add(jogador);
    }

    //DELETE
    public boolean deletar(Jogador jogador){
        return false;
//        return jogadores.remove(jogador);
    }

}
