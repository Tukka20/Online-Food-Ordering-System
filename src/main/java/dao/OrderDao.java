package dao;

import Config.DbConfig;
import entity.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {

    public void placeOrder(String email, List<Menu> cart) throws SQLException, ClassNotFoundException {

        Connection connection= DbConfig.getconnection();
        PreparedStatement ps=connection.prepareStatement(" insert into orders (user_email,food_name,price) values (?,?,?)");
        for(Menu item: cart)
        {

            ps.setString(1,email);
            ps.setString(2,item.getName());
            ps.setInt(3,item.getPrice());
            ps.executeUpdate();

        }
        ps.close();
        connection.close();


    }
}
