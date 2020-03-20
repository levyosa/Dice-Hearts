package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;

public class Rodada {

    private int id;
    private SimpleIntegerProperty palpite;
    private SimpleIntegerProperty dado1;
    private SimpleIntegerProperty dado2;
    private int pkJogador;
    private int resultado;

    public Rodada(){
        palpite = new SimpleIntegerProperty();
        dado1 = new SimpleIntegerProperty();
        dado2 = new SimpleIntegerProperty();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPalpite() {
        return palpite.get();
    }

    public SimpleIntegerProperty palpiteProperty() {
        return palpite;
    }

    public void setPalpite(int palpite) {
        this.palpite.set(palpite);
    }

    public int getDado1() {
        return dado1.get();
    }

    public SimpleIntegerProperty dado1Property() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1.set(dado1);
    }

    public int getDado2() {
        return dado2.get();
    }

    public SimpleIntegerProperty dado2Property() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2.set(dado2);
    }

    public int getPkJogador() {
        return pkJogador;
    }

    public void setPkJogador(int pkJogador) {
        this.pkJogador = pkJogador;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
