package sample.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Model.JDBCJogadorDAO;
import sample.Model.JDBCRodadaDAO;
import sample.Model.Jogador;
import sample.Model.Rodada;

import java.util.Optional;

public class ControllerTela {

    @FXML
    ComboBox cbJogadores;
    @FXML
    Button btAddJogador,btJogar;
    @FXML
    TextField tfPalpite;
    @FXML
    TableView tvRodadas;
    @FXML
    TextField t1,t2;
    @FXML
    TableColumn<Rodada,Integer> colPalpite,colResultado;



    public void initialize() throws Exception {
        cbJogadores.setItems(JDBCJogadorDAO.getInstance().list());
        populaLista();


    }


    public void jogarDados() throws Exception {
        int dado1 = (int) (Math.random()*6 +1);
        int dado2 = (int) (Math.random()*6 +1);
        int resuldado = dado1+dado2;
        mostraResultado(dado1,dado2);
        Rodada rod = new Rodada();
        rod.setPalpite(Integer.parseInt(tfPalpite.getText()));
        rod.setDado1(dado1);
        rod.setDado2(dado2);
        Jogador j = (Jogador) cbJogadores.getSelectionModel().getSelectedItem();
        rod.setPkJogador(j.getId());




        System.out.println("rodada criada:"+"  palpite:"+rod.getPalpite() +"  resuldado:" +resuldado+ "   dado1:"+rod.getDado1()+"  dado2:"+rod.getDado2()+"  Jgador: "+rod.getPkJogador()+"  "+j.getNome() );

        sample.Model.JDBCRodadaDAO.getInstance().add(rod);
        populaLista();
        if(resuldado== rod.getPalpite()){


            System.out.println("ganhou ee");

            t1.setText("♥");
            t2.setText("♥");
        }
    }

    public void abrirDialogAddJogador(ActionEvent actionEvent) throws Exception {


        TextInputDialog cadastro = new TextInputDialog("nome");
        cadastro.setTitle("Ｄ Ｉ Ｃ Ｅ ＿ Ｈ Ｅ Ａ Ｒ Ｔ Ｓ");
        cadastro.setHeaderText("Digite seu nome para cadastrar.");
        cadastro.setContentText("Nome:");


        Optional<String> result = cadastro.showAndWait();
        if (result.isPresent()){
            System.out.println("Nome: " + result.get());
        }

        Jogador j = new Jogador();
        j.setNome(result.get());

        System.out.println(j.getNome());

       JDBCJogadorDAO.getInstance().add(j);




    }

    public void atualizaTvRodadas(){
       // System.out.println("Atualizou lista");

    }

    public void ListarJogadores(){
        JDBCJogadorDAO.getInstance().list();

    }


    private void mostraResultado(int dado1,int dado2){
        t1.setText((renderizaDado(dado1)));
        t2.setText((renderizaDado(dado2)));

    }
    public String renderizaDado(int valor) {
        if (valor == 1) {
            return "⚀";
        } else if (valor == 2) {
            return "⚁";
        } else if (valor == 3) {
            return "⚂";
        } else if (valor == 4) {
            return "⚃";
        } else if (valor == 5) {
            return "⚄";
        } else if (valor == 6) {
            return "⚅";
        }
        return null;
    }

    public void populaLista() throws Exception {
        colPalpite.setCellValueFactory(new PropertyValueFactory<>("palpite"));
        colResultado.setCellValueFactory(new PropertyValueFactory<>("resultado"));


        tvRodadas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tvRodadas.setItems(JDBCRodadaDAO.getInstance().list());
    }

}
