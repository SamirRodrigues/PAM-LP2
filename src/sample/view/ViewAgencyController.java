package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAgencyController implements Initializable {

    public TableView<Photographer> photoList = new TableView<>();
    public TableColumn<Photographer, Integer> idPhotographer = new TableColumn<>();
    public TableColumn<Photographer, String> namePhotographer = new TableColumn<>();

    public TableView<Order> orderList = new TableView<>();
    public TableColumn<Order, Integer> idOrder = new TableColumn<>();
    public TableColumn<Order, String> nameOrder = new TableColumn<>();
    public TableColumn<Order, Integer> packOrder = new TableColumn<>();

    //Test Variable
    public Order[] orders = new Order[20];

    public Label idDetailOrder = new Label();
    public Label nameDetailOrder = new Label();
    public Label packDetailOrder = new Label();
    public Label descriptionDetailOrder = new Label();


    // ## Start Register Menu Options ##
    //Esse metodo Inicia a janela de cadastro de uma nova empresa parceira
    public void RegisterNewCompany() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("companyRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }
    //Esse metodo Inicia a janela de cadastro de um(a) novo(a) fotografo(a) parceiro(a)
    public void RegisterNewPhotographer() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("photographerRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }
    // ## End Register Menu Options ##

    // ## Start Agency Body View ##
    //Gera a lista teste de fotografos parceiros
    private ObservableList<Photographer> getPhotographer() {
        ObservableList<Photographer> p = FXCollections.observableArrayList();
        p.add(new Photographer(1,"Samir"));
        p.add(new Photographer(2,"Leticia"));
        p.add(new Photographer(3,"Cephas"));
        p.add(new Photographer(4,"Will"));

        return p;
    }
    //Gera a lista teste de Pedidos
    private void getOrder() {
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
    }
    //Gera lista filtrada dos fotografos com os pedidos relacionados
    private  ObservableList<Order> setOrder(Photographer p, Order[] orders) {
        ObservableList<Order> o = FXCollections.observableArrayList();

        for (Order i: orders)
        {
            if (i!= null && p.getId() == i.getId())
            {
                i.setDescription("Descrição do pedido de " +  i.getName());
                o.add(i);
            }
        }
        return o;
    }

    //Esse metodo recebe um pedido para inicializar a janela de detalhamento com os dados desse pedido
    public void initData(Order order) {
        idDetailOrder.setText(String.valueOf(order.getId()));
        nameDetailOrder.setText(order.getName());
        packDetailOrder.setText(String.valueOf(order.getPack()));
        descriptionDetailOrder.setText(order.getDescription());

    }

    //Esse metodo recebe um pedido para inicializar a janela de detalhamento com os dados desse pedido
    public void initData() {

        idDetailOrder.setText("-");
        nameDetailOrder.setText("-");
        packDetailOrder.setText("-");
        descriptionDetailOrder.setText("-");

    }

    //Executa a filtragem dos fotografos com os pedidos relacionados
    public void ButtonAction1() {
        initData();
        idOrder.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameOrder.setCellValueFactory(new PropertyValueFactory<>("name"));
        packOrder.setCellValueFactory(new PropertyValueFactory<>("pack"));
        getOrder();
        orderList.setItems(setOrder(photoList.getSelectionModel().getSelectedItem(),orders));
    }

    //Executa o detalhamento dos pedidos
    public void ButtonAction2() {
        initData(orderList.getSelectionModel().getSelectedItem());
    }

    // ## End Agency Body View ##
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //These items are for configuring the TableView
        idPhotographer.setCellValueFactory(new PropertyValueFactory<>("id"));
        namePhotographer.setCellValueFactory(new PropertyValueFactory<>("name"));
        photoList.setItems(getPhotographer());
    }
}