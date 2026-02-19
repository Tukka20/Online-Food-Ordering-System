package dao;

import Config.DbConfig;
import entity.User;

import java.sql.*;

public class UserDao {

    public static boolean registration(User user) throws SQLException, ClassNotFoundException {

        Connection connection= DbConfig.getconnection();
        PreparedStatement ps=connection.prepareStatement("insert into users (name, email, password) values (?,?,?)");
        PreparedStatement checkData=connection.prepareStatement("select* from users where email=?");
        ps.setString(1,user.getName());

        //check emailId is exits or not
        checkData.setString(1, user.getEmail());
        ResultSet rs=checkData.executeQuery();
        if(rs.next())
        {
            return false;

        }

        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        rs.close();
        checkData.close();
        ps.close();
        connection.close();

        return true;
    }


    public boolean login(User user) throws SQLException, ClassNotFoundException {

                boolean status = false;

                try {
                    Connection connection = DbConfig.getconnection();

                    PreparedStatement ps = connection.prepareStatement(
                            "SELECT 1 FROM users WHERE email=? AND password=?");

                    ps.setString(1, user.getEmail());
                    ps.setString(2, user.getPassword());

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        status = true;
                    }

                    rs.close();
                    ps.close();
                    connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return status;

    }

}



