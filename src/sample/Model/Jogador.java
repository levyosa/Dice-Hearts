package sample.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jogador {
    private int id;
    private SimpleStringProperty nome;
    private ObservableList<Rodada> rodadas;

    public Jogador(){
        nome= new SimpleStringProperty();
        rodadas = FXCollections.observableArrayList();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public ObservableList<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(ObservableList<Rodada> rodadas) {
        this.rodadas = rodadas;
    }

    public void addRodada(Rodada r){
        rodadas.add(r);
    }

    @Override
    public String toString() {
        return this.nome.get();
    }
}
