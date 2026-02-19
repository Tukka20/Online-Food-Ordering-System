package dao;

import Config.DbConfig;
import entity.Restaurants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {

    public List<Restaurants> getRestaurantList() throws SQLException, ClassNotFoundException {

        List<Restaurants> list=new ArrayList<>();


        Connection connection=DbConfig.getconnection();
        PreparedStatement ps=connection.prepareStatement("select restaurant_id, restaurant_name from restaurants");

        ResultSet rs=ps.executeQuery();
        while (rs.next())
        {
            Restaurants restaurants=new Restaurants();

            restaurants.setId(rs.getInt("restaurant_id"));

            restaurants.setName(rs.getString("restaurant_name"));

            list.add(restaurants);
        }


        rs.close();
        ps.close();
        connection.close();

        return list;



    }
}
