package sample.view;

import javafx.beans.property.SimpleStringProperty;

public class Photographer {

    private SimpleStringProperty name;
    private int id;


    public Photographer(int id, String name) {
        this.name = new SimpleStringProperty(name);
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
