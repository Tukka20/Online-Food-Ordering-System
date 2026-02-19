package entity;

public class Restaurants {
    private int id;
    private String name;

    public Restaurants()
    {

    }

    public Restaurants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ Restaurant id :"+id+" | Restaurant name :"+name+"]";
    }
}
