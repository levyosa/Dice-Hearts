package sample.Model;

import javafx.beans.value.ObservableStringValue;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface JogadorDAO {
    public void add(Jogador j) throws Exception;

    public ObservableList<Jogador> list()throws Exception;



}
