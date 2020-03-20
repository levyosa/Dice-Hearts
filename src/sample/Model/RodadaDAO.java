package sample.Model;

import javafx.collections.ObservableList;

public interface RodadaDAO {

    public void add(Rodada r) throws Exception;

    public void delete();

    public ObservableList<Rodada> list() throws Exception;

}
