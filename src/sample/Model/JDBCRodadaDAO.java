package sample.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.FabricaConexao;
import sample.Model.Rodada;
import sample.Model.RodadaDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCRodadaDAO
        implements RodadaDAO{


    private static JDBCRodadaDAO instance;
    private ObservableList<Rodada> lista;

    private JDBCRodadaDAO(){
        lista = FXCollections.observableArrayList();
    }

    public static JDBCRodadaDAO getInstance(){
        if(instance==null){
            instance = new JDBCRodadaDAO();
        }
        return instance;
    }


    @Override
    public void add(Rodada r) throws Exception {
        Connection c = FabricaConexao.getConnection();

        String sql = "insert into"+
                " rodadas(palpite,dado1,dado2,pkJogador)"+
                "values(?,?,?,?)";



        PreparedStatement pStm = c.prepareStatement(sql);
        pStm.setInt(1,r.getPalpite());
        pStm.setInt(2,r.getDado1());
        pStm.setInt(3,r.getDado2());
        pStm.setInt(4,r.getPkJogador());

        pStm.execute();

        pStm.close();
        c.close();
    }


    private Rodada montaRodada(ResultSet rs)throws SQLException{

        int id = rs.getInt("id");
        int palpite = rs.getInt("palpite");
        int dado1 = rs.getInt("dado1");
        int dado2 = rs.getInt("dado2");
        int pkJogador = rs.getInt("pkJogador");
        int resultado = dado1+dado2;

        Rodada r = new Rodada();
        r.setId(id);
        r.setPalpite(palpite);
        r.setDado1(dado1);
        r.setDado2(dado2);
        r.setPkJogador(pkJogador);
        r.setResultado(resultado);
        return r;
    }



    @Override
    public void delete() {

    }



    @Override
    public ObservableList<Rodada> list() throws Exception {
        //ArrayList<Rodada> Rodadas = new ArrayList<>();
        lista.clear();

            Connection c = FabricaConexao.getConnection();
            Statement stm = c.createStatement();
            ResultSet rs = stm
                    .executeQuery("select * from rodadas");

            while (rs.next()){
                Rodada j = montaRodada(rs);
                lista.add(j);
            }

            rs.close();
            stm.close();
            c.close();


        return lista;
    }




}
