package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewLoginController {

    public TextField userLogin;
    public PasswordField passLogin;

    public void Login(ActionEvent event) throws Exception {
        if (userLogin.getText().equals("photo"))
        {

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); // Pegando referencia da tela antior
            window.close();

            Parent photographerViewParent = FXMLLoader.load(getClass().getResource("photographerView.fxml")); // Carregando o arquivo fxml
            Scene photographerViewScene = new Scene(photographerViewParent); // Colocando em uma nova scene


            Stage newWindow = new Stage();
            newWindow.setScene(photographerViewScene);
            newWindow.show();

        }

        if (userLogin.getText().equals("admin"))
        {
            // Pegando referencia da tela antior
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();

            Parent agencyViewParent = FXMLLoader.load(getClass().getResource("agencyView.fxml")); // Carregando o arquivo fxml
            Scene agencyViewScene = new Scene(agencyViewParent); // Colocando em uma nova scene

            Stage newWindow = new Stage();
            newWindow.setScene(agencyViewScene);
            newWindow.show();
        }
    }
}
