package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewPhotoController {

    public void RegisterNewClient() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("clientRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

    public void RegisterNewTrip() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("tripRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

}
