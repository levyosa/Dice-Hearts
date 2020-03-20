package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/Tela.fxml"));
        primaryStage.setTitle(" Ｄ Ｉ Ｃ Ｅ ＿ Ｈ Ｅ Ａ Ｒ Ｔ Ｓ");
        primaryStage.setScene(new Scene(root, 325, 475));
        primaryStage.setResizable(false);
        primaryStage.show();





    }


    public static void main(String[] args) {
        launch(args);
    }
}