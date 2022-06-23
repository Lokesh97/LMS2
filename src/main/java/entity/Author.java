package main.java.entity;

public class Author {

    private String name;

    private String id;

    public Author(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Author(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
