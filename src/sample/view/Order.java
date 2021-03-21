package sample.view;

import javafx.beans.property.SimpleStringProperty;

public class Order {

    private final SimpleStringProperty name;
    private int id;
    private int pack;
    private final SimpleStringProperty description;

    public String getDescription() { return description.get(); }

    public SimpleStringProperty descriptionProperty() { return description; }

    public void setDescription(String description) { this.description.set(description); }

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
        this.description = new SimpleStringProperty("Empty");
    }

    public Order() {
        this.name = new SimpleStringProperty("");
        this.id = 0;
        this.pack = 0;
        this.description = new SimpleStringProperty("");
    }
}
