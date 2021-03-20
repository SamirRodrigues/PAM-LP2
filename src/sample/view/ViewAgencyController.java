package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAgencyController implements Initializable {

    public TableView<Photographer> photoList = new TableView();
    public TableColumn<Photographer, Integer> idPhotographer = new TableColumn<>();
    public TableColumn<Photographer, String> namePhotographer = new TableColumn<>();

    public TableView<Order> orderList = new TableView();
    public TableColumn<Order, Integer> idOrder = new TableColumn<>();
    public TableColumn<Order, String> nameOrder = new TableColumn<>();
    public TableColumn<Order, Integer> packOrder = new TableColumn<>();

    //Test Variable
    public Order[] orders = new Order[20];



    // Start Register Menu Options

    public void RegisterNewCompany() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("companyRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

    public void RegisterNewPhotographer() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("photographerRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

    // End Register Menu Options

    // Start Agency Body View

    private ObservableList<Photographer> getPhotographer() {
        ObservableList<Photographer> p = FXCollections.observableArrayList();
        p.add(new Photographer(1,"Samir"));
        p.add(new Photographer(2,"Leticia"));
        p.add(new Photographer(3,"Cephas"));
        p.add(new Photographer(4,"Will"));

        return p;
    }

    private ObservableList<Order> getOrder() {
        ObservableList<Order> o = FXCollections.observableArrayList();
        o.add(new Order(1,"Luiz",1));
        o.add(new Order(1,"Zé",1));
        o.add(new Order(2,"Jão",3));
        o.add(new Order(2,"DarthVader",3));

        int count = 0;
        for (Order i : o ) {
            orders[count] = i;
            count++;
        }
        return o;
    }


    private  ObservableList<Order> setOrder(Photographer p, Order[] orders) {
        ObservableList<Order> o = FXCollections.observableArrayList();

        for (Order i: orders)
        {
            if (i!= null && p.getId() == i.getId())
            {
                o.add(i);
            }
        }
        return o;
    }

    public void ButtonAction() throws IOException
    {
        idOrder.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        nameOrder.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
        packOrder.setCellValueFactory(new PropertyValueFactory<Order, Integer>("pack"));
        getOrder();
        orderList.setItems(setOrder(photoList.getSelectionModel().getSelectedItem(),orders));
    }

    // End Agency Body View


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //These items are for configuring the TableView
        idPhotographer.setCellValueFactory(new PropertyValueFactory<Photographer, Integer>("id"));
        namePhotographer.setCellValueFactory(new PropertyValueFactory<Photographer, String>("name"));
        photoList.setItems(getPhotographer());
    }


}