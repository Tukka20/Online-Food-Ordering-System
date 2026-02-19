package entity;

public class Order {
    private int id;
    private String userEmail;
    private String foodName;
    private String dateTime;

    public Order(int id, String userEmail, String foodName, String dateTime) {
        this.id = id;
        this.userEmail = userEmail;
        this.foodName = foodName;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "[ Id=" + id +
                " | User Email='" + userEmail +
                " | Food Name='" + foodName +
                " | Date Time='" + dateTime +" ]";
    }
}
