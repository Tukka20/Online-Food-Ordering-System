package dao;

import Config.DbConfig;
import entity.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {

    public List<Menu> getMenu(int restaurantId) throws SQLException, ClassNotFoundException {

        List<Menu> list = new ArrayList<>();
        Connection connection = DbConfig.getconnection();

        PreparedStatement ps = connection.prepareStatement("select food_name,price from food_items where restaurant_id=?");
        ps.setInt(1, restaurantId);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Menu items = new Menu(rs.getString("food_name"), rs.getInt("price"));

            list.add(items);


        }

        rs.close();
        ps.close();
        connection.close();

        return list;
    }

}
