package sample.view;

import javafx.beans.property.SimpleStringProperty;

public class Order {

    private SimpleStringProperty name;
    private int id;
    private int pack;

    public String getName() { return name.get(); }

    public SimpleStringProperty nameProperty() { return name; }

    public void setName(String name) { this.name.set(name); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getPack() { return pack; }

    public void setPack(int pack) { this.pack = pack; }

    public Order(int id, String name, int pack) {
        this.name = new SimpleStringProperty(name);
        this.id = id;
        this.pack = pack;
    }
}
