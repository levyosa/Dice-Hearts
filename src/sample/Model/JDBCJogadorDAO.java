package sample.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;


public class JDBCJogadorDAO
        implements JogadorDAO {


    private static JDBCJogadorDAO instance;
    private ObservableList<Jogador> lista;

    private JDBCJogadorDAO(){
        lista = FXCollections.observableArrayList();
    }

    public static JDBCJogadorDAO getInstance(){
        if(instance==null){
            instance = new JDBCJogadorDAO();
        }
        return instance;
    }


    @Override
    public void add(Jogador j) throws Exception {
        Connection c = FabricaConexao.getConnection();

        String sql = "insert into"+
                " jogadores(nome)"+
                "values(?)";



        PreparedStatement pStm = c.prepareStatement(sql);
        pStm.setString(1,j.getNome());


        pStm.execute();

        pStm.close();
        c.close();
    }


    private Jogador montaJogador(ResultSet rs)throws SQLException{
        int id = rs.getInt("id");
        String nome = rs.getString("nome");


        Jogador j = new Jogador();
        j.setId(id);
        j.setNome(nome);

        return j;
    }


    @Override
    public ObservableList<Jogador> list() {

        lista.clear();
        try {
            Connection c = FabricaConexao.getConnection();
            Statement stm = c.createStatement();
            ResultSet rs = stm
                    .executeQuery("select * from jogadores");

            while (rs.next()){
                Jogador j = montaJogador(rs);
                lista.add(j);
            }

            rs.close();
            stm.close();
            c.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return lista;
    }


}
