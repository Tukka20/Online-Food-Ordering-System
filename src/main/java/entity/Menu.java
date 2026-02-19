package entity;

public class Menu {
    private int id;
    private String name;
    private int price;
    private String restaurant;
    private int restaurantId;

    public Menu(String name,int price)
    {
        this.name=name;
        this.price=price;

    }

    public Menu(int id, String name, int price, String restaurant, int restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
        this.restaurantId = restaurantId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "[ Food Item Id=" + id + " | Name :" + name +" | Price=" + price + " | restaurant='" + restaurant + " | restaurantId=" + restaurantId +" ]";
    }
}
