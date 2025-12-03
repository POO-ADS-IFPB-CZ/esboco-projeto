package dao;

import model.Jogador;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GenericDao<T> {
    private File file;

    public GenericDao(String arquivo) throws IOException {
        file = new File(arquivo);
        if(!file.exists()) file.createNewFile();
    }

    //CREATE
    public boolean salvar(T objeto) throws IOException, ClassNotFoundException {
        Set<T> objetos = getObjetos();
        if(objetos.add(objeto)){
            atualizarArquivo(objetos);
            return true;
        }
        return false;
    }

    private void atualizarArquivo(Set<T> objetos)
            throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(objetos);
        }
    }

    //READ
    public Set<T> getObjetos() throws IOException,
            ClassNotFoundException {
        if(file.length()==0) return new HashSet<>();
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))){
            return (Set<T>) in.readObject();
        }
    }

    //UPDATE
    public boolean atualizar(T objeto) throws IOException, ClassNotFoundException {
        Set<T> objetos = getObjetos();
        if(objetos.remove(objeto) && objetos.add(objeto)){
            atualizarArquivo(objetos);
            return true;
        }
        return false;
    }

    //DELETE
    public boolean deletar(T objeto) throws IOException, ClassNotFoundException {
        Set<T> objetos = getObjetos();
        if(objetos.remove(objeto)){
            atualizarArquivo(objetos);
            return true;
        }
        return false;
    }
}